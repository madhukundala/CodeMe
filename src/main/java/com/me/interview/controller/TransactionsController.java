package com.me.interview.controller;

import com.me.interview.api.TransactionResponse;
import com.me.interview.services.ITransactionsServices;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class TransactionsController {

    Logger logger = Logger.getLogger(TransactionsController.class);


    @Autowired
    private ITransactionsServices transactionsServices;

    @GetMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    @Description("This api gives the transactions happened during the period ")
    public Mono<TransactionResponse> getTransactions(@RequestParam(value = "accountID") String accountID,
                                                     @RequestParam(value = "fromDate") String fromDate,
                                                     @RequestParam(value = "toDate") String toDate) {
        logger.debug("entering the getTransactions ");
        return transactionsServices.getTransactions(accountID, fromDate, toDate);
    }


}
