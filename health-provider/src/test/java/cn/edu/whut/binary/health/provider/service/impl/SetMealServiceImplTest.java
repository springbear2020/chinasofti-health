package cn.edu.whut.binary.health.provider.service.impl;

import cn.edu.whut.binary.health.api.service.SetMealService;
import cn.edu.whut.binary.health.common.pojo.CheckGroup;
import cn.edu.whut.binary.health.common.pojo.CheckItem;
import cn.edu.whut.binary.health.common.pojo.SetMeal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @author Spring-_-Bear
 * @datetime 2022-07-30 18:46 Saturday
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SetMealServiceImplTest {
    @Autowired

    private SetMealService setMealService;

    @Test
    public void getSetMealDetails() {
        SetMeal setMeal = setMealService.getSetMealDetails(5);
        System.out.println(setMeal);
        List<CheckGroup> checkGroupList = setMeal.getCheckGroups();
        for (CheckGroup checkGroup : checkGroupList) {
            System.out.println("/* ----- 检查组 ----- */");
            System.out.println(checkGroup);
            List<CheckItem> checkItemList = checkGroup.getCheckItems();
            checkItemList.forEach(System.out::println);
        }
    }
}