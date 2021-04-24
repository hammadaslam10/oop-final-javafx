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
    private PasswordField pass;



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

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("StudentPortal.fxml"));
                root=loader.load();

                StudentInfo studentInfo =loader.getController();
                studentInfo.DisplayLogin(username);
                // root=FXMLLoader.load(getClass().getResource("StudentPortal.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.show();

        }
        public  void    lOGIN(ActionEvent event)throws IOException{

            try {

                StringBuilder st=new StringBuilder();
                st.append("username   "+name.getText().toString()+"\n");
                st.append("pass       "+pass.getText().toString()+"\n");
                File file=new File("Student.txt");


                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter Write = new FileWriter(file.getName(), true);
                BufferedWriter bw = new BufferedWriter(Write);
                bw.write(st.toString());
                bw.close();

                String username = name.getText();
                FXMLLoader Loader = new FXMLLoader(getClass().getClassLoader().getResource("StudentPortal.fxml"));
                root=Loader.load();

                StudentInfo StudentController =Loader.getController();
                StudentController.DisplayLogin(username);
                // root=FXMLLoader.load(getClass().getResource("StudentPortal.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.show();

                System.out.println("Done");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
