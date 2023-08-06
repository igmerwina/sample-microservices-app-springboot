package com.transaction.controller;

import com.transaction.dto.request.ReqSubmit;
import com.transaction.dto.response.ResponseService;
import com.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/submit")
    @ResponseBody
    public ResponseService submitOrder(@RequestBody ReqSubmit req) throws Exception {
        return transactionService.submitOrder(req);
    }

}

