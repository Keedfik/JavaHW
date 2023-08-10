package ru.gb.hwmap;


import java.util.*;

public class Task2 {
    public static void main(String[] args) {
    List<String> fullNames = new ArrayList<>();
    fullNames.add("Иван Иванов");
    fullNames.add("Светлана Петрова");
    fullNames.add("Кристина Белова");
    fullNames.add("Анна Мусина");
    fullNames.add("Анна Крутова");
    fullNames.add("Иван Юрин");
    fullNames.add("Петр Лыков");
    fullNames.add("Павел Чернов");
    fullNames.add("Петр Чернышов");
    fullNames.add("Мария Федорова");
    fullNames.add("Марина Светлова");
    fullNames.add("Мария Савина");
    fullNames.add("Мария Рыкова");
    fullNames.add("Марина Лугова");
    fullNames.add("Анна Владимирова");
    fullNames.add("Иван Мечников");
    fullNames.add("Петр Петин");
    fullNames.add("Иван Ежов");

    List<String> result = findRepetitiveNames(fullNames);
    System.out.println("sorted names = " + result);
}

    /**
     * @param fullNames list of names and surnames
     * @return list of sorted names by repetitive
     * @apiNote Print names with appearances and returns list of names sorted by appearances.
     */
    public static List<String> findRepetitiveNames(List<String> fullNames) {
        Map<String, Integer> counter = new HashMap<>();

        for (String fullName : fullNames) {
            String name = fullName.split(" ")[0];

            Integer currentCount = counter.getOrDefault(name, 0);
            counter.put(name, currentCount + 1);
        }

        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " => " + entry.getValue());
            }
        }

        return counter.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(Map.Entry::getKey).toList();
    }
}