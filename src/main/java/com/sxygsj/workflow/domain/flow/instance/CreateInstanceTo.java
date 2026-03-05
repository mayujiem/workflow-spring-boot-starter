package com.sxygsj.workflow.domain.flow.instance;

import java.util.Map;

/**
 * 创建流程实体 参数
 */
public class CreateInstanceTo {
    /**
     * 流程标识
     */
    private String processDefinitionKey;
    /**
     * 发起流程用户id
     */
    private String userId;
    /**
     * 流程变量
     */
    private Map<String, Object> variables;
    /**
     * 业务数据的唯一标识
     */
    private String businessKey;

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }
}
