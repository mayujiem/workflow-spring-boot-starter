package com.sxygsj.workflow.domain.flow.task;

/**
 *
 * @author myj
 * @since 2025/8/22
 */
public class UserCreateTo {
    /**
     * 发起流程用户id
     */
    private String startUserId;
    /**
     * 流程标识
     */
    private String processKey;
    /**
     * 流程实例id
     */
    private String processInstanceId;

    /**
     * 流程名称
     */
    private String processName;

    /**
     * 流程状态
     * running      运行中
     * terminated   已终止
     * completed    已完成
     * canceled     已取消
     */
    private String state;
    /**
     * 第几页
     */
    private Integer pageNum = 1;
    /**
     * 每页大小
     */
    private Integer pageSize = 10;

    public String getStartUserId() {
        return startUserId;
    }

    public void setStartUserId(String startUserId) {
        this.startUserId = startUserId;
    }

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
