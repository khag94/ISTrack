package themis.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.openqa.selenium.*;

@Provider
public class NoSuchWindowMapper implements ExceptionMapper<NoSuchWindowException>
{
	@Override
	//public Response toResponse(NoSuchWindowException e) {
	public Response toResponse(NoSuchWindowException e) {
		// TODO Auto-generated method stub
		//return null;
	
		return Response.status(500).entity(e.getMessage()).build();
		//return Ex;
	}

	
	
}
