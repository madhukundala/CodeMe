package com.me.interview;

import com.me.interview.services.TransactionsServices;
import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterviewApplication {


    static Logger logger = Logger.getLogger(TransactionsServices.class);

    public static void main(String[] args) {

        //  ITransactionsServices transactionsServices = new TransactionsServices();
        //  TransactionResponse response = transactionsServices.getTransactions("ACC334455", "20/10/18 11:47:23", "20/10/18 16:47:23");
        //  logger.debug(response);

        SpringApplication.run(InterviewApplication.class, args);
    }


}
