import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class RequestService {

    private final String SERVER = "http://old.lb.lt/webservices/fxrates/FxRates.asmx/getFxRatesForCurrency?";

    public Document sendRequest(String type, String currencyCode, String dateFrom, String dateTo) throws Exception {

        String url = SERVER + "tp=" + type + "&ccy=" + currencyCode + "&dtFrom=" + dateFrom + "&dtTo=" + dateTo;
        URLConnection con = new URL(url).openConnection();
        con.addRequestProperty("Accept", "application/xml");
        InputStream is = con.getInputStream();
        return createDocument(is);
    }

    public static Document createDocument(InputStream is) {
        DocumentBuilderFactory domFactory;
        DocumentBuilder builder;

        try {
            domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setValidating(false);
            domFactory.setNamespaceAware(false);
            builder = domFactory.newDocumentBuilder();
            return builder.parse(is);
        } catch (Exception ex) {
            System.out.println("unable to load XML: " + ex);
        }
        return null;
    }

}
