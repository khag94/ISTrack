package themis.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.openqa.selenium.TimeoutException;

@Provider
public class TimeOutMapper implements ExceptionMapper<TimeoutException>
{
	@Override
	public Response toResponse(TimeoutException e) {
		// TODO Auto-generated method stub
		//return null;
		return Response.status(500).entity(e.getMessage()).build();
		//return Response.status(504).entity(e.getMessage()).build();
	}

}
