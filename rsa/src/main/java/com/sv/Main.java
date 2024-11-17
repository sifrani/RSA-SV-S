package com.sv;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.WARN);

        RSA rsa = new RSA();

        System.out.print("Messaggio: ");
        String message = sc.nextLine();

        System.out.println("Messaggio originale: " + message);

        List<BigInteger> encrypted = rsa.encryptText(message);
        System.out.println("Messaggio cifrato: " + encrypted);

        String decrypted = rsa.decryptText(encrypted);
        
        System.out.println("Messaggio decifrato: " + decrypted);
    }
}
