package leetcode;

import java.util.*;

public class Arrays {


    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i == j) {
                    j++;
                }
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return index;
    }

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return false;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int reversed_int = 0;
        while (x > reversed_int) {
            int pop = x % 10;
            x /= 10;
            reversed_int = (reversed_int * 10) + pop;
            System.out.println("pop = " + pop);
            System.out.println("X = " + x);
            System.out.println("reversed_int = " + reversed_int);
        }
        System.out.println("Fuera del ciclo reversed_int = " + reversed_int);
        System.out.println("Fueral de ciclo X = " + x);
        System.out.println("reversed_int / 10 = " + reversed_int / 10);
        return x == reversed_int || x == reversed_int / 10;
    }

    public int searchInsert(int[] nums, int target) {
        java.util.Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                index = i;
            }
        }
        if (index == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (target > nums[i]) {
                    index++;
                }
            }
        }
        return index;
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newArr = new int[n + 1];
        newArr[0] = 1;
        return newArr;
    }

    public boolean containsDuplicate(int[] nums) {
        boolean result = false;
        java.util.Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                result = true;
            }
        }
        return result;
    }

    public int minimumSum(int[] nums) {
        int sum = 0;
        int i = 0, j = 1, k = 2;
        while (i < nums.length && j < nums.length && k < nums.length) {
            if (nums[i] < nums[j] && nums[k] < nums[j]) {
                System.out.println(i + " " + j + " " + k);
                return sum = nums[i] + nums[j] + nums[k];
            } else {
                i++;
                j++;
                k++;
            }
        }

        return sum;
    }

    public int maximumWealth(int[][] accounts) {
        int maxRichest = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            maxRichest = Math.max(maxRichest, sum);
        }
        return maxRichest;
    }

    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = i % 3 == 0;
            boolean divisibleBy5 = i % 5 == 0;

            if (divisibleBy3 && divisibleBy5) {
                answer.add("FizzBuzz");
            } else if (divisibleBy3) {
                answer.add("Fizz");
            } else if (divisibleBy5) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i));
            }
        }
        return answer;
    }

    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            steps++;
        }
        return steps;
    }

    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> array = new ArrayList<>();
        int tamano = 0;
        while (head != null) {
            array.add(head);
            head = head.next;
            tamano++;
        }
        return array.get(tamano / 2);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);

            int matchingIndex = magazine.indexOf(r);

            if (matchingIndex == -1) {
                return false;
            }

            magazine = magazine.substring(0, matchingIndex) + magazine.substring(matchingIndex + 1);
        }
        return true;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int consecutive = 0;
        int ones = 0;
        for (int num : nums) {
            if (num == 1) {
                ones += num;
            } else {
                if (consecutive < ones) {
                    consecutive = ones;
                }
                ones = 0;
            }
        }
        return Math.max(ones, consecutive);
    }

    public int findNumbers(int[] nums) {
        int evenNumber = 0;
        for (int j : nums) {
            String num = Integer.toString(j);
            if (num.length() % 2 == 0) {
                evenNumber++;
            }
        }
        return evenNumber;
    }

    public int[] sortedSquares(int[] nums) {
        int[] squareNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            squareNums[i] = (int) Math.pow(nums[i], 2);
        }
        java.util.Arrays.sort(squareNums);
        return squareNums;
    }

    public String mergeAlternately(String word1, String word2) {
        String merged = "";
        int length = Math.max(word1.length(), word2.length());
        int i = 0, j = 0;
        while (i < length) {
            merged += word1.charAt(i);  //HAY QUE TERMINARLO
            merged += word2.charAt(i);
            i++;
        }
        return merged;
    }

    public String gcdOfStrings(String str1, String str2) {
        int length1 = Math.max(str1.length(), str2.length());
        int length2 = Math.min(str1.length(), str2.length());
        String x = "";
        for (int i = length2; i < length1; i++) {
            if (str1.length() > str2.length()) {
                x += str1.charAt(i);
            } else {
                x += str2.charAt(i);
            }
        }
        return x;
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public boolean tieneDublicados(int[] nums) {
        boolean tiene = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                tiene = true;
            }
        }
        return tiene;
    }

    public void intercambiarPoscicion(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public void intercambiarPos(int[] nums, int a, int b) {
        int temp;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void moverAIzquierda(int index, int[] arr) {
        for (int i = index; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int aux = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[aux];
            aux++;
        }
        java.util.Arrays.sort(nums1);
    }

    public int maximumProduct(int[] nums) {
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                i++;
            }
            product *= nums[i];
        }
        return product;
    }

    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];
        int i = 0, j = 0;
        while (i < ans.length && j < ans.length) {
            ans[i] = nums[j];
            i++;
            j++;
            if (j >= nums.length)
                j = 0;
        }
        return ans;
    }

    public int finalValueAfterOperations(String[] operations) {
        int value = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("++X") || operations[i].equals("X++")) {
                value++;
            } else {
                value--;
            }
        }
        return value;
    }

    public int[] shuffle(int[] nums, int n) {
        int[] answer = new int[2 * n];
        int[] aux = new int[n];
        int[] aux2 = new int[n];
        int j = 0;
        for (int i = n; i < nums.length; i++) {
            aux[j] = nums[i];
            j++;
        }
        for (int i = 0; i < n; i++) {
            aux2[i] = nums[i];
        }
        j = 0;
        for (int i = 0; i < answer.length - 1; i += 2) {
            answer[i] = aux2[j];
            j++;
        }
        j = 0;
        for (int i = 1; i <= answer.length; i += 2) {
            answer[i] = aux[j];
            j++;
        }
        return answer;
    }

    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int j = mat.length - 1;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            sum += mat[i][j];
            j--;
        }
        if (mat.length % 2 != 0) {
            sum -= mat[mat.length / 2][mat.length / 2];
        }
        return sum;
    }

    public static boolean linearSearch(int[] array, int length, int element) {
        // Check for edge cases. Is the array null or empty?
        // If it is, then we return false because the element we're
        // searching for couldn't possibly be in it.
        if (array == null || length == 0) {
            return false;
        }

        // Carry out the linear search by checking each element,
        // starting from the first one.
        for (int i = 0; i < length; i++) {
            // We found the element at index i.
            // So we return true to say it exists.
            if (array[i] == element) {
                return true;
            }
        }

        // We didn't find the element in the array.
        return false;
    }

    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(2 * arr[i]) && map.get(2 * arr[i]) != i) {
                return true;
            }
        }
        return false;
    }

    public int mostWordsFound(String[] sentences) {
        int mostWords = 0;
        for (int i = 0; i < sentences.length; i++) {
            if (mostWords < calcNumWords(sentences[i])) {
                mostWords = calcNumWords(sentences[i]);
            }
        }
        return mostWords;
    }

    public int calcNumWords(String sentence) {
        int cant = 1;
        if (sentence.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                cant++;
            }
        }
        return cant;
    }

    public int[] leftRightDifference(int[] nums) {
        int[] answer = new int[nums.length];
        int[] nums1 = leftSum(nums);
        int[] nums2 = rightSum(nums);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = nums1[i] - nums2[i];
            if (answer[i] < 0) {
                answer[i] *= -1;
            }
        }
        return answer;
    }

    public int[] leftSum(int[] nums) {
        int[] answer = new int[nums.length];
        int leftSum = 0;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = leftSum + nums[i - 1];
            leftSum = answer[i];
        }
        return answer;
    }

    public int[] rightSum(int[] nums) {
        int[] answer = new int[nums.length];
        int rightSum = 0;   //{10,4,8,3} -> [15 11 3 0]
        int length = answer.length;
        length -= 2;
        for (int i = length; i >= 0; i--) {
            answer[i] = rightSum + nums[i + 1];
            rightSum = answer[i];
        }
        return answer;
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < target.length; i++) {
            arr.add(index[i], nums[i]);
        }
        for (int i = 0; i < arr.size(); i++) {
            target[i] = arr.get(i);
        }
        return target;
    }

    public void moverAlaDerecha(int[] nums, int index, int val) {
        for (int i = index; i >= index; i--) {
            nums[i + 1] = nums[i];
        }
        nums[index] = val;
    }

    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public int numIdenticalPairs(int[] nums) {
        int goodPairs = 0;
        java.util.Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    goodPairs++;
                }
            }
        }
        return goodPairs;
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] answer = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j] && i != j) {
                    count++;
                }
            }
            answer[i] = count;
            count = 0;
        }
        return answer;
    }

    public int[] numberGame(int[] nums) {
        int[] arr = new int[nums.length];
        java.util.Arrays.sort(nums);
//        Input: nums = [5,4,2,3]
//        --> java.util.Arrays.sort(nums);  -->[2 3 4 5]
//        --> Output: [3,2,5,4]
        int alice, bob;
        for (int i = 0; i < nums.length - 1; i += 2) {
            alice = nums[i];
            bob = nums[i + 1];
            arr[i] = bob;
            arr[i + 1] = alice;
        }
        return arr;
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String word1Str = String.join("", word1);
        String word2Str = String.join("", word2);
        return word1Str.compareTo(word2Str) == 0;
    }

    public String restoreString(String s, int[] indices) {
        String shuffled = "";
        String[] word = new String[indices.length];
        for (int i = 0; i < indices.length; i++) {
            word[indices[i]] = String.valueOf(s.charAt(i));
        }
        for (String c : word) {
            shuffled += c;
        }
        return shuffled;
    }

    public int differenceOfSum(int[] nums) {
        int sumElements = 0, sumDigits = 0;
        for (int i = 0; i < nums.length; i++) {
            sumElements += nums[i];
            if (nums[i] >= 10) {
                int num = nums[i];
                while (num > 0) {
                    sumDigits += num % 10;
                    num = num / 10;
                }
            } else {
                sumDigits += nums[i];
            }
        }
        return Math.abs(sumElements - sumDigits);
    }

    public int digitsSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;   //MÉTODO DE AYUDA
            num /= 10;
        }
        return sum;
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
//        Input: arr = [1,4,2,5,3]
//        Output: 58
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public int maxProductDifference(int[] nums) {
        java.util.Arrays.sort(nums);
        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
    }

    public void moverElementosALaDerecha(int[] nums) {
        System.out.println(java.util.Arrays.toString(nums));
        for (int i = 2; i >= 0; i--) {
            nums[i + 1] = nums[i];
        }
        nums[0] = 0;
        System.out.println(java.util.Arrays.toString(nums));
    }

    public void insertarEnElarreglo(int[] nums, int indice, int elemento) {
        System.out.println(java.util.Arrays.toString(nums));
        for (int i = 6; i >= indice; i--) {
            nums[i + 1] = nums[i];
        }
        nums[indice] = elemento;
        System.out.println(java.util.Arrays.toString(nums));
    }

    public void duplicateZeros(int[] arr) {
        System.out.println(java.util.Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j >= i + 1; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }
        System.out.println(java.util.Arrays.toString(arr));
    }

    public void moverElementoALaIzquierda(int[] nums, int index) {
        System.out.println(java.util.Arrays.toString(nums));
        int temp;
        temp = nums[index];
        for (int i = index + 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = temp;
        System.out.println(java.util.Arrays.toString(nums));
    }

    public boolean validMountainArray(int[] arr) {
        boolean answer = false;

        return answer;
    }

    public int findSpecialInteger(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                count--;
            }
        }
        return count;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        long answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (0 <= i && i < j && j < nums.length) {
                    if (lower <= nums[i] + nums[j] && nums[i] + nums[j] <= upper) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public int getDecimalValue(ListNode head) {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode() {}
         *     ListNode(int val) { this.val = val; }
         *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }

    public int thirdMax(int[] nums) {
        java.util.Arrays.sort(nums);
        for (int index = 0; index < nums.length / 2; ++index) {
            int temp = nums[index];
            nums[index] = nums[nums.length - 1 - index];
            nums[nums.length - 1 - index] = temp;
        }
        int count = 1;
        int thirdMax = nums[0];
        for (int index = 1; index < nums.length; ++index) {
            if (nums[index] != thirdMax) {
                count += 1;
                thirdMax = nums[index];
            }

            if (count == 3) {
                return nums[index];
            }
        }
        return nums[0];
    }

    public int heightChecker(int[] heights) {
        int answer = 0;
        int[] expected = heights.clone();
        java.util.Arrays.sort(expected);
        for (int i = 0; i < heights.length; i++) {
            if (expected[i] != heights[i]) {
                answer++;
            }
        }
        return answer;
    }

    public void moveZeroes(int[] nums) {
        int index = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            } else {
                count++;
            }
        }
        int i = 0;
        while (count > 0) {
            nums[nums.length - 1 - i] = 0;
            i++;
            count--;
        }
    }

    public int[] sortArrayByParity(int[] nums) {
        int[] answer = new int[nums.length];
        int indexRight = answer.length - 1;
        int indexLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                answer[indexLeft] = nums[i];
                indexLeft++;
            } else {
                answer[indexRight] = nums[i];
                indexRight--;
            }
        }
        return answer;
    }

    public int[] replaceElements(int[] arr) {
        int index = 0;
        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            arr[index] = hightElement(arr, i);
            index++;
            if (i == arr.length - 1) {
                arr[i] = -1;
            }
        }
        return arr;
    }

    public int hightElement(int[] nums, int index) {
        int hightElement = 0;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > hightElement) {
                hightElement = nums[i];
            }
        }
        return hightElement;
    }

    public boolean isPerfectSquare(int num) {
        int square = (int) Math.sqrt(num);
        return square * square == num;
    }

    public int commonFactors(int a, int b) {
        int factors = 0;
        int i = 1;
        int maxNumber = Math.min(a, b);
        while (i <= maxNumber) {
            if (a % i == 0 && b % i == 0) {
                factors++;
            }
            i++;
        }
        return factors;
    }

    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) leftSum += nums[i - 1];
            if (totalSum - leftSum - nums[i] == leftSum) {
                return i;
            }
        }
        return -1;
    }

    public int dominantIndex(int[] nums) {
        int index = 0;
        int largestInt = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largestInt) {
                largestInt = nums[i];
                index = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (largestInt != nums[i] && largestInt < 2 * nums[i]) {
                return -1;
            }
        }
        return index;
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int[] answer = new int[mat.length];

        return answer;
    }

    public String addBinary(String a, String b) {
        String ans = "";
        return ans;
    }

    public int binaryToDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {

        }
        return decimal;
    }

    public int strStr(String haystack, String needle) {
        int index = 0;
        if (needle.length() >= haystack.length()) return -1;
        char[] hayStackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        for (int i = 0; i < hayStackChar.length; i++) {

        }
        return index;
    }

    public String addStrings(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> answer = new ArrayList<>();
        java.util.Arrays.sort(nums);
        int min = nums[0];
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = min;
            min++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != arr[i]) {
                answer.add(nums[i] + 1);
            }
        }
        return answer;
    }

    //nums = [1,2,2,3,3,4,7,8]
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> answer = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            stringBuilder.append(words[i]);
            for (int j = 0; j < stringBuilder.length(); j++) {
                if (stringBuilder.charAt(j) == x) {
                    answer.add(i);
                    break;
                }
            }
            stringBuilder.delete(0, stringBuilder.length());
        }
        return answer;
    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] >= target) {
                ans++;
            }
        }
        return ans;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> answer = new ArrayList<>();
        int maximunCandie = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] >= maximunCandie)
                maximunCandie = candies[i];
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maximunCandie) {
                answer.add(true);
            } else {
                answer.add(false);
            }
        }
        return answer;
    }

    public int countPairs(List<Integer> nums, int target) {
        int ans = 0;
        Integer[] arr = new Integer[nums.size()];
        arr = nums.toArray(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] < target)
                    ans++;
            }
        }
        return ans;
    }

    public int[] decompressRLElist(int[] nums) {

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {

            for (int j = 0; j < nums[i]; j++) {
                arr.add(nums[i + 1]);
            }
        }

        int[] answer = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        for (int i = 0; i < items.size(); i++) {

        }
        return 0;
    }

    public boolean canBeIncreasing(int[] nums) {
        boolean answer = false;
        ArrayList<Integer> arr = new ArrayList<>();
        if (nums.length == 2) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }                                                          //[100,21,100]

        for (int i = 1; i < arr.size() - 1; i++) {
            if (arr.get(i) >= arr.get(i - 1) && arr.get(i) >= arr.get(i + 1)) {
                arr.remove(i);
            }
        }                                                       //CONTINUARÁ...
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) < arr.get(i + 1)) {
                answer = true;
            } else {
                return answer;
            }
        }
        return answer;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (hashMap.containsKey(current) && i - hashMap.get(current) <= k) {
                return true;
            } else {
                hashMap.put(current, i);
            }
        }
        return false;
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int length = Math.max(nums1.length, nums2.length);

        for (int i = 0; i < length; i++) {
            if (nums1[i] == nums2[i]) {
                return nums1[i];            //CONTINUARÁ...
            }
        }
        return -1;
    }

    public boolean hasCycle(ListNode head) {
        if (head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {

            slow = slow.next;
            fast = fast.next.next;

            if (fast == null || fast.next == null) {
                return false;
            }

        }
        return true;
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode valNode = null;
        while (slow != fast) {

            if (slow.val == fast.val) {
                valNode = slow;
                break;
            }

            if (fast == null || fast.next == null) return null;

            slow = slow.next;
            fast = fast.next.next;

        }

        return valNode;
    }

    public int maximumDifference(int[] nums) {
        int maxDifference = -1;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (i < j && nums[i] < nums[j] && nums[j] - nums[i] > maxDifference) {
                    maxDifference = nums[j] - nums[i];
                }

            }

        }

        return maxDifference;
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        java.util.Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean check(int[] nums) {
        return false;
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        int sumMax = 0;
        java.util.Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            if (nums[i] == 0) {
                k--;
            }
            nums[i] = -nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            sumMax += nums[i];
        }
        return sumMax;
    }

    public int findGCD(int[] nums) {
        int mn = 0, mx = 0;

        java.util.Arrays.sort(nums);

        mn = nums[0];                               //FALTA TERMINAR
        mx = nums[nums.length - 1];

        if (nums.length == 2 && mn == mx) return mn;

        return greatestCommunDivisor(mn, mx);
    }

    public int greatestCommunDivisor(int a, int b) {
        int greatest = 0;
        int i = 1;
        int mx = Math.max(a, b);
        while (i <= mx && a % i == 0 && b % i == 0) {
            greatest++;                                 //FALTA TERMINAR
            i++;
        }
        return greatest;
    }

    public int maximizeSum(int[] nums, int k) {
        int maxSum = 0;
        int m = 0;

        for (int i = 0; i < nums.length; i++) {
            m = Math.max(nums[i], m);
        }

        while (k > 0) {
            maxSum += m;
            m++;
            nums[nums.length - 1] = m;
            k--;
        }
        return maxSum;
    }

    public List<Integer> findPeaks(int[] mountain) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                answer.add(i);
            }
        }
        return answer;
    }

    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0;
        for (int i = 0; i < batteryPercentages.length - 1; i++) {
            if (batteryPercentages[i] > 0) {
                count++;
                for (int j = i + 1; j < batteryPercentages.length; j++) {
                    batteryPercentages[i + 1] -= 1;
                }
            } else if (batteryPercentages[i] == 0) i++;
        }
        return count;
    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {

        ArrayList<String> answer = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            stringBuilder.append(words.get(i));
            String string = stringBuilder.toString();
            String[] split = string.split(String.valueOf(separator));

        }

        return answer;
    }

    public int missingNumber(int[] nums) {
        int answer = 0;

        java.util.Arrays.sort(nums);

        int n = nums.length;

        int[] arr = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != arr[i]) {
                answer = arr[i];
                break;
            }
        }

        if (nums[n - 1] != n) return n;

        return answer;
    }

    public String firstPalindrome(String[] words) {

        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i])) {
                return words[i];
            }
        }

        return "";
    }

    public boolean isPalindrome(String word) {

        if (word == null || word.isEmpty()) {
            return false;
        }

        StringBuilder stringBuilder = new StringBuilder(word);

        if (stringBuilder.reverse().toString().compareTo(word) == 0) {
            return true;
        }

        return false;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String node1 = nodeToString(l1);

        String node2 = nodeToString(l2);

        int sum = Integer.parseInt(reverse(node1)) + Integer.parseInt(reverse(node2));

        String sumStr = reverse(Integer.toString(sum));

        ListNode answer = getNode(sumStr);

        return answer;
    }

    public ListNode getNode(String string) {
        int number = Integer.parseInt(String.valueOf(string.charAt(0)));
        ListNode nodeRoot = new ListNode(number);
        ListNode currentNode = nodeRoot;
        for (int i = 1; i < string.length(); i++) {
            number = Integer.parseInt(String.valueOf(string.charAt(i)));
            ListNode nodeNext = new ListNode(number);
            currentNode.next = nodeNext;
            currentNode = nodeNext;
        }
        return nodeRoot;
    }

    public String nodeToString(ListNode node) {
        StringBuilder stringBuilder = new StringBuilder();

        while (node.next != null) {
            stringBuilder.append(node.val);
            node = node.next;
        }

        return stringBuilder.toString();
    }

    public String reverse(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        return stringBuilder.reverse().toString();
    }

    public int prefixCount(String[] words, String pref) {

        int count = 0;

        for (int i = 0; i < words.length; i++) {
            count = countWordsWithPrefix(words[i], pref);
        }
        return count;
    }

    public int countWordsWithPrefix(String word, String prefix) {

        int count = 0;
        boolean leave = false;

        for (int i = 0; i < prefix.length(); i++) {
            if (word.charAt(i) == prefix.charAt(i)) {
                leave = true;
            }
        }

        if (leave)
            count++;

        return count;
    }

    public List<Integer> targetIndices(int[] nums, int target) {

        List<Integer> answer = new ArrayList<>();

        java.util.Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                answer.add(i);
        }

        return answer;
    }

    public int maxSum(int[] nums) {


        return 0;
    }

    public int vowelStrings(String[] words, int left, int right) {

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        int count = 0;

        if (words.length == 1) {
            for (int i = 0; i < vowels.length; i++) {
                if (words[i].charAt(0) == vowels[i]) {
                    count++;
                }
            }
        }

        for (int i = 0; i < words.length; i++) {

            if (i >= left && i <= right) {

                for (int j = 0; j < vowels.length; j++) {

                    if (words[i].charAt(0) == vowels[j] && words[i].charAt(words[i].length() - 1) == vowels[j]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public int buyChoco(int[] prices, int money) {

        java.util.Arrays.sort(prices);

        int sum = prices[0] + prices[1];

        if (sum == money) return 0;

        if (money - sum > 0)
            return money - sum;

        return money;

    }

    public int maxProduct(int[] nums) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2)
                max2 = num;
        }

        return (max1 - 1) * (max2 - 1);
    }

    public int[][] flipAndInvertImage(int[][] image) {

        for (int i = 0; i < image.length; i++) {

            int low = 0;

            int high = image.length - 1;

            while (low <= high) {
                if (image[i][low] == image[i][high]) {
                    image[i][low] = 1 - image[i][low];
                    image[i][high] = image[i][low];
                }
                low++;
                high--;
            }
        }

        return image;
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {

        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {

            for (int j = i + 1; j < arr.length - 1; j++) {

                for (int k = j + 1; k < arr.length; k++) {

                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public int arithmeticTriplets(int[] nums, int diff) {

        int count = 0;

        int lenght = nums.length;

        for (int i = 0; i < lenght - 2; i++) {
            for (int j = i + 1; j < lenght - 1; j++) {
                for (int k = j + 1; k < lenght; k++) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public int countKDifference(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (Math.abs(nums[j] - nums[i]) == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isAcronym(List<String> words, String s) {

        if (s.length() < words.size()) return false;

        StringBuilder acronym = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            acronym.append(words.get(i).charAt(0));
        }

        if (acronym.toString().compareTo(s) == 0) return true;

        return false;
    }

    public int largestAltitude(int[] gain) {

        int[] altitudes = new int[gain.length + 1];

        int highAltitude = 0;

        for (int i = 1; i < altitudes.length; i++) {
            altitudes[i] = gain[i - 1];
        }

        for (int i = 0; i < gain.length; i++) {
            altitudes[i + 1] = gain[i] + altitudes[i];
        }

        for (int i = 0; i < altitudes.length; i++) {
            highAltitude = Math.max(highAltitude, altitudes[i]);
        }

        return highAltitude;
    }

    public int sumOfSquares(int[] nums) {

        int n = nums.length;

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (n % (i + 1) == 0) {
                int square = nums[i];
                sum += square * square;
            }
        }

        return sum;
    }

    public int countPairs(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j] && (i * j) % k == 0) count++;

            }
        }

        return count;
    }

    public int maximumNumberOfStringPairs(String[] words) {

        int count = 0;

        for (int i = 0; i < words.length - 1; i++) {

            for (int j = i + 1; j < words.length; j++) {

                StringBuilder stringBuilder = new StringBuilder(words[j]);

                String strToCompare = stringBuilder.reverse().toString();

                if (words[i].compareTo(strToCompare) == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean areNumbersAscending(String s) {

        List<Integer> list = new ArrayList<>();

        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {

            try {
                int strNum = Integer.parseInt(words[i]);
                list.add(strNum);
            } catch (NumberFormatException ignored) {

            }

        }

        for (int i = 0; i < list.size() - 1; i++) {

            if (list.get(i) >= list.get(i + 1)) return false;

        }

        return true;
    }

    public int minOperations(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] >= nums[i + 1]) {
                count += nums[i] - nums[i + 1] + 1;
                nums[i + 1] = nums[i] + 1;
            }

        }

        return count;
    }

    public int[] separateDigits(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 9) {
                String num = Integer.toString(nums[i]);

                for (int j = 0; j < num.length(); j++) {
                    list.add(Integer.parseInt(String.valueOf(num.charAt(j))));
                }
            } else {
                list.add(nums[i]);
            }

        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {

            answer[i] = list.get(i);

        }

        return answer;
    }

    public int arrayPairSum(int[] nums) {
        return 0;
    }

    public String truncateSentence(String s, int k) {

        String[] words = s.split(" ");

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < k; i++) {

            stringBuilder.append(words[i]);

            stringBuilder.append(" ");

        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public int minimumSum(int num) {

        int[] digits = new int[4];

        int i = 0;
        int numAux = num;
        while (numAux > 0) {
            digits[i] = numAux % 10;
            numAux /= 10;
            i++;
        }

        java.util.Arrays.sort(digits);

        return (digits[0] * 10 + digits[3]) + (digits[1] * 10 + digits[2]);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int countOnes = 0;

        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] == 1) {
                countOnes++;
            }
        }
        /*
        Input: flowerbed = [1,0,0,0,1], n = 2
        Output: false

        [1,0,0,0,0,1]
        n = 2
        */
        int plots = flowerbed.length - countOnes;

        if (plots * 3 > n) {
            return true;
        } else {
            return false;
        }
    }

    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        int product = 1;

        for (int i = 0; i < nums.length; i++) {


        }

        return answer;
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {

        int answer = 0;

        for (int i = 0; i < nums.size(); i++) {

            if (k == Integer.bitCount(i)) {
                answer += nums.get(i);
            }
        }

        return answer;
    }

    public int[] findArray(int[] pref) {

        int[] answer = new int[pref.length];

        answer[0] = pref[0];

        for (int i = 1; i < pref.length; i++) {

            answer[i] = pref[i - 1] ^ pref[i];
        }

        return answer;
    }

    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];

        arr[0] = first;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = encoded[i - 1] ^ encoded[i];
        }

        return arr;
    }

    public int maxFrequencyElements(int[] nums) {

        // Paso 1: Crear una tabla hash para contar las frecuencias de los elementos
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Paso 2: Encontrar la frecuencia máxima
        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        // Paso 3: Sumar las frecuencias de los elementos que tienen la frecuencia máxima
        int totalFrequencies = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency == maxFrequency) {
                totalFrequencies += frequency;
            }
        }

        return totalFrequencies;
    }

    public int findDuplicate(int[] nums) {

        java.util.Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }

        return 0;
    }

    public String[] sortPeople(String[] names, int[] heights) {

        String[] answer = new String[names.length];

        HashMap<Integer, String> hashMap = new HashMap<>();

        for (int i = 0; i < names.length; i++) {

            hashMap.put(heights[i], names[i]);
        }

        // Crear un TreeMap y pasar un comparador personalizado que ordene de forma descendente por las llaves
        TreeMap<Integer, String> treeMap = new TreeMap<>(Collections.reverseOrder());
        treeMap.putAll(hashMap);

        int index = 0;
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {

            answer[index] = entry.getValue();
            index++;
        }

        return answer;
    }

    public List<Integer> findDuplicates(int[] nums) {

        ArrayList<Integer> answer = new ArrayList<>();

        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {

            if (hashtable.containsKey(nums[i])) {
                answer.add(nums[i]);
            } else {
                hashtable.put(nums[i], i);
            }
        }

        return answer;
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> answer = new ArrayList<>();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < nums1.length - 1; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] != nums2[j] && nums1[i] != nums1[i + 1]) {
                    arr.add(nums1[i]);
                }

            }
        }
        // ESTÁ MAL
        answer.add(arr);

        arr.clear();

        for (int i = 0; i < nums2.length - 1; i++) {

            for (int j = 0; j < nums1.length; j++) {

                if (nums2[i] != nums1[j] && nums1[i] != nums1[i + 1]) {
                    arr.add(nums2[i]);
                }

            }
        }

        answer.add(arr);

        return answer;
    }

    public int sumOfUnique(int[] nums) {

        int sum = 0;

        var hashmap = new HashMap<Integer, Integer>();
        //{1,2,3,2}
        for (int num : nums) {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }

        System.out.println(hashmap);

        var entrys = hashmap.entrySet();

        for (var entry : entrys) {

            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }

        return sum;
    }

    public boolean uniqueOccurrences(int[] arr) {

        var hashMap = new HashMap<Integer, Integer>();

        if (arr.length == 2 && arr[0] != arr[1]) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            hashMap.put(i, arr[i]);
        }

        var entrySet = hashMap.entrySet();

        for (var entry : entrySet) {

            if (hashMap.containsKey(entry.getValue())) return true;
        }

        return false;
    }

    public int firstMissingPositive(int[] nums) {

        var num = 1;

        var hashmap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {

            hashmap.put(nums[i], i);

        }

        for (int i = 0; i < hashmap.size(); i++) {

            if (hashmap.containsKey(num)) num++;

        }

        return num;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) return 0;

        int product = 1;

        int count = 0;

        int left = 0;

        int right = 0;

        while (right < nums.length) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            count += right - left + 1;

            right++;
        }

        return count;
    }

    public int maxSubarrayLength(int[] nums, int k) {
        return 0;
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {

        long answer = 0;

        int left = 0;

        int right = 0;

        int index = 0;

        while (right < nums.length) {

            while (index < right - 1) {
                if (nums[index] == minK && nums[index + 1] == maxK) {

                }

                index++;
            }


            right++;
        }

        return 0L;
    }

    public int search(int[] nums, int target) {
        if (java.util.Arrays.binarySearch(nums, target) >= 0)
            return java.util.Arrays.binarySearch(nums, target);
        else
            return -1;
    }

    public char nextGreatestLetter(char[] letters, char target) {

        for (int i = 0; i < letters.length; i++) {

            if (letters[i] > target) {
                return letters[i];
            }
        }

        return letters[0];
    }

    public int countNegatives(int[][] grid) {

        int countNegative = 0;

        int n = grid.length; //Nums of rows
        int m = grid[0].length; //Nums of colums

        int indexN = 0;
        int indexM = 0;

        while (indexN < n && indexM < m) {

            if (grid[indexN][indexM] < 0) {
                countNegative += (n - indexN);
                indexM++;
            } else {
                indexN++;
            }
        }
        return countNegative;
    }

    public int[] searchRange(int[] nums, int target) {

        int[] answer = new int[2];

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {
                arr.add(i);
            }
        }

        if (arr.size() == 1) {
            arr.add(arr.get(0));
        } else if (arr.isEmpty()) {
            arr.add(-1);
            arr.add(-1);
        }

        answer[0] = arr.get(0);
        answer[1] = arr.get(arr.size() - 1);

        return answer;
    }

    public int subsetXORSum(int[] nums) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            sum += nums[i] ^ nums[i + 1];
        }

        return sum;

    }

    public void subsets(int[] arr) {
    }

    public int[] singleNumber(int[] nums) {
        int[] answer = new int[2];

        if (nums.length == 2 && nums[0] != nums[1]) {
            answer[0] = nums[0];
            answer[1] = nums[1];
            return answer;
        }

        java.util.Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i += 2) {

            if (nums[i] == nums[i + 1]) i += 2;

            if ((nums[i] ^ nums[i + 1]) == 0) {
                answer[0] = nums[i];
                answer[1] = nums[i + 1];
            }
        }

        return answer;
    }

    public int scoreOfString(String s) {
        int answer = 0;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            answer += Math.abs(chars[i] - chars[i + 1]);
        }

        return answer;
    }

    public int maximumStrongPairXor(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

        }

        return 0;
    }

    public int subarraysDivByK(int[] nums, int k) {

        int sum = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length - i; j++) {

                for (int l = i; l <= i + j; l++) {
                    sum += nums[l];
                }
                if (sum % k == 0) {
                    count++;
                }
                sum = 0;
            }

        }
        return count;
    }

    public int maxSubArray(int[] nums) {

        int mSum = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum >= 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            mSum = sum > mSum ? sum : mSum;
        }

        return mSum;
    }

    public int subarraySum(int[] nums, int k) {

        return 0;
    }

    public int minMovesToSeat(int[] seats, int[] students) {

        int count = 0, n = students.length;

        java.util.Arrays.sort(seats);
        java.util.Arrays.sort(students);
        //seats = [2,2,6,6], students = [1,3,2,6]
        //sorted
        //seats = [2,2,6,6], students = [1,2,3,6]
        //seats = [2,2,6,6], students = [2,2,6,6]
        //----------------
        //seats = [3,1,5], students = [2,7,4]
        //sorted
        //seats = [1,3,5], students = [2,4,7]
        for (int i = 0; i < n; i++) {
            while (students[i] != seats[i]) {
                if (seats[i] > students[i]) {
                    students[i]++;
                    count++;
                }
                if (seats[i] < students[i]) {
                    students[i]--;
                    count++;
                }
            }
        }
        return count;
    }

    public int findKthPositive(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();

        int i = 0;

        int missingNumber = 1;

        while (i < arr.length) {
            if (missingNumber != arr[i]) {
                list.add(missingNumber);
                missingNumber++;
            }
            i++;
        }

        return list.get(k - 1);
    }

    public int minKBitFlips(int[] nums, int k) {

        int currentFlips = 0;
        int totalFlips = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (i >= k && nums[i - k] == 2) {
                currentFlips--;
            }

            if ((currentFlips % 2) == nums[i]) {
                if (i + k > nums.length) {
                    return -1;
                }
                nums[i] = 2;
                currentFlips++;
                totalFlips++;
            }
        }
        return totalFlips;
    }

    public boolean threeConsecutiveOdds(int[] arr) {

        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 2] % 2 != 0 && arr[i - 1] % 2 != 0 && arr[i] % 2 != 0) {
                return true;
            }
        }

        return false;
    }

    public int minDifference(int[] nums) {

        java.util.Arrays.sort(nums);

        if (nums.length == 3) {
            return 0;
        }
        System.out.println(java.util.Arrays.toString(nums));
        int count = 0;
        int min1 = java.util.Arrays.stream(nums).min().getAsInt();

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != min1) {
                nums[i] = min1;
                count++;
            }
            if (count == 3) break;
        }
        System.out.println(java.util.Arrays.toString(nums));
        return Math.abs(min1 - nums[1]);
    }

    public int addedInteger(int[] nums1, int[] nums2) {

        int sum1 = java.util.Arrays.stream(nums1).sum();
        int sum2 = java.util.Arrays.stream(nums2).sum();

        return (sum2 - sum1) / nums1.length;
    }

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {

        int[] answer = new int[2];

        int left = 0;

        int right = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }



        return answer;
    }

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] % (nums2[j] * k) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public double minimumAverage(int[] nums) {

        double[] averages = new double[nums.length / 2];

        java.util.Arrays.sort(nums);

        int n = nums.length / 2;

        for (int i = 0; i < n; i++) {
            int minElement = nums[i];
            int maxElement = nums[n - 1 - i];

            double average = (minElement + maxElement) / 2.0;

            averages[i] = Double.parseDouble(String.format("%.1f", average));
        }

        double minAverage = Double.MAX_VALUE;

        for(double num : averages){
            minAverage = Math.min(minAverage, num);
        }

        return minAverage;
    }


}