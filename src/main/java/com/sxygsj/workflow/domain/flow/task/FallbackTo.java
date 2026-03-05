package com.sxygsj.workflow.domain.flow.task;

public class FallbackTo {
    /**
     * 退回原因
     */
    private String comment;
    /**
     * 抄送用户Id数组
     */
    private String[] copyUserIdList;
    /**
     * 退回到的任务key
     */
    private String targetTaskDefinitionKey;
    /**
     * 任务ID
     */
    private String taskId;
    /**
     * 审批人
     */
    private String userId;

    public String getComment() { return comment; }
    public void setComment(String value) { this.comment = value; }

    public String[] getCopyUserIdList() { return copyUserIdList; }
    public void setCopyUserIdList(String[] value) { this.copyUserIdList = value; }

    public String getTargetTaskDefinitionKey() { return targetTaskDefinitionKey; }
    public void setTargetTaskDefinitionKey(String value) { this.targetTaskDefinitionKey = value; }

    public String getTaskId() { return taskId; }
    public void setTaskId(String value) { this.taskId = value; }

    public String getUserId() { return userId; }
    public void setUserId(String value) { this.userId = value; }
}
