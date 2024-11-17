package com.rsa;

import java.math.BigInteger;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RSA rsa = new RSA();
        String message = "NPM I BCRYPT ERA UN BEL RICORDO";
        System.out.println("Messaggio originale: " + message);

        List<BigInteger> encrypted = rsa.encryptText(message);
        System.out.println("Messaggio cifrato: " + encrypted);

        String decrypted = rsa.decryptText(encrypted);
        
        System.out.println("Messaggio decifrato: " + decrypted);
    }
}
