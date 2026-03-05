package com.sxygsj.workflow.domain.flow.task;

import java.util.List;

public class ProcessInsStatusVo {
    /**
     * 流程实例ID
     */
    private String processInstanceId;
    /**
     * 实例状态
     */
    private String instanceStatus;

    /**
     * 当前运行的节点id
     */
    private List<String> currentActivityId;

    /**
     * 实例状态描述
     */
    private String instanceStatusName;
    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getInstanceStatus() {
        return instanceStatus;
    }

    public void setInstanceStatus(String instanceStatus) {
        this.instanceStatus = instanceStatus;
    }

    public List<String> getCurrentActivityId() {
        return currentActivityId;
    }

    public void setCurrentActivityId(List<String> currentActivityId) {
        this.currentActivityId = currentActivityId;
    }

    public String getInstanceStatusName() {
        return instanceStatusName;
    }

    public void setInstanceStatusName(String instanceStatusName) {
        this.instanceStatusName = instanceStatusName;
    }
}
