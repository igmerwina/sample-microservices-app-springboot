package com.transaction.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transaction.dto.request.JournalReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component("transactionproducer")
@RequiredArgsConstructor
public class TransactionProducer {

    @Value("${spring.kafka.producer.topic}")
    private String journalTopic;

    private final ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void postJournalTrx(JournalReq req) throws Exception {
        log.info("Start post to kafka postJournalTrx - id order {}", req.getIdOrder());
        kafkaTemplate.send(journalTopic, objectMapper.writeValueAsString(req));
        log.info("End post to kafka postJournalTrx - id order {}", req.getIdOrder());
    }
}

