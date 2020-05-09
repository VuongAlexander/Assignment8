package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application{	
	
		Button b7;
		Button b8;
		Button b9;
		Button bDIV;
	
		Button b4;
		Button b5;
		Button b6;
		Button bMUL;
	
		Button b1;
		Button b2;
		Button b3;
		Button bSUB;
	
		Button b0;
		Button bDOT;
		Button bEQU;
		Button bADD;
	
		Button bCLR;
		
		TextField tf;
	
	public void start(Stage primaryStage) throws Exception {
		tf = new TextField();
		BorderPane root = new BorderPane();
		GridPane keyPad = new GridPane();
		root.setTop(tf);
		root.setCenter(keyPad);
		
		b7 = new Button("7");
		b8 = new Button("8");
		b9 = new Button("9");
		bDIV = new Button("/");
		
		b4 = new Button("4");
		b5 = new Button("5");
		b6 = new Button("6");
		bMUL = new Button("*");
		
		b1 = new Button("1");
		b2 = new Button("2");
		b3= new Button("3");
		bSUB= new Button("-");
		
		b0 = new Button("0");
		bDOT = new Button(".");
		bEQU = new Button("=");
		bADD = new Button("+");
		
		bCLR = new Button("AC");
		
		setButtonSize(b1);
        setButtonSize(b2);
        setButtonSize(b3);
        setButtonSize(b4);
        setButtonSize(b5);
        setButtonSize(b6);
        setButtonSize(b7);
        setButtonSize(b8);
        setButtonSize(b9);
        setButtonSize(b0);
        setButtonSize(bDOT);
        setButtonSize(bDIV);
        setButtonSize(bMUL);
        setButtonSize(bSUB);
        setButtonSize(bADD);
        setButtonSize(bEQU);
        
     // attach a handler to process button clicks 
        ButtonHandler handler = new ButtonHandler();       
        b1.setOnAction(handler);
        b2.setOnAction(handler);
        b3.setOnAction(handler);
        b4.setOnAction(handler);
        b5.setOnAction(handler);
        b6.setOnAction(handler);
        b7.setOnAction(handler);
        b8.setOnAction(handler);
        b9.setOnAction(handler);
        b0.setOnAction(handler);
        bDOT.setOnAction(handler);
        bDIV.setOnAction(handler);
        bMUL.setOnAction(handler);
        bSUB.setOnAction(handler);
        bADD.setOnAction(handler);
        bEQU.setOnAction(handler);
        bCLR.setOnAction(handler);
        
        keyPad.add(b7, 0, 0);
        b7.setStyle("-fx-font-size: 2em; ");
        keyPad.add(b8, 1, 0);
        b8.setStyle("-fx-font-size: 2em; ");
        keyPad.add(b9, 2, 0);
        b9.setStyle("-fx-font-size: 2em; ");
        keyPad.add(bDIV, 3, 0);
        bDIV.setStyle("-fx-font-size: 2em; -fx-text-fill: #ff0000");
        
        keyPad.add(b4, 0, 1);
        b4.setStyle("-fx-font-size: 2em; ");
        keyPad.add(b5, 1, 1);
        b5.setStyle("-fx-font-size: 2em; ");
        keyPad.add(b6, 2, 1);
        b6.setStyle("-fx-font-size: 2em; ");
        keyPad.add(bMUL, 3, 1);
        bMUL.setStyle("-fx-font-size: 2em; -fx-text-fill: #ff0000");
        
        keyPad.add(b1, 0, 2);
        b1.setStyle("-fx-font-size: 2em; ");
        keyPad.add(b2, 1, 2);
        b2.setStyle("-fx-font-size: 2em; ");
        keyPad.add(b3, 2, 2);
        b3.setStyle("-fx-font-size: 2em; ");
        keyPad.add(bSUB, 3, 2);
        bSUB.setStyle("-fx-font-size: 2em; -fx-text-fill: #ff0000");
        
        keyPad.add(b0, 0, 3);
        b0.setStyle("-fx-font-size: 2em; ");
        keyPad.add(bDOT, 1, 3);
        bDOT.setStyle("-fx-font-size: 2em; ");
        keyPad.add(bEQU, 2, 3);
        bEQU.setStyle("-fx-background-color: #00ff00; -fx-font-size: 2em; ");
        keyPad.add(bADD, 3, 3);
        bADD.setStyle("-fx-font-size: 2em; -fx-text-fill: #ff0000");
        
        keyPad.add(bCLR, 0, 4, 4, 4);
        bCLR.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        bCLR.setStyle("-fx-border-color: #00ff00; -fx-background-color: #0000FF");
        
		
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Calculator");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	public void setButtonSize(Button button){
		button.setPrefHeight(35);
		button.setPrefWidth(45);
	}
	
	// Handler for processing the button clicks 
    class ButtonHandler implements EventHandler<ActionEvent> 
    { 
    	Double num1 = 0.0;
	    int cases = -1;
	    
    	public void handle(ActionEvent e) {
        	if(e.getSource() == b1) {
        		tf.setText(tf.getText() + "1");
        	} else if(e.getSource() == b2) {
        		tf.setText(tf.getText() + "2");
        	} else if(e.getSource() == b3) {
        		tf.setText(tf.getText() + "3");
        	} else if(e.getSource() == b4) {
        		tf.setText(tf.getText() + "4");
        	} else if(e.getSource() == b5) {
        		tf.setText(tf.getText() + "5");
        	} else if(e.getSource() == b6) {
        		tf.setText(tf.getText() + "6");
        	} else if(e.getSource() == b7) {
        		tf.setText(tf.getText() + "7");
        	} else if(e.getSource() == b8) {
        		tf.setText(tf.getText() + "8");
        	} else if(e.getSource() == b9) {
        		tf.setText(tf.getText() + "9");
        	} else if(e.getSource() == b0) {
        		tf.setText(tf.getText() + "0");
        	} else if(e.getSource() == bCLR) {
        		tf.setText("");
        	} else if(e.getSource() == bADD) {
        		num1 = Double.parseDouble(tf.getText());
        		cases = 1;
        		tf.setText("");
        	} else if(e.getSource() == bSUB) {
        		num1 = Double.parseDouble(tf.getText());
        		cases = 2;
        		tf.setText("");
        	} else if(e.getSource() == bMUL) {
        		num1 = Double.parseDouble(tf.getText());
        		cases = 3;
        		tf.setText("");
        	} else if(e.getSource() == bDIV) {
        		num1 = Double.parseDouble(tf.getText());
        		cases = 4;
        		tf.setText("");	
        	} else if(e.getSource() == bEQU) {
        		Double num2 = Double.parseDouble(tf.getText());
        		switch(cases) {
        			case 1: 
        				Double answer = num1 + num2;
        				tf.setText(String.valueOf(answer));
        				break;
        			case 2:
        				answer = num1 - num2;
        				tf.setText(String.valueOf(answer));
        				break;
        			case 3:
        				answer = num1 * num2;
        				tf.setText(String.valueOf(answer));
        				break;
        			case 4:
        				answer = 0.0;
        				try {
        					answer = num1 / num2;
        				} catch(Exception msg){
        					tf.setText("Error");
        				}
        				tf.setText(String.valueOf(answer));
        				break;
        		}
        	}
        }
    }
	
	//Handler for processing Button Clicks. OH WELL
	
	public static void main(String[] args) {
        launch(args);
    }
}

