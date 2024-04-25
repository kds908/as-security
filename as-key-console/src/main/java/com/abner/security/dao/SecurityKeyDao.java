package com.abner.security.dao;

import com.abner.security.entity.SecurityKey;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description for this class
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/4/25 14:26
 */
public interface SecurityKeyDao extends JpaRepository<SecurityKey, Long> {
}
