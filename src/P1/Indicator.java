package P1;



import java.util.Calendar;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Indicator {
	
	Team team1;
	Team team2 ;
	protected TableView table = new TableView();
	Stage stage = new Stage();
	Text textScroe1;
	Text textScroe2;
	PlayTime playtime;
	Text textTimeSecond;
	Text textTimeMinute;
	Timeline animation;
	Timeline animation2;
	String photo1 = null;
	String photo2 = null;
	Text textNowTime;
	Calendar c;
	int year = 0;
	int month = 0;
	int day = 0;
	int hour = 0;
	int minute = 0;
	int second = 0;
	String [] teams = {"公牛","湖人","火箭","猛龙","骑士","勇士"};
	String [] teamsphoto = {"Image/公牛.jpg","Image/湖人.png","Image/火箭.png","Image/猛龙.jpg","Image/骑士.png","Image/勇士.png"};
	
	
	protected final ObservableList<Data> dt = 
			FXCollections.observableArrayList();
	public Indicator(Team team1,Team team2,int time) {
		// TODO Auto-generated constructor stub
		this.team1 = team1;
		this.team2 = team2;
		playtime = new PlayTime(time);
	}
	
	protected void getPane() {
		
		Scene scene = new Scene(new Group());
		stage.setTitle("文字直播显示器");
		stage.setWidth(1000);
		stage.setHeight(550);
		
		BorderPane borderpane = new BorderPane();
		
		
		Pane pane = new Pane();
		Text textTeamName1 = new Text(150,50,team1.TeamName);
		Text textTeamName2 = new Text(700,50,team2.TeamName);
		textTeamName1.setFont(Font.font("Arial",FontWeight.BOLD,50));
		textTeamName2.setFont(Font.font("Arial",FontWeight.BOLD,50));
		pane.getChildren().addAll(textTeamName1,textTeamName2);
		textScroe1 = new Text(180,100,team1.Score + "");
		textScroe2 = new Text(730,100,team1.Score + "");
		textScroe1.setFont(Font.font("Arial",45 ));
		textScroe2.setFont(Font.font("Arial",45 ));
		textScroe1.setFill(Color.RED);
		textScroe2.setFill(Color.RED);
		pane.getChildren().addAll(textScroe1,textScroe2);
		
		for(int i = 0;i < teams.length; i ++) {
			if(team1.TeamName.equals(teams[i])) {
				photo1 = new String(teamsphoto[i]);
			}
			if(team2.TeamName.equals(teams[i])) {
				photo2 = new String(teamsphoto[i]);
			}
		}
		if(photo1 == null) {
			photo1 = new String("Image/无.png");
		}
		if(photo2 == null) {
			photo2 = new String("Image/无.png");
		}
		 
		
		//photo1 = new String("Image/"+team1.TeamName +  ".jpg");
		Image image1 = new Image(photo1);
		ImageView imageview1 = new ImageView(image1);
		imageview1.setX(30);
		imageview1.setY(30);
		pane.getChildren().addAll(imageview1);
		//photo2 = new String("Image/"+team2.TeamName+".jpg");
		Image image2 = new Image(photo2);
		ImageView imageview2 = new ImageView(image2);
		imageview2.setX(850);
		imageview2.setY(30);
		pane.getChildren().addAll(imageview2);
		
		Image image3 = new Image("Image/NBA.jpg");
		ImageView imageview3 = new ImageView(image3);
		imageview3.setX(400);
		imageview3.setY(0);
		pane.getChildren().addAll(imageview3);
		
		textTimeMinute = new Text(410,100,playtime.minute+":");
		if(playtime.minute < 10 && playtime.minute >= 0) {
			textTimeMinute.setText("0" +playtime.minute+":");
		}
		textTimeSecond = new Text(480,100,playtime.second +"0");
		textTimeMinute.setFont(Font.font("Arial",45 ));
		textTimeSecond.setFont(Font.font("Arial",45 ));
		pane.getChildren().addAll(textTimeSecond,textTimeMinute);
		
		c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH)+1;
		day = c.get(Calendar.DATE);
		hour = c.get(Calendar.HOUR_OF_DAY);
		minute = c.get(Calendar.MINUTE);
		second = c.get(Calendar.SECOND);
		if(second >=0 &&second < 10) {
			textNowTime= new Text(400,120,year +"-"+ month +"-" + day + " " + hour +":" + minute +":0" +second);
		}
		else if(minute >=0 && minute < 10) {
			textNowTime= new Text(400,120,year +"-"+ month +"-" + day + " " + hour +":0" + minute +":" +second);
		}
		else {
			textNowTime= new Text(400,120,year +"-"+ month +"-" + day + " " + hour +":" + minute +":" +second);

		}	
		

		textNowTime.setFont(Font.font("Arial",18 ));
		pane.getChildren().add(textNowTime);
		
		
		EventHandler<ActionEvent> eventHandler2 = e -> {
			c = Calendar.getInstance();
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH)+1;
			day = c.get(Calendar.DATE);
			hour = c.get(Calendar.HOUR_OF_DAY);
			minute = c.get(Calendar.MINUTE);
			second = c.get(Calendar.SECOND);
			if(second >=0 &&second < 10) {
				textNowTime.setText(year +"-"+ month +"-" + day + " " + hour +":" + minute +":0" +second);
			}
			else if(minute >=0 && minute < 10) {
				textNowTime.setText(year +"-"+ month +"-" + day + " " + hour +":0" + minute +":" +second);
			}
			else {
				textNowTime.setText(year +"-"+ month +"-" + day + " " + hour +":" + minute +":" +second);

			}	
		};
		 
		
		animation2 = new Timeline(new KeyFrame(Duration.millis(1000),eventHandler2));
		animation2.setCycleCount(Timeline.INDEFINITE);
		animation2.play();
		
		EventHandler<ActionEvent> eventHandler = e -> {
			
			if(playtime.second == 0 && playtime.minute == 0) {
				textTimeSecond.setText( "00:00");
			}
			
			
			if(playtime.second == 0) {
				if(playtime.minute == 0) {
					textTimeSecond.setText( "00:00");
				}
				else {
					playtime.setSecond(59);
					playtime.minute--;
				}
			}
			else {
				playtime.second--;
			}
			
			if(playtime.second < 10 && playtime.second >= 0) {
				textTimeSecond.setText( "0" + playtime.second);
			}
			else {
				textTimeSecond.setText(playtime.second + "");
			} 
			if(playtime.minute < 10 && playtime.minute >= 0) {
				textTimeMinute.setText("0" +playtime.minute+":");
			}
			else {
				textTimeMinute.setText(playtime.minute+":");
			}
			
			
		};
		
		animation = new Timeline(new KeyFrame(Duration.millis(1000),eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
		table.setEditable(true);
		
		TableColumn timeCol = new TableColumn("时间");
		timeCol.setMinWidth(100);
		timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
		TableColumn teamCol = new TableColumn("球队");
		teamCol.setMinWidth(100);
		teamCol.setCellValueFactory(new PropertyValueFactory<>("team"));
		TableColumn memberCol = new TableColumn("球员");
		memberCol.setMinWidth(100);
		memberCol.setCellValueFactory(new PropertyValueFactory<>("member"));
		TableColumn dataCol = new TableColumn("事件");
		dataCol.setMinWidth(600);
		dataCol.setCellValueFactory(new PropertyValueFactory<>("data"));
		TableColumn scoreCol = new TableColumn("比分");
		scoreCol.setMinWidth(100);
		scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
		
		table.setItems(dt);
		table.getColumns().addAll(timeCol,teamCol,memberCol,dataCol,scoreCol);
		
		dt.add(new Data("12:00",team1.TeamName," ","对阵阵容:"+team1.TeamMemberName1+","+team1.TeamMemberName2+","+team1.TeamMemberName3+","+team1.TeamMemberName4+","+team1.TeamMemberName5,"0:0"));
		dt.add(new Data("12:00",team2.TeamName," ","对阵阵容:"+team2.TeamMemberName1+","+team2.TeamMemberName2+","+team2.TeamMemberName3+","+team2.TeamMemberName4+","+team2.TeamMemberName5,"0:0"));
		borderpane.setTop(pane);
		borderpane.setAlignment(pane, Pos.CENTER);
	    borderpane.setCenter(table);
	    borderpane.setAlignment(table, Pos.CENTER);
	    
		((Group)scene.getRoot()).getChildren().addAll(borderpane);
		
		
		stage.setScene(scene);
		stage.show();
		
	}
 
}
