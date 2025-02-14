package leetcode.disign;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {

    private List<Integer> products;
    private int lastZeroIndex;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1);
        lastZeroIndex = -1;
    }

    public void add(int num) {

        if (num == 0) {
            products = new ArrayList<>();
            products.add(1);
            lastZeroIndex = products.size() - 1;
        } else {
            int lastProduct = products.get(products.size() - 1);
            products.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {
        int n = products.size();
        if (lastZeroIndex >= n - k) return 0; // Si un 0 está en los últimos k elementos, el producto es 0
        return products.get(n - 1) / products.get(n - 1 - k);
    }

    /**
     * Your ProductOfNumbers object will be instantiated and called as such:
     * ProductOfNumbers obj = new ProductOfNumbers();
     * obj.add(num);
     * int param_2 = obj.getProduct(k);
     */

}
