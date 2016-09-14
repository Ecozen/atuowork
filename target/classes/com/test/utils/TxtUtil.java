package com.test.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TxtUtil {
	
	public static String readTxtFile(String filePath,String encoding) {
        StringBuffer appInfolistInput = new StringBuffer();
        try {
//            String encoding = "UTF8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    appInfolistInput.append(lineTxt);
                }
                read.close();
                bufferedReader.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return appInfolistInput.toString();
    }
	
    public static List<String> readTxtFile2(String filePath,String encoding) {
        List<String> list = new ArrayList<String>();
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    list.add(lineTxt);
                }
                read.close();
                bufferedReader.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return list;
    }
	
	
	public static void readByte(String fileName) {
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
            byte[] byteBuffer = new byte[is.available()];
            int read = 0;
            while((read = is.read(byteBuffer)) != -1){
                System.out.write(byteBuffer, 0, read);
            }
        } catch (FileNotFoundException e) {        
            e.printStackTrace();
        } catch (IOException e) {          
            e.printStackTrace();
        }finally{          
            try {
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {              
                e.printStackTrace();
            }
        }      
    }
	
	public static void writeBuffer(String fileName, String content){
        try {
            File file = new File(fileName);
            BufferedWriter output = new BufferedWriter(new FileWriter(file));          
            output.write(content);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void writeByte(String fileName){
        try {
            File file = new File(fileName);
            OutputStream os = new FileOutputStream(file);
            String s = "hello world";          
            byte[] byteBuffer = s.getBytes();
            os.write(byteBuffer, 0, byteBuffer.length);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
