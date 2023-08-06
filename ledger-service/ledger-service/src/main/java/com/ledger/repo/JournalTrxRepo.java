package com.ledger.repo;

import com.ledger.entity.JournalTrx;
import org.springframework.data.repository.CrudRepository;

public interface JournalTrxRepo extends CrudRepository<JournalTrx, String> {

}
