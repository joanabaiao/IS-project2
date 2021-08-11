package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Converter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jpa.ActorJPA;
import jpa.MovieJPA;

/**
 * Session Bean implementation class MoviesEJB
 */
@Stateless
@LocalBean
@Local(Converter.class)
public class MoviesEJB implements MoviesEJBRemote, MoviesEJBLocal {
	
	
	@PersistenceContext(name = "TestPersistence")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public MoviesEJB() {
        // TODO Auto-generated constructor stub
    }
    
	// MOVIES
    @Override
	public List<String> getMoviesTitle() {
		
		Query q = em.createQuery("SELECT title FROM MovieJPA m");
		@SuppressWarnings("unchecked")
		List<String> mylist = q.getResultList();	
		
		return mylist;
	}
    
	// MOVIES
    @Override
	public List<MovieJPA> getMovies() {
		
		Query q = em.createQuery("SELECT m FROM MovieJPA m");
		@SuppressWarnings("unchecked")
		List<MovieJPA> mylist = q.getResultList();	
		
		return mylist;
	}
    
    // MOVIES BY TITLE
    @Override
    public List<MovieJPA> getMoviesByTitle(String title) {
		
		Query q = em.createQuery("SELECT m FROM MovieJPA m WHERE LOWER(title) LIKE LOWER(\'%" + title + "%\')");
		@SuppressWarnings("unchecked")
		List<MovieJPA> mylist = q.getResultList();	
		
		return mylist;
	}
    
    // MOVIES BY RATING
    @Override
    public List<MovieJPA> getMoviesByRating(double min, double max) {
		
		Query q = em.createQuery("SELECT m FROM MovieJPA m WHERE rating BETWEEN " + min + " AND " + max);
		@SuppressWarnings("unchecked")
		List<MovieJPA> mylist = q.getResultList();	
		
		return mylist;
    }
    
    // MOVIES BY YEAR
    @Override
	public List<MovieJPA> getMoviesByYear(int min, int max) {
		
		Query q = em.createQuery("SELECT m FROM MovieJPA m WHERE year BETWEEN " + min + " AND " + max);
		@SuppressWarnings("unchecked")
		List<MovieJPA> mylist = q.getResultList();	
		
		return mylist;
	}
    
       
    // MOVIES BY RANK
    @Override
	public MovieJPA getMovieByRank(int rank_position) {
		
    	MovieJPA movie = null;
		Query q = em.createQuery("SELECT m FROM MovieJPA m WHERE top250Rank=" + rank_position);
		@SuppressWarnings("unchecked")
		List<MovieJPA> mylist = q.getResultList();	
		try {
			movie = mylist.get(0);
		}
		catch (Exception e) {
			
		}	
		return movie;
	}
    
    
    // MOVIES BY ACTORS
	@Override
	public List<MovieJPA> getMoviesByActor(String actor) {
		
		Query q = em.createQuery("SELECT a FROM ActorJPA a WHERE LOWER(name) LIKE LOWER(\'%" + actor + "%\')");
		List<MovieJPA> mylist = new ArrayList<MovieJPA>();
		@SuppressWarnings("unchecked")
		List<ActorJPA> mylist_actors = q.getResultList();
		try {
			mylist = mylist_actors.get(0).getMovies();
		}
		catch (Exception e) {
			
		}	
		
		return mylist;
	}
	
	
}
