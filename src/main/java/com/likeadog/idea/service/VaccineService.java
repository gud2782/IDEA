package com.likeadog.idea.service;

import com.likeadog.idea.repository.VaccineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VaccineService {

    private final VaccineRepository vaccineRepository;
}
