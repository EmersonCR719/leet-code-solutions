package leetcode.string;

import java.util.*;

public class Strings {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public int numJewelsInStones(String jewels, String stones) {

        int count = 0;

        for (int i = 0; i < stones.length(); i++) {

            for (int j = 0; j < jewels.length(); j++) {

                if (stones.charAt(i) == jewels.charAt(j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public String interpret(String command) {

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {

            if (command.charAt(i) == 'G') {
                answer.append("G");
            }

            if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                answer.append("o");
            }

            if (command.charAt(i) == '(' && command.charAt(i + 1) == 'a' && command.charAt(i + 2) == 'l' &&
                    command.charAt(i + 3) == ')') {
                answer.append("al");
            }

        }

        return answer.toString();
    }

    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public boolean checkIfPangram(String sentence) {

        char c = 'a';

        for (int i = 0; i < 26; i++) {

            if (sentence.contains(String.valueOf(c)))
                c++;
            else
                return false;
        }

        return true;
    }

    public String reversePrefix(String word, char ch) {

        int index = -1;

        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) == ch) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return word;
        }

        StringBuilder stringBuilder = new StringBuilder(word.substring(0, index + 1));

        return stringBuilder.reverse().append(word.substring(index + 1)).toString();
    }

    public String sortSentence(String s) {

        String[] words = s.split(" ");

        String[] arr = new String[words.length];

        for (int i = 0; i < words.length; i++) {

            int index = Integer.parseInt(String.valueOf(words[i].charAt(words[i].length() - 1))) - 1;
            arr[index] = words[i];

        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public int balancedStringSplit(String s) {

        int count = 0;

        int ret = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'L') {
                ret++;
            } else {
                ret--;
            }

            if (ret == 0) {
                count++;
            }
        }

        return count;
    }

    public String mergeAlternately(String word1, String word2) {

        StringBuilder merged = new StringBuilder();

        char[] chars1 = word1.toCharArray();

        char[] chars2 = word2.toCharArray();

        int i = 0;

        int length = Math.min(word1.length(), word2.length());

        while (i < length) {

            merged.append(chars1[i]);

            merged.append(chars2[i]);

            i++;
        }

        if (chars1.length < chars2.length) {
            merged.append(word2.substring(i));
        } else {
            merged.append(word1.substring(i));
        }

        return merged.toString();
    }

    public String reverseVowels(String s) {

        StringBuilder stringBuilder = new StringBuilder();

        String str = s.toLowerCase();

        char[] word = s.toCharArray();

        for (int i = 0; i < str.length(); i++) {

            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                    || s.charAt(i) == 'u') {
                stringBuilder.append(s.charAt(i));
            }
        }

        stringBuilder.reverse();

        StringBuilder answer = new StringBuilder();

        int index = 0;

        for (int i = 0; i < word.length; i++) {

            if (word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u') {
                word[i] = stringBuilder.charAt(index);
                index++;
            }                               // FALTA TERMINAR
        }

        for (int i = 0; i < word.length; i++) {

            answer.append(word[i]);
        }


        return answer.toString();
    }

    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (!map.containsKey(s.charAt(i))) {

                if (map.containsValue(t.charAt(i))) {
                    return false;
                } else {
                    map.put(s.charAt(i), t.charAt(i));
                }
            } else {

                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public int maxDepth(String s) {

        int maxParentheses = 0;

        int countParentheses = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                countParentheses++;
            }

            if (s.charAt(i) == ')') {
                maxParentheses = Math.max(countParentheses, maxParentheses);
                countParentheses--;
            }
        }

        return maxParentheses;
    }

    public String makeGood(String s) {

        if (s.isEmpty() || s.length() == 1) return s;

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (stringBuilder.length() > 0 && Math.abs(stringBuilder.charAt(stringBuilder.length() - 1) - c) == 32) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

    public String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder();

        int openParentheses = 0;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '(') {
                openParentheses++;
            } else if (chars[i] == ')') {
                if (openParentheses == 0) {
                    chars[i] = '*';
                } else {
                    openParentheses--;
                }
            }
        }

        for (int i = chars.length - 1; i >= 0 && openParentheses > 0; i--) {

            if (chars[i] == '(') {
                chars[i] = '*';
            }
        }

        for (char c : chars) {
            if (c != '*') {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public boolean checkValidString(String s) {

        char[] chars = s.toCharArray();

        int leftMin = 0;
        int leftMax = 0;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '(') {
                leftMin++;
                leftMax++;
            } else if (chars[i] == ')') {
                leftMin--;
                leftMax--;
            } else if (chars[i] == '*') {
                leftMin--;
                leftMax++;
            }

            if (leftMax < 0) return false;

            if (leftMin < 0) leftMin = 0;
        }

        return leftMin == 0;
    }

    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> studentQueue = new PriorityQueue<>();

        Stack<Integer> sandwichStack = new Stack<>();

        for (int i = 0; i < students.length; i++) {
            studentQueue.offer(students[i]);
            sandwichStack.push(sandwiches[sandwiches.length - 1 - i]);
        }

        int i = 0;

        while (!studentQueue.isEmpty() && i < sandwichStack.size()) {

            if (studentQueue.peek() == sandwichStack.peek()) {
                sandwichStack.pop();
                studentQueue.poll();
                i = 0;
            } else {
                studentQueue.offer(studentQueue.poll());
                i++;
            }
        }

        return sandwichStack.size();
    }

    public int timeRequiredToBuy(int[] tickets, int k) {

        int time = 0, i = 0, n = tickets.length;

        while (tickets[k] > 0) {
            if (tickets[i] != 0) tickets[i]--;
            time++;
            i++;
            if (i == n) i = 0;
        }

        return time;
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        int[] answer = new int[2];
        return answer;
    }

    public void reverseString(char[] s) {
        int low = 0;
        int hight = s.length - 1;
        int iterator = 0;
        //s = ["h","e","l","l","o"]
        while (iterator <= hight) {
            char swap = s[iterator];
            s[low] = s[hight];
            s[hight] = swap;
            low++;
            hight--;
            iterator++;
        }
    }

    public int findPermutationDifference(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        int asnwer = 0;

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        for (int i = 0; i < t.length(); i++) {
            asnwer += Math.abs(i - map.get(t.charAt(i)));
        }

        return asnwer;
    }

    public String reverseWords(String s) {

        String[] words = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();

        int i = words.length - 1;

        while (i > 0) {
            if (!words[i].equals(" ")) {
                sb.append(words[i].trim()).append(" ");
            }
            i--;
        }

        return sb.append(words[0]).toString();
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";

        String base = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(base) != 0) {
                base = base.substring(0, base.length() - 1);
            }
        }

        return base;
    }

    public boolean isPalindrome(String s) {

        if (s.isEmpty()) return true;

        String sLowerCase = s.toLowerCase();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sLowerCase.length(); i++) {
            if ((sLowerCase.charAt(i) >= 97 && sLowerCase.charAt(i) <= 122) ||
                    (sLowerCase.charAt(i) >= 48 && sLowerCase.charAt(i) <= 57)) {
                sb.append(sLowerCase.charAt(i));
            }
        }

        int i = 0, j = sb.length() - 1;
        while (i < j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public boolean isSubsequence(String s, String t) {

        int i = 0, j = 0;

        while (i < s.length() || j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == s.length();
    }

    public int appendCharacters(String s, String t) {
        int i = 0, j = 0, n = s.length(), m = t.length();
        while (i < n && j < m) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return m - j;
    }

    public boolean wordPattern(String pattern, String s) {

        Map<Character, String> map = new HashMap<>();
        
        String[] words = s.split("\\s+");

        if (words.length != pattern.length()) return false;

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), words[i]);
            }
        }

        return true;
    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for(int count : counts){
            if (count != 0) return false;
        }

        return true;
    }

    public String kthDistinct(String[] arr, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(String str : arr){
            if (map.get(str) == 1){
                k--;
            }

            if (k == 0){
                return str;
            }
        }

        return "";
    }

    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        int left = 0, count = 0;
        Map<Character, Integer> vowelCount = new HashMap<>();
        int consonants = 0;

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);

            // Contar vocales únicas en la ventana
            if (vowels.contains(c)) {
                vowelCount.put(c, vowelCount.getOrDefault(c, 0) + 1);
            } else {
                consonants++;
            }

            // Reducir la ventana si excede k consonantes
            while (consonants > k) {
                char leftChar = word.charAt(left);
                if (vowels.contains(leftChar)) {
                    vowelCount.put(leftChar, vowelCount.get(leftChar) - 1);
                    if (vowelCount.get(leftChar) == 0) {
                        vowelCount.remove(leftChar);
                    }
                } else {
                    consonants--;
                }
                left++;
            }

            // Si la ventana es válida (tiene todas las vocales y k consonantes)
            if (vowelCount.size() == 5 && consonants == k) {
                count += left + 1;
            }
        }

        return count;
    }

    public int maxVowels(String s, int k) {

        int currentVowels = 0, n = s.length(), maxVowels;

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                currentVowels++;
            }
        }

        maxVowels = currentVowels;

        for (int i = k; i < n; i++) {
            if (vowels.contains(s.charAt(i))) {
                currentVowels++;
            }
            if (vowels.contains(s.charAt(i - k))) {
                currentVowels--;
            }
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }

}
