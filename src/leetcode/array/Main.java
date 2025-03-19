package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Arrays arr = new Arrays();

        int[] nums1 = {1000000000,999999999,1000000000,999999999,1000000000,999999999};

        int[] nums2 = {1, 5, 2, 6};

        String s1 = "abcd", s2 = "dcba";

        List<String> list = new ArrayList<>(List.of("one.two.three"));

        System.out.println(arr.splitWordsBySeparator(list, '.'));

    }
}
