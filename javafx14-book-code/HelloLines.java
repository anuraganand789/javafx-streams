import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.stage.Stage;

import javafx.scene.shape.Line;
import javafx.scene.paint.Color;

import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class HelloLines extends Application{

   final Line[] lines;

   public HelloLines(){
       lines = new Line[] {
                   lineNode(20, 20, 320, 120, 3, Color.RED),
                   lineNode(320, 120, 120, 220, 5, Color.GREEN),
                   lineNode(120, 220, 20, 20, 1, Color.BLUE)
               };
   }

   private Line lineNode(final double x, final double y,
                     final double a, final double b,
                     final double width, final Color color){
        final Line line = new Line(x, y  , a, b);
        line.setStroke(color);
        line.setStrokeWidth(width);
        
        return line;
    }

    private Text textNode(final String displayText){
        final Text text = new Text(displayText);
        text.setX(200);
        text.setY(50);
        text.setFont(new Font(36));

        return text;
    }
    
    @Override
    public void start(final Stage stage){
       final Group root = new Group(lines);
       root.getChildren().add(textNode("Hello"));
       
       stage.setTitle("Triangle");
       stage.setScene(new Scene(root, 350, 250));
       stage.show();
    }
}
