package qbank.transactions.service;

import jakarta.inject.Singleton;

@Singleton
public class TransactionService {

    public String transfer(String fromAccount, String toAccount, double amount, String type) {
        if (amount <= 0) {
            throw new IllegalArgumentException("O valor da transferência deve ser maior que 0.");
        }
        return "Transferência de R$" + amount + " de " + fromAccount + " para " + toAccount + " via " + type + " efetuada.";
    }
}
