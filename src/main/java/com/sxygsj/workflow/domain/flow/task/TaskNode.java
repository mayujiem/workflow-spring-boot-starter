package com.sxygsj.workflow.domain.flow.task;


/**
 *
 * @author myj
 * @since 2025/8/19
 */
public class TaskNode {
    /**
     * 节点 id
     */
    private String activityId;
    /**
     * 节点名称
     */
    private String activityName;
    /**
     * 节点处理人
     */
    private String assignee;
    /**
     * 节点处理时间
     */
    private String handleTime;
    /**
     * 节点状态  1：进行中  2：已完成  0：未处理
     */
    private Integer nodeStatus;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }

    public Integer getNodeStatus() {
        return nodeStatus;
    }

    public void setNodeStatus(Integer nodeStatus) {
        this.nodeStatus = nodeStatus;
    }
}
