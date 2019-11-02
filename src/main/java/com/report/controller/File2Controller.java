package com.report.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.report.dto.UploadedFile;
import com.report.service.UploadedFile2Service;


// 파일 데이터를 폴더에 저장.
// 액션 메소드에서 파일을 다운로드 함.
@Controller
public class File2Controller {

    @Autowired UploadedFile2Service uploadedFile2Service;

    @RequestMapping("file2/list")
    public String list(Model model) {
        model.addAttribute("files", uploadedFile2Service.findAll());
        return "file/list";
    }

    @RequestMapping(value="file2/upload", method=RequestMethod.POST)
    public String upload(@RequestParam("fileUpload") MultipartFile[] multipartFiles) throws IOException {
        for(MultipartFile multipartFile : multipartFiles) {
            if (multipartFile.getSize() <= 0) continue;
            uploadedFile2Service.save(multipartFile);
        }
        return "redirect:list";
    }

    @RequestMapping("file2/delete")
    public String delete(@RequestParam("id") int id) throws Exception {
        uploadedFile2Service.delete(id);
        return "redirect:list";
    }

    @RequestMapping("file2/download")
    public void download(@RequestParam("id") int id, HttpServletResponse response) throws Exception {
        UploadedFile uploadedfile = uploadedFile2Service.getUploadedFile(id);
       if (uploadedfile == null) return;
        String fileName = URLEncoder.encode(uploadedfile.getFile_name(),"UTF-8");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";");
        try (BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream())) {
            output.write(uploadedfile.getData());
        }
    }
}
