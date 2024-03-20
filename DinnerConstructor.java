package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DinnerConstructor {

    private Map<String, List<String>> dishes;

    public DinnerConstructor() {
        dishes = new HashMap<>();
    }

    public void addDish(String type, String name) {
        dishes.putIfAbsent(type, new ArrayList<>());
        dishes.get(type).add(name);
    }

    public List<String> generateCombination(List<String> types, int numberOfCombos) {
        List<String> combinations = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfCombos; i++) {
            StringBuilder combo = new StringBuilder();
            for (String type : types) {
                if (!dishes.containsKey(type) || dishes.get(type).isEmpty()) {
                    return null; // Проверка на существующий тип блюда
                }
                List<String> typeDishes = dishes.get(type);
                int randomIndex = random.nextInt(typeDishes.size());
                combo.append(typeDishes.get(randomIndex)).append(", ");
            }
            combinations.add(combo.substring(0, combo.length() - 2)); // Убираем лишнюю запятую
        }

        return combinations;
    }
}
