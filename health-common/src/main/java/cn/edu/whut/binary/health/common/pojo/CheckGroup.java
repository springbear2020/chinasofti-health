package cn.edu.whut.binary.health.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 16:36 Saturday
 */
public class CheckGroup implements Serializable {
    private static final long serialVersionUID = -4684873775142187647L;

    private Integer id;
    /**
     * 检查组代号
     */
    private String code;
    /**
     * 检查组名称
     */
    private String name;
    /**
     * 检查组助记符
     */
    private String helpCode;
    /**
     * 检查组适用性别
     */
    private String sex;
    /**
     * 检查组介绍
     */
    private String remark;
    /**
     * 注意事项
     */
    private String attention;

    /**
     * 一个检查组含有多个检查项
     */
    private List<CheckItem> checkItems;

    public List<CheckItem> getCheckItems() {
        return checkItems;
    }

    public void setCheckItems(List<CheckItem> checkItems) {
        this.checkItems = checkItems;
    }

    public CheckGroup() {
    }

    public CheckGroup(Integer id, String code, String name, String helpCode, String sex, String remark, String attention) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.helpCode = helpCode;
        this.sex = sex;
        this.remark = remark;
        this.attention = attention;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHelpCode() {
        return helpCode;
    }

    public void setHelpCode(String helpCode) {
        this.helpCode = helpCode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    @Override
    public String toString() {
        return "CheckGroup{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", helpCode='" + helpCode + '\'' +
                ", sex='" + sex + '\'' +
                ", remark='" + remark + '\'' +
                ", attention='" + attention + '\'' +
                ", checkItems=" + checkItems +
                '}';
    }
}

