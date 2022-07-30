package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.CheckGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @author Spring-_-Bear
 * @datetime 2022-07-19 11:22 Tuesday
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CheckGroupMapperTest {
    @Autowired
    private CheckGroupMapper checkGroupMapper;

    @Test
    public void saveCheckGroup() {
        CheckGroup checkGroup = new CheckGroup();
        checkGroup.setCode("123");
        System.out.println(checkGroupMapper.saveCheckGroup(checkGroup));
    }

    @Test
    public void getCheckGroupByCodeOrNameOrHelpCode() {
        System.out.println(checkGroupMapper.getCheckGroupByCodeOrNameOrHelpCode("GGSX"));
    }

    @Test
    public void updateCheckGroupById() {
        CheckGroup checkGroup = new CheckGroup();
        checkGroup.setId(5);
        checkGroup.setSex("1");
        System.out.println(checkGroupMapper.updateCheckGroupById(checkGroup));
    }
}