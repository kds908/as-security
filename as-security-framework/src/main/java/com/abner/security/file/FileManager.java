package com.abner.security.file;

import com.abner.security.meta.FileMeta;

/**
 * interface of file management
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/4/27 17:55
 */
public interface FileManager {
    void save(FileMeta fileMeta);

    Object read(String fileName);

    void remove(String fileName);
}
