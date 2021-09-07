package com.wangbin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadAndDownload {
    @PostMapping(value = "/upload")
    public String uploadFile(MultipartFile icon, HttpSession session) throws IOException {
        String fileName = icon.getName();
        String originalFilename = icon.getOriginalFilename();
        System.out.println(fileName);
        System.out.println(originalFilename);
        fileName = UUID.randomUUID().toString()+originalFilename;

        ServletContext context = session.getServletContext();
        String path = context.getRealPath("photo");
        if (! new File(path).exists()) new File(path).mkdirs();

        icon.transferTo(new File(path+"/"+fileName));
        return "success";
    }
}
