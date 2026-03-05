package com.sxygsj.workflow;

import com.sxygsj.workflow.autoconfigure.WorkflowProperties;
import com.sxygsj.workflow.domain.ApiConstants;
import com.sxygsj.workflow.domain.R;
import com.sxygsj.workflow.domain.flow.TableData;
import com.sxygsj.workflow.domain.flow.def.ProcessDefinitionDetail;
import com.sxygsj.workflow.domain.flow.instance.CreateInstanceTo;
import com.sxygsj.workflow.domain.flow.instance.ProcessInstanceDetailVo;
import com.sxygsj.workflow.domain.flow.instance.ProcessInstanceVo;
import com.sxygsj.workflow.domain.flow.task.*;
import com.sxygsj.workflow.event.CompletedEvent;
import com.sxygsj.workflow.event.CreatedEvent;
import com.sxygsj.workflow.event.TerminatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 工作流服务集成
 *
 * @author myj
 * @since 2025/7/15
 */
public class FlowService extends WorkflowSupport {
    private final static Logger logger = LoggerFactory.getLogger(FlowService.class);
    private final ApplicationEventPublisher eventPublisher;
    private final String urlPrefix = ApiConstants.API_URL_PREFIX;

    public FlowService(WorkflowProperties workflowProperties, ApplicationEventPublisher applicationEventPublisher) {
        super(workflowProperties);
        this.eventPublisher = applicationEventPublisher;
    }

    /**
     * 查询流程定义信息
     *
     * @param processDefinitionKey 流程标识key
     */
    public ProcessDefinitionDetail getProcessDetail(String processDefinitionKey) {
        if (!StringUtils.hasText(processDefinitionKey)) {
            return null;
        }
        String url = urlPrefix + "/processDef/detail?processDefinitionKey={processDefinitionKey}";
        ResponseEntity<R<ProcessDefinitionDetail>> response = getRestTemplate().exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<R<ProcessDefinitionDetail>>() {
                },
                processDefinitionKey
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            R<ProcessDefinitionDetail> body = response.getBody();
            if (body != null && body.isSuccess()) {
                return body.getData();
            }
        }
        logger.error("查询流程[processKey={}]定义信息异常：{}", processDefinitionKey, response.getBody());
        throw new RuntimeException("查询流程[processKey={" + processDefinitionKey + "}]定义信息异常");
    }

    /**
     * 发起流程
     */
    public String createProcessInstance(CreateInstanceTo createInstanceTo) {
        if (createInstanceTo == null ||
                !StringUtils.hasText(createInstanceTo.getProcessDefinitionKey()) ||
                !StringUtils.hasText(createInstanceTo.getUserId())) {
            throw new IllegalArgumentException("参数不完整");
        }
        String url = urlPrefix + "/processIns/create";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<R<String>> response = getRestTemplate().exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(createInstanceTo, headers),
                new ParameterizedTypeReference<R<String>>() {
                }
        );
        String processInstanceId = null;
        if (response.getStatusCode().is2xxSuccessful()) {
            R<String> body = response.getBody();
            if (body != null && body.isSuccess()) {
                processInstanceId = body.getData();
                if (StringUtils.hasText(processInstanceId)) {
                    logger.info("用户[userId={}]发起流程[processDefinitionKey={}]成功", createInstanceTo.getUserId(), createInstanceTo.getProcessDefinitionKey());
                    String now = LocalDateTime.now(ZoneId.of("+8")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    eventPublisher.publishEvent(new CreatedEvent(processInstanceId, createInstanceTo.getProcessDefinitionKey(), createInstanceTo.getUserId(), now));
                }
            } else {
                logger.error("用户[userId={}]发起流程[processDefinitionKey={}]异常", createInstanceTo.getUserId(), createInstanceTo.getProcessDefinitionKey());
                throw new RuntimeException("发起流程异常");
            }
        } else {
            logger.error("用户[userId={}]发起流程[processDefinitionKey={}]异常：{}", createInstanceTo.getUserId(), createInstanceTo.getProcessDefinitionKey(), response.getBody());
        }
        return processInstanceId;
    }

    /**
     * 查询用户任务
     */
    public List<TasDetailVo> getUserTaskList(UserTaskTo userTaskTo) {
        if (!StringUtils.hasText(userTaskTo.getUserId())) {
            throw new IllegalArgumentException("参数不完整");
        }
        String url = urlPrefix + "/task/userTodoList";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<R<List<TasDetailVo>>> response = getRestTemplate().exchange(url,
                HttpMethod.POST,
                new HttpEntity<>(userTaskTo, headers),
                new ParameterizedTypeReference<R<List<TasDetailVo>>>() {
                }
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            R<List<TasDetailVo>> body = response.getBody();
            if (body != null && body.isSuccess()) {
                List<TasDetailVo> data = body.getData();
                if (data != null && !data.isEmpty()) {
                    return data;
                }
            }
        }
        return Collections.emptyList();
    }
    /**
     * 查询用户任务(分页)
     */
    public TableData<TasDetailVo> getUserTaskList(UserTaskToPage userTaskTo) {
        if (!StringUtils.hasText(userTaskTo.getUserId())) {
            throw new IllegalArgumentException("参数不完整");
        }
        String url = urlPrefix + "/task/page/userTodoList";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<TableData<TasDetailVo>> response = getRestTemplate().exchange(url,
                HttpMethod.POST,
                new HttpEntity<>(userTaskTo, headers),
                new ParameterizedTypeReference<TableData<TasDetailVo>>() {}
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return TableData.emptyList(response.getStatusCodeValue(), "查询用户待办任务异常");
    }
    /**
     * 获得抄送列表(分页)
     */
    public TableData<ProcessInstanceCopyVo> getProcessCopyList(ProcessInstanceCopyTo userTaskTo) {
        if (!StringUtils.hasText(userTaskTo.getUserId())) {
            throw new IllegalArgumentException("参数不完整");
        }
        String url = urlPrefix + "/processCopy/list";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<TableData<ProcessInstanceCopyVo>> response = getRestTemplate().exchange(url,
                HttpMethod.POST,
                new HttpEntity<>(userTaskTo, headers),
                new ParameterizedTypeReference<TableData<ProcessInstanceCopyVo>>() {}
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return TableData.emptyList(response.getStatusCodeValue(), "查询抄送列表异常");
    }
    /**
     * 查询用户发起的流程列表
     */
    public TableData<ProcessInstanceVo> getUserCreateProcessInstanceList(UserCreateTo userCreate) {
        if (!StringUtils.hasText(userCreate.getStartUserId())) {
            throw new IllegalArgumentException("发起用户id不能为空");
        }
        String url = urlPrefix + "/task/page/userCreateList";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<TableData<ProcessInstanceVo>> response = getRestTemplate().exchange(url,
                HttpMethod.POST,
                new HttpEntity<>(userCreate, headers),
                new ParameterizedTypeReference<TableData<ProcessInstanceVo>>() {}
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return TableData.emptyList(response.getStatusCodeValue(), "查询用户发起的流程异常");
    }
    /**
     * 查询用户已办的任务列表
     */
    public TableData<TasDetailVo> getTaskDoneList(UserTaskDoneTo userTaskDoneTo) {
        if (!StringUtils.hasText(userTaskDoneTo.getCurrentUserId())) {
            throw new IllegalArgumentException("当前用户id不能为空");
        }
        String url = urlPrefix + "/task/page/userDoneList";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<TableData<TasDetailVo>> response = getRestTemplate().exchange(url,
                HttpMethod.POST,
                new HttpEntity<>(userTaskDoneTo, headers),
                new ParameterizedTypeReference<TableData<TasDetailVo>>() {}
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return TableData.emptyList(response.getStatusCodeValue(), "查询用户已办的任务列表");
    }
    /**
     * 查询流程实例状态
     * @param processInstanceIdList 流程实例id 列表
     */
    public List<ProcessInsStatusVo> getProcessInstanceStatus(List<String> processInstanceIdList) {
        if (processInstanceIdList== null || processInstanceIdList.isEmpty()) {
            return Collections.emptyList();
        }
        String url = urlPrefix + "/processIns/status";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<R<List<ProcessInsStatusVo>>> response = getRestTemplate().exchange(url,
                HttpMethod.POST,
                new HttpEntity<>(processInstanceIdList, headers),
                new ParameterizedTypeReference<R<List<ProcessInsStatusVo>>>() {
                }
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            R<List<ProcessInsStatusVo>> body = response.getBody();
            if (body != null && body.isSuccess()) {
                List<ProcessInsStatusVo> data = body.getData();
                if (data != null && !data.isEmpty()) {
                    return data;
                }
            }
        }
        return Collections.emptyList();
    }

    /**
     * 查询流程实例信息
     *
     * @param instanceId 流程实例id
     */
    public ProcessInstanceDetailVo getProcessInstanceDetail(String instanceId) {
        if (!StringUtils.hasText(instanceId)) {
            throw new IllegalArgumentException("流程实例id不能为空");
        }
        String url = urlPrefix + "/processIns/detail?processInstanceId={instanceId}";

        ResponseEntity<R<ProcessInstanceDetailVo>> response = getRestTemplate().exchange(url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<R<ProcessInstanceDetailVo>>() {
                },
                instanceId
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            R<ProcessInstanceDetailVo> body = response.getBody();
            if (body != null && body.isSuccess()) {
                return body.getData();
            }
        } else {
            logger.error("查询流程实例[instanceId={}]信息异常：{}", instanceId, response.getBody());
        }
        return null;
    }


    /**
     * 同意
     *
     * @param taskId            任务id
     * @param userId            用户id
     * @param comment           审批意见
     * @param processInstanceId 流程实例id
     * @param copyUserIdList    抄送用户Id数组
     * @param formData          表单数据
     */
    public ProcessInsStatusVo agree(String taskId,
                                    String userId,
                                    String comment,
                                    String processInstanceId,
                                    String[] copyUserIdList,
                                    Map<String, Object> formData) {
        if (!StringUtils.hasText(taskId) ||
                !StringUtils.hasText(userId) ||
                !StringUtils.hasText(processInstanceId)) {
            throw new IllegalArgumentException("参数不完整");
        }

        String url = urlPrefix + "/task/approve";
        TaskTo taskTo = new TaskTo();
        taskTo.setUserId(userId);
        taskTo.setTaskId(taskId);
        taskTo.setComment(comment);
        taskTo.setCopyUserIdList(copyUserIdList);
        taskTo.setFormData(formData);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<R<ProcessInsStatusVo>> response = getRestTemplate().exchange(url,
                HttpMethod.POST,
                new HttpEntity<>(taskTo, headers),
                new ParameterizedTypeReference<R<ProcessInsStatusVo>>() {
                }
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            R<ProcessInsStatusVo> body = response.getBody();
            if (body != null && body.isSuccess()) {
                ProcessInsStatusVo data = body.getData();
                logger.info("用户[userId={}]同意流程[processInstanceId={}],任务[taskId={}]", userId, processInstanceId, taskId);
                if (data != null && "completed".equals(data.getInstanceStatus())) {
                    logger.info("用户[userId={}]同意流程[processInstanceId={}],任务[taskId={}],并且此流程完成", userId, processInstanceId, taskId);
                    eventPublisher.publishEvent(new CompletedEvent(processInstanceId));
                }
                return data;
            }
        }
        logger.error("用户[userId={}]同意流程[processInstanceId={}]异常：{}", userId, processInstanceId, response.getBody());
        throw new RuntimeException("用户[userId={" + userId + "}]同意流程[processInstanceId={" + processInstanceId + "}]异常");
    }

    /**
     * 拒绝
     *
     * @param taskId            任务id
     * @param userId            用户id
     * @param comment           审批意见
     * @param copyUserIdList    抄送用户Id数组
     * @param processInstanceId 流程实例id
     */
    public ProcessInsStatusVo reject(String taskId, String userId, String comment, String[] copyUserIdList, String processInstanceId) {
        if (!StringUtils.hasText(taskId) ||
                !StringUtils.hasText(userId) ||
                !StringUtils.hasText(processInstanceId)) {
            throw new IllegalArgumentException("参数不完整");
        }

        String url = urlPrefix + "/task/reject";
        TaskTo taskTo = new TaskTo();
        taskTo.setUserId(userId);
        taskTo.setTaskId(taskId);
        taskTo.setComment(comment);
        taskTo.setCopyUserIdList(copyUserIdList);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<R<ProcessInsStatusVo>> response = getRestTemplate().exchange(url,
                HttpMethod.POST,
                new HttpEntity<>(taskTo, headers),
                new ParameterizedTypeReference<R<ProcessInsStatusVo>>() {
                }
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            R<ProcessInsStatusVo> body = response.getBody();
            if (body != null && body.isSuccess()) {
                ProcessInsStatusVo data = body.getData();
                logger.info("用户[userId={}]拒绝流程[processInstanceId={}],任务[taskId={}]", userId, processInstanceId, taskId);
                eventPublisher.publishEvent(new TerminatedEvent(processInstanceId));
                return data;
            }
        }
        logger.error("用户[userId={}]拒绝流程[processInstanceId={}]异常：{}", userId, processInstanceId, response.getBody());
        throw new RuntimeException("用户[userId={" + userId + "}]拒绝流程[processInstanceId={" + processInstanceId + "}]异常");
    }

    /**
     * 查询所有可退回的节点
     *
     * @param taskId 任务id
     * @return 节点列表
     */
    public List<TaskReturnVo> getTaskReturnList(String taskId) {
        if (!StringUtils.hasText(taskId)) {
            throw new IllegalArgumentException("taskId不能为空");
        }
        String url = urlPrefix + "/task/returnList?taskId={taskId}";
        ResponseEntity<R<List<TaskReturnVo>>> response = getRestTemplate().exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<R<List<TaskReturnVo>>>() {
                },
                taskId
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            R<List<TaskReturnVo>> body = response.getBody();
            if (body != null && body.isSuccess()) {
                return body.getData();
            }
        }
        return Collections.emptyList();
    }


    /**
     * 退回
     *
     * @param taskId                  任务id
     * @param userId                  用户id
     * @param comment                 审批意见
     * @param targetTaskDefinitionKey 退回到的任务key
     */
    public ProcessInsStatusVo returnTask(String taskId, String userId, String comment, String targetTaskDefinitionKey) {
        if (!StringUtils.hasText(taskId) ||
                !StringUtils.hasText(userId) ||
                !StringUtils.hasText(targetTaskDefinitionKey)) {
            throw new IllegalArgumentException("参数不完整");
        }
        String url = urlPrefix + "/task/return";
        FallbackTo taskTo = new FallbackTo();
        taskTo.setUserId(userId);
        taskTo.setTaskId(taskId);
        taskTo.setComment(comment);
        taskTo.setCopyUserIdList(new String[0]);
        taskTo.setTargetTaskDefinitionKey(targetTaskDefinitionKey);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<R<ProcessInsStatusVo>> response = getRestTemplate().exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(taskTo, headers),
                new ParameterizedTypeReference<R<ProcessInsStatusVo>>() {
                }
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            R<ProcessInsStatusVo> body = response.getBody();
            logger.info("用户[userId={}]退回流程,任务[taskId={}]", userId, taskId);
            if (body != null && body.isSuccess()) {
                return body.getData();

            }
        }
        logger.error("用户[userId={}]退回流程异常：{}", userId, response.getBody());
        throw new RuntimeException("用户[userId={" + userId + "}转办异常");
    }

    /**
     * 转办
     *
     * @param taskId         任务id
     * @param userId         用户id
     * @param comment        审批意见
     * @param assigneeUserId 要转办的用户id
     * @param copyUserIdList 抄送用户Id数组
     */
    public ProcessInsStatusVo transfer(String taskId, String userId, String comment, String assigneeUserId, String[] copyUserIdList) {
        if (!StringUtils.hasText(taskId) ||
                !StringUtils.hasText(assigneeUserId) ||
                !StringUtils.hasText(userId)) {
            throw new IllegalArgumentException("参数不完整");
        }
        String url = urlPrefix + "/task/transfer";
        TransferTaskTo transferTaskDTO = new TransferTaskTo();
        transferTaskDTO.setTaskId(taskId);
        transferTaskDTO.setAssigneeUserId(assigneeUserId);
        transferTaskDTO.setComment(comment);
        transferTaskDTO.setUserId(userId);
        transferTaskDTO.setCopyUserIdList(copyUserIdList);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<R<ProcessInsStatusVo>> response = getRestTemplate().exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(transferTaskDTO, headers),
                new ParameterizedTypeReference<R<ProcessInsStatusVo>>() {
                }
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            R<ProcessInsStatusVo> body = response.getBody();
            logger.info("用户[userId={}]转办流程,任务[taskId={}]", userId, taskId);
            if (body != null) {
                return body.getData();
            }
        }
        logger.error("用户[userId={}]转办流程异常：{}", userId, response.getBody());
        throw new RuntimeException("用户[userId={" + userId + "}转办异常");
    }

    /**
     * 委派
     *
     * @param taskId         任务id
     * @param userId         用户id
     * @param comment        审批意见
     * @param delegateUserId 要委派的用户id
     * @param copyUserIdList 抄送用户Id数组
     */
    public ProcessInsStatusVo delegate(String taskId, String userId, String comment, String delegateUserId, String[] copyUserIdList) {
        if (!StringUtils.hasText(taskId) ||
                !StringUtils.hasText(delegateUserId) ||
                !StringUtils.hasText(userId)) {
            throw new IllegalArgumentException("参数不完整");
        }
        String url = urlPrefix + "/task/delegate";
        DelegateTaskTo delegateTaskDTO = new DelegateTaskTo();
        delegateTaskDTO.setTaskId(taskId);
        delegateTaskDTO.setDelegateUserId(delegateUserId);
        delegateTaskDTO.setComment(comment);
        delegateTaskDTO.setUserId(userId);
        delegateTaskDTO.setCopyUserIdList(copyUserIdList);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<R<ProcessInsStatusVo>> response = getRestTemplate().exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(delegateTaskDTO, headers),
                new ParameterizedTypeReference<R<ProcessInsStatusVo>>() {
                }
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            R<ProcessInsStatusVo> body = response.getBody();
            logger.info("用户[userId={}]委派流程,任务[taskId={}]", userId, taskId);
            if (body != null) {
                return body.getData();
            }
        }
        logger.error("用户[userId={}]委派流程异常：{}", userId, response.getBody());
        throw new RuntimeException("用户[userId={" + userId + "}]委派异常");
    }

    /**
     * 撤回流程
     *
     * @param processInstanceId 流程实例id
     * @param userId     用户id
     * @param reason     原因
     */
    public boolean cancel(String processInstanceId, String userId, String reason) {
        if (!StringUtils.hasText(processInstanceId) || !StringUtils.hasText(userId)|| !StringUtils.hasText(reason)) {
            throw new IllegalArgumentException("参数不完整");
        }
        String url = urlPrefix + "/processIns/cancelByStartUser";
        ProcessInstanceDetailVo.ProcessInstanceParams processInstanceParams = new ProcessInstanceDetailVo.ProcessInstanceParams();
        processInstanceParams.setProcessInstanceId(processInstanceId);
        processInstanceParams.setUserId(userId);
        processInstanceParams.setReason(reason);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<R<?>> response = getRestTemplate().exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(processInstanceParams, headers),
                new ParameterizedTypeReference<R<?>>() {
                }
        );
        if (response.getStatusCode().is2xxSuccessful()){
            R<?> body = response.getBody();
            logger.info("用户[userId={}]撤回流程[processInstanceId={}]", userId, processInstanceId);
            return body != null && body.isSuccess();
        }
        logger.error("用户[userId={}]撤回流程[processInstanceId={}]异常", userId, processInstanceId);
        return false;
    }

}
