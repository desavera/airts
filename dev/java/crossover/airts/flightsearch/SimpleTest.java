package crossover.airts.flightsearch;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.junit.Test;

import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.research.ws.wadl.Application;

public class SimpleTest extends JerseyTest {
	 
    @Path("hello")
    public static class HelloResource {
        @GET
        public String getHello() {
            return "Hello World!";
        }
    }
 
    @Override
    protected AppDescriptor configure() {
        return new AppDescriptor(HelloResource.class);
    }
 
    @Test
    public void test() {
        final String hello = target("hello").request().get(String.class);
        assertEquals("Hello World!", hello);
    }
}