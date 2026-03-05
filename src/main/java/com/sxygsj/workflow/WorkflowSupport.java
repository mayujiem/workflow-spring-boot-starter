package com.sxygsj.workflow;

import com.sxygsj.workflow.autoconfigure.WorkflowProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInitializer;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

/**
 * 公共服务工具类
 */
public class WorkflowSupport {
    private final static Logger logger = LoggerFactory.getLogger(WorkflowSupport.class);

    private final RestTemplate restTemplate;

    public WorkflowSupport(WorkflowProperties workflowProperties) {
        checkServiceInfo(workflowProperties);
        this.restTemplate = new RestTemplate();
        this.restTemplate.setInterceptors(Collections.singletonList(this::logIntercept));
        // 工作流服务 api请求头
        ClientHttpRequestInitializer clientHttpRequestInitializer = request -> {
            HttpHeaders headers = request.getHeaders();
            headers.add("AK", workflowProperties.getAppId());
            headers.add("SK", workflowProperties.getSecretKey());
        };
        restTemplate.setClientHttpRequestInitializers(Collections.singletonList(clientHttpRequestInitializer));

        String baseUrl = workflowProperties.getBaseUrl();
        if (baseUrl != null) {
            DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
            restTemplate.setUriTemplateHandler(factory);
        }
    }

    /**
     * 构建rest客户端
     * @return rest客户端
     */
    protected RestTemplate getRestTemplate() {
        return this.restTemplate;
    }

    /**
     * 检查服务信息
     */
    private static void checkServiceInfo(WorkflowProperties workflowProperties) {
        if (workflowProperties == null || workflowProperties.getAppId() == null || workflowProperties.getBaseUrl() == null) {
            logger.error("未配置工作流服务");
            throw new RuntimeException("未配置工作流服务");
        }
    }

    private ClientHttpResponse logIntercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logger.debug("Request URI: {}", request.getURI());
        logger.debug("Request Method: {}", request.getMethod());
        logger.debug("Request Headers: {}", request.getHeaders().toSingleValueMap());
        logger.debug("Request Body: {}", new String(body, StandardCharsets.UTF_8));
        ClientHttpResponse execute = execution.execute(request, body);
        logger.debug("Response code: {}", execute.getStatusCode());
        return execute;
    }
}
