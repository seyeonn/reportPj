package com.report.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.report.config.UploadProperties;
import com.report.dto.UploadedFile;
import com.report.mapper.UploadedFileMapper;

//업로드된 파일의 내용을 파일시스템 폴더에 저장한다.
//그 폴더는 webapp 폴더 아래에 있어야 한다.
//
//webapp 폴더 아래에 파일이 저장되기 때문에,
//액션 메소드를 거치지 않고 그 파일의 URL을 이용하여 다운로드 한다.

@Service
public class UploadedFile3Service {

    @Autowired UploadProperties uploadProperties; // application.properties 파일의 설정 값
    @Autowired UploadedFileMapper uploadedFileMapper;
    @Autowired ServletContext servletContext; // webapp 폴더의 경로명을 계산하기 위해 필요한 객체

    // 파일 목록 조회
    public List<UploadedFile> findAll() {
        return uploadedFileMapper.findAll();
    }

    // application.properties 파일에서 urlPath 설정값을 리턴한다.
    // webapp 폴더 아래의,  다운로드할 파일들이 들어있는 폴더의 경로이다
    public String getUrlPath() {
        return uploadProperties.getUrlPath();
    }

    // 파일 저장
    public void save(MultipartFile multipartFile) throws IOException {
        // 업로드된 파일의 이름을 구한다.
        String fileName = Paths.get(multipartFile.getOriginalFilename()).getFileName().toString();
        String extension = getExtension(fileName); // 파일의 확장자를 구한다.

        UploadedFile uploadedFile = new UploadedFile();  // 엔터티 객체 생성
        uploadedFile.setFile_name(""); // 새 파일명을 아직 결정할 수 없어서 공백만 저장한다.
        uploadedFile.setFile_size((int) multipartFile.getSize()); // 파일 크기 설정
        uploadedFile.setFile_time(new Date()); // 현재 시각 설정
        uploadedFileMapper.insert(uploadedFile); // uploadedFile 테이블에 저장
        // 저장하자마자 auto increment인 id 필드 값이 결정된다.
        // id 필드 값과, 업로드된 파일명에서 확장자 부분을 결합하여 새 파일명 생성
        String newFileName = uploadedFile.getNo() + extension;
        uploadedFile.setFile_name(newFileName); // 새 파일명 설정
        uploadedFileMapper.insert(uploadedFile); // 새 파일명을 테이블에 update 한다.

        // 파일의 내용을 업로드 폴더 아래에 파일을 생성하여 저장
        Files.write(getFilePath(uploadedFile), multipartFile.getBytes());
    }

    // 파일 삭제
    public void delete(int no) {
        try {
            // 삭제할 파일 레코드 조회
            uploadedFileMapper.deleteByNo(no);  // uploadedFile 테이블에서 레코드 삭제
            UploadedFile uploadedFile = uploadedFileMapper.findByNo(no);
            Files.delete(getFilePath(uploadedFile)); // 업로드 폴더에 저장된 파일 삭제
        } catch (Exception e) {
        }
    }

    // 파일명에서 확장자 부분을 리턴한다.
    private String getExtension(String fileName) {
        String extension = "";
        int index = fileName.lastIndexOf('.');
        if (index > 0) extension = fileName.substring(index);
        return extension;
    }

    // 파일의 내용을 저장할 파일의 경로명을 리턴한다.
    private Path getFilePath(UploadedFile uploadedFile) {
        // servletContext.getRealPath(File.separator) => webapp 폴더의 절대 경로명을 구한다.
        // uploadProperties.getUrlPath() => 파일을 저장할 폴더의, webapp 폴더 아래 경로명을 구한다.
        String folderPath = servletContext.getRealPath(File.separator) + uploadProperties.getUrlPath();

        // 폴더의 경로명과 파일이름을 결합한 경로 객체를 리턴한다.
        return Paths.get(folderPath, uploadedFile.getFile_name());
    }

}
