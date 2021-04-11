import javafx.application.Application;
import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class HelloFX extends Application{
   
   public HelloFX(){ 
       System.out.format("Constructor %d.%n", Thread.currentThread().getId());
    }
    
    @Override
    public void init(){
       System.out.format("Init %d.%n", Thread.currentThread().getId());
    }

    @Override
    public void stop(){
       System.out.format("Stop %d.%n", Thread.currentThread().getId());
    }
    @Override
    public void start(final Stage stage){
        System.out.format("Start %d.%n", Thread.currentThread().getId());
        final TextField textField = new TextField();

        final Label label = new Label();
        label.setStyle("-fx-text-fill : blue");

        final Button btn = new Button("Hello");
        btn.setOnAction( (event) -> {
            final String textFieldValue = textField.getText();
            label.setText(String.format("Hello %s", 
                          textFieldValue.trim().length() > 0 
                          ? textFieldValue
                          : "There"));
        });
        final Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> Platform.exit());

        final VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren()
        .addAll(new Label("Enter Your Name : "),
                textField,
                label,
                btn,
                exitButton);

        stage.setScene(new Scene(vbox, 300, 200));
        stage.setTitle("Hello FX");
        stage.show();
    }
}
