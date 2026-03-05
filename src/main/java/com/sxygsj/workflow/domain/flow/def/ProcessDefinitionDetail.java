package com.sxygsj.workflow.domain.flow.def;

import java.util.Arrays;
import java.util.Map;

public class ProcessDefinitionDetail {
    /**
     * 流程定义id
     */
    private String processDefinitionId;
    /**
     * 流程名称
     */
    private String processName;
    /**
     * 流程标识
     */
    private String processKey;
    /**
     * 流程分类
     */
    private String category;
    /**
     * 流程模型id
     */
    private String modelId;
    /**
     * 发起类型
     * user 用户 ; role 角色; dept 部门; all 所有人
     */
    private String startType;
    /**
     * 可发起用户编号数组
     */
    private String[] startUserIds;
    /**
     * 可发起角色编号数组
     */
    private String[] startRoleIds;
    /**
     * 可发起部门编号数组
     */
    private String[] startDeptIds;
    /**
     * 自由撤回
     * 1 = 是(流程发起后，任意时候都能由发起人撤回)
     * 0 = 否(流程发起后，在第一个节点未审批时，才能撤回)
     */
    private Integer allowCancelProcess = 0;
    /**
     * 表单类型
     * 1=流程表单(表单设计器设计) 2=业务表单(用户自定义表单)
     */
    private Integer formType;
    /**
     * 表单名称
     */
    private String formName;
    /**
     * 表单自定义路径
     */
    private String formCustomPath;
    /**
     * 表单自定义路由
     */
    private String formCustomRoute;
    /**
     * 表单id
     */
    private Long formId;
    /**
     * 表单配置
     */
    private String formConf;
    /**
     * 表单数据项
     */
    private String formFields;
    /**
     * 表单数据项权限配置   1=可写，2=可读，3隐藏
     */
    private Map<String,Object> formFieldPermissions;
    /**
     * bpmn xml
     */
    private String bpmnXml;

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public Integer getFormType() {
        return formType;
    }

    public void setFormType(Integer formType) {
        this.formType = formType;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormCustomPath() {
        return formCustomPath;
    }

    public void setFormCustomPath(String formCustomPath) {
        this.formCustomPath = formCustomPath;
    }

    public String getFormCustomRoute() {
        return formCustomRoute;
    }

    public void setFormCustomRoute(String formCustomRoute) {
        this.formCustomRoute = formCustomRoute;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getFormConf() {
        return formConf;
    }

    public void setFormConf(String formConf) {
        this.formConf = formConf;
    }

    public String getFormFields() {
        return formFields;
    }

    public void setFormFields(String formFields) {
        this.formFields = formFields;
    }

    public String getBpmnXml() {
        return bpmnXml;
    }

    public void setBpmnXml(String bpmnXml) {
        this.bpmnXml = bpmnXml;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStartType() {
        return startType;
    }

    public void setStartType(String startType) {
        this.startType = startType;
    }

    public String[] getStartUserIds() {
        return startUserIds;
    }

    public void setStartUserIds(String[] startUserIds) {
        this.startUserIds = startUserIds;
    }

    public String[] getStartRoleIds() {
        return startRoleIds;
    }

    public void setStartRoleIds(String[] startRoleIds) {
        this.startRoleIds = startRoleIds;
    }

    public String[] getStartDeptIds() {
        return startDeptIds;
    }

    public void setStartDeptIds(String[] startDeptIds) {
        this.startDeptIds = startDeptIds;
    }

    public Integer getAllowCancelProcess() {
        return allowCancelProcess;
    }

    public void setAllowCancelProcess(Integer allowCancelProcess) {
        this.allowCancelProcess = allowCancelProcess;
    }

    public Map<String, Object> getFormFieldPermissions() {
        return formFieldPermissions;
    }

    public void setFormFieldPermissions(Map<String, Object> formFieldPermissions) {
        this.formFieldPermissions = formFieldPermissions;
    }

    @Override
    public String toString() {
        return "ProcessDefinitionDetail{" +
                "processDefinitionId='" + processDefinitionId + '\'' +
                ", processName='" + processName + '\'' +
                ", processKey='" + processKey + '\'' +
                ", category='" + category + '\'' +
                ", modelId='" + modelId + '\'' +
                ", startType='" + startType + '\'' +
                ", startUserIds=" + Arrays.toString(startUserIds) +
                ", startRoleIds=" + Arrays.toString(startRoleIds) +
                ", startDeptIds=" + Arrays.toString(startDeptIds) +
                ", allowCancelProcess=" + allowCancelProcess +
                ", formType=" + formType +
                ", formName='" + formName + '\'' +
                ", formCustomPath='" + formCustomPath + '\'' +
                ", formCustomRoute='" + formCustomRoute + '\'' +
                ", formId=" + formId +
                ", formConf='" + formConf + '\'' +
                ", formFields='" + formFields + '\'' +
                ", bpmnXml='" + bpmnXml + '\'' +
                '}';
    }
}
