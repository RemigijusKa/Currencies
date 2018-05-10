package EisGroup;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlHandler extends DefaultHandler {

    boolean bType = false;
    boolean bDate = false;
    boolean bCurrencyCode = false;
    boolean bAmount = false;

    @Override

    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("Tp")) {
            bType = true;
        } else if (qName.equalsIgnoreCase("Dt")) {
            bDate = true;
        } else if (qName.equalsIgnoreCase("Ccy")) {
            bCurrencyCode = true;
        } else if (qName.equalsIgnoreCase("Amt")) {
            bAmount = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("FxRate")) {
            System.out.println("---------");
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bType) {
            System.out.println("Type: " + new String(ch, start, length));
            bType = false;
        } else if (bDate) {
            System.out.println("Date: " + new String(ch, start, length));
            bDate = false;
        } else if (bCurrencyCode) {
            System.out.println("Currency Code: " + new String(ch, start, length));
            bCurrencyCode = false;
        } else if (bAmount) {
            System.out.println("Amount: " + new String(ch, start, length));
            bAmount = false;
        }
    }
}
