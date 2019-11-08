package com.mok.blockchain;

import com.mok.blockchain.utils.SHA256;

public class Transaction implements Tx {

    private String value;

    private String hash;

    public Transaction(String value) {
        this.hash = SHA256.generateHash(value);
        this.setValue(value);
    }

    @Override
    public String hash() {
        return hash;
    }

    public String getValue() {
        return value;
    }

    private void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "value='" + value + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
