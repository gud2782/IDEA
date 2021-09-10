package com.likeadog.idea.service;

import com.likeadog.idea.repository.V_infoRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class V_infoService {

    private final V_infoRepository v_infoRepository;
}
