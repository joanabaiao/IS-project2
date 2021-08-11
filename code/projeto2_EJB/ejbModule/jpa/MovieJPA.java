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
	
	
	
	public List<String> actorsNames() {
		List<String> act_names = new ArrayList<String>();
		for (ActorJPA a : actors) {
			act_names.add(a.getName());
		}
		return act_names;
	}
	
	public List<String> directorsNames() {
		List<String> dir_names = new ArrayList<String>();
		for (DirectorJPA d : directors) {
			dir_names.add(d.getName());
		}
		return dir_names;
	}
	

	@Override
	public String toString() {
		return "\n----------- "  + title + " -----------\n" + 
				"Rank Position: " + top250Rank + 
				"\nRuntimes: " + runtimes + 
				"\nYear: " + year + 
				"\nRating: " + rating + 
				"\nVotes: " + votes + 
				"\nGenres: " + String.join(", ", genres) + 
				"\nCountries: " +  String.join(", ", countries) + 
				"\nDirectors: " +  String.join(", ", directorsNames()) + 
				"\nActors: " +  String.join(", ", actorsNames()) + 
				"\nDescription: " + description + "\n";
	}
	
	
}


