package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.CheckGroup;
import cn.edu.whut.binary.health.common.pojo.CheckItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @author Spring-_-Bear
 * @datetime 2022-07-30 21:40 Saturday
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SetMealCheckGroupMapperTest {
    @Autowired
    private SetMealCheckGroupMapper setMealCheckGroupMapper;

    @Test
    public void getCheckGroupsOfSetMeal() {
        List<CheckGroup> checkGroupList = setMealCheckGroupMapper.getCheckGroupsOfSetMeal(5);
        checkGroupList.forEach(System.out::println);
    }

    @Test
    public void getCheckGroupsDetails() {
        List<CheckGroup> checkGroupList = setMealCheckGroupMapper.getCheckGroupsDetails(5);
        for (CheckGroup checkGroup : checkGroupList) {
            System.out.println("/* ----- 检查组 ----- */");
            System.out.println(checkGroup);
            List<CheckItem> checkItemList = checkGroup.getCheckItems();
            checkItemList.forEach(System.out::println);
        }
    }
}