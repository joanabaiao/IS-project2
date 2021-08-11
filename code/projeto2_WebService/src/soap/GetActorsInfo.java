package soap;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.ActorsEJBRemote;
import jpa.ActorJPA;
import processed.ActorJPAProcessed;

@WebService
public class GetActorsInfo {
	
	@EJB
	private ActorsEJBRemote actorsEJB;
	
	@WebMethod
	public List<ActorJPAProcessed> getActors() {
		setProperties();	
		List<ActorJPA> actors = actorsEJB.getActors();	
		List<ActorJPAProcessed> actors2 = actorsProcessing(actors);
		
		return actors2;
	}
	
	@WebMethod
	public List<ActorJPAProcessed> getActorByName(String name) {
		setProperties();	
		List<ActorJPA> actors = actorsEJB.getActorByName(name);	
		List<ActorJPAProcessed> actors2 = actorsProcessing(actors);
		
		return actors2;
	}
	
	@WebMethod
	public List<ActorJPAProcessed> getActorByMovieTitle(String title) {
		setProperties();	
		List<ActorJPA> actors = actorsEJB.getActorsInfoByMovieTitle(title);	
		List<ActorJPAProcessed> actors2 = actorsProcessing(actors);
		
		return actors2;
	}
	
	
	public void setProperties() {
		
		Properties jndiProperties = new Properties();
        jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
        jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
 
		Context context;
		try {
			context = new InitialContext(jndiProperties);
			actorsEJB = (ActorsEJBRemote) context.lookup("projeto2_EAR_WebService/projeto2_EJB/ActorsEJB!ejb.ActorsEJBRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ActorJPAProcessed> actorsProcessing(List<ActorJPA> actorJPA) {
		List<ActorJPAProcessed> processed = new ArrayList<ActorJPAProcessed>(); 
		for (ActorJPA a: actorJPA) {
			ActorJPAProcessed ap = new ActorJPAProcessed(a);
			processed.add(ap);		
		}
		return processed;
	}
	
}