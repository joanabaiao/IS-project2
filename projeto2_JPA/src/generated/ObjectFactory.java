//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.04 at 12:36:09 AM WEST 
//


package generated;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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

    private final static QName _Item_QNAME = new QName("", "item");
    private final static QName _Runtimes_QNAME = new QName("", "runtimes");
    private final static QName _Year_QNAME = new QName("", "year");
    private final static QName _CoverUrl_QNAME = new QName("", "cover-url");
    private final static QName _Rating_QNAME = new QName("", "rating");
    private final static QName _Name_QNAME = new QName("", "name");
    private final static QName _Description_QNAME = new QName("", "description");
    private final static QName _Top250Rank_QNAME = new QName("", "top-250-rank");
    private final static QName _Votes_QNAME = new QName("", "votes");
    private final static QName _Title_QNAME = new QName("", "title");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link Genres }
     * 
     */
    public Genres createGenres() {
        return new Genres();
    }

    /**
     * Create an instance of {@link Director }
     * 
     */
    public Director createDirector() {
        return new Director();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link Cast }
     * 
     */
    public Cast createCast() {
        return new Cast();
    }

    /**
     * Create an instance of {@link Countries }
     * 
     */
    public Countries createCountries() {
        return new Countries();
    }

    /**
     * Create an instance of {@link Catalog }
     * 
     */
    public Catalog createCatalog() {
        return new Catalog();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "item")
    public JAXBElement<String> createItem(String value) {
        return new JAXBElement<String>(_Item_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "runtimes")
    public JAXBElement<BigInteger> createRuntimes(BigInteger value) {
        return new JAXBElement<BigInteger>(_Runtimes_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "year")
    public JAXBElement<BigInteger> createYear(BigInteger value) {
        return new JAXBElement<BigInteger>(_Year_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cover-url")
    public JAXBElement<String> createCoverUrl(String value) {
        return new JAXBElement<String>(_CoverUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "rating")
    public JAXBElement<BigDecimal> createRating(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Rating_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "top-250-rank")
    public JAXBElement<BigInteger> createTop250Rank(BigInteger value) {
        return new JAXBElement<BigInteger>(_Top250Rank_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "votes")
    public JAXBElement<BigInteger> createVotes(BigInteger value) {
        return new JAXBElement<BigInteger>(_Votes_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "title")
    public JAXBElement<String> createTitle(String value) {
        return new JAXBElement<String>(_Title_QNAME, String.class, null, value);
    }

}
