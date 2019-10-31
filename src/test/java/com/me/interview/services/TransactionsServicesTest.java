package com.me.interview.services;

import com.me.interview.api.TransactionResponse;
import com.me.interview.exceptions.ServiceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransactionsServicesTest {

    @Autowired
    private ITransactionsServices transactionsServices;


    @Test
    public void getTransactionsValidTest() {

        TransactionResponse response = transactionsServices.getTransactions("ACC334455", "20/10/18 11:47:23", "20/10/18 16:47:23").block();

        Assertions.assertEquals("Relative balance for the period is: -240.50", response.getBalance());
        Assertions.assertEquals("Number of transactions included is: 4", response.getTransactions());

    }

    @Test
    public void getTransactionsInvalidDateThrowsExceptionTest() {

        ServiceException exception = Assertions.assertThrows(ServiceException.class, () -> transactionsServices.getTransactions("ACC334455", "20/10/18 11:47:2", "20/10/18 16:47:23"));
        Assertions.assertEquals("Text '20/10/18 11:47:2' could not be parsed at index 15", exception.getMessage());
    }

}


