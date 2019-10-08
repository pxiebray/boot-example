package com.ztest.spring.beans.reflect;

/**
 * @see sun.misc.Launcher
 * @see sun.misc.Launcher.ExtClassLoader
 * @see sun.misc.Launcher.AppClassLoader
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/10/30 0030 23
 */
public class ParseClassLoader {

    public static void main(String[] args) {
        ClassLoader appClassLoader = ParseClassLoader.class.getClassLoader();
        System.out.println(appClassLoader.getClass().getName());

        ClassLoader extensionClassLoader = appClassLoader.getParent();
        System.out.println(extensionClassLoader.getClass().getName());

        //bootstrapClassLoader implements by c++
        System.out.println(System.getProperty("sun.boot.class.path"));

    }
}
