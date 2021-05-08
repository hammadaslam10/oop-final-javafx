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

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.io.IOException;

public class StudentInfo  {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
     Label NameLabel;

    @FXML
     Label ReligionLabel;

    @FXML
     Label RegistrationNumberLabel;

    @FXML
     Label PhoneNumberLabel;

    @FXML
     Label CurrentSemLabel;

    @FXML
     Label CgpaLabel;

    @FXML
     Label DepartementLabel;

    @FXML
     Label ProgramManagaerLabel;

    @FXML
    private Label cross;
    public void SwitchToSemesterInfo(ActionEvent event) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader("./tempStdnt.txt"));
        String thisLine = br.readLine();
        String[] stdntData = thisLine.split(" ");
        String username = stdntData[0];
        String RegStrNumber = stdntData[1];
        String PhoneNo = stdntData[2];
        String CurrentSem = stdntData[3];
        String Cgpa = stdntData[4];
        String Department = stdntData[5];
        String ProgramManager = stdntData[6];
        String Religion = stdntData[7];

        FXMLLoader load = new FXMLLoader(getClass().getResource("SemesterInfo.fxml"));
        root=load.load();
        StudentInfo stdntInfo = load.getController();

        stdntInfo.NameLabel.setText(username);
        stdntInfo.RegistrationNumberLabel.setText(RegStrNumber);
        stdntInfo.PhoneNumberLabel.setText(PhoneNo);
        stdntInfo.CurrentSemLabel.setText(CurrentSem);
        stdntInfo.CgpaLabel.setText(Cgpa);
        stdntInfo.DepartementLabel.setText(Department);
        stdntInfo.ProgramManagaerLabel.setText(ProgramManager);
        stdntInfo.ReligionLabel.setText(Religion);


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
        root=FXMLLoader.load(getClass().getResource("StudentsPortal.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    public void SwitchToStudent(ActionEvent event) throws Exception{

        root=FXMLLoader.load(getClass().getResource("Student.fxml"));
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
    void DisplayLogin(String Username, String Pass){


        this.NameLabel.setText("Welcome Back:- "+Username);
        //ye dekh
        this.RegistrationNumberLabel.setText("Registration Number Is:- "+Pass);
        this.CgpaLabel.setText("Your Are Studying in 2nd Semester");
    }



}
