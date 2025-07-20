package dev.hspl.todo2ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Map;

@SpringBootApplication
@EnableAsync
@EnableCaching
public class Todo2dddApplication {
	public static void main(String[] args) {
		var ctx = SpringApplication.run(Todo2dddApplication.class, args);
		Map<String, CacheManager> result = ctx.getBeansOfType(CacheManager.class);
		System.out.println(result);
	}
}
