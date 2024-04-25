package com.abner.security.service.impl;

import com.abner.security.dao.SecurityKeyDao;
import com.abner.security.entity.SecurityKey;
import com.abner.security.entity.parm.SecurityKeyParam;
import com.abner.security.service.SecurityKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description for this class
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/4/25 14:26
 */
@Service
public class SecurityKeyServiceImpl implements SecurityKeyService {
    @Autowired
    private SecurityKeyDao securityKeyDao;

    @Override
    public SecurityKey create(SecurityKey securityKey) {
        return securityKeyDao.save(securityKey);
    }

    @Override
    public List<SecurityKey> list(SecurityKeyParam param) {
        SecurityKey example = SecurityKey.builder()
                .applyMemberId(param.getApplyMemberId())
                .projectId(param.getProjectId())
                .keyVersion(param.getKeyVersion())
                .build();
        return securityKeyDao.findAll(Example.of(example));
    }

    @Override
    public SecurityKey getProjectKey(Long projectId, Long version) {
        // TODO get current member information as a parameter
        SecurityKeyParam param = SecurityKeyParam.builder()
                // .applyMemberId()
                .projectId(projectId)
                .keyVersion(version)
                .build();
        List<SecurityKey> list = list(param);
        return list.stream().findFirst().orElse(null);
    }

    @Override
    public SecurityKey getById(Long id) {
        return securityKeyDao.findById(id).orElse(null);
    }
}
