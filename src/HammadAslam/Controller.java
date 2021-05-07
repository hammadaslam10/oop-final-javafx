package HammadAslam;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.Window;


import java.io.*;


public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Parent root1;

    @FXML
    private Rectangle rect;
    @FXML
    private Label cross;

    @FXML
    TextField name;

    @FXML
   PasswordField pass;


    @FXML
    void Crossbutton(javafx.scene.input.MouseEvent event) {
        if(event.getSource() ==cross)
            System.exit(0);
    }


    public void SwitchToHome(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToSTUDENT(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("Students.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToTeacher(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("Teacher.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToAdmin(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("Admin.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SaveDataAndAllowStudent(ActionEvent event) throws IOException {
        //ye dekh isme line 87 na charna or error 83 pe araha hai
        String username = name.getText();
        String RegStrNumber = pass.getText();

        BufferedReader auth = new BufferedReader(new FileReader("./student.txt"));
        String thisLine="";
        while((thisLine= auth.readLine())!=null) {
            String[] split = thisLine.split(" ");
            String FirstName = split[0];
            String LastName = split[1];
            String RegistrationNo = split[2];
            String PhoneNo = split[3];
            String CurrentSem = split[4];
            String Cgpa = split[5];
            String Department = split[6];
            String ProgramManager = split[7];
            String Gender = split[8];
            String Religion = split[9];
            if((username.equals(FirstName)) && (RegStrNumber.equals(RegistrationNo))){
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
            } else {
                Alert invalid = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
                Window owner = ((Node) event.getTarget()).getScene().getWindow();
                invalid.setContentText("Login invalid, retry");
                invalid.initModality(Modality.APPLICATION_MODAL);
                invalid.initOwner(owner);
                invalid.showAndWait();
                if (invalid.getResult()==ButtonType.OK){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Students.fxml"));
                    root=loader.load();
                    StudentController studentInfo =loader.getController();
                }
            }
        }
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentPortal.fxml"));
//        root=loader.load();
//        StudentInfo studentInfo =loader.getController();
//        studentInfo.DisplayLogin(username,RegStrNumber);
        // root=FXMLLoader.load(getClass().getResource("StudentPortal.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void VerifyAdmin(ActionEvent event) throws IOException{
        root=FXMLLoader.load(getClass().getResource("AdminOption.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void VerifyTeacher(ActionEvent event) throws IOException{
        root=FXMLLoader.load(getClass().getResource("TeacherOption.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}