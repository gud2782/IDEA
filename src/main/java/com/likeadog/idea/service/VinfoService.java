package com.likeadog.idea.service;

import com.likeadog.idea.domain.Vinfo;
import com.likeadog.idea.repository.VinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VinfoService {

    private final VinfoRepository vinfoRepository;

    public List<Vinfo> findVcs() {

        return vinfoRepository.findAll();

    }

    public Vinfo findVaccine(Long vaccineIdx) {

        return vinfoRepository.findOne(vaccineIdx);

    }

    @Transactional
    public void saveVcs(Vinfo vinfo) {

        vinfoRepository.save(vinfo);

    }




}
