package guru.qa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Типы данных
        // логический
        boolean varBoolean = false;
        // целочисленные
        byte varByte = 100; // -128 ... 127  (-2 ^ 7 ... (2 ^ 7) -1)
        short varShort = 1000; // -321768  ... 321767
        int varInt = 100_000_000;
        long varLong = 0L;
        // символ (под капотом тоже число)
        char varChar = 'f';
        //  числа с плавающей точкой
        float varFloat = 0.0F;
        double varDouble0 = 36.0;
        String varString0 = "Selenide";
        String varString1 = "Selenide";

        int coinNominal = 3;
        String coinCurrency = "RUB";

        // Операторы
        // Операторы математические
        int result = 10;
        result = result + 1;
        result +=  1;
        result = ++result;

        // Операторы сравнения
        // > < >= <= == !=

        // Логические операторы
        // && || !, ^
        if (coinCurrency.equals("RUB")) {
            System.out.println("Это рубль!");
        } else if (coinCurrency.equals("USD")) {
            System.out.println("Это долар!");
        } else {
            System.out.println("Ничего не подошло");
        }

        switch (coinCurrency) {
            case "RUB": {
                System.out.println("Это рубль!");
                break;
            }
            case "USD": {
                System.out.println("Это долар!");
                break;
            }
            default: {
                System.out.println("Ничего не подошло");
            }
        }


        // примитивные переменные
        byte varByte2 = 127; //-128 ....... 127
        short varShort2 = 32767; // -32788 ....... 32767
        int varInt2 = 99999; // -2 в 31 степени ..... 2 в 31 степени -1 must have
        long varLong2 =999999L; // -2 в 64 степени ...... до 2 в 64 степени -1
        // Floating point data
        float varFloat2 = 0.1f; //32bytes
        double varDouble = 1.99d; //64 bytes must have
        //операции с переменными
        System.out.println(varByte2 + varShort2);
        System.out.println(varInt2 - varLong2);
        System.out.println(varByte2 / varFloat2);
        System.out.println(varByte2 % varShort2);
        // переполнение
        System.out.println((byte) (varByte2 + 1));
        System.out.println((short) (varShort2 + varLong2));
        //вычисления с int и double
        System.out.print("Usual price for this goods is ");
        System.out.print(varInt2 + varDouble);
        System.out.print(" USD, ");
        System.out.print("but your special price for this goods is ");
        System.out.print(varInt2 - varDouble);
        System.out.print(" USD");



    }


    public static String someMethod() {
        return "" ;
    }
}