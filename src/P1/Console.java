package P1;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Console extends Application {
	
	protected InformationWindow informatoin = new InformationWindow();  
	protected Indicator indicator;
	protected AddData addData;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		button1 = new Button("���ӱ���");
		button2 = new Button("������ʼ");
		button3 = new Button("����¼�");
		button4 = new Button("������ͣ");
		button5 = new Button("��������");
		
		BorderPane pane = new BorderPane();
		
		VBox vbox = new VBox(20);
		vbox.setPadding(new Insets(20,20,20,100));
		vbox.getChildren().add(button1);
		vbox.getChildren().add(button2);
		vbox.getChildren().add(button3);
		vbox.getChildren().add(button4);
		vbox.getChildren().add(button5);
		
		button1.setOnAction(e -> IncreaseMatch());
		button2.setOnAction(e -> gameStart());
		button3.setOnAction(e -> AddInformation());
		button4.setOnAction(e -> gamepause());
		button5.setOnAction(e -> gameover());
		pane.setCenter(vbox);
		
		Scene scene = new Scene(pane,300,300);
		primaryStage.setTitle("����̨");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private Object gameover() {
		// TODO Auto-generated method stub
		indicator.stage.close();
		return null;
	}

	private void gamepause() {
		// TODO Auto-generated method stub
		if(indicator.animation.getStatus() == Animation.Status.PAUSED) {
			indicator.animation.play();
			button4.setText("������ͣ");
		}
		else {
			indicator.animation.pause();
			button4.setText("��������");
		}
		
	}

	private void AddInformation() {
		// TODO Auto-generated method stub
		addData = new AddData(informatoin.team1, informatoin.team2,indicator);
		addData.getPane();
	}

	private void IncreaseMatch() {
		// TODO Auto-generated method stub
		informatoin.getPane();
	}
	
	private void gameStart() {
		// TODO Auto-generated method stub
		indicator = new Indicator(informatoin.team1, informatoin.team2,informatoin.time);
		indicator.getPane();

	}
	public static void main(String[] args) {
		Application.launch(args);
	}
	

}
