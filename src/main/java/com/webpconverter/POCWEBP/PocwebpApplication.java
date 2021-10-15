package com.webpconverter.POCWEBP;

import com.webpconverter.POCWEBP.Converter.WebpConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@SpringBootApplication
public class PocwebpApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocwebpApplication.class, args);
		new WebpConverter().TransformImageToWebpBase64();
	}

	@Bean
	public WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("*");
			}
		};
	}
}
