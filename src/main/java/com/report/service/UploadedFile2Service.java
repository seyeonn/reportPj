package com.report.service;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.report.config.UploadProperties;
import com.report.dto.UploadedFile;
import com.report.mapper.UploadedFileMapper;



@Service
public class UploadedFile2Service { // 업로드된 파일의 내용을 파일시스템 폴더에 저장한다. 파일 다운로드 액션 메소드에서, 그 파일을 읽어서 출력한다.


    @Autowired UploadProperties uploadProperties; // application.properties 파일의 설정 값
    @Autowired UploadedFileMapper uploadedFileMapper;

    // 파일 목록 조회
    public List<UploadedFile> findAll() {
        return uploadedFileMapper.findAll(); // uploadedFile 테이블의 모든 레코드를 조회
    }

    // 파일 저장
    public void save(MultipartFile multipartFile) throws IOException {
        // 업로드된 파일의 이름을 구한다.
        String fileName = Paths.get(multipartFile.getOriginalFilename()).getFileName().toString();

        UploadedFile uploadedFile = new UploadedFile();  // 엔터티 객체 생성
        uploadedFile.setFile_name(fileName);  // 파일명 설정
        uploadedFile.setFile_size((int) multipartFile.getSize());  // 파일크 기 설정
        uploadedFile.setFile_time(new Date()); // 현재 시각 설정
        uploadedFileMapper.insert(uploadedFile);  // uploadedFile 테이블에 저장

        // 파일의 내용을 업로드 폴더 아래에 파일을 생성하여 저장
        Files.write(getFilePath(uploadedFile), multipartFile.getBytes());
    }

    // 파일 삭제
    public void delete(int no) throws IOException {
        try {
            // 삭제할 파일 레코드 조회
            uploadedFileMapper.deleteByNo(no); // uploadedFile 테이블에서 레코드 삭제
            UploadedFile uploadedFile = uploadedFileMapper.findByNo(no);
            Files.delete(getFilePath(uploadedFile)); // 업로드 폴더에 저장된 파일 삭제
        } catch (Exception e) {
        }
    }

    // 다운로드하기 위해 파일을 조회하여 리턴
    public UploadedFile getUploadedFile(int no) throws IOException {
        // uploadedFile 테이블에서 레코드 조회
        UploadedFile uploadedFile = uploadedFileMapper.findByNo(no);

        // 파일의 내용을 업로드 폴더 아래의 파일에서 읽어온다.
        byte[] data = Files.readAllBytes(getFilePath(uploadedFile));
        uploadedFile.setData(data); // 파일의 내용을 UploadedFile 객체에 채운다.
        return uploadedFile; // UploadedFile 객체 리턴
    }

    // 파일의 내용을 저장할 파일의 경로명을 리턴한다.
    private Path getFilePath(UploadedFile uploadedFile) {
        // UploadedFile 객체의 id 값은 uploadedFile 테이블의 primary key 이다.
        // 이 값을 파일명으로 사용한다.
        //
        // uploadProperties.getLocalPath() 값은 application.properties 파일의 설정값이고,
        // 파일을 저장할 폴더의 경로명을 지정한다.
        String newFileName = String.valueOf(uploadedFile.getNo());

        // 폴더의 경로명과 파일이름을 결합한 경로 객체를 리턴한다.
        return Paths.get(uploadProperties.getLocalPath(), newFileName);
    }

}
