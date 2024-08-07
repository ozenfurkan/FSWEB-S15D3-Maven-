package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Ali", "Veli"));
        employees.add(new Employee(2, "Mehmet", "Veli"));
        employees.add(new Employee(1, "Ali", "Veli"));
        employees.add(new Employee(3, "Hıdır", "Veli"));
        employees.add(new Employee(3, "Hıdır", "Veli"));
        employees.add(new Employee(4, "Tanzimat", "Veli"));

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Duplicates: " + duplicates);

        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println("Uniques: " + uniques.values());

        List<Employee> withoutDuplicates = removeDuplicates(employees);
        System.out.println("Without Duplicates: " + withoutDuplicates);
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> set = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();
        for (Employee employee : list) {
            if (employee != null && !set.add(employee)) {
                duplicates.add(employee);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniqueEmployees = new HashMap<>();
        Set<Employee> set = new HashSet<>();
        for (Employee employee : list) {
            if (employee != null && !set.add(employee)) {
                uniqueEmployees.put(employee.getId(), employee);
            }
        }
        return uniqueEmployees;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Employee employee : list) {
            if (employee != null) {
                Integer count = countMap.get(employee.getId());
                if (count == null) {
                    countMap.put(employee.getId(), 1);
                } else {
                    countMap.put(employee.getId(), count + 1);
                }
            }
        }

        List<Employee> result = new LinkedList<>();
        for (Employee employee : list) {
            if (employee != null && countMap.get(employee.getId()) == 1) {
                result.add(employee);
            }
        }
        return result;
    }
}
