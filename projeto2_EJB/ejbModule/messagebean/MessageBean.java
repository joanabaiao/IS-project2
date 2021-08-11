package messagebean;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import ejb.MoviesEJB;
import ejb.ActorsEJB;
import jpa.MovieJPA;

/**
 * Message-Driven Bean implementation class for: MessageBean
 */
@MessageDriven(activationConfig = {	
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/serverQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, mappedName = "java:jboss/exported/jms/queue/serverQueue")

public class MessageBean implements MessageListener {
	
	@EJB
	private MoviesEJB moviesejb;
	
	@EJB
	private ActorsEJB actorsejb;
	
	@Inject
	private JMSContext context;

    /**
     * Default constructor. 
     */
    public MessageBean() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	
    	try {
    		
			String request = message.getStringProperty("request");
			
			if (request.equals("ALLMOVIES")) {
				
				JMSProducer producer = context.createProducer();
				TextMessage reply = context.createTextMessage();
				
				List<MovieJPA> movies_list = moviesejb.getMovies();
				movies_list.sort(Comparator.comparing(MovieJPA::getTop250Rank));
				
				String movies_string = "\nRESULTS:\n";
				for (MovieJPA movie : movies_list) {
					movies_string = movies_string + String.valueOf(movie.getTop250Rank()) + "- " + movie.getTitle() + "\n";
				}	
				
				reply.setText(movies_string);
				producer.send(message.getJMSReplyTo(), reply);				
			}	
			
			else if (request.split("-")[0].equals("MOVIE")) {
				
				JMSProducer producer = context.createProducer();
				TextMessage reply = context.createTextMessage();
				
				MovieJPA movie = moviesejb.getMovieByRank(Integer.valueOf(request.split("-")[1]));
				
				String movie_string = movie.toString();
				
				reply.setText(movie_string);
				producer.send(message.getJMSReplyTo(), reply);					
			}
			
			else if (request.split("-")[0].equals("ADDACTOR")) {
				
				JMSProducer producer = context.createProducer();
				TextMessage reply = context.createTextMessage();
						
				String name = request.split("-")[1];
				String movies = request.split("-")[2];
				List<String> movies_rank = Arrays.asList(movies.split(";"));
				
				actorsejb.addActor(name, movies_rank);
				
				String response = "\nActor " + name + " added!";

				reply.setText(response);
				producer.send(message.getJMSReplyTo(), reply);	
				
			}
    	}
    	
    	catch (JMSException e) {
    		e.printStackTrace();
		}
        
    }

}
