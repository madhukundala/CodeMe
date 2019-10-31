package com.me.interview.services;

import com.me.interview.api.TransactionResponse;
import reactor.core.publisher.Mono;

public interface ITransactionsServices {

    Mono<TransactionResponse> getTransactions(String accountID, String fromDate, String toDate);
}
