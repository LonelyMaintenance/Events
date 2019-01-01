
package gc;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "GiftCardWebService", targetNamespace = "http://gc/", wsdlLocation = "http://localhost:8080/GiftCardWebService/GiftCardWebService?WSDL")
public class GiftCardWebService_Service
    extends Service
{

    private final static URL GIFTCARDWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException GIFTCARDWEBSERVICE_EXCEPTION;
    private final static QName GIFTCARDWEBSERVICE_QNAME = new QName("http://gc/", "GiftCardWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/GiftCardWebService/GiftCardWebService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GIFTCARDWEBSERVICE_WSDL_LOCATION = url;
        GIFTCARDWEBSERVICE_EXCEPTION = e;
    }

    public GiftCardWebService_Service() {
        super(__getWsdlLocation(), GIFTCARDWEBSERVICE_QNAME);
    }

    public GiftCardWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), GIFTCARDWEBSERVICE_QNAME, features);
    }

    public GiftCardWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, GIFTCARDWEBSERVICE_QNAME);
    }

    public GiftCardWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GIFTCARDWEBSERVICE_QNAME, features);
    }

    public GiftCardWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GiftCardWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GiftCardWebService
     */
    @WebEndpoint(name = "GiftCardWebServicePort")
    public GiftCardWebService getGiftCardWebServicePort() {
        return super.getPort(new QName("http://gc/", "GiftCardWebServicePort"), GiftCardWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GiftCardWebService
     */
    @WebEndpoint(name = "GiftCardWebServicePort")
    public GiftCardWebService getGiftCardWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://gc/", "GiftCardWebServicePort"), GiftCardWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GIFTCARDWEBSERVICE_EXCEPTION!= null) {
            throw GIFTCARDWEBSERVICE_EXCEPTION;
        }
        return GIFTCARDWEBSERVICE_WSDL_LOCATION;
    }

}
