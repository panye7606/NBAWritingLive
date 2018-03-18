package P1;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InformationWindow {
	
	Team team1 = new Team("骑士","骑士1","骑士2","骑士3","骑士4","骑士5");
	Team team2 = new Team("勇士","勇士1","勇士2","勇士3","勇士4","勇士5");
	int time = 12;
	Stage stage = new Stage();
	protected TextField tfTeamOne = new TextField();
	protected TextField tfTeamOneMember1 = new TextField();
	protected TextField tfTeamOneMember2 = new TextField();
	protected TextField tfTeamOneMember3 = new TextField();
	protected TextField tfTeamOneMember4 = new TextField();
	protected TextField tfTeamOneMember5 = new TextField();
	protected TextField tfTeamTwo = new TextField();
	protected TextField tfTeamTwoMember1 = new TextField();
	protected TextField tfTeamTwoMember2 = new TextField();
	protected TextField tfTeamTwoMember3 = new TextField();
	protected TextField tfTeamTwoMember4 = new TextField();
	protected TextField tfTeamTwoMember5 = new TextField();
	protected TextField tfTime = new TextField();
	protected Button btConfirm = new Button("确定");
	
	protected GridPane getPane() {
		GridPane pane = new GridPane();
		pane.setHgap(5);
		pane.setVgap(5);
		pane.add(new Label("球队1："),0,0);
		pane.add(tfTeamOne, 1, 0);
		pane.add(new Label("球队1成员1："),0,1);
		pane.add(tfTeamOneMember1, 1, 1);
		pane.add(new Label("球队1成员2："),0,2);
		pane.add(tfTeamOneMember2, 1, 2);
		pane.add(new Label("球队1成员3："),0,3);
		pane.add(tfTeamOneMember3, 1, 3);
		pane.add(new Label("球队1成员4："),0,4);
		pane.add(tfTeamOneMember4, 1, 4);
		pane.add(new Label("球队1成员5："),0,5);
		pane.add(tfTeamOneMember5, 1, 5);
		pane.add(new Label("球队2："),0,6);
		pane.add(tfTeamTwo, 1, 6);
		pane.add(new Label("球队2成员1："),0,7);
		pane.add(tfTeamTwoMember1, 1, 7);
		pane.add(new Label("球队2成员2："),0,8);
		pane.add(tfTeamTwoMember2, 1, 8);
		pane.add(new Label("球队2成员3："),0,9);
		pane.add(tfTeamTwoMember3, 1, 9);
		pane.add(new Label("球队2成员4："),0,10);
		pane.add(tfTeamTwoMember4, 1, 10);
		pane.add(new Label("球队2成员5："),0,11);
		pane.add(tfTeamTwoMember5, 1, 11);
		pane.add(new Label("比赛时间(分钟)："),0,12);
		pane.add(tfTime, 1, 12);
		pane.add(btConfirm,1,13);
		
		pane.setAlignment(Pos.CENTER);
		tfTeamOne.setAlignment(Pos.BOTTOM_RIGHT);
		tfTeamOneMember1.setAlignment(Pos.BOTTOM_RIGHT);
		tfTeamOneMember2.setAlignment(Pos.BOTTOM_RIGHT);
		tfTeamOneMember3.setAlignment(Pos.BOTTOM_RIGHT);
		tfTeamOneMember4.setAlignment(Pos.BOTTOM_RIGHT);
		tfTeamOneMember5.setAlignment(Pos.BOTTOM_RIGHT);
		tfTeamTwo.setAlignment(Pos.BOTTOM_RIGHT);
		tfTeamTwoMember1.setAlignment(Pos.BOTTOM_RIGHT);
		tfTeamTwoMember2.setAlignment(Pos.BOTTOM_RIGHT);
		tfTeamTwoMember3.setAlignment(Pos.BOTTOM_RIGHT);
		tfTeamTwoMember4.setAlignment(Pos.BOTTOM_RIGHT);
		tfTeamTwoMember5.setAlignment(Pos.BOTTOM_RIGHT);
		tfTime.setAlignment(Pos.BOTTOM_RIGHT);
		
		pane.setHalignment(btConfirm, HPos.RIGHT);
		
		btConfirm.setOnAction(e -> confirm());
		
		
		Scene scene1 = new Scene(pane,500,500);
		stage.setTitle("信息");
		stage.setScene(scene1);
		stage.show();
		return pane;
		
	}

	private void confirm() {
		// TODO Auto-generated method stub
		team1.TeamName = tfTeamOne.getText();
		team1.TeamMemberName1 = tfTeamOneMember1.getText();
		team1.TeamMemberName2 = tfTeamOneMember2.getText();
		team1.TeamMemberName3 = tfTeamOneMember3.getText();
		team1.TeamMemberName4 = tfTeamOneMember4.getText();
		team1.TeamMemberName5 = tfTeamOneMember5.getText();
		team2.TeamName = tfTeamTwo.getText();
		team2.TeamMemberName1 = tfTeamTwoMember1.getText();
		team2.TeamMemberName2 = tfTeamTwoMember2.getText();
		team2.TeamMemberName3 = tfTeamTwoMember3.getText();
		team2.TeamMemberName4 = tfTeamTwoMember4.getText();
		team2.TeamMemberName5 = tfTeamTwoMember5.getText();
		time = Integer.parseInt(tfTime.getText());
		stage.close();
		
	}

}
