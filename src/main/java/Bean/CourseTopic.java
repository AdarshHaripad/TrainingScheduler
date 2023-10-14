package Bean;

public class CourseTopic {

	
	    private String topic;
	    private int timeTaken;
	    
	    
		public CourseTopic(String topicName, int duration) {
			this.topic=topicName;
			this.timeTaken=duration;
			// TODO Auto-generated constructor stub
		}
		public String getTopic() {
			return topic;
		}
		public void setTopic(String topic) {
			this.topic = topic;
		}
		public int getTimeTaken() {
			return timeTaken;
		}
		public void setTimeTaken(int timeTaken) {
			this.timeTaken = timeTaken;
		}

		 @Override
		    public String toString() {
		        return "CourseTopic{" +
		                "topic='" + topic + '\'' +
		                ", duration=" + timeTaken +
		                '}';
		    }
	    
	    
}
