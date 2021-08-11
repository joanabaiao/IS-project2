package jms;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Sender {
	
    private ConnectionFactory connectionFactory;
    private Destination destination;

    public Sender() throws NamingException {
    	
		this.connectionFactory = InitialContext.doLookup("jms/RemoteConnectionFactory");
		this.destination = InitialContext.doLookup("jms/queue/serverQueue");
    }

    public String send(String text) {
    	
    	String str = "";
        
        try (JMSContext context = connectionFactory.createContext("john", "!1secret");) {
        	
            JMSProducer messageProducer = context.createProducer();         
            TextMessage msg = context.createTextMessage();
            Destination tmp = context.createTemporaryQueue();
			
			msg.setJMSReplyTo(tmp);		
			msg.setStringProperty("request", text);
			
			messageProducer.send(destination, msg);
			
			JMSConsumer cons = context.createConsumer(tmp);
			str = cons.receiveBody(String.class);
        }
        
        catch (Exception re) {
            re.printStackTrace();
        }
        return str;
    }
}
