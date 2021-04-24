package HammadAslam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            primaryStage.setTitle("UNIVERISTY MANAGEMENT");

            primaryStage.setResizable(false);
            Scene se=new Scene(root);


            primaryStage.setScene(se);
            // Font.loadFont(Application.class.getResource("C:/Users/ Muhammad Hanif/Documents/jar_files/fonts/awesome.ttf"). toExternalForm(), 12);
            //    se.getStylesheets().add(getClass().getResource("Application.css").toExternalForm());
            String css=this.getClass().getResource("Styles.css").toExternalForm();
            se.getStylesheets().add(css);
            primaryStage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

