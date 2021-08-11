package source;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.ActorsEJBRemote;
import ejb.MoviesEJBRemote;
import jpa.ActorJPA;
import jpa.MovieJPA;

public class Client {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws NamingException {	
		
		Properties jndiProps = new Properties();
		jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");		
		jndiProps.put(Context.PROVIDER_URL,"http-remoting://localhost:8080"); 
		jndiProps.put("jboss.naming.client.ejb.context", true);
		Context ctx = new InitialContext(jndiProps);
		
		MoviesEJBRemote mr = (MoviesEJBRemote) ctx.lookup("projeto2_EAR_WebService/projeto2_EJB/MoviesEJB!ejb.MoviesEJBRemote");
		ActorsEJBRemote ar = (ActorsEJBRemote) ctx.lookup("projeto2_EAR_WebService/projeto2_EJB/ActorsEJB!ejb.ActorsEJBRemote");
		
		boolean main_menu = true;
		while(main_menu){
			System.out.println("\n########## MAIN MENU ##########\n");
			System.out.println("[1] Movies Menu");
			System.out.println("[2] Actors Menu");
			System.out.println("[e] Exit\n");
			System.out.println("Select an option: ");

			String option = scan.nextLine();
			switch (option) {
		    	case "1":
		    		MoviesMenu(mr);
		    		break;
				case "2":
					ActorsMenu(ar);
					break;
				case "e":
					System.out.println("\n----------- Goodbye!!! -----------");
					main_menu = false;
					break;
			}
		}
	}
		
	public static void MoviesMenu(MoviesEJBRemote mr) throws NamingException {
		
		boolean movies_menu = true;
		while(movies_menu) {
				
			System.out.println("\n########### MOVIES MENU ##########\n");
			System.out.println("[1] See all Movies");
			System.out.println("[2] Search by Titles");
			System.out.println("[3] Search by Rating");
			System.out.println("[4] Search by Year");
			System.out.println("[5] Search by Actor\n");
			System.out.println("[e] Exit\n");
			System.out.println("Select an option: ");
			
			String option_movie = scan.nextLine();
			List<MovieJPA> movies_list = new ArrayList<MovieJPA>();
			
			switch (option_movie) {
			
			case "1":
				System.out.println("\n########### All Movies ###########\n");			
				movies_list = mr.getMovies();
				break;
				
			case "2":
				System.out.println("\n######## Search by title #########\n");
				System.out.println("Title: ");
				String title = scan.nextLine();
				movies_list = mr.getMoviesByTitle(title);
				break;
				
			case "3": 
				System.out.println("\n######## Search by rating ########\n");
				System.out.println("Minimum limit (0-10): ");
				double min_rating = scan.nextDouble();
				System.out.println("Maximum limit (<10): ");
				double max_rating = scan.nextDouble();			
				movies_list = mr.getMoviesByRating(min_rating, max_rating);
				break;
				
			case "4": 
				System.out.println("\n######### Search by year #########\n");
				System.out.println("Minimum limit: ");
				double min_year = scan.nextDouble();
				System.out.println("Maximum limit: ");
				double max_year = scan.nextDouble();
				
				movies_list = mr.getMoviesByRating(min_year, max_year);
				break;
			
			case "5":
				System.out.println("\n######### Search by actor #########\n");
				System.out.println("Actor name:");
				String actor = scan.nextLine();
				
				movies_list = mr.getMoviesByActor(actor);
				break;
				
			case "e":		
				movies_menu = false;
				break;
			}
			
			// SHOW RESULTS
			if (movies_menu) {
				if (movies_list.isEmpty()){
					System.out.println("\nNo Results!\n");
				}
				else if (movies_list.size() <= 5) {
					System.out.println("\nRESULTS:\n");
					for (MovieJPA movie: movies_list) {
						System.out.println(movie.toString());
					}
				}
				else {
					System.out.println("\nRESULTS:\n");
					for(int i=0; i<(movies_list.size()); i++) {
						System.out.println(String.valueOf(i) + "- " + movies_list.get(i).getTitle());
					}
					boolean show_info = true;
					while (show_info) {
						System.out.println("\n######## See movie details ########\n");
						System.out.println("[Enter] Menu");
						System.out.println("Select movie: ");
						String selected_movie = scan.nextLine();
						if (selected_movie.isEmpty()) {
							show_info = false;
						}
						else {
							System.out.println(movies_list.get(Integer.valueOf(selected_movie)).toString());
						}
					}
				}
			}
		}
	}
	
	public static void ActorsMenu(ActorsEJBRemote ar) throws NamingException {
		boolean actors_menu = true;
		
		while(actors_menu) {
				
			System.out.println("\n########### ACTORS MENU ##########\n");
			System.out.println("[1] See all Actors");
			System.out.println("[2] Search by Name");
			System.out.println("[3] Search by Movie");
			System.out.println("[e] Exit\n");
			System.out.println("Select an option: ");
			
			String option_actor = scan.nextLine();
			List<ActorJPA> actors_list = new ArrayList<ActorJPA>();
			
			switch (option_actor) {
			
			// All actors
			case "1":
				System.out.println("\n########### All Actors ###########\n");			
				actors_list = ar.getActors();
				break;
				
			case "2":
				System.out.println("\n######## Search by name #########\n");
				System.out.println("Name: ");
				String name = scan.nextLine();
				actors_list = ar.getActorByName(name);
				break;
				
			case "3":
				System.out.println("\n######## Search by movie #########\n");
				System.out.println("Movie title: ");
				String movie = scan.nextLine();
				actors_list = ar.getActorsInfoByMovieTitle(movie);
				break;

			case "e":		
				actors_menu = false;
				break;
			}
			
			// SHOW RESULTS
			if (actors_menu) {
				if (actors_list.isEmpty()){
					System.out.println("\nNo Results!\n");
				}
				else {
					System.out.println("\nRESULTS:\n");
					for(int i=0; i<(actors_list.size()); i++) {
						System.out.println(String.valueOf(i) + "- " + actors_list.get(i).getName());
					}
					boolean show_info = true;
					while (show_info) {
						System.out.println("\n######## See movie details ########\n");
						System.out.println("[Enter] Menu");
						System.out.println("Select Actor: ");
						String selected_actor = scan.nextLine();
						if (selected_actor.isEmpty()) {
							show_info = false;
						}
						else {
							ActorJPA actor = actors_list.get(Integer.valueOf(selected_actor));
							for(MovieJPA movie : actor.getMovies()) {
								System.out.println(movie.toString());
							}
						}
					}
				}
			} 	
		}
	}
}
