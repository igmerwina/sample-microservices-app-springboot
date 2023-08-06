package com.ledger.service;

import com.ledger.dto.request.JournalReq;
import com.ledger.entity.JournalTrx;
import com.ledger.repo.JournalTrxRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component("journalconsumer")
@RequiredArgsConstructor
public class JournalConsumer {

    @Autowired
    private final JournalTrxRepo journalTrxRepo;

    @Transactional
    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeJournalTrx(JournalReq req) throws Exception {
        log.info("Start consumeJournalTrx - " + req.getIdOrder());

        JournalTrx journalTrx = JournalTrx.builder()
                .id(System.currentTimeMillis())
                .idOrder(req.getIdOrder())
                .itemCode(req.getItemCode())
                .userId(req.getUserId())
                .brand(req.getBrand())
                .description(req.getDescription())
                .totalPrice(req.getTotalPrice())
                .fee(req.getFee())
                .discount(req.getDiscount())
                .build();

        journalTrxRepo.save(journalTrx);

        log.info("End consumeJournal");
    }
}


