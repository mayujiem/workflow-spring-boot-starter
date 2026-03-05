package com.sxygsj.workflow.domain.flow.task;

/**
 * 流程抄送 VO
 */
public class ProcessInstanceCopyVo {
    /**
     * 编号
     */
    private Long id;
    /**
     * 抄送人id
     */
    private String sendUserId;
    /**
     * 抄送人
     */
    private UserBaseVo sendUser;
    /**
     * 流程发起人
     */
    private UserBaseVo startUser;
    /**
     * 流程名称
     */
    private String processInstanceName;
    /**
     * 流程实例id
     */
    private String processInstanceId;
    /**
     * 抄送任务id
     */
    private String taskId;
    /**
     * 抄送任务名称
     */
    private String taskName;

    /** 创建时间 yyyy-MM-dd HH:mm:ss*/
    private String createTime;

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getProcessInstanceName() {
        return processInstanceName;
    }

    public void setProcessInstanceName(String processInstanceName) {
        this.processInstanceName = processInstanceName;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserBaseVo getSendUser() {
        return sendUser;
    }

    public void setSendUser(UserBaseVo sendUser) {
        this.sendUser = sendUser;
    }

    public UserBaseVo getStartUser() {
        return startUser;
    }

    public void setStartUser(UserBaseVo startUser) {
        this.startUser = startUser;
    }

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
}
