package HammadAslam;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;

public class TeacherPortal {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label cross;


    @FXML
     Label TeacherFirstNameLabel;
    @FXML
     Label IdNoLabel;

    @FXML
     Label TeacherLastNameLabel;

    @FXML
     Label PhoneNumberLabel;

    @FXML
     Label ExperienceLabel;

    @FXML
     Label DepartementLabel;

    @FXML
     Label SubjectTeachesLabel;

    @FXML
     Label QualificationLabel;

    @FXML
     Label DesignationLabel;

    @FXML
     Label FacultyLabel;



    @FXML
    void Crossbutton(javafx.scene.input.MouseEvent event) {
        if(event.getSource() ==cross)
            System.exit(0);
    }


    public void SwitchToTeacherDetails(ActionEvent event) throws Exception{
          BufferedReader br = new BufferedReader(new FileReader("./tempTeacher.txt"));
        String thisLine = br.readLine();
        String[]    TeacherData = thisLine.split(" ");
        String FirstName = TeacherData[0];
        String LastName = TeacherData[1];
        String IdNo  = TeacherData[2];
        String PhoneNo= TeacherData[3];
        String Experience = TeacherData[4];
        String Department = TeacherData[5];
        String SubjectTeaches = TeacherData[6];
        String Qualification=TeacherData[7];
        String Designation = TeacherData[8];
        String Faculty = TeacherData[9];


        FXMLLoader load = new FXMLLoader(getClass().getResource("Teacher Details.fxml"));
        root=load.load();
        TeacherPortal teacherPortal = load.getController();

        teacherPortal.TeacherFirstNameLabel.setText(FirstName);
        teacherPortal.TeacherLastNameLabel.setText(LastName);
        teacherPortal.IdNoLabel.setText(IdNo);
        teacherPortal.PhoneNumberLabel.setText(PhoneNo);
        teacherPortal.ExperienceLabel.setText( Experience);
        teacherPortal. DepartementLabel.setText(Department);
        teacherPortal.SubjectTeachesLabel.setText(SubjectTeaches);
        teacherPortal.QualificationLabel.setText(Qualification);
        teacherPortal.DesignationLabel.setText(Designation);
        teacherPortal. FacultyLabel.setText(Faculty);

        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToTeachingGuidLines(ActionEvent event) throws Exception{
        root= FXMLLoader.load(getClass().getResource("Teaching Guidlines.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToTeacherOption(ActionEvent event) throws Exception{
        root= FXMLLoader.load(getClass().getResource("TeacherOption.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToTeacherPortal(ActionEvent event) throws Exception{
        root= FXMLLoader.load(getClass().getResource("Teacher.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
