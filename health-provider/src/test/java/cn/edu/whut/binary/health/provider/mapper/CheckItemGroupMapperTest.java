package cn.edu.whut.binary.health.provider.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Spring-_-Bear
 * @datetime 2022-07-19 11:43 Tuesday
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CheckItemGroupMapperTest {
    @Autowired
    private CheckItemGroupMapper checkItemGroupMapper;

    @Test
    public void saveCheckItemIdListBatch() {
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(101);
        list.add(102);
        System.out.println(checkItemGroupMapper.saveCheckItemIdListBatch(100, list));
    }
}