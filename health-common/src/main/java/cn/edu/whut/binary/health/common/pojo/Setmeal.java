package cn.edu.whut.binary.health.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 16:53 Saturday
 */
public class Setmeal implements Serializable {
    private static final long serialVersionUID = -6265424093185956918L;

    private Integer id;
    /**
     * 体检套餐名称
     */
    private String name;
    /**
     * 体检套餐代号
     */
    private String code;
    /**
     * 体检套餐助记码
     */
    private String helpCode;
    /**
     * 套餐适用性别：0-不限  1-男   2-女
     */
    private String sex;
    /**
     * 套餐适用年龄（范围）
     */
    private String age;
    private Float price;
    private String remark;
    private String attention;
    /**
     * 套餐图片 url
     */
    private String img;

    /**
     * 体检套餐对应的检查组（多对多）
     */
    private List<CheckGroup> checkGroups;

    public List<CheckGroup> getCheckGroups() {
        return checkGroups;
    }

    public void setCheckGroups(List<CheckGroup> checkGroups) {
        this.checkGroups = checkGroups;
    }

    public Setmeal() {
    }

    public Setmeal(Integer id, String name, String code, String helpCode, String sex, String age, Float price, String remark, String attention, String img) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.helpCode = helpCode;
        this.sex = sex;
        this.age = age;
        this.price = price;
        this.remark = remark;
        this.attention = attention;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Setmeal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", helpCode='" + helpCode + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", price=" + price +
                ", remark='" + remark + '\'' +
                ", attention='" + attention + '\'' +
                ", img='" + img + '\'' +
                ", checkGroups=" + checkGroups +
                '}';
    }
}
