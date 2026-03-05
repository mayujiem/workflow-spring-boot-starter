package com.sxygsj.workflow.event;

import org.springframework.context.ApplicationEvent;

/**
 * 流程完成
 */
public class CompletedEvent extends ApplicationEvent {
    /**
     * 流程实例id
     */
    private final String processInstanceId;


    public CompletedEvent(String processInstanceId) {
        super(processInstanceId);
        this.processInstanceId = processInstanceId;

    }


    public String getProcessInstanceId() {
        return this.processInstanceId;
    }
}
