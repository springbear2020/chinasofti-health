package cn.edu.whut.binary.health.backend.controller;

import cn.edu.whut.binary.health.common.constant.MessageConstant;
import cn.edu.whut.binary.health.common.entity.Response;
import cn.edu.whut.binary.health.common.util.DateUtils;
import cn.edu.whut.binary.health.common.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-22 09:11 Friday
 */
@RestController
public class TransferController {
    @PostMapping("/transfer.do")
    public Response saveImage(@RequestParam("img") MultipartFile img, HttpSession session) {
        // 获取 webapp/ 目录在磁盘上的真实路径
        String realPath = session.getServletContext().getRealPath("/");
        // 判断今日文件上传保存目录是否存在，不存在则创建
        String fileSavePath = "/resources/img/" + DateUtils.parseDateWithHyphen(new Date());
        File directoryToday = new File(realPath + fileSavePath);
        if (!directoryToday.exists()) {
            // 创建多级目录，忽略返回值
            directoryToday.mkdirs();
        }

        try {
            // 获取源文件名
            String imgName = img.getOriginalFilename();
            assert imgName != null;
            String suffix = imgName.substring(imgName.lastIndexOf("."));
            // 给源文件重新命名，例如格式为：202207221015-a28ee439.png
            String newFileName = StringUtils.getImageFileName(suffix);
            // 保存图片到磁盘目录
            img.transferTo(new File(directoryToday + "/" + newFileName));
            return Response.success(MessageConstant.PIC_UPLOAD_SUCCESS).put("url", fileSavePath + "/" + newFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.error(MessageConstant.PIC_UPLOAD_FAIL);
    }
}
