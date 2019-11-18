package com.report.service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.report.dto.Lecturefile;
import com.report.mapper.LecturefileMapper;



@Service
public class LecturefileService {

    @Autowired LecturefileMapper lecturefileMapper;

    // 파일 목록 조회
    public List<Lecturefile> findAll(int id) {
        return lecturefileMapper.findAll(id); // uploadedFile 테이블의 모든 레코드를 조회
    }

    // 파일 저장
    public void save(MultipartFile multipartFile, int lecture_no) throws IOException {
        // 업로드된 파일의 이름을 구한다.
        String fileName = Paths.get(multipartFile.getOriginalFilename()).getFileName().toString();

        Lecturefile lecturefile = new Lecturefile(); // 엔터티 객체 생성.
        lecturefile.setFile_name(fileName); // 파일명 설정
        lecturefile.setFile_size((int) multipartFile.getSize()); // 파일크 기 설정
        lecturefile.setFile_time(new Date()); // 현재 시각 설정
        lecturefile.setData(multipartFile.getBytes()); // 파일의 내용을 data 속성에 저장
        lecturefile.setLecture_no(lecture_no);
        lecturefileMapper.insert(lecturefile); // lectureFile 테이블에 저장
    }

    // 파일 삭제
    public void delete(int no) throws IOException {
    	lecturefileMapper.deleteByNo(no); // uploadedFile 테이블에서 레코드 삭제
    }

    // 다운로드하기 위해 파일을 조회하여 리턴
    public Lecturefile getUploadedFile(int no) throws IOException {
        return lecturefileMapper.findByNo(no); // uploadedFile 테이블에서 레코드 조회
    }
}
