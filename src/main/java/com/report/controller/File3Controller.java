package com.report.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.report.service.UploadedFile3Service;

// 파일 데이터를 webapp 폴더에 저장.
// 정적 파일 다운로드
@Controller
public class File3Controller {

    @Autowired UploadedFile3Service uploadedFile3Service;

    @RequestMapping("file3/list")
    public String list(Model model) {
        model.addAttribute("uploadPath", uploadedFile3Service.getUrlPath());
        model.addAttribute("files", uploadedFile3Service.findAll());
        return "file/list3";
    }

    @RequestMapping(value="file3/upload", method=RequestMethod.POST)
    public String upload(@RequestParam("fileUpload") MultipartFile[] multipartFiles) throws IOException {
        for(MultipartFile multipartFile : multipartFiles) {
            if (multipartFile.getSize() <= 0) continue;
            uploadedFile3Service.save(multipartFile);
        }
        return "redirect:list";
    }

    @RequestMapping("file3/delete")
    public String delete(@RequestParam("id") int id) throws Exception {
        uploadedFile3Service.delete(id);
        return "redirect:list";
    }
}
