package com.sxygsj.workflow.domain.flow.instance;

import java.util.Map;

public class ProcessInstanceFormInfo {
    /**
     * 流程名称
     */
    private String processName;
    /**
     * 流程实例id
     */
    private String processInstanceId;
    /**
     * 流程定义key
     */
    private String processDefinitionKey;
    /**
     * 实例状态
     */
    private String instanceStatus;
    /**
     * 表单类型
     */
    private Integer formType;
    /**
     * 自定义表单路由
     */
    private String formCustomRoute;
    /**
     * 自定义表单路径
     */
    private String formCustomPath;
    /**
     * 表单id
     */
    private Long formId;
    /**
     * 表单字段
     */
    private String formFields;
    /**
     * 表单配置
     */
    private String formConf;
    /**
     * 表单名称
     */
    private String formName;
    /**
     * 表单数据
     */
    private Map<String, Object> variables;
    /**
     * 表单数据项权限配置  1=可写，2=可读，3隐藏
     */
    private Map<String,Object> formFieldPermissions;
    /**
     * 发起人自由撤回
     * 1 = 是(流程发起后，任意时候都能由发起人撤回)
     * 0 = 否(流程发起后，在第一个节点未审批时，才能撤回)
     */
    private Integer allowCancelProcess;

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getFormCustomRoute() {
        return formCustomRoute;
    }

    public void setFormCustomRoute(String formCustomRoute) {
        this.formCustomRoute = formCustomRoute;
    }

    public String getFormCustomPath() {
        return formCustomPath;
    }

    public void setFormCustomPath(String formCustomPath) {
        this.formCustomPath = formCustomPath;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getFormFields() {
        return formFields;
    }

    public void setFormFields(String formFields) {
        this.formFields = formFields;
    }

    public String getFormConf() {
        return formConf;
    }

    public void setFormConf(String formConf) {
        this.formConf = formConf;
    }

    public Integer getFormType() {
        return formType;
    }

    public void setFormType(Integer formType) {
        this.formType = formType;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getInstanceStatus() {
        return instanceStatus;
    }

    public void setInstanceStatus(String instanceStatus) {
        this.instanceStatus = instanceStatus;
    }

    public Integer getAllowCancelProcess() {
        return allowCancelProcess;
    }

    public void setAllowCancelProcess(Integer allowCancelProcess) {
        this.allowCancelProcess = allowCancelProcess;
    }

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    public Map<String, Object> getFormFieldPermissions() {
        return formFieldPermissions;
    }

    public void setFormFieldPermissions(Map<String, Object> formFieldPermissions) {
        this.formFieldPermissions = formFieldPermissions;
    }
}
