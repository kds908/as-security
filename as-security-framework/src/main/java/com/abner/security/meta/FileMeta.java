package com.abner.security.meta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Meta data of file
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/4/27 18:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileMeta {
    private String fileName;
    private byte[] fileData;
    private String fileType;
    private String filePath;
}
