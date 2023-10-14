package Bean;

public class RetrieveTopic {

	private String topicName;
	private int duration;
	
	//Constructors for initializing
	public RetrieveTopic(String topicName, int duration) {
		super();
		this.topicName = topicName;
		this.duration = duration;
	}
	
//Getters and setters for accessibility
	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
