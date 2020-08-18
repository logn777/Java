package com.company.algorithms;

public class Base {
    public static int sumDigitOfNumber2(int num){
        int sum = 0;

        char[] arr = Integer.toString(num).toCharArray();
        for(char c : arr){
            if(Character.isDigit(c))
                sum += Character.getNumericValue(c);
        }
        return sum;
    }

    //решение в лоб
    public static int sumDigitOfNumber(int num){
        int sum = 0;

        while (num != 0){
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    
}
