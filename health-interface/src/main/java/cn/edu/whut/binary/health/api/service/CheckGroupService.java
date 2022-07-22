package cn.edu.whut.binary.health.api.service;

import cn.edu.whut.binary.health.common.entity.PageQueryBean;
import cn.edu.whut.binary.health.common.pojo.CheckGroup;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-19 10:00 Tuesday
 */
public interface CheckGroupService {
    /**
     * 保存检查组，并维护检查组和检查项的多对多关系
     *
     * @param checkGroup      检查组
     * @param checkItemIdList 检查组关联的检查项的 ID
     */
    boolean saveCheckGroup(CheckGroup checkGroup, List<Integer> checkItemIdList);

    /**
     * 获取检查组分页数据
     *
     * @param pageQueryBean 分页查询条件，包含了当前页码、每页数量、查询条件
     */
    PageInfo<CheckGroup> getCheckGroupPageData(PageQueryBean pageQueryBean);

    /**
     * 通过 ID 删除检查组
     *
     * @return true - 删除成功
     */
    boolean deleteCheckGroupById(Integer checkGroupId);

    /**
     * 根据检查组 ID 查询其对应的检查项信息（一个检查组对应多个检查项）
     *
     * @return 检查组对应的检查项的 ID 集合
     */
    List<Integer> getCheckItemIdsOfCheckGroup(Integer checkGroupId);

    /**
     * 更新检查组信息，并更新检查组所对应的检查项
     *
     * @param checkGroup      新的检查组信息
     * @param checkItemIdList 新检查组所对应的新检查项的 ID 集合
     * @return true - 更新成功
     */
    boolean updateCheckGroup(CheckGroup checkGroup, List<Integer> checkItemIdList);

    /**
     * 查询所有检查组
     */
    List<CheckGroup> getAllCheckGroups();
}