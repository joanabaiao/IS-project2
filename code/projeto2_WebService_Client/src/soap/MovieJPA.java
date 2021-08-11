
package soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for movieJPA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="movieJPA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actors" type="{http://soap/}actorJPA" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="countries" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="coverUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="directors" type="{http://soap/}directorJPA" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="genres" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="runtimes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="top250Rank" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="votes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "movieJPA", propOrder = {
    "actors",
    "countries",
    "coverUrl",
    "description",
    "directors",
    "genres",
    "id",
    "rating",
    "runtimes",
    "title",
    "top250Rank",
    "votes",
    "year"
})
public class MovieJPA {

    @XmlElement(nillable = true)
    protected List<ActorJPA> actors;
    @XmlElement(nillable = true)
    protected List<String> countries;
    protected String coverUrl;
    protected String description;
    @XmlElement(nillable = true)
    protected List<DirectorJPA> directors;
    @XmlElement(nillable = true)
    protected List<String> genres;
    protected Long id;
    protected Double rating;
    protected Integer runtimes;
    protected String title;
    protected Integer top250Rank;
    protected Integer votes;
    protected Integer year;

    /**
     * Gets the value of the actors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActorJPA }
     * 
     * 
     */
    public List<ActorJPA> getActors() {
        if (actors == null) {
            actors = new ArrayList<ActorJPA>();
        }
        return this.actors;
    }

    /**
     * Gets the value of the countries property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the countries property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCountries().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCountries() {
        if (countries == null) {
            countries = new ArrayList<String>();
        }
        return this.countries;
    }

    /**
     * Gets the value of the coverUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverUrl() {
        return coverUrl;
    }

    /**
     * Sets the value of the coverUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverUrl(String value) {
        this.coverUrl = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the directors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirectors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DirectorJPA }
     * 
     * 
     */
    public List<DirectorJPA> getDirectors() {
        if (directors == null) {
            directors = new ArrayList<DirectorJPA>();
        }
        return this.directors;
    }

    /**
     * Gets the value of the genres property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genres property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenres().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGenres() {
        if (genres == null) {
            genres = new ArrayList<String>();
        }
        return this.genres;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRating(Double value) {
        this.rating = value;
    }

    /**
     * Gets the value of the runtimes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRuntimes() {
        return runtimes;
    }

    /**
     * Sets the value of the runtimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRuntimes(Integer value) {
        this.runtimes = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the top250Rank property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTop250Rank() {
        return top250Rank;
    }

    /**
     * Sets the value of the top250Rank property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTop250Rank(Integer value) {
        this.top250Rank = value;
    }

    /**
     * Gets the value of the votes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVotes() {
        return votes;
    }

    /**
     * Sets the value of the votes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVotes(Integer value) {
        this.votes = value;
    }

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYear(Integer value) {
        this.year = value;
    }

}
