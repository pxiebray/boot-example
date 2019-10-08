package com.ztest.spring.resources;

import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/10/29 0029 50
 */
public class ResourceTest {

    public void test(){

    }

    public static void main(String[] args) {
        Resource resource = new PathResource("G:\\GItPlatform2\\ztest-boot\\ztest-spring\\src\\main\\resources\\spring.xml");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
