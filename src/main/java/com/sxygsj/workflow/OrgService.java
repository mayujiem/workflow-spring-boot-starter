package com.sxygsj.workflow;

import com.sxygsj.workflow.autoconfigure.WorkflowProperties;
import com.sxygsj.workflow.domain.ApiConstants;
import com.sxygsj.workflow.domain.R;
import com.sxygsj.workflow.domain.org.DeptTo;
import com.sxygsj.workflow.domain.org.RoleTo;
import com.sxygsj.workflow.domain.org.UserTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 组织架构集成
 *
 * @author myj
 * @since 2025/7/15
 */
public class OrgService extends WorkflowSupport {
    private final Logger logger = LoggerFactory.getLogger(OrgService.class);
    private final String urlPrefix = ApiConstants.API_URL_PREFIX;

    public OrgService(WorkflowProperties workflowProperties) {
        super(workflowProperties);
    }

    //==============================角色====================================


    private final Predicate<RoleTo> rolePredicate = role -> role != null && StringUtils.hasText(role.getRoleId()) && StringUtils.hasText(role.getRoleName());

    /**
     * 查询角色信息
     */
    public RoleTo getRole(String roleId) {
        if (!StringUtils.hasText(roleId)) {
            logger.error("角色id为空");
            return null;
        }
        String url = urlPrefix + "/tenant/role/info?roleId={roleId}";
        ResponseEntity<R<RoleTo>> response = getRestTemplate().exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<R<RoleTo>>() {
                },
                roleId
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            R<RoleTo> body = response.getBody();
            if (body != null && body.isSuccess() != null) {
                return body.getData();
            }
        }
        return null;
    }

    /**
     * 新增角色
     */
    public void addRole(RoleTo role) {
        if (!rolePredicate.test(role)) {
            logger.error("新增角色参数错误");
            return;
        }
        String url = urlPrefix + "/tenant/role/add";
        R<?> response = getRestTemplate().postForObject(url, role, R.class);
        if (response != null && response.isSuccess() && response.getData() != null) {
            logger.debug("新增角色成功");
        } else {
            logger.error("新增角色异常：{}", response);
            throw new RuntimeException(response != null ? response.getMsg() : "响应为空");
        }
    }

    /**
     * 修改角色
     */
    public void editRole(RoleTo role) {
        if (!rolePredicate.test(role)) {
            logger.error("修改角色参数错误");
            return;
        }
        String url = urlPrefix + "/tenant/role/edit";
        R<?> response = getRestTemplate().postForObject(url, role, R.class);
        if (response != null && response.isSuccess() && response.getData() != null) {
            logger.debug("修改角色成功");
        } else {
            logger.error("修改角色异常：{}", response);
            throw new RuntimeException(response != null ? response.getMsg() : "响应为空");
        }
    }

    /**
     * 删除角色
     */
    public void delRole(Long[] roleIds) {
        if (roleIds == null || roleIds.length == 0) {
            logger.error("删除角色参数错误");
            return;
        }

        String url = urlPrefix + "/tenant/role/del";
        List<String> collect = Arrays.stream(roleIds).filter(Objects::nonNull).map(Object::toString).collect(Collectors.toList());
        R<?> response = getRestTemplate().postForObject(url, collect, R.class);
        if (response != null && response.isSuccess() && response.getData() != null) {
            logger.debug("删除角色成功");
        } else {
            logger.error("删除角色异常：{}", response);
            throw new RuntimeException(response != null ? response.getMsg() : "响应为空");
        }
    }

    public void delRole(String[] roleIds) {
        if (roleIds == null || roleIds.length == 0) {
            logger.error("删除角色参数错误");
            return;
        }

        String url = urlPrefix + "/tenant/role/del";
        R<?> response = getRestTemplate().postForObject(url, roleIds, R.class);
        if (response != null && response.isSuccess() && response.getData() != null) {
            logger.debug("删除角色成功");
        } else {
            logger.error("删除角色异常：{}", response);
            throw new RuntimeException(response != null ? response.getMsg() : "响应为空");
        }
    }

    /**
     * 批量新增角色
     */
    public void batchAddRole(List<RoleTo> roleList) {
        if (roleList == null || roleList.isEmpty()) {
            logger.error("批量新增角色参数错误");
            return;
        }
        List<RoleTo> collect = roleList.stream().filter(rolePredicate).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            String url = urlPrefix + "/tenant/role/batchAdd";
            R<?> response = getRestTemplate().postForObject(url, collect, R.class);
            if (response != null && response.isSuccess() && response.getData() != null) {
                logger.debug("批量新增角色成功");
            } else {
                logger.error("批量新增角色异常：{}", response);
                throw new RuntimeException(response != null ? response.getMsg() : "响应为空");
            }
        }
    }

    //==============================部门====================================
    private final Predicate<DeptTo> deptPredicate = dept -> dept != null && StringUtils.hasText(dept.getDeptId()) && StringUtils.hasText(dept.getDeptName());

    /**
     * 查询部门信息
     */
    public DeptTo getDept(String deptId) {
        if (!StringUtils.hasText(deptId)) {
            logger.error("部门id为空");
            return null;
        }
        String url = urlPrefix + "/tenant/dept/info?deptId={deptId}";
        ResponseEntity<R<DeptTo>> response = getRestTemplate().exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<R<DeptTo>>() {
                },
                deptId
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            R<DeptTo> body = response.getBody();
            if (body != null && body.isSuccess() != null) {
                return body.getData();
            }
        }
        return null;
    }

    /**
     * 新增部门
     */
    public void addDept(DeptTo dept) {
        if (!deptPredicate.test(dept)) {
            logger.error("新增部门参数错误");
            return;
        }
        String url = urlPrefix + "/tenant/dept/add";
        R<?> response = getRestTemplate().postForObject(url, dept, R.class);
        if (response != null && response.isSuccess() && response.getData() != null) {
            logger.debug("新增部门成功");
        } else {
            logger.error("新增部门异常：{}", response);
            throw new RuntimeException(response != null ? response.getMsg() : "响应为空");
        }
    }

    /**
     * 修改部门
     */
    public void editDept(DeptTo dept) {
        if (!deptPredicate.test(dept)) {
            logger.error("修改部门参数错误");
            return;
        }
        String url = urlPrefix + "/tenant/dept/edit";
        R<?> response = getRestTemplate().postForObject(url, dept, R.class);
        if (response != null && response.isSuccess() && response.getData() != null) {
            logger.debug("修改部门成功");
        } else {
            logger.error("修改部门异常：{}", response);
            throw new RuntimeException(response != null ? response.getMsg() : "响应为空");
        }
    }

    /**
     * 删除部门
     */
    public void delDept(Long deptId) {
        if (deptId == null) {
            logger.error("删除部门参数错误");
            return;
        }
        String url = urlPrefix + "/tenant/dept/del";
        List<String> collect = Collections.singletonList(deptId.toString());
        R<?> response = getRestTemplate().postForObject(url, collect, R.class);
        if (response != null && response.isSuccess() && response.getData() != null) {
            logger.debug("删除部门成功");
        } else {
            logger.error("删除部门异常：{}", response);
            throw new RuntimeException(response != null ? response.getMsg() : "响应为空");
        }
    }
    /**
     * 删除部门
     */
    public void delDept(String[] deptIds) {
        if (deptIds == null || deptIds.length == 0) {
            logger.error("删除部门参数错误");
            return;
        }
        String url = urlPrefix + "/tenant/dept/del";

        R<?> response = getRestTemplate().postForObject(url, deptIds, R.class);
        if (response != null && response.isSuccess() && response.getData() != null) {
            logger.debug("删除部门成功");
        } else {
            logger.error("删除部门异常：{}", response);
            throw new RuntimeException(response != null ? response.getMsg() : "响应为空");
        }
    }

    /**
     * 批量新增部门
     */
    public void batchAddDept(List<DeptTo> deptList) {
        if (deptList == null || deptList.isEmpty()) {
            logger.error("批量新增部门参数错误");
            return;
        }
        List<DeptTo> collect = deptList.stream().filter(deptPredicate).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            String url = urlPrefix + "/tenant/dept/batchAdd";
            R<?> response = getRestTemplate().postForObject(url, deptList, R.class);
            if (response != null && response.isSuccess() && response.getData() != null) {
                logger.debug("批量新增部门成功");
            } else {
                logger.error("批量新增部门异常：{}", response);
                throw new RuntimeException(response != null ? response.getMsg() : "响应为空");
            }
        }
    }
    //==============================用户====================================

    private final Predicate<UserTo> userPredicate = user -> user != null && StringUtils.hasText(user.getUserId()) && StringUtils.hasText(user.getUsername());

    /**
     * 查询用户信息
     */
    public UserTo getUser(String userId) {
        if (!StringUtils.hasText(userId)) {
            logger.error("用户id为空");
            return null;
        }
        String url = urlPrefix + "/tenant/user/info?userId={userId}";
        ResponseEntity<R<UserTo>> response = getRestTemplate().exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<R<UserTo>>() {
                },
                userId
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            R<UserTo> body = response.getBody();
            if (body != null && body.isSuccess() != null) {
                return body.getData();
            }
        }
        return null;
    }

    /**
     * 新增用户
     */
    public void addUser(UserTo user) {
        if (!userPredicate.test(user)) {
            logger.error("新增用户参数错误");
            return;
        }
        String url = urlPrefix + "/tenant/user/add";
        R<?> response = getRestTemplate().postForObject(url, user, R.class);
        if (response != null && response.isSuccess() && response.getData() != null) {
            logger.debug("新增用户成功");
        } else {
            logger.error("新增用户异常：{}", response);
            throw new RuntimeException(response != null ? response.getMsg() : "响应为空");
        }
    }

    /**
     * 修改用户
     */
    public void editUser(UserTo user) {
        if (!userPredicate.test(user)) {
            logger.error("修改用户参数错误");
            return;
        }
        String url = urlPrefix + "/tenant/user/edit";
        R<?> response = getRestTemplate().postForObject(url, user, R.class);
        if (response != null && response.isSuccess() && response.getData() != null) {
            logger.debug("修改用户成功");
        } else {
            logger.error("修改用户异常：{}", response);
            throw new RuntimeException(response != null ? response.getMsg() : "响应为空");
        }
    }

    /**
     * 删除用户
     */
    public void delUser(List<String> userIds) {
        if (userIds == null || userIds.isEmpty()) {
            logger.error("删除用户参数错误");
            return;
        }

        String url = urlPrefix + "/tenant/user/del";
        R<?> response = getRestTemplate().postForObject(url, userIds, R.class);
        if (response != null && response.isSuccess() && response.getData() != null) {
            logger.debug("删除用户成功");
        } else {
            logger.error("删除用户异常：{}", response);
            throw new RuntimeException(response != null ? response.getMsg() : "响应为空");
        }
    }


    /**
     * 批量新增用户
     */
    public void batchAddUser(List<UserTo> userList) {
        if (userList == null || userList.isEmpty()) {
            logger.error("批量新增用户参数错误");
            return;
        }
        List<UserTo> collect = userList.stream().filter(userPredicate).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            String url = urlPrefix + "/tenant/user/batchAdd";
            R<?> response = getRestTemplate().postForObject(url, collect, R.class);
            if (response != null && response.isSuccess() && response.getData() != null) {
                logger.debug("批量新增用户成功");
            } else {
                logger.error("批量新增用户异常：{}", response);
                throw new RuntimeException(response != null ? response.getMsg() : "响应为空");
            }
        }
    }
}
