package com.sxygsj.workflow.domain.flow.task;

/**
 * 工作流任务视图对象
 */
public class TasDetailVo {
    /**
     * 任务编号
     */
    private String taskId;
    /**
     * 任务名字
     */
    private String taskName;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 完成时间
     */
    private String finishTime;
    /**
     * 任务耗时
     */
    private String duration;
    /**
     * 流程发起人信息
     */
    private UserBaseVo startUser;
    /**
     * 流程发起人id
     */
    private String startUserId;
    /**
     * 流程实例id
     */
    private String processInstanceId;
    /**
     * 流程定义key
     */
    private String processDefinitionKey;

    /**
     * 流程名称
     */
    private String processName;
    /**
     * 按钮列表
     */
    private String buttons;

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

    public UserBaseVo getStartUser() {
        return startUser;
    }

    public void setStartUser(UserBaseVo startUser) {
        this.startUser = startUser;
    }

    public String getStartUserId() {
        return startUserId;
    }

    public void setStartUserId(String startUserId) {
        this.startUserId = startUserId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    public String getButtons() {
        return buttons;
    }

    public void setButtons(String buttons) {
        this.buttons = buttons;
    }

    @Override
    public String toString() {
        return "TasDetailVo{" +
                "taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", duration='" + duration + '\'' +
                ", startUser=" + startUser +
                ", startUserId='" + startUserId + '\'' +
                ", processInstanceId='" + processInstanceId + '\'' +
                ", processDefinitionKey='" + processDefinitionKey + '\'' +
                ", processName='" + processName + '\'' +
                ", buttons='" + buttons + '\'' +
                '}';
    }
}
