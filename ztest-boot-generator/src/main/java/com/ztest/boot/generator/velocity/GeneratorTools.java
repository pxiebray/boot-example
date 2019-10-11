package com.ztest.boot.generator.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.*;
import java.util.Properties;

public class GeneratorTools {

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		properties.setProperty("resource.loader", "class");
		properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		Velocity.init(properties);


		VelocityContext vContext = new VelocityContext();
		vContext.put("className", new String("Test"));
		Template template = Velocity.getTemplate("template/mytemplate.vm");

		String targetFile = sourcePath() + File.separator + "Test.java";
		System.out.println("目标文件路径 " + targetFile);
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(targetFile))){
			template.merge(vContext, writer);
		}

		getFilePath();
	}

	/**
	 * 获取根路径
	 *
	 * @return
	 */
	public static String sourcePath() {
		String path = GeneratorTools.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		if (path.contains("target")) {
			path = path.substring(0, path.indexOf("target"));
		}
		return path + "src/main/java";
	}

	public static String getFilePath() throws IOException {
		String path = "";
		// file
		File file = new File("");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getCanonicalPath());
		System.out.println(file.getPath());

		// class
		System.out.println(GeneratorTools.class.getResource(""));
		System.out.println(GeneratorTools.class.getResource("/"));
		System.out.println(GeneratorTools.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		System.out.println(GeneratorTools.class.getClassLoader().getResource(""));

		// class - file
		File file1 = new File(GeneratorTools.class.getResource("/").getPath());
		System.out.println(file.getPath());
		return path;
	}

}
