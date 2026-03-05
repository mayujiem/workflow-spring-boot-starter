package com.sxygsj.workflow.domain.flow.instance;

/**
 * 流程实例视图
 */
public class ProcessInstanceVo {
    /**
     * 任务编号
     */
    private String taskId;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务Key
     */
    private String taskDefKey;
    /**
     * 流程类型
     */
    private String category;
    /**
     * 局部变量信息
     */
    private Integer version;
    /**
     * 流程部署编号
     */
    private String deployId;
    /**
     * 流程ID
     */
    private String processDefinitionId;
    /**
     * 流程key
     */
    private String processKey;
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 流程定义名称
     */
    private String processName;
    /**
     * 流程实例ID
     */
    private String processInstanceId;
    /**
     * 表单类型
     * 1=流程表单 2=业务表单
     */
    private Integer formType;
    /**
     * 自定义表单路由
     */
    private String formCustomRoute;
    /**
     * 自定义表单路径
     */
    private String formCustomPath;

    /**
     * 流程标识
     */
    private String businessKey;

    /**
     * 候选执行人
     */
    private String candidate;
    /**
     * 任务创建时间
     */
    private String createTime;
    /**
     * 任务完成时间
     */
    private String finishTime;
    /**
     * 任务耗时
     */
    private String duration;
    /**
     * 流程状态
     */
    private String processStatus;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDefKey() {
        return taskDefKey;
    }

    public void setTaskDefKey(String taskDefKey) {
        this.taskDefKey = taskDefKey;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDeployId() {
        return deployId;
    }

    public void setDeployId(String deployId) {
        this.deployId = deployId;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getFormType() {
        return formType;
    }

    public void setFormType(Integer formType) {
        this.formType = formType;
    }

    public String getFormCustomRoute() {
        return formCustomRoute;
    }

    public void setFormCustomRoute(String formCustomRoute) {
        this.formCustomRoute = formCustomRoute;
    }

    public String getFormCustomPath() {
        return formCustomPath;
    }

    public void setFormCustomPath(String formCustomPath) {
        this.formCustomPath = formCustomPath;
    }
}
