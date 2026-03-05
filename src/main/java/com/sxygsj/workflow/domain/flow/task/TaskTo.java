package com.sxygsj.workflow.domain.flow.task;

import java.util.Map;

public class TaskTo {
    /**
     * 审批意见
     */
    private String comment;
    /**
     * 抄送用户Id数组
     */
    private String[] copyUserIdList;
    /**
     * 任务ID
     */
    private String taskId;
    /**
     * 审批人
     */
    private String userId;
    /**
     * 表单数据
     */
    private Map<String, Object> formData;

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

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Object> getFormData() {
        return formData;
    }

    public void setFormData(Map<String, Object> formData) {
        this.formData = formData;
    }
}
