package com.me.interview.controller;

import com.me.interview.JsonUtil;
import com.me.interview.api.TransactionResponse;
import com.me.interview.services.ITransactionsServices;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Mono;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ITransactionsServices transactionsServices;

    private String validResponsePath = "/response.json";

    @Test
    public void validInputReturnResponseTest() throws Exception {

        Mono<TransactionResponse> response = Mono.just(JsonUtil.getObjectFromJson(JsonUtil.readJsonFile(validResponsePath), TransactionResponse.class));

        Mockito.when(transactionsServices.getTransactions(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                .thenReturn(response);

        mockMvc.perform(get("/api/transactions?accountID=ACC334455&fromDate=20/10/18 11:47:23&toDate=20/10/18 17:47:23"))
                .andExpect(status().isOk());

        Mockito.verify(transactionsServices, Mockito.times(1)).getTransactions(Mockito.anyString(), Mockito.anyString(), Mockito.anyString());

    }

    @Test
    public void inValidInputThrowErrorResponseTest() throws Exception {

        Mono<TransactionResponse> response = Mono.just(JsonUtil.getObjectFromJson(JsonUtil.readJsonFile(validResponsePath), TransactionResponse.class));

        Mockito.when(transactionsServices.getTransactions(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                .thenReturn(response);

        mockMvc.perform(get("/api/transactions?accountID=ACC334455&fromDate=20/10/18 11:47:23"))
                .andExpect(status().is4xxClientError());


        Mockito.verify(transactionsServices, Mockito.times(0)).getTransactions(Mockito.anyString(), Mockito.anyString(), Mockito.anyString());

    }


}
