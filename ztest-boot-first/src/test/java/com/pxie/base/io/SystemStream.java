package com.pxie.base.io;

import java.io.*;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/27 0027 40
 */
public class SystemStream {
    private static Runtime runtime = Runtime.getRuntime();

    public static void main(String[] args) throws IOException {
        system();
    }

    public static void system() {
        Scanner scanner = new Scanner(System.in);

        String cmd = "";
        while ( !(cmd = scanner.nextLine()).equals("exit")) {
            runtime(cmd);
        }
    }

    public static void console() {
        Console console = System.console();
        System.out.println("input your name:");
        String name = console.readLine();

        System.out.println("input your password:");
        char[] passwd = console.readPassword();

        System.out.println("your name: " + name + ", your password: " + String.valueOf(passwd));
    }

    public static void runtime(String cmd) {
        if (cmd == null || "".equals(cmd)) {
            return;
        }

        try {
            Process process = runtime.exec(cmd);
            //inputStream
            try (BufferedReader resultReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), "GBK"))){

                String str = null;
                while ((str = resultReader.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // errorStream
            try (BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream(), "GBK"))){

                String str = null;
                while ((str = errorReader.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
