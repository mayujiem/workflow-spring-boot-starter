package com.sxygsj.workflow.domain.flow.task;


/**
 * 任务委派
 */
public class DelegateTaskTo {
    /**
     * 审批人
     */
    private String userId;
    /**
     * 任务ID
     */
    private String taskId;
    /**
     * 被委派用户id
     */
    private String delegateUserId;
    /**
     * 委派原因
     */
    private String comment;
    /**
     * 抄送用户Id集合
     */
    private String[] copyUserIdList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getDelegateUserId() {
        return delegateUserId;
    }

    public void setDelegateUserId(String delegateUserId) {
        this.delegateUserId = delegateUserId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String[] getCopyUserIdList() {
        return copyUserIdList;
    }

    public void setCopyUserIdList(String[] copyUserIdList) {
        this.copyUserIdList = copyUserIdList;
    }
}
