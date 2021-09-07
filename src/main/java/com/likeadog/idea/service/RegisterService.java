package com.likeadog.idea.service;

import com.likeadog.idea.repository.RegisterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;
}
