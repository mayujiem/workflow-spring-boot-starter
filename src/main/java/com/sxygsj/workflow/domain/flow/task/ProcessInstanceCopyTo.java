package com.sxygsj.workflow.domain.flow.task;

public class ProcessInstanceCopyTo {
    /**
     * 被抄送人id
     */
    private String userId;
    /**
     * 第几页
     */
    private Integer pageNum = 1;
    /**
     * 每页大小
     */
    private Integer pageSize = 10;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
