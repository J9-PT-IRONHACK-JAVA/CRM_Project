package com.example.crm_project.utils;

public class TypeWriter {
    public static void typewriterFromString(String stringToApplyEffect, int delay) {
        for (int i = 0; i < stringToApplyEffect.length(); i++) {
            System.out.print(stringToApplyEffect.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
