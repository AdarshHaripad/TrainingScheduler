package Bean;

import java.util.Date;

public class ScheduledTopic {
	
	private String topic;
	private Date StartDate;
	private Date EndDate;
	public ScheduledTopic(String topic, Date startDate, Date endDate) {
		super();
		this.topic = topic;
		StartDate = startDate;
		EndDate = endDate;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	
@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}

}
