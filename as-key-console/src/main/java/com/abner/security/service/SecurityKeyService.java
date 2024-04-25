package com.abner.security.service;

import com.abner.security.entity.SecurityKey;
import com.abner.security.entity.parm.SecurityKeyParam;

import java.util.List;

/**
 * Description for this class
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/4/25 14:25
 */
public interface SecurityKeyService {
    SecurityKey create(SecurityKey securityKey);

    List<SecurityKey> list(SecurityKeyParam param);

    SecurityKey getProjectKey(Long projectId, Long version);

    SecurityKey getById(Long id);
}
