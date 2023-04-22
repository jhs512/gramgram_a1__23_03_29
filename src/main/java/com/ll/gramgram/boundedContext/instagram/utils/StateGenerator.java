package com.ll.gramgram.boundedContext.instagram.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class StateGenerator {
    private static final SecureRandom random = new SecureRandom();

    public static String generateState() {
        return new BigInteger(130, random).toString(32);
    }
}
