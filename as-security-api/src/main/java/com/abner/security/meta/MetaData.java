package com.abner.security.meta;

import lombok.Data;

/**
 * meta data of processing
 *
 * <p>
 * {@code @author: } abners.
 * <p>
 * {@code @date: } 2024/4/3 12:17
 */
@Data
public class MetaData {
    /**
     * the name of algorithm
     */
    private String algorithmName;
    /**
     * pieces of keys,
     * key and iv
     */
    private String[] keyShards;
    /**
     * the processed data
     */
    private String data;

    private byte[] encryptedData;
}
