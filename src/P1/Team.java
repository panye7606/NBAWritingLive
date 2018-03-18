package P1;

public class Team {
	protected String TeamName;
	protected String TeamMemberName1;
	protected String TeamMemberName2;
	protected String TeamMemberName3;
	protected String TeamMemberName4;
	protected String TeamMemberName5;
	protected int Score;
	
	public Team(String teamName, String teamMemberName1, String teamMemberName2, String teamMemberName3,
			String teamMemberName4, String teamMemberName5) {
		super();
		TeamName = teamName;
		TeamMemberName1 = teamMemberName1;
		TeamMemberName2 = teamMemberName2;
		TeamMemberName3 = teamMemberName3;
		TeamMemberName4 = teamMemberName4;
		TeamMemberName5 = teamMemberName5;
		Score = 0;
	}

	public Team() {
		// TODO Auto-generated constructor stub
		Score = 0;
	}
	
	
	
}
