package com.ych;

import java.net.URL;

/**
 * Created by hua on 2017/2/10.
 */
public class TestClassLoader {
    public static void main(String[] args) {
//        ClassLoader classLoader = TestClassLoader.class.getClassLoader();
//        while(classLoader !=null){
//            System.out.println("======="+classLoader);
//            classLoader = classLoader.getParent();
//        }
        String scanPackage = "com.ych";
//       URL url= TestClassLoader.class.getClassLoader().getResource("/com/ych");
//        String path = url.getFile();
        System.out.println(scanPackage);
        Person person = new Person();
    }

    private static String convertPath(String path){
        String result = path.replaceAll("\\.","/");
        return result;
    }
}
