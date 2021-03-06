package com.likeadog.idea.repository;

import com.likeadog.idea.domain.Register;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        Query query = em.createQuery("select r from Register r", Register.class);
        List<Register> listall = query.getResultList();
                return listall;

    }

    public List<Register> findAniByUserIDX(Long userIdx) {
        return em.createQuery("select r from Register r where r.del='NO' and r.user.userIdx = :userIdx",
                        Register.class)
                .setParameter("userIdx", userIdx)
                .getResultList();
    }


    public Register findByAniId(String aniId) {
        System.out.println("Repository_aniId : " +aniId);
        Register result = em.createQuery("select r from Register r where r.del='NO' and r.aniId = :aniId", Register.class)
                .setParameter("aniId",aniId)
                .getSingleResult();
        System.out.println(result.getAniName());
        return result;
//        return em.createQuery("select r from Register r where r.del='NO' and r.aniId = :aniId", Register.class)
//                .setParameter("aniId",aniId)
//                .getSingleResult();
    }

    public List<Register> findByPhone(String phone) {
        System.out.println("Repository_phone : " +phone);
        List<Register> result = em.createQuery("select r from Register r where r.del='NO' and r.user.phone = :phone", Register.class)
                .setParameter("phone",phone)
                .getResultList();
        System.out.println(result.get(0).getAniName());
        return result;
    }
}
