package com.sxygsj.workflow.autoconfigure;

import com.sxygsj.workflow.FlowService;
import com.sxygsj.workflow.OrgService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({WorkflowProperties.class})
@Configuration(proxyBeanMethods = false)
public class WorkFlowServiceAutoConfiguration {
    private final WorkflowProperties workflowProperties;

    public WorkFlowServiceAutoConfiguration(WorkflowProperties workflowProperties) {
        this.workflowProperties = workflowProperties;
    }

    /**
     * 工作流流服务
     */
    @Bean
    public FlowService flowService(ApplicationEventPublisher applicationEventPublisher) {
        return new FlowService(workflowProperties,applicationEventPublisher);
    }


    /**
     * 组织架构
     */
    @Bean
    public OrgService orgService() {
        return new OrgService(workflowProperties);
    }


}
