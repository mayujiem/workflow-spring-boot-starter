package com.sxygsj.workflow.domain;

/**
 * 响应信息主体
 */
public class R<T> {
    /** 成功 */
    public static final int SUCCESS = 200;

    private int code;

    private String msg;

    private T data;

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

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public  Boolean isSuccess()
    {
        return R.SUCCESS == this.getCode();
    }

    @Override
    public String toString() {
        return "R{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
