import java.util.*;
public class FruitsBasket {

    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int start = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        for (int end = 0; end < fruits.length; end++) {
            basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) + 1);

            while (basket.size() > 2) {
                int fruitToRemove = fruits[start];
                basket.put(fruitToRemove, basket.get(fruitToRemove) - 1);
                if (basket.get(fruitToRemove) == 0) {
                    basket.remove(fruitToRemove);
                }
                start++;
            }

            maxFruits = Math.max(maxFruits, end - start + 1);
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        FruitsBasket obj = new FruitsBasket();
        int[] fruits = {1, 2, 1};
        System.out.println(obj.totalFruit(fruits)); // Output: 3
    }

}
