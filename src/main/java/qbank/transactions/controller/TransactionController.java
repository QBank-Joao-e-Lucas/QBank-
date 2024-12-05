package qbank.transactions.controller;

import io.micronaut.http.annotation.*;
import qbank.transactions.service.TransactionService;

@Controller("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    // Injeção do serviço TransactionService via construtor
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Post("/transfer")
    public String transfer(
            @QueryValue String fromAccount,
            @QueryValue String toAccount,
            @QueryValue double amount,
            @QueryValue String type
    ) {
        // Chamando o serviço para realizar a transferência
        return transactionService.transfer(fromAccount, toAccount, amount, type);
    }
}
