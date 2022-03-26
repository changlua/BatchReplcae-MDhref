package com.changlu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName Test
 * @Author ChangLu
 * @Date 3/26/2022 1:43 PM
 * @Description TODO
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        System.out.println(new File("").getAbsolutePath());
//        InputStream is = new FileInputStream(new File("filePath"));
//        Properties properties = new Properties();
//        properties.load(is);
        final InputStream is = Test.class.getResourceAsStream("/rpmd.properties");
        Properties properties = new Properties();
        properties.load(is);
        System.out.println(properties.getProperty("file"));

    }
}