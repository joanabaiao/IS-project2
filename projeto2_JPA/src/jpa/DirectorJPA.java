package jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "directors")
public class DirectorJPA  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "director_id")
	private Long id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "movies_directors",
            joinColumns = {@JoinColumn(name = "director_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
	private List<MovieJPA> movies = new ArrayList<MovieJPA>();

	public DirectorJPA() {
	}
	
	public DirectorJPA(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovieJPA> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieJPA> movies) {
		this.movies = movies;
	}


}