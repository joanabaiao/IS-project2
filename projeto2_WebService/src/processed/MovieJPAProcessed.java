package processed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jpa.ActorJPA;
import jpa.DirectorJPA;
import jpa.MovieJPA;

public class MovieJPAProcessed implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// we use this generation type to match that of SQLWriteStudents
	
	private Long id;
	private Integer top250Rank;
	private String title;
	private Integer runtimes;
	private Integer year;
	private Double rating;
	private Integer votes;
	private String coverUrl;
	private String description;
	private List<String> genres;
	private List<String> countries;
	private List<String> directors;
    private List<String> actors;
    
    public MovieJPAProcessed(){
    	
    }
    
    public MovieJPAProcessed (MovieJPA movie) {
    	this.id = movie.getId();
        this.title = movie.getTitle();
        this.year = movie.getYear();
        this.countries = movie.getCountries();
        this.rating = movie.getRating();
        this.top250Rank = movie.getTop250Rank();
        this.runtimes = movie.getRuntimes();
        this.votes = movie.getVotes();
        this.description = movie.getDescription();
        this.coverUrl = movie.getCoverUrl();
        this.genres = movie.getGenres();
        
        List<String> cast = new ArrayList<String>();      
        for (ActorJPA actor : movie.getActors()) {
        	cast.add(actor.getName());
        }
        this.actors = cast;
        
        List<String> dir = new ArrayList<String>();      
        for (DirectorJPA director : movie.getDirectors()) {
        	dir.add(director.getName());
        }
        this.directors = dir;
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

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	
	public String toString() {
		return "\n----------- "  + title + " -----------\n" + 
				"Rank Position: " + top250Rank + 
				"\nRuntimes: " + runtimes + 
				"\nYear: " + year + 
				"\nRating: " + rating + 
				"\nVotes: " + votes + 
				"\nGenres: " + String.join(", ", genres) + 
				"\nCountries: " +  String.join(", ", countries) + 
				"\nDirectors: " +  String.join(", ", directors) + 
				"\nActors: " +  String.join(", ", actors) + 
				"\nDescription: " + description + "\n";
	}

	
}

