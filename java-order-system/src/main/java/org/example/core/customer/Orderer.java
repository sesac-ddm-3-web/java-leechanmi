package org.example.core.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Orderer {
    private final Cart cart;
    private final Wallet wallet;
}
