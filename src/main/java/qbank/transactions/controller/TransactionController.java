package qbank.transactions.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

import jakarta.inject.Singleton;

@Singleton
public class TransactionController {

    @Get("/transactions/transfer")
    public HttpResponse<String> transfer(
            @QueryValue String fromAccount,
            @QueryValue String toAccount,
            @QueryValue Double amount,
            @QueryValue String type) {

        // Lógica da transferência
        String responseMessage = String.format(
                "Transferência de R$%.2f de %s para %s via %s efetuada.",
                amount, fromAccount, toAccount, type
        );
        return HttpResponse.ok(responseMessage);
    }
}
