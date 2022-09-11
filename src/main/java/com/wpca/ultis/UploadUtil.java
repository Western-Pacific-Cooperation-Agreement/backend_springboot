package com.wpca.ultis;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
*@author  XieQijiang
*@Pcakage  com.wpca.ultis.UploadUtil
*@Date  2022年09月11日 19:08
*@Description
*/
public class UploadUtil {


    /**
     * 上传文件到服务器本地静态资源文件位置
     * @param file 上传保存的文件
     * @param localFilePath 本地文件位置
     */
    public static String uploadFile(MultipartFile file, String localFilePath,String username) {

        File f = new File(localFilePath,username);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdir();
        }
        try {
            file.transferTo(f); //  保存文件
            return f.getName();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
