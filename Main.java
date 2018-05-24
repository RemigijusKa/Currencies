
import org.w3c.dom.Document;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static final String TYPE_EU = "EU";

    public static void main(String[] args) throws Exception {
        System.out.println("Please enter currency code: ");
        String currencyCode = scanner.next().toUpperCase();
        System.out.println("Please enter period Start Date: (Example 2018-01-01) ");
        String dateFrom = scanner.next();
        System.out.println("Please enter period End Date: (Example 2018-05-01), if needed only one day rate - repeat date. ");
        String dateTo = scanner.next();
        scanner.close();

        Document xmlData= new RequestService().sendRequest(TYPE_EU, currencyCode, dateFrom, dateTo);
        new Parser().xmlParser(xmlData);
        double changeRate = new Parser().currencyChangeRate(xmlData);
        System.out.println("\nCurrency change rate is: " + new DecimalFormat("#.##").format(changeRate) +"%");
    }

}
