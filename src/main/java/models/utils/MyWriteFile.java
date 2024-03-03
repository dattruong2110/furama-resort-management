package models.utils;

import models.entity.customer.Customer;
import models.entity.employee.Employee;

import java.io.*;
import java.util.List;

public class MyWriteFile {
    private void myWriteFile(String path, String data) {
        File file = new File(path);
        try {
            Writer writeFile = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writeFile);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeEmployeeFile(String path, List<Employee> employeeList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Employee employee : employeeList) {
            stringBuffer.append(employee.getInfo());
        }
        myWriteFile(path, String.valueOf(stringBuffer));
    }

    public void writeCustomerFile(String path, List<Customer> customerList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Customer customer : customerList) {
            stringBuffer.append(customer.getInfo());
        }
        myWriteFile(path, String.valueOf(stringBuffer));
    }
}
