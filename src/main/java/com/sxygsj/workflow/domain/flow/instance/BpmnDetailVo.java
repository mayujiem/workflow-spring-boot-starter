package com.sxygsj.workflow.domain.flow.instance;
import java.util.List;

public class BpmnDetailVo {
    /**
     * bpmn xml
     */
    private String bpmnXml;
    /**
     * bpmn 节点数据
     */
    private List<FlowViewerDto> nodeData;

    public String getBpmnXml() {
        return bpmnXml;
    }

    public void setBpmnXml(String bpmnXml) {
        this.bpmnXml = bpmnXml;
    }

    public List<FlowViewerDto> getNodeData() {
        return nodeData;
    }

    public void setNodeData(List<FlowViewerDto> nodeData) {
        this.nodeData = nodeData;
    }
}
