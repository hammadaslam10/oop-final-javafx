package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StudentTable.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    @Override
    public void init(){
        File thefile = new File("./student.txt");
        if(thefile.length()!=0){
            StudentController.loadData();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
