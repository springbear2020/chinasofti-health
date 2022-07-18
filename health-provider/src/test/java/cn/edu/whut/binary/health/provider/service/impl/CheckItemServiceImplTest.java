package cn.edu.whut.binary.health.provider.service.impl;

import cn.edu.whut.binary.health.api.service.CheckItemService;
import cn.edu.whut.binary.health.common.entity.PageQueryBean;
import cn.edu.whut.binary.health.common.pojo.CheckItem;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author Spring-_-Bear
 * @datetime 2022-07-18 10:45 Monday
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CheckItemServiceImplTest {
    @Autowired
    private CheckItemService checkItemService;

    @Test
    public void getCheckItemPageData() {
        PageQueryBean pageQueryBean = new PageQueryBean(1, 5, null);
        PageInfo<CheckItem> checkItemPageData = checkItemService.getCheckItemPageData(pageQueryBean);
        System.out.println(checkItemPageData);
    }
}