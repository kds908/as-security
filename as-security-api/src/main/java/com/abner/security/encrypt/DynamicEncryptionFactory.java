package com.abner.security.encrypt;

import com.abner.security.loader.AlgorithmUtil;
import com.abner.security.loader.DynamicEncryptionLoader;
import com.abner.security.meta.AlgorithmDefinition;
import org.springframework.core.io.DefaultResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * The implement of DataEncryption
 * Dynamic load algorithm class byte
 * and encrypt/decrypt data
 *
 * <p>
 * {@code @author: } Abner Song
 * <p>
 * {@code @date: } 2024/4/3 15:01
 */
public class DynamicEncryptionFactory implements EncryptFactory {
    Map<String, AlgorithmDefinition> algorithmMap = new HashMap<>();

    @Override
    public Class<?> getAlgorithmClass(String algorithmName) throws Exception {
        AlgorithmDefinition definition = algorithmMap.get(algorithmName);
        if (definition != null) {
            return DynamicEncryptionLoader.loadClassFromByte(definition.getAlgorithmByte());
        } else {
//            definition = DynamicEncryptionLoader.loadClassFromAlgorithmService(algorithmName);
            AlgorithmUtil algorithmUtil = new AlgorithmUtil(new DefaultResourceLoader());
            definition = algorithmUtil.loadClassFromAlgorithmService();
            if (definition == null) {
                throw new RuntimeException("unknown algorithm.");
            }
            algorithmMap.put(definition.getAlgorithmName(), definition);
            return DynamicEncryptionLoader.loadClassFromByte(definition.getAlgorithmByte());
        }
    }

    @Override
    public void registerAlgorithmDefinition(AlgorithmDefinition definition) {

    }
}
