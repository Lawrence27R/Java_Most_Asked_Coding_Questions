package com.codes.java;

import java.util.*;

public class ListCodingQuestionsCode {


    List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

    List<Integer> list1 = List.of(10, 20, 30);

//    List starts with 1
//    list.size()        // length

//    list.get(i)        // read

//    list.set(i, value) // replace

//    list.add(x)        // append

//    list.remove(i)     // remove by index

//    list.remove(Integer.valueOf(x)) // remove by value

//    Collections.sort(list)

//    Collections.reverse(list)


    // ============================================================================
    // Question: Find Largest Element
    // Input : [10, 20, 30, 40, 50]
    // Output: 50
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static int findLargest(List<Integer> list) {
        int largest = list.get(0);
        for (int num : list) {
            if (num > largest) largest = num;
        }
        return largest;
    }

    // ============================================================================
    // Question: Find Second Largest Element
    // Input : [10, 20, 30, 40, 50]
    // Output: 40
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static int findSecondLargest(List<Integer> list) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : list) {
            if (num > largest) {
                second = largest;
                largest = num;
            } else if (num > second && num != largest) {
                second = num;
            }
        }
        return second;
    }

    // ============================================================================
    // Question: Reverse List
    // Input : [1,2,3,4,5]
    // Output: [5,4,3,2,1]
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static List<Integer> reverse(List<Integer> list) {
        List<Integer> result = new ArrayList<>(list);
        int left = 0, right = result.size()-1;
        while(left < right){
            int temp = result.get(left);
            result.set(left,result.get(right));
            result.set(right,temp);
            left++;
            right--;
        }
        return result;
    }

    // ============================================================================
    // Question: Remove Duplicates
    // Input : [1,2,2,3,4,4,5]
    // Output: [1,2,3,4,5]
    // Time Complexity : O(n²)
    // Space Complexity: O(n)
    // ============================================================================
    public static List<Integer> removeDuplicates(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        for(Integer num:list){
            if(!result.contains(num)){
                result.add(num);
            }
        }
        return result;
    }

    // ============================================================================
    // Question: Find Duplicate Elements
    // ============================================================================
    public static List<Integer> findDuplicates(List<Integer> list){
        List<Integer> duplicates = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).equals(list.get(j)) && !duplicates.contains(list.get(i))){
                    duplicates.add(list.get(i));
                }
            }
        }
        return duplicates;
    }

    // ============================================================================
    // Question: Sum of Elements
    // ============================================================================
    public static int sum(List<Integer> list){
        int sum=0;
        for(int num:list){
            sum+=num;
        }
        return sum;
    }

    // ============================================================================
    // Question: Count Even and Odd Numbers
    // ============================================================================
    public static void countEvenOdd(List<Integer> list){
        int even=0,odd=0;
        for(int num:list){
            if(num%2==0) even++;
            else odd++;
        }
        System.out.println("Even = "+even);
        System.out.println("Odd = "+odd);
    }

    // ============================================================================
    // Question: Move Zeros To End
    // ============================================================================
    public static List<Integer> moveZerosToEnd(List<Integer> list){
        List<Integer> result = new ArrayList<>(list);
        int index=0;
        for(int i=0;i<result.size();i++){
            if(result.get(i)!=0){
                result.set(index++,result.get(i));
            }
        }
        while(index<result.size()){
            result.set(index++,0);
        }
        return result;
    }

    // ============================================================================
    // Question: Check Palindrome
    // ============================================================================
    public static boolean isPalindrome(List<Integer> list){
        int left=0,right=list.size()-1;
        while(left<right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // ============================================================================
    // Question: Frequency of Element
    // ============================================================================
    public static int frequency(List<Integer> list,int target){
        int count=0;
        for(int num:list){
            if(num==target) count++;
        }
        return count;
    }

    // ============================================================================
    // Question: Longest Consecutive Ones
    // ============================================================================
    public static int longestConsecutiveOnes(List<Integer> list){
        int max=0,count=0;
        for(int num:list){
            if(num==1){
                count++;
                max=Math.max(max,count);
            }else{
                count=0;
            }
        }
        return max;
    }

    // ============================================================================
    // Question: Rotate Left By K
    // ============================================================================
    public static List<Integer> rotateLeft(List<Integer> list,int k){
        List<Integer> result=new ArrayList<>(list);
        Collections.rotate(result,-k);
        return result;
    }

    // ============================================================================
    // Question: Rotate Right By K
    // ============================================================================
    public static List<Integer> rotateRight(List<Integer> list,int k){
        List<Integer> result=new ArrayList<>(list);
        Collections.rotate(result,k);
        return result;
    }

    // ============================================================================
    // Question: Merge Two Lists
    // ============================================================================
    public static List<Integer> merge(List<Integer> list1,List<Integer> list2){
        List<Integer> result=new ArrayList<>(list1);
        result.addAll(list2);
        return result;
    }

    // ============================================================================
    // Question: Intersection of Two Lists
    // ============================================================================
    public static List<Integer> intersection(List<Integer> list1,List<Integer> list2){
        List<Integer> result=new ArrayList<>();
        for(Integer num:list1){
            if(list2.contains(num) && !result.contains(num)){
                result.add(num);
            }
        }
        return result;
    }

    // ============================================================================
    // Question: Two Sum
    // ============================================================================
    public static List<Integer> twoSum(List<Integer> list,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<list.size();i++){
            int num=list.get(i);
            if(map.containsKey(target-num)){
                return Arrays.asList(map.get(target-num),i);
            }
            map.put(num,i);
        }
        return Collections.emptyList();
    }

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(10,20,20,30,40,0,40,50);

        System.out.println(findLargest(list));
        System.out.println(findSecondLargest(list));
        System.out.println(reverse(list));
        System.out.println(removeDuplicates(list));
        System.out.println(findDuplicates(list));
        System.out.println(sum(list));
        countEvenOdd(list);
        System.out.println(moveZerosToEnd(list));
    }
}
