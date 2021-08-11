package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.apple.eawt.AppEvent.SystemSleepEvent;

import jpa.ActorJPA;
import jpa.MovieJPA;
import ejb.MoviesEJB;

/**
 * Session Bean implementation class ActorsEJB
 */
@Stateless
@LocalBean
public class ActorsEJB implements ActorsEJBRemote, ActorsEJBLocal {


    @PersistenceContext(name = "TestPersistence")
	private EntityManager em;
    
  
    /**
     * Default constructor. 
     */
    
    public ActorsEJB() {
        // TODO Auto-generated constructor stub
    }
    
    // Todos os atores (objeto)
    @Override
	public List<ActorJPA> getActors() {
		
		Query q = em.createQuery("SELECT a FROM ActorJPA a");
		@SuppressWarnings("unchecked")
		List<ActorJPA> mylist = q.getResultList();
		
		return mylist;
	}
      
    // Pesquisar atores por nome
    @Override
	public List<ActorJPA> getActorByName(String name) {
		
    	Query q = em.createQuery("SELECT a FROM ActorJPA a WHERE LOWER(name) LIKE LOWER(\'%" + name + "%\')");
		@SuppressWarnings("unchecked")
		List<ActorJPA> mylist = q.getResultList();
		
		return mylist;
	}
    
    
    // Pesquisar atores pelo nome do filme
    @Override
	public List<ActorJPA> getActorsInfoByMovieTitle(String title) {
		
		Query q = em.createQuery("SELECT m FROM MovieJPA m WHERE LOWER(title) LIKE LOWER(\'%" + title + "%\')");
        List<ActorJPA> mylist = new ArrayList<ActorJPA>();
		@SuppressWarnings("unchecked")
		List<MovieJPA> mylist_movies = q.getResultList();
        try {
			mylist = mylist_movies.get(0).getActors();
		}
		catch(Exception e) {
			//  Não há resultado
		}			
		return mylist;
	}
    
    @Override
    public void addActor(String name, List<String> movies_rank) {
    	
    	ActorJPA actor = new ActorJPA(name);
		List<MovieJPA> actor_movies = new ArrayList<MovieJPA>();
		for (String rank: movies_rank) {			
			MovieJPA new_movie = getNewActorsMovie(Integer.valueOf(rank));
			System.out.println(new_movie.getTitle());
			actor_movies.add(new_movie);			
		}
		actor.setMovies(actor_movies);
    	em.persist(actor);
   	}

    @Override
	public MovieJPA getNewActorsMovie(int rank_position) {
		
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
    
    // Adicionar ator
    /*
    @Override
    public void addActor(ActorJPA actor) {
    	System.out.print(actor.getName());
    	for (MovieJPA m: actor.getMovies()) {
    		System.out.println(m.getId());
    	}
    	//em.persist(actor);
   	}
    */
    

    // Todos os nomes dos atores
    /*
    @Override
	public List<ActorJPA> getActorsNames() {
		
		Query q = em.createQuery("SELECT name FROM ActorJPA a");
		@SuppressWarnings("unchecked")
		List<ActorJPA> mylist = q.getResultList();
		
		return mylist;
	}*/
    
    /*
    // Pesquisar filmes pelo nome do ator
    @Override
    public List<MovieJPA> getActorMovies(String name) {
		Query query = em.createQuery("SELECT a FROM ActorJPA a WHERE LOWER(name) LIKE LOWER(\'%" + name + "%\')");
		@SuppressWarnings("unchecked")
		List<ActorJPA> mylist = query.getResultList();
		List<MovieJPA> mylist_movies = new ArrayList<MovieJPA>();
		try {
			mylist_movies = mylist.get(0).getMovies();
		}
		catch(Exception e) {
			//  Não há resultado
		}
		return mylist_movies;
	}
*/

}
