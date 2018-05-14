package EisGroup;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class RequestService {
    private final String USER_AGENT = "Mozilla/5.0";
    private final String SERVER = "http://old.lb.lt/webservices/fxrates/FxRates.asmx/getFxRatesForCurrency?";

    public void sendGet(String type, String currencyCode, String dateFrom, String dateTo) throws Exception {
        //                http://old.lb.lt/webservices/fxrates/FxRates.asmx/getFxRatesForCurrency?tp=EU&ccy=CNY&dtFrom=2018-05-01&dtTo=2018-05-08
        String url = SERVER + "tp=" + type + "&ccy=" + currencyCode + "&dtFrom=" + dateFrom + "&dtTo=" + dateTo;
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XmlHandler xmlHandler = new XmlHandler();
            saxParser.parse(url, xmlHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
