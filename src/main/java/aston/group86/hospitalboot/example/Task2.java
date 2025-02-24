package aston.group86.hospitalboot.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import nonapi.io.github.classgraph.json.JSONUtils;
import org.springframework.aop.scope.ScopedProxyUtils;

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

        Map<String, String> collect = accounts.stream()
            .collect(Collectors.toMap(Account::getNumber, Account::getCurrency, (k1, k2) -> k2));

        System.out.println(collect);

    }

    @Data
    @AllArgsConstructor
    private static class Account {
        private String number;
        public String currency;
    }
}