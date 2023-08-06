package com.param.repo;

import com.param.entity.Discount;
import org.springframework.data.repository.CrudRepository;

public interface DiscountRepo extends CrudRepository<Discount, Integer> {
}