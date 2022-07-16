package cn.edu.whut.binary.health.common.entity;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 17:01 Saturday
 */
public class Response implements Serializable {
    private static final long serialVersionUID = 1992589378681096903L;

    public static final int SUCCESS = 0;
    public static final int INFO = 1;
    public static final int WARN = 2;
    public static final int ERROR = 3;

    /**
     * 响应码
     */
    private Integer code;
    /**
     * 响应的消息
     */
    private String msg;
    /**
     * 响应的数据
     */
    private Map<String, Object> resultMap = new HashMap<>();

    public static Response success(String msg) {
        return getResponse(msg, SUCCESS);
    }

    public static Response info(String msg) {
        return getResponse(msg, INFO);
    }

    public static Response warn(String msg) {
        return getResponse(msg, WARN);
    }

    public static Response error(String msg) {
        return getResponse(msg, ERROR);
    }

    private static Response getResponse(String msg, int code) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public Response put(String key, Object value) {
        this.getResultMap().put(key, value);
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
}
