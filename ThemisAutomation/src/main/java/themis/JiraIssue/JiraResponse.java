package themis.JiraIssue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JiraResponse {

	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("key")
	@Expose
	private String key;
	@SerializedName("self")
	@Expose
	private String self;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

}