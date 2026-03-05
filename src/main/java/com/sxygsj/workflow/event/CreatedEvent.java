package com.sxygsj.workflow.event;

import org.springframework.context.ApplicationEvent;

/**
 * 流程创建
 */
public class CreatedEvent extends ApplicationEvent {
    /**
     * 流程实例id
     */
    private final String processInstanceId;
    /**
     * 流程定义的标识
     */
    private final String processDefinitionKey;
    /**
     * 流程发起人id
     */
    private final String startUserId;
    /**
     * 创建时间
     */
    private final String createTime;


    /**
     * 创建流程实例事件
     *
     * @param processInstanceId    流程实例id
     * @param processDefinitionKey 流程定义的标识
     * @param startUserId          流程发起人id
     * @param createTime           创建时间
     */
    public CreatedEvent(String processInstanceId, String processDefinitionKey, String startUserId, String createTime) {
        super(processInstanceId);
        this.processInstanceId = processInstanceId;
        this.processDefinitionKey = processDefinitionKey;
        this.startUserId = startUserId;
        this.createTime = createTime;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public String getStartUserId() {
        return startUserId;
    }

    public String getCreateTime() {
        return createTime;
    }
}
