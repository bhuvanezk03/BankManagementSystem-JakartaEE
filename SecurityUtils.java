package com.bankapp.utils;

import java.util.UUID;

public class SecurityUtils {
    public static String generateAccountNumber() {
        return "ACC-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public static String generateSafetyDepositBox() {
        return "SDB-" + UUID.randomUUID().toString().substring(0, 8);
    }
}
