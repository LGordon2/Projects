package com.lewgordon;

public class Collatz {
    public static Integer calculateSteps(Integer number){
        if(number <= 1){
            return 0;
        }

        // If number is even divide by 2.
        if(number % 2 == 0){
            return 1 + calculateSteps(number / 2);
        }

        // Otherwise multiply it by 3 and add 1.
        return 1 + calculateSteps(number * 3 + 1);
    }
}
