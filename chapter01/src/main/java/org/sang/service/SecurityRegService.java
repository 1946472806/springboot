package org.sang.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityRegService {
    public int reg(String username,String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String encodePassword = encoder.encode(password);
        return saveToDb(username,encodePassword);
    }

    private int saveToDb(String username, String encodePasswod) {
        return 0;
    }
}
