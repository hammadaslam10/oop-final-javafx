package HammadAslam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    /**
     * Controller wali class ma 3 function hai verify admin ,verify teacher or SaveDataAndAllowStudent ke naam se usme authentication wala karna hai
     *

     **/

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
    @Override
    public void init(){
        File thefile = new File("./student.txt");
        if(thefile.length()!=0){
            StudentController.loadDataStudent();
        }
        File file = new File("./teacher.txt");
        if(file.length()!=0){
            TeacherController.loadDataTeacher();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

