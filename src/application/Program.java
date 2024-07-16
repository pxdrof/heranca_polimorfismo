package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException{

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List <Product> product = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int icont;

        System.out.print(" Enter the number of products: ");
        int number = sc.nextInt();

        for(icont = 1; icont <= number; icont++){
            System.out.println("Product #" + icont + " data");
            System.out.print("Common, used or imported (c/u/i)? ");
            char choose = sc.next().charAt(0);
            sc.nextLine(); // line break
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            sc.nextLine(); // line break

            if (choose == 'i'){
                System.out.print("Customs fee: ");
                Double custumosFee = sc.nextDouble();
                product.add( new ImportedProduct(name, price, custumosFee) );
            } else if (choose == 'u'){
                System.out.print("Manufacturedate (DD/MM/YYYY): ");
                Date manuFactureDate = sdf.parse(sc.nextLine());
                product.add( new UsedProduct(name, price, manuFactureDate) );
            } else {
                product.add(new Product(name, price));
            }
        }

        System.out.print("\nPRICE TAGS:");
        for (Product pdt : product){
            System.out.print(pdt.priceTag());
        }

        sc.close();
    }
}
