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
import java.util.concurrent.locks.ReentrantLock;


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
    TextField TeacherName;
    @FXML
    PasswordField Teacherpass;

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
    // This method is the login auth method for student. split logic is being used here.
    public void SaveDataAndAllowStudent(ActionEvent event) throws IOException {
        String username = name.getText();
        String RegStrNumber = pass.getText();
        String rec="";

        BufferedReader auth = new BufferedReader(new FileReader("./student.txt"));
        String thisLine="";

        while((thisLine= auth.readLine())!=null) {
            String[] split = thisLine.split(" ");
            if((username.equals(split[0])) && (RegStrNumber.equals(split[2]))){
                rec=String.join(" ",split);
            }
        }
        if(!rec.equals("")){
            String[] split = rec.split(" ");
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

            File thefile = new File("./tempStdnt.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(thefile));
            String data = addAll(username,RegStrNumber,PhoneNo,CurrentSem,Cgpa,Department,ProgramManager,Religion);
            bw.write(data);
            bw.close();
        }
        else {
            Alert invalid = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            invalid.setContentText("Login invalid, retry");
            invalid.initModality(Modality.APPLICATION_MODAL);
            invalid.initOwner(owner);
            invalid.showAndWait();
            if (invalid.getResult()==ButtonType.OK){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Students.fxml"));
                root=loader.load();
            }
        }
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public String addAll(String firstName, String regNum, String phNo, String currentSem, String cgpa, String department, String programManager, String Religion){
        return firstName+" "+regNum+" "+phNo+" "+currentSem+" "+cgpa+" "+department+" "+programManager+" "+Religion;
    }
    @FXML
    private TextField AdminName;
    @FXML
    private PasswordField AdminPass;
    public void VerifyAdmin(ActionEvent event) throws IOException{
      String TempAdminName=AdminName.getText();
      String TempAdminPass=AdminPass.getText();
      String adminname="admin";
      String adminpass="admin";
      if(TempAdminName.equals("admin")&&TempAdminPass.equals("admin")){
          root=FXMLLoader.load(getClass().getResource("AdminOption.fxml"));
          stage=(Stage)((Node)event.getSource()).getScene().getWindow();
          scene=new Scene(root);
          stage.setScene(scene);
          stage.show();
      }
          else{
              Alert invalid = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
              Window owner = ((Node) event.getTarget()).getScene().getWindow();
              invalid.setContentText("Login invalid, retry");
              invalid.initModality(Modality.APPLICATION_MODAL);
              invalid.initOwner(owner);
              invalid.showAndWait();
              if (invalid.getResult()==ButtonType.OK){
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
                  root=loader.load();
                  AdminName.clear();
                  AdminPass.clear();
              }
          }
    }
    // Same logic used as in student.
    public void VerifyTeacher(ActionEvent event) throws IOException{
        String Teachername = TeacherName.getText();
        String TeacherId = Teacherpass.getText();
        String rec="";

        BufferedReader auth = new BufferedReader(new FileReader("./teacher.txt"));
        String thisLine="";

        while((thisLine= auth.readLine())!=null) {
            String[] split = thisLine.split(" ");
            if((Teachername.equals(split[0])) && (TeacherId.equals(split[2]))) {
                rec=String.join(" ",split);
            }
        }
        if(!rec.equals("")){
            String[] split = rec.split(" ");
            String FirstName = split[0];
            String LastName = split[1];
            String IdNo = split[2];
            String PhoneNo = split[3];
            String experience = split[4];
            String department = split[5];
            String subjecteaches = split[6];
            String qualification = split[7];
            String designation = split[8];
            String faculty = split[9];

            FXMLLoader load = new FXMLLoader(getClass().getResource("Teacher Details.fxml"));
            root=load.load();
            TeacherPortal teacherPortal = load.getController();

            teacherPortal.TeacherFirstNameLabel.setText(Teachername);
            teacherPortal.TeacherLastNameLabel.setText(LastName);
            teacherPortal.IdNoLabel.setText(TeacherId);
            teacherPortal.PhoneNumberLabel.setText(PhoneNo);
            teacherPortal.ExperienceLabel.setText(experience);
            teacherPortal.DepartementLabel.setText(department);
            teacherPortal.SubjectTeachesLabel.setText(subjecteaches);
            teacherPortal.QualificationLabel.setText(qualification);
            teacherPortal.DesignationLabel.setText(designation);
            teacherPortal.FacultyLabel.setText(faculty);

            File thefile = new File("./tempTeacher.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(thefile));
            String data = addTeacherAll(Teachername,LastName,TeacherId,PhoneNo,experience,department,subjecteaches,qualification,designation,faculty);
            bw.write(data);
            bw.close();
        }
        else {
            Alert invalid = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            invalid.setContentText("Login invalid, retry");
            invalid.initModality(Modality.APPLICATION_MODAL);
            invalid.initOwner(owner);
            invalid.showAndWait();
            if (invalid.getResult()==ButtonType.OK){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Teacher.fxml"));
                root=loader.load();
            }
        }
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public String addTeacherAll(String firstName, String lastname, String idno, String phonenum, String experience, String department, String subjecteaches, String qualification,String designation,String faculty){
        return firstName+" "+lastname+" "+idno+" "+phonenum+" "+experience+" "+department+" "+subjecteaches+" "+qualification+" "+designation+" "+faculty;
    }
}