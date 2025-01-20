package leetcode;

public class Main {

    public static void main(String[] args) {

        Arrays arr = new Arrays();

        int[] nums1 = {1,2,3};

        int[] nums2 = {3,1,2};

        int[] answer = arr.findThePrefixCommonArray(nums1, nums2);

        System.out.println(java.util.Arrays.toString(answer));

    }
}
