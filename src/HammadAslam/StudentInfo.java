package HammadAslam;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentInfo {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button SemesterInfo;

    @FXML
    private Label cross;

    @FXML
    private Label cross1;
    @FXML
    private Label infolabel;
public String uname;
 //       public  void DisplayLoginInfo(String Username) {
 //uname=Username;
   //     infolabel.setText("welcome back :-"+Username);

        //}
    ///public void DisplayLoginInfo(MouseEvent mouseEvent) {
      //  DisplayLoginInfo(uname);
    //}

    @FXML
    void SwitchStudentPortal(javafx.scene.input.MouseEvent event){

    }

    @FXML
    void Crossbutton(javafx.scene.input.MouseEvent event) {
        if(event.getSource() ==cross)
            System.exit(0);
    }

    @FXML
    void SwitchToCourseInfo(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("Course Registration.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SwitchToPolicies(ActionEvent event)throws IOException  {
        root=FXMLLoader.load(getClass().getResource("Policies.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SwitchToSemesterInfo(ActionEvent event)throws IOException  {
        root=FXMLLoader.load(getClass().getResource("SemesterInfo.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
