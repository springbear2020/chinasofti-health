package cn.edu.whut.binary.health.common.pojo;

import javax.management.relation.Role;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 16:50 Saturday
 */
public class Permission implements Serializable {
    private static final long serialVersionUID = 348148272147864239L;

    private Integer id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限关键字，用于权限控制
     */
    private String keyword;
    /**
     *
     */
    private String description;

    /**
     * 当前权限对应的角色列表
     */
    private Set<Role> roles = new HashSet<>(0);

    public Permission() {
    }

    public Permission(Integer id, String name, String keyword, String description) {
        this.id = id;
        this.name = name;
        this.keyword = keyword;
        this.description = description;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keyword='" + keyword + '\'' +
                ", description='" + description + '\'' +
                ", roles=" + roles +
                '}';
    }
}
