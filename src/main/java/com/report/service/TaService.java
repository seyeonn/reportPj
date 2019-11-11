package com.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.report.dto.Authority;
import com.report.dto.Ta;
//import com.report.mapper.AuthorityMapper;
import com.report.mapper.ProfessorMapper;
import com.report.mapper.TaMapper;

@Service
public class TaService {
    @Autowired
    TaMapper taMapper;
    @Autowired
    ProfessorMapper professorMapper;
//    @Autowired
//    AuthorityMapper authorityMapper;


    public List<Ta> findAll(){
        return taMapper.findAll();
    }

    public Ta createEntity(Ta newTa){
        Ta ta = new Ta();

//        Authority authority = new Authority();

        ta.setTa_no(newTa.getTa_no());

//        ta.setPassword(authority.getTa_authority());

//        ta.setProfessor(new Professor());
//
//        ta.getProfessor().setProfessorNo(newTa.getProfessorNo());

        return ta;
    }

    public void save(Ta newTa){
        Ta ta = createEntity(newTa);
        taMapper.insert(ta);
    }
    public Ta login(String taId, String password) {
        Ta ta = taMapper.findByTaId(taId);
        if (ta == null) {
            System.out.println("TA에 입력된 id 값은" + taId);
            return null;
        }
        String pw = password;
        if (!ta.getPassword().equals(pw)) {
            return null;
        }
        return ta;
    }

}