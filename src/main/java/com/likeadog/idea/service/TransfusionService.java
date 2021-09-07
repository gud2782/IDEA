package com.likeadog.idea.service;

import com.likeadog.idea.repository.TransfusionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransfusionService {

    private final TransfusionRepository transfusionRepository;
}
