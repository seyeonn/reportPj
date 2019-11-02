package com.report.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadedFile {
    
    int no;

    String file_name;
    int file_size;
    Date file_time;

    byte[] data; // 업로드된 파일의 내용을 저장하기 위한 멤버 변수 선언
}
