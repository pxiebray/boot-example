package com.ztest.boot.cache.resources;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class CacheResources {

	@Autowired(required = false)
	CacheManager cacheManager;

	private final Cache<String, String> cache;
	public CacheResources() {
		 cache = Caffeine.newBuilder().expireAfterWrite(30, TimeUnit.SECONDS)
				.maximumSize(3)
				.build();
	}

	@GetMapping("/get/{id}")
	public String get(@PathVariable("id") String id) {
		return "hello " + cache.getIfPresent(id);
	}

	@GetMapping("/put/{id}")
	public String put(@PathVariable("id") String id) {
		cache.put(id, new Date().toString());
		return "put " + id;
	}

	@GetMapping("/stats")
	public Map<String, String> stats() {
		return cache.asMap();
	}

	@GetMapping("/metric")
	public String metric() {
		return cache.stats().toString();
	}

}
