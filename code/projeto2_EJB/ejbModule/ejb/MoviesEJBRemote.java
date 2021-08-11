package ejb;

import java.util.List;

import javax.ejb.Remote;

import jpa.MovieJPA;

@Remote
public interface MoviesEJBRemote {

	List<MovieJPA> getMovies();

	List<MovieJPA> getMoviesByTitle(String title);
	
	List<MovieJPA> getMoviesByRating(double min, double max);

	List<MovieJPA> getMoviesByYear(int min, int max);

	List<MovieJPA> getMoviesByActor(String actor);

	List<String> getMoviesTitle();

	MovieJPA getMovieByRank(int rank_position);

}
