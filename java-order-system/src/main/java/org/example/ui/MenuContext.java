package org.example.ui;

import java.util.Scanner;

import org.example.core.Restaurant;
import org.example.core.customer.Orderer;

public class MenuContext {
    public final Scanner in;
    public final Restaurant restaurant;
    public final Orderer orderer;

    public MenuContext(Scanner in, Restaurant restaurant, Orderer orderer) {
        this.in = in;
        this.restaurant = restaurant;
        this.orderer = orderer;
    }
}