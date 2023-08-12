package ru.gb.hwlaptop;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        List<Laptop> laptops = Laptop.createLaptops(20);
        Laptop.printLaptops(laptops);

        Map<Integer, String> filters = Laptop.askFilter();
        List<Laptop> filterLaptops = Laptop.filter(laptops, filters);

        int sortByField = Laptop.askSort();
        List<Laptop> result = Laptop.sort(filterLaptops, sortByField);

        Laptop.printLaptops(result);
    }
}

