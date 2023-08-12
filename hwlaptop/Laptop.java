package ru.gb.hwlaptop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.*;

@Data
@AllArgsConstructor
@ToString
public class Laptop {
    private Integer ram;
    private Integer cpu;
    private Integer memory;
    private String os;
    private String color;

    /**
     * @param n number of generated laptops
     * @return list of laptops
     * @apiNote Generate list of laptops.
     */
    public static List<Laptop> createLaptops(int n) {
        List<Laptop> laptops = new ArrayList<>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            laptops.add(new Laptop(random.nextInt(2, 32),
                    random.nextInt(2, 32),
                    random.nextInt(2, 32),
                    "os-" + random.nextInt(10),
                    "color-" + random.nextInt(20)
            ));
        }

        return laptops;
    }

    /**
     * @return map of filters, key is a number of field, and value is a filter value
     * @apiNote Ask from user filters.
     */
    public static Map<Integer, String> askFilter() {
        Map<Integer, String> filters = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of criteria:");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("""
                    Enter the number corresponding to the required criterion for filtering:
                    1 - RAM
                    2 - CPU
                    3 - Memory
                    4 - Operating system
                    5 - Color""");

            int filterByField = sc.nextInt();
            sc.nextLine();
            String filterByValue = sc.nextLine();

            filters.put(filterByField, filterByValue);
        }

        return filters;
    }

    /**
     * @param laptops list of laptops
     * @param filters map of filters, key is a number of filed, value is a value search by
     * @return list of laptops
     * @apiNote Filters laptops my filters.
     */
    public static List<Laptop> filter(List<Laptop> laptops, Map<Integer, String> filters) {
        List<Laptop> result = new ArrayList<>();

        for (Laptop laptop : laptops) {
            boolean addField = true;
            for (Map.Entry<Integer, String> entry : filters.entrySet()) {
                if (!((entry.getKey() == 1 && laptop.getRam().toString().contains(entry.getValue())) ||
                        (entry.getKey() == 2 && laptop.getCpu().toString().contains(entry.getValue())) ||
                        (entry.getKey() == 3 && laptop.getMemory().toString().contains(entry.getValue())) ||
                        (entry.getKey() == 4 && laptop.getOs().contains(entry.getValue())) ||
                        (entry.getKey() == 5 && laptop.getColor().contains(entry.getValue())))
                ) {
                    addField = false;
                    break;
                }
            }

            if (addField) result.add(laptop);
        }

        return result;
    }


    /**
     * @return string sort by
     * @apiNote Ask from user sorting field.
     */
    public static int askSort() {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                Enter the number corresponding to the required criterion for sorting:
                1 - RAM
                2 - CPU
                3 - Memory
                4 - Operating system
                5 - Color""");

        int sortByField = sc.nextInt();

        return sortByField;
    }

    /**
     * @param laptops list of laptops
     * @param sortBy sort by this field
     * @return list of sorted laptops
     * @apiNote Sort laptops by field.
     */
    public static List<Laptop> sort(List<Laptop> laptops, int sortBy) {
        laptops.sort(Comparator.comparing((laptop) -> switch (sortBy) {
            case 1 -> laptop.getRam().toString();
            case 2 -> laptop.getCpu().toString();
            case 3 -> laptop.getMemory().toString();
            case 4 -> laptop.getOs();
            case 5 -> laptop.getColor();
            default -> null;
        }));

        return laptops;
    }

    /**
     * @param laptops list of laptops
     * @apiNote Prints on display list of laptops.
     */
    public static void printLaptops(List<Laptop> laptops) {
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
    }
}