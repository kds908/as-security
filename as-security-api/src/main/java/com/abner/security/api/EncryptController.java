package com.abner.security.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description for this class
 *
 * <p>
 * {@code @author: } Abner Song
 * <p>
 * {@code @date: } 2024/4/3 15:25
 */
@Slf4j
@RestController
@RequestMapping("/encrypt")
public class EncryptController {

    @GetMapping("encryptData")
    public Object encrypt(String algorithmName, String data) {
        log.info("apply encrypt service:algorithm={}, data={}", algorithmName, data);
        return null;
    }

    @GetMapping("decryptData")
    public Object decrypt(String algorithmName, String data) {
        log.info("apply decrypt service:algorithm={}, data={}", algorithmName, data);
        return null;
    }
}
