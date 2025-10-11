package org.example.cp.cp_optional;

import java.util.Optional;

public class User {
    private Address address;
    public User(Address address) { this.address = address; }

    public Optional<Address> getAddress() { return Optional.ofNullable(address); }
}

class Address {
    private String city;
    public Address(String city) { this.city = city; }

    public Optional<String> getCity() { return Optional.ofNullable(city); }
}