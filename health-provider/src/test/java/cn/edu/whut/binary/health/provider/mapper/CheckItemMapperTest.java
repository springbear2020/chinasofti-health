package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.CheckItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 17:46 Saturday
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CheckItemMapperTest {
    @Autowired
    private CheckItemMapper checkItemMapper;

    @Test
    public void saveCheckItem() {
        CheckItem checkItem = new CheckItem(null, "1", "lcx", "男", "23-32", 23F, "1", "无", "无");
        System.out.println(checkItemMapper.saveCheckItem(checkItem));
    }
}