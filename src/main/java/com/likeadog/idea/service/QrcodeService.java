package com.likeadog.idea.service;

import com.likeadog.idea.repository.QrcodeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QrcodeService {

    private final QrcodeRepository qrcodeRepository;
}
