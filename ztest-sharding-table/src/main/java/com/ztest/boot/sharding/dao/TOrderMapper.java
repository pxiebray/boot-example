package com.ztest.boot.sharding.dao;

import com.ztest.boot.sharding.entity.TOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface TOrderMapper {

	TOrder getOrder(Long id);

	void addOrder(TOrder order);
}
