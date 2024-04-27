package com.abner.security.file;

import com.abner.security.meta.FileMeta;
import org.apache.commons.net.ftp.FTPClient;

/**
 * FTP file manage
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/4/27 18:12
 */
public class FTPFileManage implements FileManager{
    private FTPClient ftpClient;

    public FTPFileManage(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }

    @Override
    public void save(FileMeta fileMeta) {
        // TODO save file by ftp client
    }

    @Override
    public Object read(String fileName) {
        return null;
    }

    @Override
    public void remove(String fileName) {

    }
}
