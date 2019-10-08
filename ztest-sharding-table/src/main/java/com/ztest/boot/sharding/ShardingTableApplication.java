package com.ztest.boot.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
@MapperScan(basePackages = "com.ztest.boot.**.dao", annotationClass = Repository.class)
public class ShardingTableApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingTableApplication.class, args);
	}

	@Configuration
	@ConditionalOnClass(Docket.class)
	@EnableSwagger2
	public static class SwaggerConfiguration {

		/**
		 * 定义swagger文档
		 * docket.host可以更改目标地址{host}/{basePath}中的host
		 *
		 * @param enableSwagger
		 * @param basePackage
		 * @return
		 */
		@Bean
		public Docket getDocket(@Value("${swagger.enable:true}") boolean enableSwagger,
		                        @Value("${swagger.basePackage:com.ztest.boot}") String basePackage) {
			return new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(new ApiInfoBuilder()
							.title("title")
							.description("当前version，兼容version")
							.version("v1")
							.build())
					.select().apis(RequestHandlerSelectors.basePackage(basePackage))
					.build()
					.globalOperationParameters(Arrays.asList())
					.enable(enableSwagger);
		}

	}
}
