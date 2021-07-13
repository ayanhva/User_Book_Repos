package com.example.project.service;

import com.example.project.domain.ConfToken;
import com.example.project.repository.ConfTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ConfTokenService {

    private ConfTokenRepository confTokenRepository;

    public void saveConfToken(ConfToken token) {

        confTokenRepository.save(token);
    }
}
