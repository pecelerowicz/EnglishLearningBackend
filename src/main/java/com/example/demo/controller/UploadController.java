package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@RestController
@RequestMapping("/api")
public class UploadController {

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file")MultipartFile file) throws IOException {
        Path path = FileSystems.getDefault().getPath("my_folder", file.getOriginalFilename());
        file.transferTo(path);
        return "Done!";
    }

}
