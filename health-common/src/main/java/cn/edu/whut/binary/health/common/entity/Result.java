package cn.edu.whut.binary.health.common.entity;

import java.io.Serializable;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 16:59 Saturday
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 556516438072072653L;

    /**
     * 服务器处理结果
     */
    private boolean flag;
    /**
     * 响应的消息
     */
    private String message;
    /**
     * 返回的数据
     */
    private Object data;

    public Result(boolean flag, String message) {
        super();
        this.flag = flag;
        this.message = message;
    }

    public Result(boolean flag, String message, Object data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "flag=" + flag +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
