package com.example.leetcode;

import java.util.Arrays;

public class LeetCode2 {
    public static void main(String[] args) {
        String [] list = new String[] {"flower","flow","flight"};

        String s = "()[]{}";
        System.out.println(strStr("dasdasdleetcode","leet"));
        System.out.println(strStr("a","a"));
    }
    public static String longestCommonPrefix(String[] str) {
        int arrayLength = str.length;

        if (arrayLength == 0){
            return "";
        }
        String strs = str[0];
        for (int i = 1 ; i < arrayLength ; i++){
            String current = str[i];
            int j = 0;
            int currentLength = current.length();
            while(j<currentLength && j< arrayLength && strs.charAt(j) == current.charAt(j)){
                j++;
            }
            strs = strs.substring(0,j);
        }
        return strs;
    }

    public static boolean isValid(String s) {
        while (true){
            if (s.contains("()")) {
                s = s.replace("()","");
            } else if (s.contains("[]")){
                s = s.replace("[]","");
            } else if (s.contains("{}")) {
                s = s.replace("{}","");
            } else {
                return s.isEmpty();
            }
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if (list1 != null && list2 != null){
            if ( list1.val < list2.val){
                list1.next = mergeTwoLists(list1.next,list2);
                return list1;
            }
            else {
                list2.next = mergeTwoLists(list1,list2.next);
                return list2;
            }
        }
        if (list1 == null) {
            return list2;
        }
        return list1;
    }

    public static int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        int i = 0;
        while (i <= haystackLength-needleLength ) {
            String s = haystack.substring(i,needleLength+i);
            if(needle.equals(s)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int searchInsert(int[] nums, int target) {
        int i = nums.length;
        int currentNum = nums[i-1];
        if (currentNum == target) {
            return i;
        }
        else if (currentNum < target){
            return i+1;
        }
        else {
            return -1;
        }
    }

}
