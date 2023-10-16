package items;

import java.util.ArrayList;
import java.util.List;

public class Item {
	
	
	private static final double TSHIRT_PRICE = 50.0;
    private static final double JEANS_PRICE = 80.0;
    private static final double JACKET_PRICE = 100.0;
    private static final double BUDGET = 600.0;
    private static final double MIN_PRICE = 50.0;

    public static void main(String[] args) {
        List<List<Integer>> combinations = new ArrayList<>();
        findCombinations(combinations, new ArrayList<>(), 1, BUDGET);
        System.out.println(combinations);
    }

    private static void findCombinations(List<List<Integer>> combinations, List<Integer> currentCombination, int currentItem, double remainingBudget) {
        if (remainingBudget < MIN_PRICE) {
            return;
        }

        if (currentCombination.size() == 3) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = currentItem; i < 3; i++) {
            double itemPrice = getItemPrice(i);
            if (remainingBudget >= itemPrice) {
                currentCombination.add(i);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }

    private static double getItemPrice(int item) {
        switch (item) {
            case 0: return TSHIRT_PRICE;
            case 1: return JEANS_PRICE;
            case 2: return JACKET_PRICE;
            default: return 0;
        }
    }

}

