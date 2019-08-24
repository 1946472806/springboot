package org.sang.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //单文件上传
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest req) {
//        String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
        File directory = new File("src");
        String realPath = directory.getAbsolutePath() + File.separator + "main" + File.separator + "resources" + File.separator + "uploadFile";
        String format = sdf.format(new Date());
        File folder = new File(realPath + File.separator + format);
        if (!folder.isDirectory()) {
            boolean mkdir = folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        if (oldName == null) {
            return "没有选择文件,上传失败!";
        }
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        try {
            uploadFile.transferTo(new File(folder, newName));
            return req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/uploadFile/" + format + newName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败!";
    }

    //多文件上传
    @PostMapping("/uploads")
    public String uploads(MultipartFile[] uploadFiles, HttpServletRequest req) {
        for (MultipartFile uploadFile : uploadFiles) {
//        String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
            File directory = new File("src");
            String realPath = directory.getAbsolutePath() + File.separator + "main" + File.separator + "resources" + File.separator + "uploadFile";
            String format = sdf.format(new Date());
            File folder = new File(realPath + File.separator + format);
            if (!folder.isDirectory()) {
                boolean mkdir = folder.mkdirs();
            }
            String oldName = uploadFile.getOriginalFilename();
            if (oldName == null) {
                return "没有选择文件,上传失败!";
            }
            String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
            try {
                uploadFile.transferTo(new File(folder, newName));
                String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/uploadFile/" + format + newName;
                System.out.println(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "上传成功!!!";
    }
}

