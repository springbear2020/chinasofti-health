package cn.edu.whut.binary.health.provider.service.impl;

import cn.edu.whut.binary.health.api.service.TransferService;
import com.alibaba.dubbo.config.annotation.Service;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.io.File;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-25 16:15 Monday
 */
@Service(interfaceClass = TransferService.class)
@org.springframework.stereotype.Service
@PropertySource("classpath:qiniu.properties")
public class TransferServiceImpl implements TransferService {
    /**
     * Qiniu cloud
     */
    @Value("${qiniu.qiniuService}")
    private Boolean qiniuService;
    @Value("${qiniu.accessKey}")
    private String accessKey;
    @Value("${qiniu.secretKey}")
    private String secretKey;
    @Value("${qiniu.bucket}")
    private String bucket;
    @Value("${qiniu.cdnDomain}")
    private String cdnDomain;

    @Override
    public String qiniuFileUpload(String fileFullPath, String key) {
        if (qiniuService) {
            UploadManager uploadManager = new UploadManager(new Configuration(Region.region2()));
            Auth auth = Auth.create(accessKey, secretKey);
            String uploadToken = auth.uploadToken(bucket);
            try {
                uploadManager.put(new File(fileFullPath), key, uploadToken);
                return cdnDomain + key;
            } catch (QiniuException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
