package cn.edu.whut.binary.health.provider.service.impl;


import cn.edu.whut.binary.health.api.service.TransferService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-25 16:29 Monday
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TransferServiceImplTest {
    @Autowired
    private TransferService transferService;

    @Test
    public void qiniuFileUpload() {
        String fullPath = "C:\\Users\\Admin\\Desktop\\BeFree.jpg";
        String key = "be-free-20220725.jpg";
        String accessUrl = transferService.qiniuFileUpload(fullPath, key);
        System.out.println(accessUrl);
    }
}