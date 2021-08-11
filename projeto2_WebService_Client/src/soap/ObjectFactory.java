
package soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap package. 
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

    private final static QName _GetActorByMovieTitle_QNAME = new QName("http://soap/", "getActorByMovieTitle");
    private final static QName _SetPropertiesResponse_QNAME = new QName("http://soap/", "setPropertiesResponse");
    private final static QName _GetActorsResponse_QNAME = new QName("http://soap/", "getActorsResponse");
    private final static QName _GetActorByName_QNAME = new QName("http://soap/", "getActorByName");
    private final static QName _ActorsProcessing_QNAME = new QName("http://soap/", "actorsProcessing");
    private final static QName _GetActorByNameResponse_QNAME = new QName("http://soap/", "getActorByNameResponse");
    private final static QName _ActorsProcessingResponse_QNAME = new QName("http://soap/", "actorsProcessingResponse");
    private final static QName _GetActorByMovieTitleResponse_QNAME = new QName("http://soap/", "getActorByMovieTitleResponse");
    private final static QName _GetActors_QNAME = new QName("http://soap/", "getActors");
    private final static QName _SetProperties_QNAME = new QName("http://soap/", "setProperties");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActorsProcessingResponse }
     * 
     */
    public ActorsProcessingResponse createActorsProcessingResponse() {
        return new ActorsProcessingResponse();
    }

    /**
     * Create an instance of {@link GetActorByMovieTitleResponse }
     * 
     */
    public GetActorByMovieTitleResponse createGetActorByMovieTitleResponse() {
        return new GetActorByMovieTitleResponse();
    }

    /**
     * Create an instance of {@link GetActors }
     * 
     */
    public GetActors createGetActors() {
        return new GetActors();
    }

    /**
     * Create an instance of {@link ActorsProcessing }
     * 
     */
    public ActorsProcessing createActorsProcessing() {
        return new ActorsProcessing();
    }

    /**
     * Create an instance of {@link GetActorByNameResponse }
     * 
     */
    public GetActorByNameResponse createGetActorByNameResponse() {
        return new GetActorByNameResponse();
    }

    /**
     * Create an instance of {@link SetProperties }
     * 
     */
    public SetProperties createSetProperties() {
        return new SetProperties();
    }

    /**
     * Create an instance of {@link SetPropertiesResponse }
     * 
     */
    public SetPropertiesResponse createSetPropertiesResponse() {
        return new SetPropertiesResponse();
    }

    /**
     * Create an instance of {@link GetActorByMovieTitle }
     * 
     */
    public GetActorByMovieTitle createGetActorByMovieTitle() {
        return new GetActorByMovieTitle();
    }

    /**
     * Create an instance of {@link GetActorByName }
     * 
     */
    public GetActorByName createGetActorByName() {
        return new GetActorByName();
    }

    /**
     * Create an instance of {@link GetActorsResponse }
     * 
     */
    public GetActorsResponse createGetActorsResponse() {
        return new GetActorsResponse();
    }

    /**
     * Create an instance of {@link MovieJPAProcessed }
     * 
     */
    public MovieJPAProcessed createMovieJPAProcessed() {
        return new MovieJPAProcessed();
    }

    /**
     * Create an instance of {@link MovieJPA }
     * 
     */
    public MovieJPA createMovieJPA() {
        return new MovieJPA();
    }

    /**
     * Create an instance of {@link ActorJPAProcessed }
     * 
     */
    public ActorJPAProcessed createActorJPAProcessed() {
        return new ActorJPAProcessed();
    }

    /**
     * Create an instance of {@link ActorJPA }
     * 
     */
    public ActorJPA createActorJPA() {
        return new ActorJPA();
    }

    /**
     * Create an instance of {@link DirectorJPA }
     * 
     */
    public DirectorJPA createDirectorJPA() {
        return new DirectorJPA();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActorByMovieTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "getActorByMovieTitle")
    public JAXBElement<GetActorByMovieTitle> createGetActorByMovieTitle(GetActorByMovieTitle value) {
        return new JAXBElement<GetActorByMovieTitle>(_GetActorByMovieTitle_QNAME, GetActorByMovieTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPropertiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "setPropertiesResponse")
    public JAXBElement<SetPropertiesResponse> createSetPropertiesResponse(SetPropertiesResponse value) {
        return new JAXBElement<SetPropertiesResponse>(_SetPropertiesResponse_QNAME, SetPropertiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActorsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "getActorsResponse")
    public JAXBElement<GetActorsResponse> createGetActorsResponse(GetActorsResponse value) {
        return new JAXBElement<GetActorsResponse>(_GetActorsResponse_QNAME, GetActorsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActorByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "getActorByName")
    public JAXBElement<GetActorByName> createGetActorByName(GetActorByName value) {
        return new JAXBElement<GetActorByName>(_GetActorByName_QNAME, GetActorByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActorsProcessing }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "actorsProcessing")
    public JAXBElement<ActorsProcessing> createActorsProcessing(ActorsProcessing value) {
        return new JAXBElement<ActorsProcessing>(_ActorsProcessing_QNAME, ActorsProcessing.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActorByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "getActorByNameResponse")
    public JAXBElement<GetActorByNameResponse> createGetActorByNameResponse(GetActorByNameResponse value) {
        return new JAXBElement<GetActorByNameResponse>(_GetActorByNameResponse_QNAME, GetActorByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActorsProcessingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "actorsProcessingResponse")
    public JAXBElement<ActorsProcessingResponse> createActorsProcessingResponse(ActorsProcessingResponse value) {
        return new JAXBElement<ActorsProcessingResponse>(_ActorsProcessingResponse_QNAME, ActorsProcessingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActorByMovieTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "getActorByMovieTitleResponse")
    public JAXBElement<GetActorByMovieTitleResponse> createGetActorByMovieTitleResponse(GetActorByMovieTitleResponse value) {
        return new JAXBElement<GetActorByMovieTitleResponse>(_GetActorByMovieTitleResponse_QNAME, GetActorByMovieTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActors }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "getActors")
    public JAXBElement<GetActors> createGetActors(GetActors value) {
        return new JAXBElement<GetActors>(_GetActors_QNAME, GetActors.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetProperties }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "setProperties")
    public JAXBElement<SetProperties> createSetProperties(SetProperties value) {
        return new JAXBElement<SetProperties>(_SetProperties_QNAME, SetProperties.class, null, value);
    }

}
