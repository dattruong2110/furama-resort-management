package models.utils;

import models.entity.customer.Customer;
import models.entity.employee.Employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyReadFile {
    private List<String> myReadFile(String path) {
        List<String> strings = new ArrayList<>();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
            return strings;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return strings;
    }

    public List<Employee> readFileEmployee(String path) {
        List<Employee> employeeList = new ArrayList<>();
        List<String> strings = myReadFile(path);
        for (String string : strings) {
            String[] array = string.split(",");
            if (array.length == 11) {
                employeeList.add(new Employee(
                        Long.parseLong(array[0]),
                        array[1],
                        array[2],
                        array[3],
                        array[4],
                        array[5],
                        array[6],
                        array[7],
                        array[8],
                        array[9],
                        Double.parseDouble(array[10])
                ));
            } else {
                System.out.println(string);
            }
        }

        return employeeList;
    }

    public List<Customer> readFileCustomer(String path) {
        List<Customer> customerList = new ArrayList<>();
        List<String> strings = myReadFile(path);
        for (String string : strings) {
            String[] array = string.split(",");
            if (array.length == 10) {
                customerList.add(new Customer(
                        Long.parseLong(array[0]),
                        array[1],
                        array[2],
                        array[3],
                        array[4],
                        array[5],
                        array[6],
                        array[7],
                        array[8],
                        array[9]
                ));
            } else {
                System.out.println(string);
            }
        }

        return customerList;
    }
}
