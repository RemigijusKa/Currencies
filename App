package EisGroup;

import java.util.Scanner;


public class App 
{
    static Scanner scanner = new Scanner(System.in);
    public static final String TYPE_EU ="EU";

    public static void main( String[] args ) {
        System.out.println("Please enter currency code: ");
        String currencyCode = scanner.next();
        System.out.println("Please enter period Start Date: (Example 2018-01-01 ");
        String dateFrom = scanner.next();
        System.out.println("Please enter period End Date: (Example 2018-05-01 ");
        String dateTo = scanner.next();
        scanner.close();

        RequestService requestService = new RequestService();
        try {
            requestService.sendGet(TYPE_EU, currencyCode, dateFrom, dateTo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

