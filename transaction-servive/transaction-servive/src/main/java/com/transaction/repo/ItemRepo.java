package com.transaction.repo;

import com.transaction.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<Item, String> {

}

