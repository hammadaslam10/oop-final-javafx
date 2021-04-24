package HammadAslam;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.io.IOException;

public class StudentInfo {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
     Label InfoLabel;

    @FXML
    private Label cross;
    public void SwitchToSemesterInfo(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("SemesterInfo.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void SwitchToCourseRegistration(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("Course Registration.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void SwitchToPolicies(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("Policies.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void SwitchToStudentPortal(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("Students.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void SwitchToHome(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void Crossbutton(javafx.scene.input.MouseEvent event) {
        if(event.getSource() ==cross)
            System.exit(0);
    }

    void DisplayLogin(String Username){

        InfoLabel.setText("hello"+Username);
        //ye dekh
    }



}
