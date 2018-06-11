package test;

public class EventData {

	private String id;
	private String state;
	private long timestamp;
	private String type;
	private int host;
	boolean alert;
	
	
	EventData(){
		
	}

	public boolean isAlert() {
		return alert;
	}

	public void setAlert(boolean alert) {
		this.alert = alert;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHost() {
		return host;
	}

	public void setHost(int host) {
		this.host = host;
	}
	
	
}
