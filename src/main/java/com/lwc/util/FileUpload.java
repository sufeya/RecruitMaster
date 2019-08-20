package com.lwc.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传工具类
 */
public class FileUpload {
    public static  String upLoadImg(MultipartFile img,String path){
        File  imgLoc=new File(path+"\\upload");
        if(!imgLoc.exists())
            imgLoc.mkdir();
        //获取后缀名
        String fileName=img.getOriginalFilename();
        String saveName=System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
        try {
            img.transferTo(new File(imgLoc.getAbsolutePath()+"\\"+saveName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "upload/"+saveName;
    }
}
