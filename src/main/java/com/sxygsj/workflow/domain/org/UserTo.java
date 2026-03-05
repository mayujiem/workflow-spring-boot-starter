package com.sxygsj.workflow.domain.org;

import java.util.List;

public class UserTo {
    /**
     * 部门id
     */
    private String deptId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String phonenumber;
    /**
     * 角色id数组
     */
    private List<String> roleIds;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 姓名
     */
    private String username;

    public String getDeptId() { return deptId; }
    public void setDeptId(String value) { this.deptId = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }

    public String getPhonenumber() { return phonenumber; }
    public void setPhonenumber(String value) { this.phonenumber = value; }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public String getUserId() { return userId; }
    public void setUserId(String value) { this.userId = value; }

    public String getUsername() { return username; }
    public void setUsername(String value) { this.username = value; }
}
