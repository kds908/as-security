package com.abner.security.encrypt;

import com.abner.security.meta.AlgorithmDefinition;

/**
 * Description for this class
 *
 * <p>
 * {@code @author: } Abner Song
 * <p>
 * {@code @date: } 2024/4/3 15:45
 */
public interface EncryptFactory {
    Class<?> getAlgorithmClass(String algorithmName) throws Exception;

    void registerAlgorithmDefinition(AlgorithmDefinition definition);
}
