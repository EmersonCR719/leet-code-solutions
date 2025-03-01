package leetcode.array;

public class Main {

    public static void main(String[] args) {

        Arrays arr = new Arrays();

        int[] nums1 = {1000000000,999999999,1000000000,999999999,1000000000,999999999};

        int[] nums2 = {1,2,2,1,1,0};

        String s1 = "abcd", s2 = "dcba";

        System.out.println(java.util.Arrays.toString(arr.applyOperations(nums2)));

    }
}
