package io.codeandpaan.booairbookingtx.utils;

import io.codeandpaan.booairbookingtx.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String, Double> paymentMap = new HashMap<>();

    public static void generateCredit() {
        if (paymentMap.size() < 1) {
            paymentMap.put("acc1", 12000.0);
            paymentMap.put("acc2", 10000.0);
            paymentMap.put("acc3", 18000.0);
        }
    }

    static {
        if (paymentMap.size() < 1) {
            paymentMap.put("acc1", 12000.0);
            paymentMap.put("acc2", 10000.0);
            paymentMap.put("acc3", 18000.0);
        }
    }

    public static boolean validateCreditLimit(String accNo, double paidAmount) {
        if (paidAmount > paymentMap.getOrDefault(accNo, Double.MIN_VALUE)) {
            throw new InsufficientAmountException("Insufficient credit...!");
        } else return true;
    }
}
