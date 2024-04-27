package com.abner.security.file;

import com.abner.security.meta.FileMeta;

/**
 * Default File Manager
 * store file locally
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/4/27 17:59
 */
public class DefaultFileManager implements FileManager{
    @Override
    public void save(FileMeta fileMeta) {

    }

    @Override
    public Object read(String fileName) {
        return null;
    }

    @Override
    public void remove(String fileName) {

    }
}
