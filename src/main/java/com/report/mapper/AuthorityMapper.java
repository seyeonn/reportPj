package com.report.mapper;

import com.report.dto.Authority;

public interface AuthorityMapper {
	Authority findOne(int authority_no);
	Authority findByStudent_authority(String student_authority);
	Authority findByProfessor_authority(String professor_authority);
	Authority findByTa_authority(String ta_authority);

}
