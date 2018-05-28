package com.loser.web;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("flie") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String filename = file.getOriginalFilename();
                if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")
                        || filename.endsWith(".png")){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
                    System.out.println(sdf.format(new Date()));
                    FileUtils.writeByteArrayToFile(new File("E:/ideaProject/MicroBlog/src/main/resources/head/"+ sdf.format(new Date()) +".jpg"),
                            file.getBytes());
                    return "success";
                }
            }
            return "geshi buxing";
        } catch (IOException e) {
            e.printStackTrace();
            return "shangchuancuow";
        }
    }
}
