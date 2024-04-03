package com.abner.security;

import com.abner.security.encrypt.DynamicEncryptionFactory;
import com.abner.security.encrypt.EncryptFactory;
import com.abner.security.meta.MetaData;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Method;
import java.util.Base64;

/**
 * Description for this class
 *
 * <p>
 * {@code @author: } Abner Song
 * <p>
 * {@code @date: } 2024/4/3 15:14
 */

@SpringBootApplication
public class SecurityApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApiApplication.class, args);
    }

    @Bean
    ApplicationRunner runner() {
        return e -> {
            EncryptFactory factory = new DynamicEncryptionFactory();
            try {
                Class<?> algorithmClass = factory.getAlgorithmClass("AES");
                Object encryptionInstance = algorithmClass.getDeclaredConstructor().newInstance();
                Method encryptMethod = algorithmClass.getMethod("encrypt", MetaData.class);
                Method decryptMethod = algorithmClass.getMethod("decrypt", MetaData.class);

                // mock request with AES
                MetaData data = new MetaData();
                data.setData("Hello, World!");
                data.setAlgorithmName("AES");
                data.setKeyShards(new String[]{"0123456789abcdef", "abcdefghijklmnop"});
                // encrypt data
                byte[] encryptedData = (byte[]) encryptMethod.invoke(encryptionInstance, data);
                System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encryptedData));

                MetaData encrypted = new MetaData();
                encrypted.setEncryptedData(encryptedData);
                encrypted.setAlgorithmName("AES");
                encrypted.setKeyShards(new String[]{"0123456789abcdef", "abcdefghijklmnop"});
                // decrypt data
                byte[] decryptedData = (byte[]) decryptMethod.invoke(encryptionInstance, encrypted);
                System.out.println("Decrypted: " + new String(decryptedData));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}
