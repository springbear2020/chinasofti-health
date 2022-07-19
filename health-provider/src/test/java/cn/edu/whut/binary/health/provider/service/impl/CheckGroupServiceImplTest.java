package cn.edu.whut.binary.health.provider.service.impl;

import cn.edu.whut.binary.health.api.service.CheckGroupService;
import cn.edu.whut.binary.health.common.entity.PageQueryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author Spring-_-Bear
 * @datetime 2022-07-19 13:49 Tuesday
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CheckGroupServiceImplTest {
    @Autowired
    private CheckGroupService checkGroupService;

    @Test
    public void getCheckItemPageData() {
        PageQueryBean pageQueryBean = new PageQueryBean(1, 5, null);
        System.out.println(checkGroupService.getCheckGroupPageData(pageQueryBean));
    }
}