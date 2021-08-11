package processed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jpa.ActorJPA;
import jpa.MovieJPA;

public class ActorJPAProcessed implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private List<MovieJPAProcessed> movies = new ArrayList<>();

	public ActorJPAProcessed() {
	}
	
	public ActorJPAProcessed(ActorJPA actor) {
		this.id = actor.getId();
		this.name = actor.getName();
		
        List<MovieJPAProcessed> movies_list = new ArrayList<MovieJPAProcessed>();      
        for (MovieJPA movie : actor.getMovies()) {
        	MovieJPAProcessed mp = new MovieJPAProcessed(movie);
        	movies_list.add(mp);
        }
        this.movies = movies_list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovieJPAProcessed> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieJPAProcessed> movies) {
		this.movies = movies;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String toString() {
		
		return "\nName: "  + name + "\n";
	}

	
}