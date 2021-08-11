package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ejb.MoviesEJBRemote;
import jpa.MovieJPA;
import processed.MovieJPAProcessed;

import javax.enterprise.context.RequestScoped;

@Path("/info")
@RequestScoped
public class GetMoviesInfo {
	
	@EJB
	MoviesEJBRemote moviesEJB;

	@GET
	@Path("/get1")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MovieJPAProcessed> getMovies() {
		List<MovieJPA> movies = moviesEJB.getMovies();
		List<MovieJPAProcessed> movies2 = moviesProcessing(movies);
		
		return movies2;
	}
	
	@GET
	@Path("/get2")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MovieJPAProcessed> getMoviesByTitle(@QueryParam("title") String value) {
		List<MovieJPA> movies = moviesEJB.getMoviesByTitle(value);
		List<MovieJPAProcessed> movies2 = moviesProcessing(movies);
		
		return movies2;
	}
	
	/*
	 * 
	@GET
	@Path("/get3")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MovieJPA> getMoviesByActor(@QueryParam("actorName") String value) {
		List<MovieJPA> movies = moviesEJB.getMoviesByActor(value);
		return movies;
	}
	
		
	@GET
	@Path("/get4")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getMoviesTitle() {
		List<String> movies = moviesEJB.getMoviesTitle();
		return movies;
	}
	
	*/
	
	public List<MovieJPAProcessed> moviesProcessing(List<MovieJPA> moviesJPA) {
		List<MovieJPAProcessed> processed = new ArrayList<MovieJPAProcessed>(); 
		for (MovieJPA m: moviesJPA) {
			MovieJPAProcessed mp = new MovieJPAProcessed(m);
			processed.add(mp);		
		}
		
		return processed;
	}
}
