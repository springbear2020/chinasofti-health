package cn.edu.whut.binary.health.backend.controller;

import cn.edu.whut.binary.health.common.constant.MessageConstant;
import cn.edu.whut.binary.health.common.entity.Response;
import cn.edu.whut.binary.health.common.util.DateUtils;
import cn.edu.whut.binary.health.common.util.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-22 09:11 Friday
 */
@Controller
public class TransferController {
    @PostMapping("/transfer.do")
    @ResponseBody
    public Response fileUpload(@RequestParam("file") MultipartFile file, HttpSession session) {
        // 获取 webapp/ 目录在磁盘上的真实路径
        String realPath = session.getServletContext().getRealPath("/");
        // 判断今日文件上传保存目录是否存在，不存在则创建
        String fileSavePath = "/file/upload/" + DateUtils.parseDateWithHyphen(new Date());
        File directoryToday = new File(realPath + fileSavePath);
        if (!directoryToday.exists()) {
            // 创建多级目录，忽略返回值
            directoryToday.mkdirs();
        }

        try {
            // 获取源文件名
            String imgName = file.getOriginalFilename();
            assert imgName != null;
            String suffix = imgName.substring(imgName.lastIndexOf("."));
            // 给源文件重新命名，例如格式为：202207221015-a28ee439.png
            String newFileName = FileUtils.getImageFileName(suffix);
            // 保存文件到磁盘目录
            file.transferTo(new File(directoryToday + "/" + newFileName));
            return Response.success(MessageConstant.UPLOAD_SUCCESS).put("url", fileSavePath + "/" + newFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.error(MessageConstant.UPLOAD_FAIL);
    }

    /**
     * 文件下载
     *
     * @param filename 全文件名（包含文件后缀名）
     */
    @GetMapping("/transfer.do")
    public ResponseEntity<byte[]> fileDownload(@RequestParam("filename") String filename) {
        // 使用 Spring 定位类路径下的文件资源，文件统一放在类路径下的 file/ 目录中
        Resource resource = new ClassPathResource("file/" + filename);
        byte[] byteData;
        try {
            InputStream inputStream = resource.getInputStream();
            // 创建与文件输入流中字节数等大的字节数组
            byteData = new byte[inputStream.available()];
            // 将文件中的二进制数据读入到缓冲字节数组中
            inputStream.read(byteData);
            inputStream.close();
        } catch (IOException e) {
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }

        // 创建 HttpHeaders 对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        // 设置下载的方式及下载文件名
        headers.add("Content-Disposition", "attachment;filename=" + resource.getFilename());
        // 响应 ResponseEntity 对象
        return new ResponseEntity<>(byteData, headers, HttpStatus.OK);
    }
}
