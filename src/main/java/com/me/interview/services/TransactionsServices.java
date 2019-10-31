package com.me.interview.services;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.me.interview.api.TransactionResponse;
import com.me.interview.constants.CommonConstants;
import com.me.interview.exceptions.ServiceException;
import com.me.interview.pojo.TransactionRequest;
import org.jboss.logging.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionsServices implements ITransactionsServices {
    Logger logger = Logger.getLogger(TransactionsServices.class);

    @Override
    public Mono<TransactionResponse> getTransactions(String accountID, String fromDate, String toDate) {
        TransactionResponse transactionResponse;
        logger.debug("entering getTransactions in services");
        try {

            LocalDateTime fromDateTime = getFormattedDate(fromDate);
            LocalDateTime toDateTime = getFormattedDate(toDate);

            transactionResponse = new TransactionResponse();

            List<TransactionRequest> csvoutput = readCSVFile();

            if (!CollectionUtils.isEmpty(csvoutput)) {

                BigDecimal relativeBalance = BigDecimal.ZERO;
                BigDecimal sumOfAmounts = BigDecimal.ZERO;
                int transactions = 0;

                for (TransactionRequest request : csvoutput) {

                    if (accountID.equals(request.getFromAccountId()) || accountID.equals(request.getToAccountId())) {

                        BigDecimal amount = new BigDecimal(request.getAmount().trim());
                        String paymentType = request.getTransactionType().trim();
                        LocalDateTime createdDate = getFormattedDate(request.getCreatedAt());

                        if (paymentType.equals(CommonConstants.PAYMENT)
                                && (createdDate.isEqual(fromDateTime) || createdDate.isAfter(fromDateTime))
                                && (createdDate.isEqual(toDateTime) || createdDate.isBefore(toDateTime))) {

                            sumOfAmounts = sumOfAmounts.add(amount);
                            transactions++;

                        } else if (paymentType.equals(CommonConstants.REVERSAL)) {

                            sumOfAmounts = sumOfAmounts.subtract(amount);
                            transactions--;
                        }
                    }
                }
                relativeBalance = relativeBalance.subtract(sumOfAmounts);
                transactionResponse.setBalance("Relative balance for the period is: " + relativeBalance.toString());
                transactionResponse.setTransactions("Number of transactions included is: " + String.valueOf(transactions));
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        return Mono.just(transactionResponse);
    }

    /**
     * @return
     * @throws IOException
     */
    private List<TransactionRequest> readCSVFile() throws IOException {

        FileReader filereader = new FileReader(new ClassPathResource("input.csv").getFile());

        MappingIterator<TransactionRequest> transactionRequestMappingIterator = new CsvMapper()
                .readerWithTypedSchemaFor(TransactionRequest.class)
                .readValues(filereader);

        return transactionRequestMappingIterator.readAll();
    }


    /**
     * @param input
     * @return
     */
    private LocalDateTime getFormattedDate(String input) {

        return LocalDateTime.parse(input, CommonConstants.DATE_TIME_FORMATTER);

    }


}


