package com.ships.repositories;

import org.springframework.data.repository.CrudRepository;
import com.ships.model.OrderInfo;

public interface OrderInfoRepository extends CrudRepository<OrderInfo, Long> {

}
