package com.lwc.util;

import org.springframework.stereotype.Component;

import java.io.*;

public class SerializableUtil {

    //将字节数组反序列化为对象
    public static  Object toObject(byte[] bytes){
        Object obj=null;
        try{
            ByteArrayInputStream bis=new ByteArrayInputStream(bytes);
            ObjectInputStream ois=new ObjectInputStream(bis);
            obj=ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
    //将对象序列化为字节数组
    public static byte[] toByteArray(Object obj){
        byte[] bytes =null;
        ByteArrayOutputStream bos =new ByteArrayOutputStream();
        try{
            ObjectOutputStream oos=new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes=bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
