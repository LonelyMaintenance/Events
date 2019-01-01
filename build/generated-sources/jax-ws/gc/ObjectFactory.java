
package gc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gc package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SQLException_QNAME = new QName("http://gc/", "SQLException");
    private final static QName _GetAccountValue_QNAME = new QName("http://gc/", "getAccountValue");
    private final static QName _GetAccountValueResponse_QNAME = new QName("http://gc/", "getAccountValueResponse");
    private final static QName _Pay_QNAME = new QName("http://gc/", "pay");
    private final static QName _PayResponse_QNAME = new QName("http://gc/", "payResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SQLException }
     * 
     */
    public SQLException createSQLException() {
        return new SQLException();
    }

    /**
     * Create an instance of {@link GetAccountValue }
     * 
     */
    public GetAccountValue createGetAccountValue() {
        return new GetAccountValue();
    }

    /**
     * Create an instance of {@link GetAccountValueResponse }
     * 
     */
    public GetAccountValueResponse createGetAccountValueResponse() {
        return new GetAccountValueResponse();
    }

    /**
     * Create an instance of {@link Pay }
     * 
     */
    public Pay createPay() {
        return new Pay();
    }

    /**
     * Create an instance of {@link PayResponse }
     * 
     */
    public PayResponse createPayResponse() {
        return new PayResponse();
    }

    /**
     * Create an instance of {@link SqlException }
     * 
     */
    public SqlException createSqlException() {
        return new SqlException();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link Throwable }
     * 
     */
    public Throwable createThrowable() {
        return new Throwable();
    }

    /**
     * Create an instance of {@link StackTraceElement }
     * 
     */
    public StackTraceElement createStackTraceElement() {
        return new StackTraceElement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SQLException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gc/", name = "SQLException")
    public JAXBElement<SQLException> createSQLException(SQLException value) {
        return new JAXBElement<SQLException>(_SQLException_QNAME, SQLException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gc/", name = "getAccountValue")
    public JAXBElement<GetAccountValue> createGetAccountValue(GetAccountValue value) {
        return new JAXBElement<GetAccountValue>(_GetAccountValue_QNAME, GetAccountValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountValueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gc/", name = "getAccountValueResponse")
    public JAXBElement<GetAccountValueResponse> createGetAccountValueResponse(GetAccountValueResponse value) {
        return new JAXBElement<GetAccountValueResponse>(_GetAccountValueResponse_QNAME, GetAccountValueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pay }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gc/", name = "pay")
    public JAXBElement<Pay> createPay(Pay value) {
        return new JAXBElement<Pay>(_Pay_QNAME, Pay.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gc/", name = "payResponse")
    public JAXBElement<PayResponse> createPayResponse(PayResponse value) {
        return new JAXBElement<PayResponse>(_PayResponse_QNAME, PayResponse.class, null, value);
    }

}
