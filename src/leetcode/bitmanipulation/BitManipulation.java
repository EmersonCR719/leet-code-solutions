package leetcode.bitmanipulation;

public class BitManipulation {

    public int[] countBits(int n) {
        /*
        int[] ans = new int[n + 1];
        int m = ans.length;

        for (int i = m - 1 ; i > 0; i--) {
            int count = 0;
            String binaryNum = Integer.toBinaryString(i);
            for (int j = 0; j < binaryNum.length(); j++) {
                if (binaryNum.charAt(j) == '1') {
                    count++;
                }
            }
            ans[i] = count;
        }

        return ans;
         */
        int[] ans = new int[n + 1];

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    public int minFlips(int a, int b, int c) {

        int flips = 0;

        while (a > 0 || b > 0 || c > 0) {

            int bitA = a & 1;  // Extraer el bit menos significativo de a
            int bitB = b & 1;  // Extraer el bit menos significativo de b
            int bitC = c & 1;  // Extraer el bit menos significativo de c

            // Caso 1: Si (bitA | bitB) ya es igual a bitC, no hacemos nada
            if ((bitA | bitB) != bitC) {
                if (bitC == 0) {
                    // Si c tiene un 0, pero (a | b) es 1, hay que cambiar ambos si están en 1
                    flips += (bitA + bitB);
                } else {
                    // Si c tiene un 1, pero (a | b) es 0, hay que cambiar un bit a 1
                    flips += 1;
                }
            }
            // Desplazar a, b y c a la derecha para revisar el siguiente bit
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }

    public int hammingWeight(int n) {

        int count = 0;

        while (n != 0) {
            n &= n - 1;
            count++;
        }

        return count;
    }

    public boolean isPowerOfTwo(int n) {
        /*
        if (n <= 0) return false;

        int count = 0;

        while (n != 0) {
            n &= n - 1;
            count++;
            if (count > 1) return false;
        }

        return true;
        */
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfFour(int n) {
        // 0x5 = 0101 (en binario)
        // 0x55555555 = 0101 0101 0101 0101 0101 0101 0101 0101 (en binario)
        // 0x55555555 = 1431655765 (en decimal)
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
