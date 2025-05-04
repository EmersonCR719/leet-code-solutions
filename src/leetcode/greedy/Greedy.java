package leetcode.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int count = 0;

        Map<Integer, Integer> freqTops = new HashMap<>();
        Map<Integer, Integer> freqBottoms = new HashMap<>();

        for (int i = 0; i < tops.length; i++) {
            freqTops.put(tops[i], freqTops.getOrDefault(tops[i], 0) + 1);
            freqBottoms.put(bottoms[i], freqBottoms.getOrDefault(bottoms[i], 0) + 1);
        }

        int maxFreqTopNum = -(int) 10e9;
        int maxFreqBottomNum = -(int) 10e9;

        for (int i = 1; i <= 6; i++) {
            maxFreqTopNum = Math.max(maxFreqTopNum, freqTops.getOrDefault(i, 0));
            maxFreqBottomNum = Math.max(maxFreqBottomNum, freqBottoms.getOrDefault(i, 0));
        }

        System.out.println(maxFreqTopNum + " " + maxFreqBottomNum);

        return count;
    }
}
