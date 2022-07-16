package cn.edu.whut.binary.health.provider.service.impl;

import cn.edu.whut.binary.health.api.service.CheckItemService;
import cn.edu.whut.binary.health.common.pojo.CheckItem;
import cn.edu.whut.binary.health.provider.mapper.CheckItemMapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 17:40 Saturday
 */
@Service(interfaceClass = CheckItemService.class)
@org.springframework.stereotype.Service
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemMapper checkItemMapper;

    @Override
    public boolean saveCheckItem(CheckItem checkItem) {
        return this.checkItemMapper.saveCheckItem(checkItem) == 1;
    }
}
