import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if (ch == 'c') {
                Product product = new Product(name, price);
                list.add(product);
            }
            else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(sc.next()); //Para pedir a data tem que ser dessa forma;
                UsedProduct usedProduct = new UsedProduct(name, price, manufactureDate);
                list.add(usedProduct);
            }
            else {
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                ImportedProduct importedProduct = new ImportedProduct(name, price, customsFee);
                list.add(importedProduct);
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS: ");
        //Percorrendo a lista
        for(Product prod : list) {
            System.out.println(prod.priceTag());
        }


        sc.close();
    }
}
