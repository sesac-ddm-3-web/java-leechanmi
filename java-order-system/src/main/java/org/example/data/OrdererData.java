package org.example.data;

import org.example.core.customer.Cart;
import org.example.core.customer.Orderer;
import org.example.core.customer.Wallet;

public class OrdererData {

    private OrdererData() {
    }

    public static Orderer buildOrderer() {
        return Orderer.builder()
            .cart(Cart.create())
            .wallet(
                Wallet.builder()
                    .cardNumber("1234-5678-9123-4567")
                    .cashBalance(5000000)
                    .pointBalance(100000)
                    .build()
            ).build();
    }
}
