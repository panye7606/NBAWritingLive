package P1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddData {
	
	protected Team team1;
	protected Team team2;
	protected Indicator indicator;
	Button button = new Button("确定");
	ComboBox<String> cbTeam = new ComboBox<>();	
	ComboBox<String> cbTeamMember = new ComboBox<>();
	ComboBox<String> cbData = new ComboBox<>();
	protected Stage stage = new Stage();
	protected String[] TeamName = new String[2];
	protected String[] TeamMember = new String[10];
	protected String[] Data = {"二分不中","二分球进","扣篮","三分不中","三分球进","篮板球","暂停","失误","犯规","罚球不中","罚球命中"};
	ObservableList<String> itemsTeam;
	ObservableList<String> itemsTeamMember;
	ObservableList<String> itemsData;
	AddData(Team team1,Team team2,Indicator indicator) {
		this.team1 = team1;
		this.team2 = team2;
		this.indicator = indicator;
	}
	
	protected void getPane() {
		
		GridPane pane = new GridPane();
		pane.setHgap(5);
		pane.setVgap(5);
		
		Label labelTeamName = new Label("球队");
		Label labelMember = new Label("球员");
		Label labelData = new Label("事件");
		
		TeamName[0] = team1.TeamName;
		TeamName[1] = team2.TeamName;
		TeamMember[0] = team1.TeamMemberName1;
		TeamMember[1] = team1.TeamMemberName2;
		TeamMember[2] = team1.TeamMemberName3;
		TeamMember[3] = team1.TeamMemberName4;
		TeamMember[4] = team1.TeamMemberName5;
		TeamMember[5] = team2.TeamMemberName1;
		TeamMember[6] = team2.TeamMemberName2;
		TeamMember[7] = team2.TeamMemberName3;
		TeamMember[8] = team2.TeamMemberName4;
		TeamMember[9] = team2.TeamMemberName5;
		
		itemsTeam = FXCollections.observableArrayList(TeamName);
		itemsTeamMember = FXCollections.observableArrayList(TeamMember);
		itemsData = FXCollections.observableArrayList(Data);
		
		pane.add(labelTeamName, 0, 0);
		pane.add(cbTeam,1,0);
		pane.add(labelMember, 0, 1);
		pane.add(cbTeamMember, 1, 1);
		pane.add(labelData, 0, 2);
		pane.add(cbData, 1, 2);
		pane.add(button, 1, 3);
		
		pane.setAlignment(Pos.CENTER);
		pane.setHalignment(button, HPos.RIGHT);
		
		cbTeam.getItems().addAll(itemsTeam);
		

		
		cbTeamMember.getItems().addAll(itemsTeamMember);
		

	
		cbData.getItems().addAll(itemsData);
		
		cbTeam.setMinWidth(200);
		cbTeamMember.setMinWidth(200);
		cbData.setMinWidth(200);
		
		button.setOnAction(e ->  start());
		
		Scene scene = new Scene(pane,400,400);
		stage.setScene(scene);
		stage.setTitle("添加事件");
		stage.show();
	}

	private void start() {
		// TODO Auto-generated method stub
		String strTeam = cbTeam.getValue();
		String strTeamMember = cbTeamMember.getValue();
		String strData = cbData.getValue();
		if(itemsTeam.indexOf(strTeam) == 0) {
			if(itemsData.indexOf(strData) == 1 ||itemsData.indexOf(strData) == 2) {
				team1.Score += 2;
			}
			else if(itemsData.indexOf(strData) == 4) {
				team1.Score += 3;
			}
			else if(itemsData.indexOf(strData) == 10) {
				team1.Score += 1;
			}
		}
		else {
			if(itemsData.indexOf(strData) == 1 ||itemsData.indexOf(strData) == 2) {
				team2.Score += 2;
			}
			else if(itemsData.indexOf(strData) == 4) {
				team2.Score += 3;
			}
			else if(itemsData.indexOf(strData) == 10) {
				team2.Score += 1;
			}
		}
		Data dt1 = new Data(indicator.playtime.str(),strTeam,strTeamMember,strData,team1.Score + ":"+team2.Score);
		indicator.dt.add(dt1);
		indicator.textScroe1.setText(team1.Score+"");
		indicator.textScroe2.setText(team2.Score+"");
		stage.close();
	}

}
