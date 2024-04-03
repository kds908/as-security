package com.abner.security.loader;

import com.abner.security.meta.AlgorithmDefinition;
import com.abner.security.meta.MetaData;

import java.lang.reflect.Method;

/**
 * Description for this class
 *
 * <p>
 * {@code @author: } Abner Song
 * <p>
 * {@code @date: } 2024/4/3 14:06
 */
public class DynamicEncryptionLoader {

    public static void main(String[] args) throws Exception {
        // 加载加密算法类
        Class<?> encryptionClass = loadClassFromByte(new byte[0]);

        // 创建加密算法实例
        Object encryptionInstance = encryptionClass.getDeclaredConstructor().newInstance();

        // 获取加密方法
        Method encryptMethod = encryptionClass.getMethod("encrypt", byte[].class, byte[].class);

        // 获取解密方法
        Method decryptMethod = encryptionClass.getMethod("decrypt", byte[].class, byte[].class);

        // 模拟数据和密钥
        byte[] data = "Hello, World!".getBytes();
        byte[] key = "SecretKey".getBytes();

        // 加密数据
        byte[] encryptedData = (byte[]) encryptMethod.invoke(encryptionInstance, data, key);
        System.out.println("Encrypted: " + new String(encryptedData));

        // 解密数据
        byte[] decryptedData = (byte[]) decryptMethod.invoke(encryptionInstance, encryptedData, key);
        System.out.println("Decrypted: " + new String(decryptedData));
    }

    /**
     * change class byte into class
     * @param classBytes
     * @return
     * @throws Exception
     */
    public static Class<?> loadClassFromByte(byte[] classBytes) throws Exception {
        return new ClassLoader() {
            public Class<?> loadClass() {
                return defineClass(null, classBytes, 0, classBytes.length);
            }
        }.loadClass();
    }

    public static byte[] encrypt(MetaData data) {
        return new byte[0];
    }

    public static byte[] decrypt(MetaData data) {

        return new byte[0];
    }

    public static AlgorithmDefinition loadClassFromAlgorithmService(String algorithmName) {
        return null;
    }
}
