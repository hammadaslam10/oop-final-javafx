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

public class TeacherPortal {

    private Stage stage;
    private Scene scene;
    private Parent root;

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


    public void SwitchToTeacherDetails(ActionEvent event) throws Exception{
        root= FXMLLoader.load(getClass().getResource("Teacher Details.fxml"));
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
