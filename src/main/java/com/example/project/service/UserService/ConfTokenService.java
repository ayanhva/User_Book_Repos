package com.example.project.service.UserService;

import com.example.project.domain.ConfToken;
import com.example.project.repository.ConfTokenRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ConfTokenService {

    private ConfTokenRepository confTokenRepository;

    public void saveConfToken(ConfToken token){
        confTokenRepository.save(token);
    }
}
