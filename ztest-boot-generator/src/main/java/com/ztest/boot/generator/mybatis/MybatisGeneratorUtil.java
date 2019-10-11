package com.ztest.boot.generator.mybatis;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MybatisGeneratorUtil {

	private String targetProject = "D:\\data";
	private String targetPackage = "com.ztest.boot.generator.dao";

	private String jdbcDriver="com.mysql.jdbc.Driver";
	private String jdbcUrl="jdbc:mysql://106.14.186.226:7070/kuxiu_gift";
	private String jdbcUsername="root";
	private String jdbcPassword="Q`W1E2R3T4Kuxiu2018~!@#$";

	private String tableName="t_test0";
	private String entityName = "Test";


	public void generator() {
		Configuration configuration = new Configuration();

		// context
		Context context = new Context(null);
		context.setId("generator");
		context.setTargetRuntime("MyBatis3");

		// jdbc connection
		JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
		jdbcConnectionConfiguration.setDriverClass(this.jdbcDriver);
		jdbcConnectionConfiguration.setConnectionURL(this.jdbcUrl);
		jdbcConnectionConfiguration.setUserId(this.jdbcUsername);
		jdbcConnectionConfiguration.setPassword(this.jdbcPassword);
		context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

		// tables
		TableConfiguration tableConfiguration = new TableConfiguration(context);
		tableConfiguration.setTableName(this.tableName);
		tableConfiguration.setDomainObjectName(this.entityName);
		context.addTableConfiguration(tableConfiguration);

		// javaModel
		JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
		javaModelGeneratorConfiguration.setTargetPackage(targetPackage);
		javaModelGeneratorConfiguration.setTargetProject(targetProject);
		javaModelGeneratorConfiguration.addProperty("enableSubPackages", "true");
		context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

		// xml
		SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
		sqlMapGeneratorConfiguration.setTargetPackage(targetPackage);
		sqlMapGeneratorConfiguration.setTargetProject(targetProject);
		sqlMapGeneratorConfiguration.addProperty("enableSubPackages", "true");
		context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

		configuration.addContext(context);
		try {
			List<String> warning = new ArrayList<>();
			MyBatisGenerator generator = new MyBatisGenerator(configuration, null, warning);
			generator.generate(null);

			warning.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MybatisGeneratorUtil util = new MybatisGeneratorUtil();
		util.generator();
	}




}
