package cn.edu.whut.binary.health.common.pojo;

import javax.management.relation.Role;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 16:29 Saturday
 */
public class User implements Serializable {
    private static final long serialVersionUID = 8941595137071806517L;

    private Integer id;
    private Date birthday;
    private String gender;
    /**
     * 用户名（唯一）
     */
    private String username;
    private String password;
    /**
     * 备注
     */
    private String remark;
    private String station;
    private String telephone;

    /**
     * 用户对应的角色列表
     */
    private Set<Role> roles = new HashSet<>(0);

    public User() {
    }

    public User(Integer id, Date birthday, String gender, String username, String password, String remark, String station, String telephone) {
        this.id = id;
        this.birthday = birthday;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.remark = remark;
        this.station = station;
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", remark='" + remark + '\'' +
                ", station='" + station + '\'' +
                ", telephone='" + telephone + '\'' +
                ", roles=" + roles +
                '}';
    }
}