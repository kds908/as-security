package com.abner.security.encrypt;

import com.abner.security.meta.MetaData;

/**
 * a data processing interface<p>
 * provide methods to encrypt/decrypt data
 *
 * <p>
 * {@code @author: } abner song
 * <p>
 * {@code @date: } 2024/4/3 12:14
 */
public interface DataEncryption {
    byte[] encrypt(MetaData data) throws Exception;

    byte[] decrypt(MetaData data) throws Exception;
}
