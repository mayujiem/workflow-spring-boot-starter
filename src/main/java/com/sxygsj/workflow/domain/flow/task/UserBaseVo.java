package com.sxygsj.workflow.domain.flow.task;

public class UserBaseVo {
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 部门名称
     */
    private String deptName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "UserBaseVo{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
