package com.example.leetcode;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
       int[] number = new int[] {2,7,11,19};
// Cau 1: two sum;
        System.out.println(Arrays.toString(twoSumAgain(number, 6)));
//        System.out.println(isPalindrome(1221));
        System.out.println(romanToInt("LVIIIX"));

    }
    public static int[] twoSum(int[] number , int target){
        Map<Integer,Integer> unset = new HashMap<>();
        int arrayLength = number.length;
        for (int i = 0; i < arrayLength; i++) {
            int minus = target - number[i];
            if (unset.containsKey(minus)) {
                return new int []{unset.get(minus), i};
            }
            unset.put(number[i],i);
        }
        return null;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0){
            return false;
        }
        int check = 0;
        while(x > check){
            check = check*10 + x%10;
            x/=10;
        }
        return (check == x || check/10 == x);
    }

    public static int romanToInt(String s) {
        int result = 0;
        int prevNumber = 0;
        int arrayLength = s.length();
        for (int i = arrayLength -1  ; i >= 0 ; i-- ) {
            char ch = s.charAt(i);
            int value = getValue(ch);
            if (value < prevNumber){
                result -= value;
            } else{
                result += value;
            }
            prevNumber = value;
        }
        return result;
    }

    public static int getValue(char s){
        switch (s){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }

    public static int[] twoSumAgain(int[] number, int target){
        int numberLength = number.length;
        for (int i = 0 ; i < numberLength ; i++){
            for (int j = i+1 ; j < numberLength ; j++){
                int sum = number[i] + number[j];
                if (sum == target){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }
}