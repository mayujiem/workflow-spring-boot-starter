package com.sxygsj.workflow.domain.flow.task;

/**
 * 任务转办
 */
public class TransferTaskTo {
    /**
     * 审批人
     */
    private String userId;
    /**
     * 任务ID
     */
    private String taskId;
    /**
     * 新审批人的用户ID
     */
    private String assigneeUserId;
    /**
     * 转办原因
     */
    private String comment;
    /**
     * 抄送用户Id集合
     */
    private String[] copyUserIdList;

    public String[] getCopyUserIdList() {
        return copyUserIdList;
    }

    public void setCopyUserIdList(String[] copyUserIdList) {
        this.copyUserIdList = copyUserIdList;
    }

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

    public String getAssigneeUserId() {
        return assigneeUserId;
    }

    public void setAssigneeUserId(String assigneeUserId) {
        this.assigneeUserId = assigneeUserId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
