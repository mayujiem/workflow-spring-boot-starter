package com.sxygsj.workflow.domain.flow.instance;

import java.util.Collections;
import java.util.List;

/**
 * 工作流任务
 */
public class FlowTaskDto{
    /**
     * 任务编号
     */
    private String taskId;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务执行人名称
     */
    private String assigneeName;
    /**
     * 任务执行人部门
     */
    private String assigneeDeptName;
    /**
     * 任务意见
     */
    private String comment;
    /**
     * 任务状态
     */
    private Integer status;
    /**
     * 任务状态名称
     */
    private String statusName;
    /**
     * 流程节点id
     */
    private String activityId;
    /**
     * 候选执行人
     */
    private String candidate;
    /**
     * 任务创建时间
     */
    private String createTime;
    /**
     * 任务完成时间
     */
    private String finishTime;
    /**
     * 操作按钮
     */
    private List<ButtonTo> buttons = Collections.emptyList();

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getAssigneeDeptName() {
        return assigneeDeptName;
    }

    public void setAssigneeDeptName(String assigneeDeptName) {
        this.assigneeDeptName = assigneeDeptName;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public List<ButtonTo> getButtons() {
        return buttons;
    }

    public void setButtons(List<ButtonTo> buttons) {
        this.buttons = buttons;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }
}
