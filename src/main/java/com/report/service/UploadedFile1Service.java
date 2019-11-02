package com.report.service;

import java.io.IOException;


import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.report.dto.UploadedFile;
import com.report.mapper.UploadedFileMapper;


@Service
public class UploadedFile1Service { // 업로드된 파일의 내용을 uploadedFile 테이블의 data 필드에 저장한다.

    @Autowired 
    UploadedFileMapper uploadedFileMapper;

    // 파일 목록 조회
    public List<UploadedFile> findAll() {
        return uploadedFileMapper.findAll(); // uploadedFile 테이블의 모든 레코드를 조회
    }

    // 파일 저장
    public void save(MultipartFile multipartFile) throws IOException {
        // 업로드된 파일의 이름을 구한다.
        String fileName = Paths.get(multipartFile.getOriginalFilename()).getFileName().toString();

        UploadedFile uploadedFile = new UploadedFile(); // 엔터티 객체 생성
        uploadedFile.setFile_name(fileName); // 파일명 설정
        uploadedFile.setFile_size((int) multipartFile.getSize()); // 파일크 기 설정
        uploadedFile.setFile_time(new Date()); // 현재 시각 설정
        uploadedFile.setData(multipartFile.getBytes()); // 파일의 내용을 data 속성에 저장
        uploadedFileMapper.insert(uploadedFile); // uploadedFile 테이블에 저장
    }

    // 파일 삭제
    public void delete(int no) throws IOException {
        uploadedFileMapper.deleteByNo(no); // uploadedFile 테이블에서 레코드 삭제
    }

    // 다운로드하기 위해 파일을 조회하여 리턴
    public UploadedFile getUploadedFile(int no) throws IOException {
        return uploadedFileMapper.findByNo(no); // uploadedFile 테이블에서 레코드 조회
    }
}
