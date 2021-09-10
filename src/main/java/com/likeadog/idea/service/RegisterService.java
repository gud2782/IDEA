package com.likeadog.idea.service;

import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.User;
import com.likeadog.idea.repository.RegisterRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;

    //동물등록
    public Long regJoin(Register register) {
        validateDuplicateUser(register); //중복 등록 검증
        registerRepository.regSave(register);
        return register.getRegisterIdx();
    }

    private void validateDuplicateUser(Register register) {
        List<Register> findMembers =
                registerRepository.findByAniId(register.getAniId());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 등록된 정보입니다.");
        }
    }
}
