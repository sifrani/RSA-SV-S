package com.example.rsa;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        RSA rsa = new RSA();
        String message = "NPM I BCRYPT ERA UN BEL RICORDO";
        System.out.println("Messaggio originale: " + message);

        BigInteger plainText = new BigInteger(message.getBytes());
        BigInteger encrypted = rsa.encrypt(plainText);
        System.out.println("Messaggio cifrato: " + encrypted);

        BigInteger decrypted = rsa.decrypt(encrypted);
        String decryptedMessage = new String(decrypted.toByteArray());
        System.out.println("Messaggio decifrato: " + decryptedMessage);
    }
}
