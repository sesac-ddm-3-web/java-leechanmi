package org.example.core.customer;

import org.example.core.customer.exception.InsufficientBalanceException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Wallet {
    private String cardNumber;
    private int cashBalance;
    private int pointBalance;

    public void deductCash(int amount) {
        if (amount > cashBalance) {
            throw new InsufficientBalanceException();
        }
        this.cashBalance -= amount;
    }

    public void deductPoints(int amount) {
        if (amount > pointBalance) {
            throw new InsufficientBalanceException();
        }
        this.pointBalance -= amount;
    }
}
