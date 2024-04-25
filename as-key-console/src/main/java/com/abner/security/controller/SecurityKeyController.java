package com.abner.security.controller;

import com.abner.security.entity.SecurityKey;
import com.abner.security.entity.parm.SecurityKeyParam;
import com.abner.security.service.SecurityKeyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description for this class
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/4/25 14:14
 */
@Slf4j
@RestController
@RequestMapping("/security/key")
public class SecurityKeyController {
    @Autowired
    private SecurityKeyService securityKeyService;

    @PostMapping("/add")
    public SecurityKey add(@RequestBody SecurityKey securityKey) {
        log.info("add securityKey:{}", securityKey);
        return securityKeyService.create(securityKey);
    }

    @PutMapping("/list")
    public List<SecurityKey> list(SecurityKeyParam param) {
        log.info("list securityKey:{}", param);
        return securityKeyService.list(param);
    }

    @GetMapping("/getProjectKey")
    public SecurityKey getProjectKey(@RequestParam Long projectId, @RequestParam Long version) {
        log.info("security key getProjectKey:{}", projectId);
        return securityKeyService.getProjectKey(projectId, version);
    }

    @GetMapping("/findById/{id}")
    public SecurityKey findById(@PathVariable Long id) {
        log.info("security key findById:{}", id);
        return securityKeyService.getById(id);
    }
}
