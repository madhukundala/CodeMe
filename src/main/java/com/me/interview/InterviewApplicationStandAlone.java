package com.me.interview;

import com.me.interview.api.TransactionResponse;
import com.me.interview.services.ITransactionsServices;
import com.me.interview.services.TransactionsServices;

public class InterviewApplicationStandAlone {


    public static void main(String[] args) {

        ITransactionsServices transactionsServices = new TransactionsServices();
        TransactionResponse response = transactionsServices.getTransactions("ACC334455", "20/10/18 11:47:23", "20/10/18 16:47:23").block();
        System.out.println(response);

    }


}
