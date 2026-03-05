package com.sxygsj.workflow.event;

import org.springframework.context.ApplicationEvent;

/**
 * 流程终止
 */
public class TerminatedEvent extends ApplicationEvent {
    /**
     * 流程实例id
     */
    private final String processInstanceId;

    public TerminatedEvent(String processInstanceId) {
        super(processInstanceId);
        this.processInstanceId = processInstanceId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }
}
