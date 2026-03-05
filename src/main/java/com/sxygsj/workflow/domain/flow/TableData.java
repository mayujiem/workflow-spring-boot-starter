package com.sxygsj.workflow.domain.flow;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 表格分页数据对象
 */
public class TableData<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 总记录数 */
    private long total;

    /** 列表数据 */
    private List<T> rows;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private String msg;

    /**
     * 表格数据对象
     */
    public TableData()
    {
    }
    public static <T> TableData<T> emptyList(int code, String msg){
        TableData<T> objectTableData = new TableData<>(Collections.emptyList(), 0);
        objectTableData.setCode(code);
        objectTableData.setMsg(msg);
        return objectTableData;
    }
    /**
     * 分页
     *
     * @param list 列表数据
     * @param total 总记录数
     */
    public TableData(List<T> list, long total)
    {
        this.rows = list;
        this.total = total;
    }

    public long getTotal()
    {
        return total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

    public List<T> getRows()
    {
        return rows;
    }

    public void setRows(List<T> rows)
    {
        this.rows = rows;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }
}
