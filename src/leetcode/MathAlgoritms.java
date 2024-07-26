package leetcode;

import java.math.BigInteger;
import java.util.*;
import java.util.Arrays;

public class MathAlgoritms {

    public int differenceOfSums(int n, int m) {

        int num1 = 0;
        int num2 = 0;
        int res;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                num2 += i;
            } else {
                num1 += i;
            }
        }
        res = num1 - num2;
        return res;
    }

    public int subtractProductAndSum(int n) {

        int productDigits = 1;

        int sumDigits = 0;

        int difference = 0;

        while (n > 0) {

            sumDigits += n % 10;

            productDigits *= n % 10;

            n /= 10;
        }

        difference = productDigits - sumDigits;

        return difference;
    }

    public double[] convertTemperature(double celsius) {

        double[] answer = new double[2];

        double kelvin = celsius + 273.15;

        double fahrenheit = celsius * 1.80 + 32.00;

        answer[0] = kelvin;

        answer[1] = fahrenheit;

        return answer;
    }

    public int xorOperation(int n, int start) {

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }

        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            answer ^= nums[i];
        }

        return answer;
    }

    public int sumOfMultiples(int n) {

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public int countDigits(int num) {

        int count = 0;

        int copyNum = num;

        while (copyNum > 0) {

            int digit = copyNum % 10;

            if (num % digit == 0) count++;

            copyNum /= 10;
        }

        return count;
    }

    public int pivotInteger(int n) {
        int sum = (n + 1) * n / 2;
        int pivot = (int) Math.sqrt(sum);
        return pivot * pivot == sum ? pivot : -1;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                answer.add(i);
            }
        }

        return answer;
    }

    public boolean isSelfDividing(int num) {

        boolean answer = true;

        int copyNum = num;

        int digit = 0;

        while (copyNum > 0) {

            digit = copyNum % 10;

            if (digit == 0 || num % digit != 0) {
                return false;
            }

            copyNum /= 10;
        }

        return answer;
    }


    public int totalMoney(int n) {

        int money = 0;

        int countDays = 1;

        for (int i = 1; i <= n; i++) {

            if (i > 7) {
                money += i + 1;
            }
            money += i;
        }

        return money;
    }

    public int sumBase(int n, int k) {
        return (n == 0) ? 0 : n % k + sumBase(n / k, k);
    }

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {

        int answer = 0;

        answer = arrivalTime + delayedTime;

        if (answer >= 24) return answer - 24;

        return answer;
    }

    public boolean squareIsWhite(String coordinates) {

        int num1 = coordinates.charAt(0) - 'a';

        int num2 = coordinates.charAt(1) - '0';

        return num1 + num2 % 2 == 0;
    }

    public String primerosCincoNumerosPares() {

        int count = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; count < 5; i++) {

            if (i % 2 == 0) {
                sb.append(i).append("|");
                count++;
            }
        }
        return sb.toString();
    }

    public int kthFactor(int n, int k) {

        int i = 1;

        ArrayList<Integer> factors = new ArrayList<>();

        while (i <= n) {
            if (n % i == 0) {
                factors.add(i);
            }
            i++;
        }

        for (int j = 0; j < factors.size(); j++) {
            if (j == k - 1) {
                return factors.get(j);
            }
        }

        return -1;
    }

    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    public int sumOfTheDigitsOfHarshadNumber(int x) {

        int sum = 0, num = x;

        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        if (x % sum == 0)
            return sum;
        else return -1;
    }

    public boolean isSameAfterReversals(int num) {


        return false;
    }

    public int reverseNum(int num) {

        int copyNum = num, reversed;

        StringBuilder stringBuilder = new StringBuilder();

        while (copyNum > 0) {

            reversed = copyNum % 10;

            stringBuilder.append(reversed);

            copyNum /= 10;
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    public boolean checkPerfectNumber(int num) {

        int sum = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        return sum == num;
    }

    public boolean isUgly(int n) {
        return false;
    }

    public List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> answer = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        int sum;

        for (int i = 0; i < num.length; i++) {
            sb.append(num[i]);
        }

        sum = Integer.parseInt(sb.toString()) + k;

        sb = new StringBuilder();

        sb.append(sum);

        for (int i = 0; i < sb.length(); i++) {
            answer.add(Integer.parseInt(String.valueOf(sb.charAt(i))));
        }

        return answer;
    }

    public String addBinary(String a, String b) {
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        BigInteger c1 = new BigInteger(String.valueOf(a1 + b1));
        return Integer.toString(Integer.parseInt(c1.toString()), 2);
    }

    public int addDigits(int num) {

        int x = num, sum = 0;

        if (num < 10) return num;

        while (sum >= 0) {
            sum += x % 10;
            x /= 10;
        }

        return sum;
    }

    public int countOperations(int num1, int num2) {

        int steps = 0;

        while (num1 > 0 && num2 > 0) {

            if (num1 >= num2) {
                num2 -= num1;
                steps++;
            } else {
                num1 -= num2;
                steps++;
            }
        }

        return steps;
    }

    public int countSymmetricIntegers(int low, int high) {

        int count = 0;

        for (int i = low; i <= high; i++) {
            if (sumOfDigits(i) == sumOfDigits(high)) {
                count++;
            }
        }

        return count;
    }

    public int sumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int countEven(int num) {

        int count = 0;

        for (int i = 1; i <= num; i++) {
            if (sumOfDigits(i) % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    public int arraySign(int[] nums) {

        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) return 0;
            if (nums[i] < 0) nums[i] = -1;
            if (nums[i] > 0) nums[i] = 1;
            product *= nums[i];
        }

        if (product > 0) {
            return 1;
        } else if (product < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public int sumOddLengthSubarrays(int[] arr) {

        int sum = 0, k = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                sum = sum + arr[i];
            }
        }

        return sum;
    }

    public boolean checkSubarraySum(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) return true;
            }
        }

        return false;
    }

    public int minimumOperations(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 != 0) count++;
        }

        return count;
    }

    public int smallestValue(int n) {

//        int i = 2;
//        ArrayList<Integer> factors = new ArrayList<>();
//        while (n > 1){
//            if (n % i == 0){
//                factors.add(i);
//                n /= i;
//            }else{
//                i++;
//            }
//        }

        if (n == factorsSum(factorsOf(n)))
            return n;
        else
            return smallestValue(factorsSum(factorsOf(n)));

    }

    public int factorsSum(List<Integer> factors) {
        int sum = 0;
        for (int num : factors) sum += num;
        return sum;
    }

    public List<Integer> factorsOf(int n) {
        ArrayList<Integer> factors = new ArrayList<Integer>();

        for (int divisor = 2; n > 1; divisor++) {
            for (; n % divisor == 0; n /= divisor) {
                factors.add(divisor);
            }
        }

        return factors;
    }

    public int distinctPrimeFactors(int[] nums) {

        HashSet<Integer> primeFactors = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = factorsOf(nums[i]);
            primeFactors.addAll(list);
        }

        return primeFactors.size();
    }

    public int reverse(int x) {

        int answer;

        StringBuilder sb = new StringBuilder();

        sb.append(x);

        String sign = x < 0 ? "-" : "";

        sb.deleteCharAt(0);

        sb.reverse();

        StringBuilder sb2 = new StringBuilder();

        if (!sign.isEmpty()){
            sb2.append(sign);
            sb2.append(sb);
        }

        for (int i = 0; i < sb2.length(); i++) {
            if (sb2.charAt(i) == '0') {
                sb2.deleteCharAt(i);
            }
            if (sb2.charAt(i) != '0') {
                break;
            }
        }

        return Integer.parseInt(sb2.toString());
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        ArrayList<Integer> nums = new ArrayList<>();

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums.add(nums1[i]);
            }
            i++;
            j++;
        }

        int[] answer = new int[nums.size()];

        for (int k = 0; k < nums.size(); k++) {
            answer[k] = nums.get(k);
        }

        return answer;
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void reverse(int[] nums, int start, int end){
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public int romanToInt(String s) {
        /*
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
         */
        Map<String, Integer> romans = new HashMap<>();
        romans.put("I", 1);
        romans.put("V", 5);
        romans.put("X", 10);
        romans.put("L", 50);
        romans.put("C", 100);
        romans.put("D", 500);
        romans.put("M", 1000);

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {

            }
        }
        

        return 0;
    }

}
