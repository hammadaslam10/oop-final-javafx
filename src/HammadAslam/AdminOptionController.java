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

public class AdminOptionController implements AdminTableControl{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label cross;

    @FXML
    TextField name;

    @FXML
    private PasswordField pass;


    public void SwitchToAdminLogin(ActionEvent event) throws Exception {
        root=FXMLLoader.load(getClass().getResource("Admin.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public  void SwitchToStudentTable(ActionEvent event) throws Exception {
        root=FXMLLoader.load(getClass().getResource("StudentTable.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void SwitchToTeacherTable(ActionEvent event) throws Exception {
        root=FXMLLoader.load(getClass().getResource("TeacherTable.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void Crossbutton(javafx.scene.input.MouseEvent event) {
        if(event.getSource() ==cross)
            System.exit(0);
    }


/*

    public void SwitchToAdminLogin(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("Admin.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToStudentTable(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("StudentTable.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToTeacherTable(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("TeacherTable.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/





}
