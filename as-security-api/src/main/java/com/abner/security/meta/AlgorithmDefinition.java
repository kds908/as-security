package com.abner.security.meta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description for this class
 *
 * <p>
 * {@code @author: } Abner Song
 * <p>
 * {@code @date: } 2024/4/3 15:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlgorithmDefinition {
    private String algorithmName;
    private byte[] algorithmByte;
}
