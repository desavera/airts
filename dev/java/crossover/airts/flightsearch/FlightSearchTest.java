package crossover.airts.flightsearch;

import com.sun.grizzly.tcp.Response;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.json.JSONConfiguration; 
import com.sun.jersey.test.framework.JerseyTest; 
import com.sun.jersey.test.framework.WebAppDescriptor; 
import org.junit.Test; 


public class FlightSearchTest extends JerseyTest {
		 	 
	 	    
	 
	    public FlightSearchTest() {  
	         super(new WebAppDescriptor.Builder("no.met.metadataeditor") 
	                .initParam(JSONConfiguration.FEATURE_POJO_MAPPING, "true").build());
	         
	          
	         Client client = ClientBuilder.newClient();
	         client.register(ThirdClientFilter.class);
	          
	         WebTarget webTarget = client.target("http://example.com/rest");
	         webTarget.register(FilterForExampleCom.class);
	         WebTarget resourceWebTarget = webTarget.path("resource");
	         WebTarget helloworldWebTarget = resourceWebTarget.path("helloworld");
	         WebTarget helloworldWebTargetWithQueryParam =
	                 helloworldWebTarget.queryParam("greeting", "Hi World!");
	          
	         Invocation.Builder invocationBuilder =
	                 helloworldWebTargetWithQueryParam.request(MediaType.TEXT_PLAIN_TYPE);
	         invocationBuilder.header("some-header", "true");
	          
	         Response response = invocationBuilder.get();
	         System.out.println(response.getStatus());
	         System.out.println(response.readEntity(String.class));
	    } 
	 
	    @Override 
	    public int getPort(int defaultPort) { 
	        return 8080; 
	    } 
	 
	    public int getPort(){ 
	        return getPort(0); 
	    } 
	 	 
	    @Test 
	    public void test1() { 	   	
	    } 	 
	
}
