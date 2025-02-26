package org.senai;

public class Weather {

    public int checkWeather(int num) {
        switch (num) {
            case 1:
                System.out.println("It's summer!");
                break;
            case 2:
                System.out.println("It's autumm!");
                break;
            case 3:
                System.out.println("It's spring!");
                break;
            case 4:
                System.out.println("Winter is coming... GOT! It's winter!");
                break;
            default:
                System.out.println("404");
                throw new IllegalArgumentException("404 Not found!");
        }
        return num;
    }
}
