package qbank.transactions.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import qbank.transactions.service.TransactionService;

@Controller("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Inject
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Post("/transfer")
    public HttpResponse<String> transfer(@QueryValue String fromAccount,
                                         @QueryValue String toAccount,
                                         @QueryValue double amount,
                                         @QueryValue String type) {
        String responseMessage = transactionService.transfer(fromAccount, toAccount, amount, type);

        if (responseMessage != null) {
            return HttpResponse.ok(responseMessage);
        } else {
            return HttpResponse.badRequest("Falha na transferência");
        }
    }
}
// testando
