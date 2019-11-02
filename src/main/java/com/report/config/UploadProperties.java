package com.report.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "com.report.upload")
public class UploadProperties { //application.properties 파일의 설정을 읽기 위한 클래스

	//	application.properties 파일의 다음 설정 값들이 UploadProperties 클래스의 속성에 자동 대입된다.
	String localPath;
    String urlPath;
}
