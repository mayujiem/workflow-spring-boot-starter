package com.sxygsj.workflow.domain.flow.instance;

import com.sxygsj.workflow.domain.flow.task.TaskNode;

import java.util.List;

/**
 * 流程实例信息
 */
public class ProcessInstanceDetailVo {
    /**
     * 流程实例表单信息
     */
    private ProcessInstanceFormInfo  processInstanceFormInfo;
    /**
     * 流转历史
     */
    private List<FlowTaskDto> approvalDetail;
    /**
     * bpmn流程图信息
     */
    private BpmnDetailVo bpmnDetail;
    /**
     * 流程节点历史信息
     */
    private List<TaskNode> taskNodeList;

    public ProcessInstanceFormInfo getProcessInstanceFormInfo() {
        return processInstanceFormInfo;
    }

    public void setProcessInstanceFormInfo(ProcessInstanceFormInfo processInstanceFormInfo) {
        this.processInstanceFormInfo = processInstanceFormInfo;
    }

    public List<FlowTaskDto> getApprovalDetail() {
        return approvalDetail;
    }

    public void setApprovalDetail(List<FlowTaskDto> approvalDetail) {
        this.approvalDetail = approvalDetail;
    }

    public BpmnDetailVo getBpmnDetail() {
        return bpmnDetail;
    }

    public void setBpmnDetail(BpmnDetailVo bpmnDetail) {
        this.bpmnDetail = bpmnDetail;
    }

    public List<TaskNode> getTaskNodeList() {
        return taskNodeList;
    }

    public void setTaskNodeList(List<TaskNode> taskNodeList) {
        this.taskNodeList = taskNodeList;
    }

    /**
     * 撤回 流程实例
     */
    public static class ProcessInstanceParams {
        /**
         * 流程实例id
         */
        private String processInstanceId;
        /**
         * 用户id
         */
        private String userId;
        /**
         * 撤回原因
         */
        private String reason;

        public String getProcessInstanceId() {
            return processInstanceId;
        }

        public void setProcessInstanceId(String processInstanceId) {
            this.processInstanceId = processInstanceId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }
}
