package com.me.interview;

import com.me.interview.services.TransactionsServices;
import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterviewApplication {


    static Logger logger = Logger.getLogger(TransactionsServices.class);

    public static void main(String[] args) {

        SpringApplication.run(InterviewApplication.class, args);
    }


}
