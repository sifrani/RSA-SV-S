package com.sv;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RSA {
    private final Logger logger = LogManager.getLogger(RSA.class);

    private BigInteger n, d, e;

    private static int bitLength = 1024;

    public RSA() {

        logger.info("Generazione chiavi");

        SecureRandom random = new SecureRandom();

        BigInteger p = BigInteger.probablePrime(bitLength / 2 + 1, random);
        logger.debug("n generato:" + p);

        BigInteger q = BigInteger.probablePrime(bitLength / 2 + 1, random);
        logger.debug("q generato" + q);



        n = p.multiply(q);
        logger.debug("n generato" + n);
        
        
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        logger.debug("phi generato" + phi);
        
        e = BigInteger.probablePrime(bitLength / 4, random);
        logger.debug("e generato" + e);
        /* 
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e = e.add(BigInteger.ONE);
        }*/

        d = e.modInverse(phi);
        logger.debug("d generato" + d);
        
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

    private BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    private BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(d, n);
    }

    public List<BigInteger> encryptText(String message) {
        
        logger.info("encrypting messaggio");
        
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
        
        logger.info("decrypting messaggio");

        String decryptedMessages = "";

        for (BigInteger c : encrypted) {
                
            BigInteger decrypted = decrypt(c);
            String decryptedMessage = new String(decrypted.toByteArray());
            
            decryptedMessages += decryptedMessage;
        }   
        
        return decryptedMessages;
    }

    private static List<String> splitStr(String str, int len) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i += len) {
            result.add(str.substring(i, Math.min(i + len, str.length())));
        }
        return result;
    }

}
