package com.rsa;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public class RSA {
    private BigInteger n, d, e;

    private static int bitLength = 1024;

    public RSA() {
        SecureRandom random = new SecureRandom();

        BigInteger p = BigInteger.probablePrime(bitLength / 2 + 1, random);

        BigInteger q = BigInteger.probablePrime(bitLength / 2 + 1, random);

        
        System.out.println("p: " + p);
        System.out.println("q: " + q);

        n = p.multiply(q);
        
        System.out.println("n: " + n);
        
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        
        e = BigInteger.probablePrime(bitLength / 4, random);
        /* 
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e = e.add(BigInteger.ONE);
        }*/

        d = e.modInverse(phi);
        
        
        System.out.println("e: " + e);
        
        System.out.println("d: " + d);
    }

    public BigInteger getPublicKey() {
        return e;
    }

    public BigInteger getPrivateKey() {
        return d;
    }

    public BigInteger getModulus() {
        return n;
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(d, n);
    }

    public List<BigInteger> encryptText(String message) {
        
        List<String> messages = splitStr(message, bitLength/8);

        List<BigInteger> encryptedFull = new ArrayList<>();
         
        for (String m : messages) {
            BigInteger plainText = new BigInteger(m.getBytes());
            BigInteger encrypted = encrypt(plainText);
            
            encryptedFull.add(encrypted);
        }

        return encryptedFull;
        
    }

    public String decryptText(List<BigInteger> encrypted) {
        
        String decryptedMessages = "";

        for (BigInteger c : encrypted) {
                
            BigInteger decrypted = decrypt(c);
            String decryptedMessage = new String(decrypted.toByteArray());
            
            decryptedMessages += decryptedMessage;
        }   
        
        return decryptedMessages;
    }

    public static List<String> splitStr(String str, int len) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i += len) {
            result.add(str.substring(i, Math.min(i + len, str.length())));
        }
        return result;
    }

}
