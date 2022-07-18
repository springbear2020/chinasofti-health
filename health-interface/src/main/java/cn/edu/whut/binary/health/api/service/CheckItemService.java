package cn.edu.whut.binary.health.api.service;

import cn.edu.whut.binary.health.common.entity.PageQueryBean;
import cn.edu.whut.binary.health.common.pojo.CheckItem;
import com.github.pagehelper.PageInfo;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 17:40 Saturday
 */
public interface CheckItemService {
    /**
     * 保存检查项
     */
    boolean saveCheckItem(CheckItem checkItem);

    /**
     * 获取检查项分页数据
     *
     * @param pageQueryBean 分页查询条件，包含了当前页码、每页数量、查询条件
     */
    PageInfo<CheckItem> getCheckItemPageData(PageQueryBean pageQueryBean);

    /**
     * 通过 ID 删除检查项
     *
     * @return true - 删除成功
     */
    boolean deleteCheckItemById(Integer checkItemId);

    /**
     * 根据 ID 查询检查项
     */
    CheckItem getCheckItemById(Integer checkItemId);

    /**
     * 根据 ID 更新检查项
     */
    boolean updateCheckItemById(CheckItem checkItem);
}
