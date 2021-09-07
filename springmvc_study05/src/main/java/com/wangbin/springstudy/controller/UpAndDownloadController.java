package com.wangbin.springstudy.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UpAndDownloadController {

    @GetMapping(value = "/download")
    public ResponseEntity<byte[]> getDownload(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String path = servletContext.getRealPath("/static/pic/aa.jpg");
        System.out.println("pic location: " + path);
        //read file
        FileInputStream inputStream = new FileInputStream(path);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();
        //create header
        MultiValueMap<String,String> httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition","attachment;filename=aa.jpg");
        //create the return code
        HttpStatus statusCode = HttpStatus.OK;
        return new ResponseEntity<byte[]>(bytes, httpHeaders, statusCode);
    }

    @PostMapping(value = "/upload")
    public String uploadFile(MultipartFile multipartFile,HttpSession session) throws IOException {
        String fileName = multipartFile.getName();
        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println(fileName);
        System.out.println(originalFilename);
        fileName = UUID.randomUUID().toString()+originalFilename;

        ServletContext context = session.getServletContext();
        String path = context.getRealPath("photo");
        if (! new File(path).exists()) new File(path).mkdirs();

//        multipartFile.transferTo(new File(path+"/"+fileName));
        return "success";
    }
}
