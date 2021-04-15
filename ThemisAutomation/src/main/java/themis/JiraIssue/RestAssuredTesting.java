package themis.JiraIssue;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

//import TestCases.GuardianHomePageTestCase;
//import io.restassured.RestAssured;
import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import net.sf.json.JSONObject;
import java.io.*;
import java.net.*;
import javax.json.*;
import java.lang.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

//import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import io.restassured.RestAssured;
public class RestAssuredTesting
{
	public static final Logger log =Logger.getLogger(RestAssuredTesting.class.getName());
	String JiraURL="https://jira.si.fr.intraorange/rest/api/2/issue";
	String username="parminder.kaur@orange.com";
	String password="Parminder@1990";
	
	
	public static String jsonissue="{\r\n" + 
            "   \"fields\":{\r\n" + 
            "      \"project\":{\r\n" + 
            "         \"key\":\"PBM\"\r\n" + 
            "      },\r\n" + 
            "      \"issuetype\":{\r\n" + 
            "         \"name\":\"Bug\"\r\n" + 
            "      },\r\n" + 
            "      \"description\":\"[Bug reported via automation by parminder]\",\r\n" + 
            "      \"summary\":\"[Bug reported via automation by parminder]\",\r\n" + 
            "      \"customfield_10000\" : \"FLIPE-4764\",\r\n" + 
            "      \"customfield_11301\": {\"value\" : \"Recette/UAT\"}\r\n" + 
            "     \r\n" + 
            "     \r\n" + 
            "   }\r\n" + 
            "}";
	
    public Response createJiraBug(String imagePath, String Description) throws ClientProtocolException, IOException
    {
    	log.info("File to be attached to issue is "+imagePath);
    	log.info("Description to be post to issue is "+Description);
		Issuetype issue = new Issuetype("Bug");
        Project project = new Project("IRS");
        Customfield11301 customfield_11301=new Customfield11301("Recette/UAT");
        //Payload  payl = new Payload ("Bug reported via automation by Parminder", "Bug reported Summary via automation by Parminder",
          //      issue, project,"IS-Track Regression Suite",customfield_11301);
                
                Payload  payl = new Payload (Description, "Bug reported Summary via automation by Parminder",
                        issue, project,"IS-Track Regression Suite",customfield_11301);

        Fields fieldpayload = new Fields(payl);

        ObjectMapper objmap = new ObjectMapper();

        String jiraBugJsonPayload = objmap.writerWithDefaultPrettyPrinter().writeValueAsString(fieldpayload);
   
        System.out.println(jiraBugJsonPayload);
        RestAssured.useRelaxedHTTPSValidation();
        //RestAssured.given().when().get(JiraURL.jiraServiceUrl);
        RestAssured.given().when().get(JiraURL);
        RequestSpecification requestSpecification = RestAssured.given();

        //String auth = new StringBuffer(JiraURL.user).append(":").append(JiraURL.pass).toString();
        String auth = new StringBuffer(username).append(":").append(password).toString();
        //byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")));
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")));
        String authHeader = "Basic " + new String(encodedAuth);
        requestSpecification.headers("AUTHORIZATION", authHeader);
        requestSpecification.contentType("application/json");
        requestSpecification.accept("application/json");
        requestSpecification.body(jiraBugJsonPayload.toString());

        System.out.println("end point url.." + JiraURL);
        
        
        Response response1 = requestSpecification.post(JiraURL);
     
        // String encodedData = getJSON_Body();
        return response1;
	}
}

	/*@Test
	public void raiseJiraIssue()
	{
		try {
            //URL url = new URL("https://jira.si.fr.intraorange/secure/Dashboard.jspa/rest/api/2/issue/");
			URL url = new URL("https://jira.si.fr.intraorange/secure/Dashboard.jspa");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
        
            
            
            Response response = null;
            response = RestAssured.given()
            	    .auth().preemptive().basic("parminder.kaur@orange.com", "Parminder@1990")
            	    .when()
            	    .get("/Create");

            	System.out.println("Access Authorized \nStatus Code :" + response.getStatusCode());
            	System.out.println("Response :" + response.asString());

            String encodedData = getJSON_Body();
            System.out.println(encodedData);

            System.out.println(getJSON_Body());
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Basic " + Base64.encode(url.getUserInfo().getBytes()));
            conn.setRequestProperty("Content-Type", "application/json");
            conn.getOutputStream().write(encodedData.getBytes());

            try {
                InputStream inputStream = conn.getInputStream();
                System.out.println(inputStream);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /*private static String getJSON_Body() {
        javax.json.JsonObject createIssue = Json.createObjectBuilder()
                .add("fields",
                        Json.createObjectBuilder().add("project",
                                Json.createObjectBuilder().add("key", "xxxx"))
                                .add("summary", "Test issue")
                                .add("description", "Test Issue")
                                .add("issuetype",
                                        Json.createObjectBuilder().add("name", "Bug"))
                ).build();

        return createIssue.toString();
    }
*/
	/*public void finalJiraIssue(String imagePath,String Description) throws ClientProtocolException, IOException
	{
		RestAssuredTesting service = new RestAssuredTesting();
		Response data = service.createJiraBug(imagePath, Description);
		System.out.println(data.asString());
		Gson gson = new Gson();
		JiraResponse jiraresponse = gson.fromJson(data.asString(), JiraResponse.class);
		log.info(jiraresponse.getId());
		String IssueId=jiraresponse.getId();
		addAttachmentToIssue(imagePath,IssueId);
		/*System.out.println(jiraresponse.getKey());
		System.out.println(jiraresponse.getSelf());
		jiraLinkSelf=jiraresponse.getSelf();*/
/*	}
	public void addAttachmentToIssue(String imagePath,String issueId) throws ClientProtocolException, IOException
	{
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String auth = new StringBuffer(username).append(":").append(password).toString();
	        //byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")));
		 byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")));
		 String authHeader = "Basic " + new String(encodedAuth);
		 //HttpPost httppost = new HttpPost("https://jira.si.fr.intraorange/"+"rest/api/latest/issue/"+issueId+"/Attachments");
		 HttpPost httppost = new HttpPost(JiraURL+issueId+"/attachments");
		 log.info("Attachment of file started");
		 httppost.setHeader("X-Atlassian-Token", "nocheck");
		 httppost.setHeader("Authorization", "Basic "+authHeader);
		 File fileToUpload = new File(imagePath);   
		 FileBody fileBody = new FileBody(fileToUpload);
		 HttpEntity entity = MultipartEntityBuilder.create().addPart("file", fileBody).build();
		 httppost.setEntity(entity);
		 String message = "executing request " + httppost.getRequestLine();
		 log.info(message);   
		 CloseableHttpResponse response;
		 try {
				response = httpclient.execute(httppost);
			} finally {
				httpclient.close();
			}
	}

}

*/

 



