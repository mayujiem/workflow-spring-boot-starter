package com.sxygsj.workflow.domain.org;

public class DeptTo {
    /**
     * 部门id
     */
    private String deptId;
    /**
     * 部门级别
     */
    private String deptLevel;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 部门类型
     */
    private String deptType;
    /**
     * 部门负责人id
     */
    private String leader;
    /**
     * 父部门id
     */
    private String parentId;
    /**
     * 状态，1=启用 0=禁用
     */
    private Integer status;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptType() {
        return deptType;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
