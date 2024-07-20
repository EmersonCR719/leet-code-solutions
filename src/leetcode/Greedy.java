package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Greedy {

    public int maximum69Number (int num) {

        StringBuilder stringBuilder = new StringBuilder();

        String numStr = String.valueOf(num);

        char[] chars = numStr.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '6'){
                chars[i] = '9';
                break;
            }

        }

        for (int i = 0; i < chars.length; i++) {

            stringBuilder.append(chars[i]);
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    public int theMaximumAchievableX(int num, int t) {

        int x = 0;

        for (int i = 0; i < t; i++) {
            x--;
            num++;              // NO SE HA TERMINADO, ESTÁ MALLLL
            if (x == num){
                return num;
            }
        }
        return 0;
    }

    public int reverse(int x) {

        StringBuilder stringBuilder = new StringBuilder();



        return 0;
    }

    public int minIncrementForUnique(int[] nums) {

        int count = 0;
        //nums = [3,2,1,2,1,7]
        //nums = [1,1,2,2,3,7]
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]){
                
                count += nums[i - 1] + 1 - nums[i];

                nums[i] = nums[i-1] + 1;
            }
        }

        return count;
    }



}
