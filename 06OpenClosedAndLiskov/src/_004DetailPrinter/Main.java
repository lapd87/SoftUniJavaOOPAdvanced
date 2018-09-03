package _004DetailPrinter;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 29.7.2018 г.
 * Time: 15:53 ч.
 */
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Pesho");
        Employee manager = new Manager("Stamat",
                Arrays.asList("doc1", "doc2"));

        DetailsPrinter detailsPrinter = new DetailsPrinter(Arrays
                .asList(employee, manager));

        detailsPrinter.printDetails();
    }
}