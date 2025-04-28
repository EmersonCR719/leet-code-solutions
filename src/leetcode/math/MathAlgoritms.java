package leetcode.math;

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

    public void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public double myPow(double x, int n) {

        double ans = 1;

        if (x == 0 || x == 1) return x;
        if (n == 0) return 1;
        else {
            if (Math.abs(n) % 2 == 0) {
                if (x == -1) return 1;
                for (int i = 0; i < Math.abs(n) / 2; i++) {
                    ans *= x;
                    ans *= x;
                }
            } else {
                if (x == -1) return 1;
                for (int i = 0; i < Math.abs(n) / 2; i++) {
                    ans *= x;
                    ans *= x;
                }
                ans = ans * x;
            }
        }
        if (ans == 1) return 0;
        return (n > 0) ? ans : (1 / ans);
    }

    public int trailingZeroes(int n) {

        if (n <= 4) return 0;

        int divisor = 5;

        double division = (double) n / divisor;

        int sumZeroes = 0;
        sumZeroes += (int) division;

        while (division > 1) {
            division /= divisor;
            sumZeroes += (int) division;
        }

        return sumZeroes;
    }

    public boolean isHappy(int n) {
        boolean exit = false;
        int num = n;
        while (!exit) {
            int sumSquare = 0;
            while (num != 0) {      //Calcular las cifras y sumar sus cuadrados
                int lastDigit = num % 10;    //lastDigit tiene el residuo de la division de num entre 10.
                sumSquare += lastDigit * lastDigit;
                num = num / 10;
            }
            if (sumSquare >= 10) {
                num = sumSquare;
            } else {
                if (sumSquare == 1 || sumSquare == 7) {
                    return true;
                }
                exit = true;
            }
        }
        return false;
    }

    public int maxPoints(int[][] points) {

        int count = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                System.out.print(points[i][j] + " ");
            }
            System.out.println();
        }

        return count;
    }

    public int translate(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public int romanToInt(String s) {
        int sum = 0;
        int current = translate(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int next = translate(s.charAt(i));

            if (current < next) {
                sum -= current;
            } else {
                sum += current;
            }
            current = next;
        }
        sum += current;

        return sum;
    }

    public int[] closestPrimes(int left, int right) {

        int prevPrime = -1, closestA = -1, closestB = -1;
        int minDifference = (int) 1e6;
        // Find all prime numbers in the given range
        for (int candidate = left; candidate <= right; candidate++) {
            if (isPrime(candidate)) {
                if (prevPrime != -1) {
                    int difference = candidate - prevPrime;
                    if (difference < minDifference) {
                        minDifference = difference;
                        closestA = prevPrime;
                        closestB = candidate;
                    }
                    // Twin prime optimization
                    if (difference == 2 || difference == 1) return new int[]{
                            prevPrime,
                            candidate,
                    };
                }
                prevPrime = candidate;
            }
        }

        return (closestA == -1)
                ? new int[]{-1, -1}
                : new int[]{closestA, closestB};
    }

    public boolean isPrime(int number) {
        if (number < 2) return false;
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0) return false;
        for (int divisor = 3; divisor * divisor <= number; divisor += 2) {
            if (number % divisor == 0) return false;
        }
        return true;
    }

    public boolean isThree(int n) {

        if (n == 1) return false;
        int counter = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) counter++;
        }

        return counter == 3;
    }

    public int findGCD(int[] nums) {

        int smallest = (int) 10e9, largest = -(int) 10e9, greatest = -(int) 10e9;

        for (int num : nums) {
            smallest = Math.min(smallest, num);
            largest = Math.max(largest, num);
        }

        int iterator = 1;
        while (iterator <= smallest) {
            if (smallest % iterator == 0 && largest % iterator == 0) {
                greatest = Math.max(iterator, greatest);
            }
            iterator++;
        }

        return greatest;
    }

    public int minOperations(int[] nums, int k) {

        int sum = 0;

        for (int num : nums) sum += num;

        return sum % k;
    }

    public int findClosest(int x, int y, int z) {

        if (Math.abs(z - x) == Math.abs(z - y)) {
            return 0;
        } else if (Math.abs(z - x) > Math.abs(z - y)) {
            return 1;
        } else {
            return 2;
        }
    }

    public int reverseNumX(int x) {
        long reverse = 0;
        while (x != 0) {
            int r = x % 10;
            reverse = reverse * 10 + r;
            x = x / 10;
        }
        if (reverse >= Integer.MAX_VALUE || reverse <= Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reverse;
    }

    public int countDistinctIntegers(int[] nums) {

        List<Integer> allNums = new ArrayList<>();

        for (int num : nums) {
            allNums.add(num);
        }

        for (int num : nums) {
            allNums.add(reverseNumX(num));
        }

        Set<Integer> set = new HashSet<>(allNums);

        return set.size();
    }

    public boolean canAliceWin(int[] nums) {

        int sumSingleDigit = 0, doubleDigit = 0;
        for (int num : nums) {
            if (num <= 9) sumSingleDigit += num;
            else doubleDigit += num;
        }
        return sumSingleDigit != doubleDigit;
    }


    public int reverse(int x) {
        return reverseNumX(x);
    }


}
