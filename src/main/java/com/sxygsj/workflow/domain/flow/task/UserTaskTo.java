package com.sxygsj.workflow.domain.flow.task;

import java.util.List;

public class UserTaskTo {
    /**
     * 流程实例id数组
     */
    private List<String>  processInstanceIds;
    /**
     * 流程定义标识数组
     */
    private List<String> processDefinitionKeys;
    /**
     * 用户id
     */
    private String userId;

    public List<String> getProcessInstanceIds() {
        return processInstanceIds;
    }

    public void setProcessInstanceIds(List<String> processInstanceIds) {
        this.processInstanceIds = processInstanceIds;
    }

    public List<String> getProcessDefinitionKeys() {
        return processDefinitionKeys;
    }

    public void setProcessDefinitionKeys(List<String> processDefinitionKeys) {
        this.processDefinitionKeys = processDefinitionKeys;
    }

    public String getUserId() { return userId; }
    public void setUserId(String value) { this.userId = value; }
}
