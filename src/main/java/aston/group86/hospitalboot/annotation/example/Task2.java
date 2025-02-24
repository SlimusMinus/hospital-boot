package aston.group86.hospitalboot.annotation.example;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
public class Task2 {

    public static void main(String[] args) {
        // Преобразовать в мапу, где ключ - номер счета, значение - код валюты

        List<Account> accounts = List.of(
                new Account("123456789", "BYN"),
                new Account("987654321", "RUB"),
                new Account("123456789", "BYN"),
                new Account("987654320", "USD"),
                new Account("987654322", "BYN"),
                new Account("987654323", "BYN"));

    }

    @Data
    @AllArgsConstructor
    private static class Account {
        private String number;
        public String currency;
    }
}