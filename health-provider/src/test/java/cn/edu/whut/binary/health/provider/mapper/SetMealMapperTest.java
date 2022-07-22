package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.SetMeal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @author Spring-_-Bear
 * @datetime 2022-07-22 08:57 Friday
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SetMealMapperTest {
    @Autowired
    private SetMealMapper setMealMapper;

    @Test
    public void getSetMealByCodeOrNameOrHelpCode() {
        List<SetMeal> setMealList = setMealMapper.getSetMealByCodeOrNameOrHelpCode("");
        setMealList.forEach(System.out::println);
    }
}