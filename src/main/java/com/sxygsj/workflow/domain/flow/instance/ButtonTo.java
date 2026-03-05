package com.sxygsj.workflow.domain.flow.instance;

/**
 * 按钮
 * @author myj
 * @since 2025/10/16
 */
public class ButtonTo {
    /**
     * 按钮类型
     */
    private String type;
    /**
     * 按钮别名
     */
    private String remark;
    /**
     * 审批意见是否必填
     * 1=必填 0=非必填
     */
    private Integer requiredComment = 1;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getRequiredComment() {
        return requiredComment;
    }

    public void setRequiredComment(Integer requiredComment) {
        this.requiredComment = requiredComment;
    }
}
