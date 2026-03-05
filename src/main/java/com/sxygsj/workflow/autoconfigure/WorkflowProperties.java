package com.sxygsj.workflow.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 工作流服务配置
 */
@ConfigurationProperties("com/sxygsj/workflow")
public class WorkflowProperties {
    /**
     * 服务基础url
     */
    private String baseUrl;
    /**
     * 服务应用id
     */
    private String appId;
    /**
     * 服务密钥
     */
    private String secretKey;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
