package cn.edu.whut.binary.health.common.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 16:52 Saturday
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 452144389340731787L;

    private Integer id;
    /**
     *  角色名称
     */
    private String name;
    /**
     * 角色关键字，用于权限控制
     */
    private String keyword;
    private String description;

    private Set<User> users = new HashSet<>(0);
    private Set<Permission> permissions = new HashSet<>(0);
    private LinkedHashSet<Menu> menus = new LinkedHashSet<>(0);

    public Role() {
    }

    public Role(Integer id, String name, String keyword, String description) {
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public LinkedHashSet<Menu> getMenus() {
        return menus;
    }

    public void setMenus(LinkedHashSet<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keyword='" + keyword + '\'' +
                ", description='" + description + '\'' +
                ", users=" + users +
                ", permissions=" + permissions +
                ", menus=" + menus +
                '}';
    }
}
