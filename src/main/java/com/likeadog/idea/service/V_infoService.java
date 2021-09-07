package com.likeadog.idea.service;

import com.likeadog.idea.repository.V_infoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class V_infoService {

    private final V_infoRepository v_infoRepository;
}
