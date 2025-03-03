package com.senai.testcase02booleanmethod;

public class ValidationNumber {

    public boolean checkNumber(Integer number) {
        if(number % 2 == 0) {
            System.out.println("PAR");
            return true;
        }
        System.out.println("ÍMPAR");
        return false;
    }
}
