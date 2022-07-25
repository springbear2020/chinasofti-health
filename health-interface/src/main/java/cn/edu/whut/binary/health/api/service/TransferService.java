package cn.edu.whut.binary.health.api.service;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-25 15:50 Monday
 */
public interface TransferService {
    /**
     * 上传文件到七牛云服务器
     *
     * @param fileFullPath 文件全路径
     * @param key          文件重命名
     * @return 上传成功则返回文件的访问 url，否则返回 null
     */
    String qiniuFileUpload(String fileFullPath, String key);
}