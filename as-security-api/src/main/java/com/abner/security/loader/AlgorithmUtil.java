package com.abner.security.loader;

import com.abner.security.meta.AlgorithmDefinition;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Description for this class
 *
 * <p>
 * {@code @author: } Abner Song
 * <p>
 * {@code @date: } 2024/4/3 16:16
 */
public class AlgorithmUtil {
    private final ResourceLoader resourceLoader;

    public AlgorithmUtil(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public AlgorithmDefinition loadClassFromAlgorithmService() {
        Resource resource = resourceLoader.getResource("AESDataEncryption.class");
        try {
            InputStream inputStream = resource.getInputStream();
            byte[] bytes = inputStreamToByteArray(inputStream);
            return new AlgorithmDefinition("AES", bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] inputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        return outputStream.toByteArray();
    }
}
