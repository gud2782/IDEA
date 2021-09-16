package com.likeadog.idea.service;

import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.repository.DonationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    @Transactional
    public void saveDo(Donation donation) {

        donationRepository.regDo(donation);
    }

    public List<Donation> findDos() {
        return donationRepository.findAll();
    }

    public Donation findOne(Long donationIdx) {
        return donationRepository.findOne(donationIdx);
    }
}
