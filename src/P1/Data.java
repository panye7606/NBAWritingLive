package P1;

import javafx.beans.property.SimpleStringProperty;

public class Data {
	
	protected final SimpleStringProperty time;
	protected final SimpleStringProperty team;
	protected final SimpleStringProperty member;
	protected final SimpleStringProperty data;
	protected final SimpleStringProperty score;
	
	public Data(String time, String team, String member, String data, String score) {
		super();
		this.time = new SimpleStringProperty(time);
		this.team = new SimpleStringProperty(team);
		this.member = new SimpleStringProperty(member);
		this.data = new SimpleStringProperty(data);
		this.score = new SimpleStringProperty(score);
	}
	
	public String getTime() {
		return time.get();
	}
	
	public void setTime(String time) {
		this.time.set(time);
	}
	public String getTeam() {
		return team.get();
	}
	public void setTeam(String team) {
		this.team.set(team);
	}
	public String getMember() {
		return member.get();
	}
	public void setMember(String member) {
		this.team.set(member);
	}
	public String getData() {
		return data.get();
	}
	public void setData(String data) {
		this.data.set(data);
	}
	public String getScore() {
		return score.get();
	}
	public void setScore(String score) {
		this.score.set(score);
	}
	
	

}
