package com.likeadog.idea.service;

import com.likeadog.idea.repository.TransfusionRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TransfusionService {

    private final TransfusionRepository transfusionRepository;
}
