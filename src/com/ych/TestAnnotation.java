package com.ych;

import com.ych.util.annotations.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ½øÈëcom
 * Created by hua on 2017/2/14.
 */
@RequestMapping("type")
public class TestAnnotation {

    public static void main(String[] args) throws IOException {
        Set<String> classNames = new LinkedHashSet<String>();
//        File file = new File("E:\\workspace\\liuliang\\target\\classes");
//        String[] fileNames = file.list();
        File fsi = new File(".");
        scanFiles(fsi, classNames);
        System.out.println(classNames);
        try {
            String className = classNames.iterator().next();
            int dot = className.lastIndexOf(".");
            Class<?> clzz = Class.forName(className.substring(0,dot));
//            Class<?> clzz = Class.forName("com.ych.TestAnnotation");
            System.out.println(clzz.getName());

            RequestMapping annotation = clzz.getAnnotation(RequestMapping.class);
            System.out.println(annotation.value());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void scanFiles(File file,Set<String> classNames){
        File[] fsiArr = file.listFiles();
        for (File fs : fsiArr){
            if (fs.isFile() && fs.getName().endsWith(".class")){

//                System.out.println(fs.getPath().substring(2));
                classNames.add(fs.getPath().substring(2).replaceAll("\\\\","."));
            }else if (fs.isDirectory()){
                scanFiles(fs,classNames);
            }
        }
    }
    @RequestMapping(value = "gxy")
    public void method(){

    }
}
