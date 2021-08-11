package client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import processed.MovieJPAProcessed;

import javax.ws.rs.core.GenericType;

import soap.GetActorsInfo;
import soap.GetActorsInfoService;
import soap.ActorJPAProcessed;

import jms.Sender;

public class ClientMain {
	
	private static Scanner scan = new Scanner(System.in);
	private static Client clientRest;
	private static WebTarget target;
	private static Response response;
	
	private static GetActorsInfo soap;	
	private static GetActorsInfoService service;
	
	public static void main(String[] args) throws NamingException, JMSException {
		
		clientRest = ClientBuilder.newClient();
		service = new GetActorsInfoService();
		soap = service.getGetActorsInfoPort();
		
		boolean main_menu = true;
		while(main_menu){
			System.out.println("\n########## MAIN MENU ##########\n");
			System.out.println("[1] Movies Menu (REST)");
			System.out.println("[2] Actors Menu (SOAP)");
			System.out.println("[3] JMS Menu");
			System.out.println("[e] Exit\n");
			System.out.println("Select an option: ");

			String option = scan.nextLine();
			switch (option) {
		    	case "1":
		    		MoviesMenu();
		    		break;	
		    	case "2":
					ActorsMenu();
					break;	
		    	case "3":
					JMSMenu();
					break;
				case "e":
					System.out.println("\n----------- Goodbye!!! -----------");
					main_menu = false;
					break;
			}
		}
	}
		
	public static void MoviesMenu(){
		
		boolean movies_menu = true;
		while(movies_menu) {
				
			System.out.println("\n########### MOVIES MENU ##########\n");
			System.out.println("[1] See all Movies");
			System.out.println("[2] Search by Titles");
			System.out.println("[e] Exit\n");
			System.out.println("Select an option: ");
			
			String option_movie = scan.nextLine();
			List<MovieJPAProcessed> movies_list = new ArrayList<MovieJPAProcessed>();
			
			switch (option_movie) {
			
			case "1":
				System.out.println("\n########### All Movies ###########\n");		
				
				target = clientRest.target("http://localhost:8080/projeto2_WebService/rest/info/get1");
				response = target.request().get();
				movies_list = response.readEntity(new GenericType<List<MovieJPAProcessed>>() {});
				movies_list.sort(Comparator.comparing(MovieJPAProcessed::getTop250Rank));

				break;
				
			case "2":
				System.out.println("\n######## Search by title #########\n");
				System.out.println("Title: ");
				String title = scan.nextLine();
				String url = "http://localhost:8080/projeto2_WebService/rest/info/get2?title=" + title;
				
				target = clientRest.target(url);
				response = target.request().get();
				movies_list = response.readEntity(new GenericType<List<MovieJPAProcessed>>() {});
				movies_list.sort(Comparator.comparing(MovieJPAProcessed::getTop250Rank));

				break;
				
			case "e":		
				movies_menu = false;
				break;
			}
			
			// SHOW RESULTS
			if (movies_menu) {
				if (movies_list.isEmpty()) {
					System.out.println("\nNo Results!\n");
				}
				else if (movies_list.size() <= 5) {
					System.out.println("\nRESULTS:\n");
					for (MovieJPAProcessed movie: movies_list) {
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
	
	public static void ActorsMenu() {
		boolean actors_menu = true;
		
		while(actors_menu) {
				
			System.out.println("\n########### ACTORS MENU ##########\n");
			System.out.println("[1] See all Actors");
			System.out.println("[e] Exit\n");
			System.out.println("Select an option: ");
			
			String option_actor = scan.nextLine();
			List<ActorJPAProcessed> actors_list = new ArrayList<ActorJPAProcessed>();
			
			switch (option_actor) {
			
			// All actors
			case "1":
				System.out.println("\n########### All Actors ###########\n");	
				actors_list = soap.getActors();
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
							ActorJPAProcessed actor = actors_list.get(Integer.valueOf(selected_actor));
							System.out.println("\nSelected actor: " + actor.getName());
							for(soap.MovieJPAProcessed movie : actor.getMovies()) {
								System.out.println(movie.toString());
							}
						}
					}
				}
			} 	
		}
	}

	public static void JMSMenu() throws NamingException, JMSException {
		
		//Receiver receiver = new Receiver();
		Sender sender = new Sender();
		
		boolean jms_menu = true;
		while(jms_menu) {
				
			System.out.println("\n########### JMS MENU ##########\n");
			System.out.println("[1] See all Movies");
			System.out.println("[2] Add actor\n");
			System.out.println("[e] Exit\n");
			System.out.println("Select an option: ");
			
			String option_jms = scan.nextLine();
			
			switch (option_jms) {
			
			case "1":
				System.out.println("\n########### All Movies ###########\n");
				
				String message = "ALLMOVIES";
				String response_movies = sender.send(message);
				System.out.println(response_movies);
				//receiver.receive();
				
				boolean show_info = true;
				while (show_info) {
					System.out.println("\n######## See movie details ########\n");
					System.out.println("[Enter] Menu");
					System.out.println("Select movie: ");
					String movie_opt = scan.nextLine();
					if (movie_opt.isEmpty()) {
						show_info = false;
					}
					else {
						String message2 = "MOVIE-" + movie_opt;
						String response_movies2 = sender.send(message2);
						System.out.println(response_movies2);
					}	
				}
				break;
				
			case "2":
				System.out.println("\n######## Add new actor #########\n");
				System.out.println("Name: ");
				String actor_name = scan.nextLine();
				
				System.out.println("\nInsert the rank position of the actor's movies separated by ;");
				System.out.println("Movies: ");
				String movies_rank = scan.nextLine();
				
				String message3 = "ADDACTOR-" + actor_name + "-" + movies_rank;
				String response_actor = sender.send(message3);
				System.out.println(response_actor);
				
				break;
				
			case "e":		
				jms_menu = false;
				break;
			}
		}
	}

}