package cn.edu.whut.binary.health.common.pojo;

import java.io.Serializable;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 16:36 Saturday
 */
public class CheckItem implements Serializable {
    private static final long serialVersionUID = 213180200224709085L;

    private Integer id;
    /**
     * 检查项代号
     */
    private String code;
    /**
     * 检查项名称
     */
    private String name;
    /**
     * 适用性别
     */
    private String sex;
    /**
     * 适用年龄（范围）
     */
    private String age;
    private Float price;
    /**
     * 检查项类型：检查或检验
     */
    private String type;
    /**
     * 说明
     */
    private String remark;
    /**
     * 注意事项
     */
    private String attention;

    public CheckItem() {
    }

    public Integer getId() {
        return id;
    }

    public CheckItem(Integer id, String code, String name, String sex, String age, Float price, String type, String remark, String attention) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.price = price;
        this.type = type;
        this.remark = remark;
        this.attention = attention;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CheckItem{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", attention='" + attention + '\'' +
                '}';
    }
}

