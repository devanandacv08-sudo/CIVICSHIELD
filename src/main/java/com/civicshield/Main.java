package com.civicshield;

import com.civicshield.privacy.PrivacyModule;

public class Main {

    public static void main(String[] args) {

        System.out.println("CivicShield Started Successfully!");

        PrivacyModule privacyModule = new PrivacyModule();
        privacyModule.start();
    }
}