package com.likeadog.idea.service;

import com.likeadog.idea.repository.DonationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;
}
