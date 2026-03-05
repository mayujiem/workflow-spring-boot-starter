package com.sxygsj.workflow.domain.flow.task;

public class TaskReturnVo {
    /**
     * 任务key
     */
    private String taskDefinitionKey;
    /**
     * 任务名称
     */
    private String taskName;

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
