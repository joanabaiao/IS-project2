package jpa;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import generated.Catalog;
import generated.GetMovieInfo;
import generated.Movie;

public class JPAWrite {
	
	public static void main(String[] args) throws FileNotFoundException, JAXBException, SAXException {
		
		Catalog catalog = GetMovieInfo.get();	
		List<ActorJPA> actorsList = new ArrayList<ActorJPA>();
		List<MovieJPA> moviesList = new ArrayList<MovieJPA>();
		List<DirectorJPA> directorsList = new ArrayList<DirectorJPA>();
		boolean contains = false;
		
		for (Movie movie_catalog : catalog.getMovie()) { 
			
			MovieJPA movie = new MovieJPA(movie_catalog);
			moviesList.add(movie);		

			// ADD ACTORS
			for (int i = 0; i < movie.getActors().size(); i++) {
				
				contains = false;
				for (int j = 0; j < actorsList.size(); j++)
				{
					if (actorsList.get(j).getName().equals(movie.getActors().get(i).getName())) {
						contains = true;
						movie.getActors().set(i, actorsList.get(j));
						actorsList.get(j).getMovies().add(movie);
					}
				}
				if (contains == false) {
					movie.getActors().get(i).getMovies().add(movie);
					actorsList.add(movie.getActors().get(i));
				}
			} 
			
			// ADD DIRECTORS
			for (int i = 0; i < movie.getDirectors().size(); i++) {
				
				contains = false;
				for (int j = 0; j < directorsList.size(); j++)
				{
					if (directorsList.get(j).getName().equals(movie.getDirectors().get(i).getName())) {
						contains = true;
						movie.getDirectors().set(i, directorsList.get(j));
						directorsList.get(j).getMovies().add(movie);
					}
				}
				if (contains == false) {
					movie.getDirectors().get(i).getMovies().add(movie);
					directorsList.add(movie.getDirectors().get(i));
				}
			} 
		}


		// WRITE
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		for (MovieJPA movie : moviesList) {
			em.persist(movie);
		}
		
		for (ActorJPA actor : actorsList) {
			em.persist(actor);
		}
		
		for (DirectorJPA director : directorsList) {
			em.persist(director);	
		}

		tx.commit();
		em.close();
		emf.close();
			
	}

}