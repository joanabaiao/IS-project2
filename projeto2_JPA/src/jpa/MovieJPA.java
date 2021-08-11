package jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import generated.Movie;
import generated.Person;

@Entity
@Table(name = "movies")
public class MovieJPA implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// we use this generation type to match that of SQLWriteStudents
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private Long id;
	
	private Integer top250Rank;
	private String title;
	private Integer runtimes;
	private Integer year;
	private Double rating;
	private Integer votes;
	private String coverUrl;
	
	@Column(columnDefinition="text")
	private String description;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@CollectionTable(name="movies_genres")
	private List<String> genres;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@CollectionTable(name="movies_countries")
	private List<String> countries;
	
	@ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<DirectorJPA> directors;
	
    @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<ActorJPA> actors;
    
    public MovieJPA(){
    	
    }
    
    public MovieJPA(Movie movie) {
        this.title = movie.getTitle();
        this.year = movie.getYear().intValue();
        this.countries = movie.getCountries().getItem();
        this.rating = movie.getRating().doubleValue();
        this.top250Rank = movie.getTop250Rank().intValue();
        this.runtimes = movie.getRuntimes().intValue();
        this.votes = movie.getVotes().intValue();
        this.description = movie.getDescription();
        this.coverUrl = movie.getCoverUrl();
        this.genres = movie.getGenres().getItem();
        
        List<ActorJPA> cast = new ArrayList<ActorJPA>();
        for (Person actor : movie.getCast().getPerson()) {
        	ActorJPA a = new ActorJPA(actor.getName());
        	cast.add(a);	
        }
        this.actors = cast;
        
        List<DirectorJPA> directors = new ArrayList<DirectorJPA>();
        for (Person director : movie.getDirector().getPerson()) {
        	DirectorJPA d = new DirectorJPA(director.getName());
        	directors.add(d);	
        }
        this.directors = directors;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTop250Rank() {
		return top250Rank;
	}

	public void setTop250Rank(Integer top250Rank) {
		this.top250Rank = top250Rank;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getRuntimes() {
		return runtimes;
	}

	public void setRuntimes(Integer runtimes) {
		this.runtimes = runtimes;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public List<DirectorJPA> getDirectors() {
		return directors;
	}

	public void setDirectors(List<DirectorJPA> directors) {
		this.directors = directors;
	}

	public List<ActorJPA> getActors() {
		return actors;
	}

	public void setActors(List<ActorJPA> actors) {
		this.actors = actors;
	}
    
    
	
}
