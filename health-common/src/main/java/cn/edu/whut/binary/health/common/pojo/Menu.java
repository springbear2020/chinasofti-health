package cn.edu.whut.binary.health.common.pojo;

import javax.management.relation.Role;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 16:43 Saturday
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = -3531666474030410778L;

    private Integer id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 访问路径
     */
    private String linkUrl;
    /**
     * 菜单项所对应的路由路径
     */
    private String path;
    /**
     * 优先级（用于排序）
     */
    private Integer priority;
    private String description;
    private String icon;
    private Integer parentMenuId;

    /**
     * 角色集合
     */
    private Set<Role> roles = new HashSet<>(0);
    /**
     * 子菜单集合
     */
    private List<Menu> children = new ArrayList<>();

    public Menu() {
    }

    public Menu(Integer id, String name, String linkUrl, String path, Integer priority, String description, String icon, Integer parentMenuId) {
        this.id = id;
        this.name = name;
        this.linkUrl = linkUrl;
        this.path = path;
        this.priority = priority;
        this.description = description;
        this.icon = icon;
        this.parentMenuId = parentMenuId;
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

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(Integer parentMenuId) {
        this.parentMenuId = parentMenuId;
    }
}
