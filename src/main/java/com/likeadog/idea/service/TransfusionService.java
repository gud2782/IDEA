package com.likeadog.idea.service;

import com.likeadog.idea.domain.Transfusion;
import com.likeadog.idea.repository.TransfusionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TransfusionService {

    private final TransfusionRepository transfusionRepository;

    @Transactional
    public void saveTrans(Transfusion transfusion) {
        transfusionRepository.regTrans(transfusion);
    }

    public List<Transfusion> findTrans() {
        return transfusionRepository.findAll();
    }

    public Transfusion findOne(Long transfusionIdx) {
        return transfusionRepository.findOne(transfusionIdx);
    }
}
