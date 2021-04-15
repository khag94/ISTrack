package themis.JiraIssue;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"project",
"issuetype",
"description",
"summary",
"customfield_10000",
"customfield_11301"
})
public class Payload {
	
	String description;
	String summary;
	Issuetype issuetype;
	Project project;
	String customfield10000;
	Customfield11301 customfield11301;
	
	public Payload(String description, String summary, Issuetype issuetype, Project project,
			String customfield_10000,Customfield11301 customfield_11301) {
		this.description = description;
		this.summary = summary;
		this.issuetype = issuetype;
		this.project = project;
		this.customfield10000=customfield_10000;
		this.customfield11301 = customfield_11301;
	
	}
	
/*@JsonProperty("project")
private Project project;
@JsonProperty("issuetype")
private Issuetype issuetype;
@JsonProperty("description")
private String description;
@JsonProperty("summary")
private String summary;
@JsonProperty("customfield_10000")
private String customfield10000;
@JsonProperty("customfield_11301")
private Customfield11301 customfield11301;*/
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("project")
public Project getProject() {
return project;
}

@JsonProperty("project")
public void setProject(Project project) {
this.project = project;
}

@JsonProperty("issuetype")
public Issuetype getIssuetype() {
return issuetype;
}

@JsonProperty("issuetype")
public void setIssuetype(Issuetype issuetype) {
this.issuetype = issuetype;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("summary")
public String getSummary() {
return summary;
}

@JsonProperty("summary")
public void setSummary(String summary) {
this.summary = summary;
}

@JsonProperty("customfield_10000")
public String getCustomfield10000() {
return customfield10000;
}

@JsonProperty("customfield_10000")
public void setCustomfield10000(String customfield10000) {
this.customfield10000 = customfield10000;
}

@JsonProperty("customfield_11301")
public Customfield11301 getCustomfield11301() {
return customfield11301;
}

@JsonProperty("customfield_11301")
public void setCustomfield11301(Customfield11301 customfield11301) {
this.customfield11301 = customfield11301;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
