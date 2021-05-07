package HammadAslam;

import javafx.event.ActionEvent;

public interface AdminTableControl {
    void SwitchToAdminLogin(ActionEvent event) throws Exception;
    void SwitchToStudentTable(ActionEvent event) throws Exception;
    void SwitchToTeacherTable(ActionEvent event) throws Exception;
    void Crossbutton(javafx.scene.input.MouseEvent event);
}
