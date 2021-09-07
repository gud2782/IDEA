package com.likeadog.idea.service;

import com.likeadog.idea.repository.QrcodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QrcodeService {

    private final QrcodeRepository qrcodeRepository;
}
