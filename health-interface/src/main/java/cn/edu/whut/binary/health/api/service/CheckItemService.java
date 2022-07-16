package cn.edu.whut.binary.health.api.service;

import cn.edu.whut.binary.health.common.pojo.CheckItem;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 17:40 Saturday
 */
public interface CheckItemService {
    /**
     * 保存检查项
     */
    boolean saveCheckItem(CheckItem checkItem);
}
