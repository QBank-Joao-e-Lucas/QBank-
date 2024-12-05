package qbank.transactions.service;

import jakarta.inject.Singleton;

@Singleton
public class TransactionService {

    public String transfer(String fromAccount, String toAccount, double amount, String type) {
        if (amount <= 0) {
            return null; 
        }


        return String.format("Transferência de R$%.2f de %s para %s via %s efetuada.",
                amount, fromAccount, toAccount, type);
    }
}
