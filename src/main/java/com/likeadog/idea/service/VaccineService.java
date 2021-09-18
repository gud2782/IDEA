package com.likeadog.idea.service;

import com.likeadog.idea.domain.User;
import com.likeadog.idea.repository.VaccineRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VaccineService {

    private final VaccineRepository vaccineRepository;

    @Transactional
    public Long join(User user) {
        vaccineRepository.save(user);
        return user.getUserIdx();

    }
}
