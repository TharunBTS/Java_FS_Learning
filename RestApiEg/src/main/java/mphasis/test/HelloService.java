package mphasis.test;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloService {
	
	@GET
	@Path("/text")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello()
	{
		return "This is simple RestAPI plain text response";
	}

}
