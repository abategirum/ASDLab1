package edu.miu.cs.cs489appsd.lab1a.productmgmtappp;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product[] fruits = {
                new Product(2927458265L, "Apple", LocalDate.parse("2022-12-09"), 18, 1.09),
                new Product(3128874119L,"Banana", LocalDate.parse("2023-01-24"), 124, 0.55),
                new Product(9189927460L,"Carrot", LocalDate.parse("2023-03-31"), 124, 0.55),

        };

        printProducts(fruits);



    }

    public static void printProducts(Product[] products){
        Arrays.sort(products, Comparator.comparing(Product::getName));

        System.out.println("Print in Json Format");
        System.out.println("[");
        Arrays.stream(products).forEach(product -> {
            System.out.println("{");
            System.out.println("\"productId\": " + product.getProductId() + "," + "\"name\": " + product.getName() + "," + "\"dateSupplied\": " + product.getDateSupplied() + ","+ "\"quantityInStock\": " + product.getQuantityInStock() + ","+ "\"unitPrice\": " + product.getUnitPrice() + "},");
        });
        System.out.println("]");

        System.out.println("----------------------------------------------------------");
        System.out.println("Print in XML Format");
        System.out.println("<products>");
        Arrays.stream(products).forEach(product -> {

            System.out.println("<product productId\"" + product.getProductId() + "\" name=\"" + product.getName() + "\" dateSupplied=\""
            + product.getDateSupplied() + "\" quantityInStock=\"" + product.getQuantityInStock() + "\" unitPrice=\"" +
                    product.getUnitPrice() + "\"/>");

        });
        System.out.println("</products>");
        System.out.println("----------------------------------------------------------");
        System.out.println("Print in CSV Format");
        Arrays.stream(products).forEach(product -> {
            System.out.println(product.getProductId() +  ", " + product.getName() + "," +
                    product.getDateSupplied() + ", " + product.getQuantityInStock() + ", " + product.getUnitPrice());
        });
    }















}
