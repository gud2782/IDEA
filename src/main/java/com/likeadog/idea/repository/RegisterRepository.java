package com.likeadog.idea.repository;

import com.likeadog.idea.domain.Register;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RegisterRepository {


    private final EntityManager em;



    public void regSave(Register register) {
        if(register.getRegisterIdx() == null) {
            em.persist(register); //신규생성 개념
        } else {
            em.merge(register); //업데이트 개념
        }

    }

    public Register findOne(Long registerIdx) {

        return  em.find(Register.class, registerIdx);
    }


    public List<Register> findAll() {
        return em.createQuery("select r from Register r", Register.class)
                .getResultList();

    }

    public List<Register> findByAniId(String aniId) {
        return em.createQuery("select r from Register r where r.aniId = :aniId",
                        Register.class)
                .setParameter("aniId", aniId)
                .getResultList();
    }
//    public Register deleteOne(Long registerIdx) {
//        return "";
//    }



}
