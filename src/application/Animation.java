package application;
	

import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Sphere;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Box;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;


public class Animation extends Application{
	
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	
	Sphere sphere;
	Cylinder cylinder;
	Box box;
	Polygon triangle;
	
	GridPane grid;
	
	
	@Override
    public void start(Stage stage) {
		
		BorderPane root = new BorderPane();
		
		grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		/*grid.setPadding(new Insets(6,3,6,3));
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPrefColumns(2);*/
		grid.setStyle("-fx-background-color: #81BEF7");
		
        sphere = new Sphere(50);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.RED);
        sphere.setMaterial(material);

        cylinder = new Cylinder();
        cylinder.setRadius(50);
        cylinder.setHeight(80);
        PhongMaterial material2 = new PhongMaterial();
        material2.setDiffuseColor(Color.ORANGE);
        cylinder.setMaterial(material2);


        box = new Box();
        box.setHeight(100);
        box.setDepth(120);
        box.setWidth(150);
        PhongMaterial material3 = new PhongMaterial();
        material3.setDiffuseColor(Color.GREEN);
        box.setMaterial(material3);
        
        triangle = new Polygon();
        triangle.getPoints().addAll(50.0, 0.0,  0.0, 50.0,100.0, 50.0);
        triangle.setFill(Color.YELLOW);
        triangle.setStroke(Color.BLACK);
        
        b1 = new Button("Rotate Transition");
		b2 = new Button("Scale Transition");
		b3 = new Button("Fade Transition");
		b4 = new Button("Sequential Transition");
		
		ButtonHandler handler = new ButtonHandler();       
        b1.setOnAction(handler);
        b2.setOnAction(handler);
        b3.setOnAction(handler);
        b4.setOnAction(handler);
        
        grid.add(sphere, 0, 0, 1, 1);
        grid.add(cylinder, 1, 0, 1, 1);
        grid.add(box, 0, 1, 1, 1);
        grid.add(triangle, 1, 1, 1, 1);
        
        grid.add(b1, 0, 3, 1, 1);
        grid.add(b2, 0, 4, 1, 1);
        grid.add(b3, 0, 5, 1, 1);
        grid.add(b4, 0, 6, 1, 1);
        root.setBottom(grid);
        
        //grid.getChildren().addAll(sphere,cylinder,box,triangle, b1, b2, b3, b4);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setX(200);
        stage.setY(300);
        stage.setMinHeight(200);
        stage.setMinWidth(350);
        stage.setTitle("Grid of Shapes");
        stage.show();
	}

	
	
	
	class ButtonHandler implements EventHandler<ActionEvent> 
    { 
		public void handle(ActionEvent e) {
			if(e.getSource() == b1) {
				 RotateTransition ft = new RotateTransition(Duration.millis(3000),box);
			     ft.setFromAngle(50.0);
			     ft.setCycleCount(4);
			     ft.setAutoReverse(true);
			 
			     ft.play();
			}
			if(e.getSource() == b2) {
				 ScaleTransition ft = new ScaleTransition(Duration.millis(3000), sphere);
			     ft.setByX(1.5);
			     ft.setByY(2.0);
			     ft.setCycleCount(4);
			     ft.setAutoReverse(true);
			 
			     ft.play();
			}
			if(e.getSource() == b3) {
				 FadeTransition ft = new FadeTransition(Duration.millis(3000),grid);
			     ft.setFromValue(1.0);
			     ft.setToValue(0.3);
			     ft.setCycleCount(4);
			     ft.setAutoReverse(true);
			 
			     ft.play();
			}
			if(e.getSource() == b4) {
				Duration dur1 = Duration.millis(1000);  
		        Duration dur2 = Duration.millis(500);  
				//Setting the pause transition  
		         PauseTransition pause = new PauseTransition(Duration.millis(1000));  
		           
		         //Setting the fade transition   
		         FadeTransition fade = new FadeTransition(dur2);  
		         fade.setFromValue(1.0f);  
		         fade.setToValue(0.3f);  
		         fade.setCycleCount(2);  
		         fade.setAutoReverse(true);  
		           
		         //Setting Translate transition  
		         TranslateTransition translate = new TranslateTransition(dur1);  
		         translate.setToX(-150f);  
		         translate.setCycleCount(2);  
		         translate.setAutoReverse(true);  
		           
		         //Setting Rotate Transition   
		         RotateTransition rotate = new RotateTransition(dur2);  
		         rotate.setByAngle(180f);  
		         rotate.setCycleCount(4);  
		         rotate.setAutoReverse(true);  
		           
		         //Setting Scale Transition   
		         ScaleTransition scale = new ScaleTransition(dur1);  
		         scale.setByX(1.5f);  
		         scale.setByY(1.2f);  
		         scale.setCycleCount(2);  
		         scale.setAutoReverse(true);  
		           
		         //Instantiating Sequential Transition class by passing the list of transitions into its constructor  
		         SequentialTransition seqT = new SequentialTransition (triangle,rotate, pause, fade, translate,  scale);  
		           
		         //playing the transition   
		         seqT.play();
			}
		}	
		
		
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
