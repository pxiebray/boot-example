package com.ztest.boot.sharding.resources;

import com.ztest.boot.sharding.dao.TOrderMapper;
import com.ztest.boot.sharding.entity.TOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class TestResources {

	@Autowired
	TOrderMapper orderMapper;

	/**
	 * @param orderId
	 * @return
	 */
	@GetMapping("/orders/{id}")
	public TOrder getOrder(@PathVariable("id") Long orderId) {
		return orderMapper.getOrder(orderId);
	}

	@PostMapping("/orders")
	public String createOrder(@RequestBody TOrder tOrder) {
		tOrder.setCreateTime(new Date());
		orderMapper.addOrder(tOrder);
		return "add order";
	}

}
