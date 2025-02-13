package utilitys;

import leetcode.string.Strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Principal {

    public static void main(Strings[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,9,8,7,4,5,6);

        int max = numbers.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(max);

        int min = numbers.stream().min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(min);


    }
}
