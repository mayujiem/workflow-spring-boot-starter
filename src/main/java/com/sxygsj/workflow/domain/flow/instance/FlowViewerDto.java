package com.sxygsj.workflow.domain.flow.instance;

public class FlowViewerDto {

    /**
     * 流程key
     */
    private String key;

    /**
     * 是否完成
     */
    private boolean completed;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
