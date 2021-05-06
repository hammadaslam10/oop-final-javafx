package HammadAslam;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.converter.NumberStringConverter;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private MenuButton filemenu;

    @FXML
    private TableView<Teacher> TeacherTable;

    @FXML
    private TableColumn<Teacher,String> FirstNameCol;

    @FXML
    private TableColumn<Teacher, String> LastNameCol;

    @FXML
    private TableColumn<Teacher, Number> IdNoCol;

    @FXML
    private TableColumn<Teacher, Number> PhoneNoCol;

    @FXML
    private TableColumn<Teacher, Number> ExperienceCol;

    @FXML
    private TableColumn<Teacher, String> DepartmentCol;

    @FXML
    private TableColumn<Teacher, String> SubjectTeachesCol;

    @FXML
    private TableColumn<Teacher, String> QualificationCol;

    @FXML
    private TableColumn<Teacher, String> DesignationCol;

    @FXML
    private TableColumn<Teacher, String> FacultyCol;

    @FXML
    private TextField FirstNameField;

    @FXML
    private TextField LastNameField;

    @FXML
    private TextField IdNoField;

    @FXML
    private TextField PhoneNoField;

    @FXML
    private TextField ExperienceField;

    @FXML
    private TextField DepartmentField;

    @FXML
    private ComboBox<String> QualificationCombo;
    ObservableList<String>QualificationComboData = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> DesignationCombo;
    ObservableList<String>DesignationComboData = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> FacultyCombo;
    ObservableList<String>FacultyComboData = FXCollections.observableArrayList();
    @FXML
    private Button AddButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private TextField SubjectTeachesField;

    @FXML
    private TextField filterInput;
    static ObservableList<Teacher> ObservableTeacherList =FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //add Listener to filterField
        filterInput.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterStudentList((String) oldValue, (String) newValue);

            }
        });
        TeacherTable.setEditable(true);
        FirstNameCol.setOnEditCommit(e->FirstNameCol_OnEditCommit(e));
        LastNameCol.setOnEditCommit(e->LastNameCol_OnEditCommit(e));
        IdNoCol.setOnEditCommit(e->IdNoCol_OnEditCommit(e));
        PhoneNoCol.setOnEditCommit(e->PhoneNoCol_OnEditCommit(e));
        ExperienceCol.setOnEditCommit(e->ExperienceCol_OnEditCommit(e));
        DepartmentCol.setOnEditCommit(e->DepartmentCol_OnEditCommit(e));
        SubjectTeachesCol.setOnEditCommit(e-> SubjectTeachesCol_OnEditCommit(e));
        QualificationCol.setOnEditCommit(e->QualificationCol_OnEditCommit(e));
        FacultyCol.setOnEditCommit(e->FacultyCol_OnEditCommit(e));
        DesignationCol.setOnEditCommit(e->DesignationCol_OnEditCommit(e));

            TeacherTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        FirstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        LastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        IdNoCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        PhoneNoCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        ExperienceCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        DepartmentCol.setCellFactory(TextFieldTableCell.forTableColumn());
        SubjectTeachesCol.setCellFactory(TextFieldTableCell.forTableColumn());
        QualificationCol.setCellFactory(TextFieldTableCell.forTableColumn());
        FacultyCol.setCellFactory(TextFieldTableCell.forTableColumn());
        DesignationCol.setCellFactory(TextFieldTableCell.forTableColumn());

        FirstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        LastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        IdNoCol.setCellValueFactory(cellData -> cellData.getValue().idNoProperty());
        PhoneNoCol.setCellValueFactory(cellData -> cellData.getValue().phoneNoProperty());
        ExperienceCol.setCellValueFactory(cellData -> cellData.getValue().experienceProperty());
        DepartmentCol.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());
        SubjectTeachesCol.setCellValueFactory(cellData -> cellData.getValue().subjectTeachesProperty());
        QualificationCol.setCellValueFactory(cellData -> cellData.getValue().qualificationProperty());
        FacultyCol.setCellValueFactory(cellData -> cellData.getValue().facultyProperty());
        DesignationCol.setCellValueFactory(cellData -> cellData.getValue().designationProperty());

        TeacherTable.setItems(ObservableTeacherList);

        QualificationComboData.add(new String("Master"));
        QualificationComboData.add(new String("Mphill"));
        QualificationComboData.add(new String("Phd"));
        QualificationCombo.setItems(QualificationComboData);
        FacultyComboData.add(new String("Permanent"));
        FacultyComboData.add(new String("Temporary"));
        FacultyCombo.setItems(FacultyComboData);
        DesignationComboData.add(new String("Lecturer"));
        DesignationComboData.add(new String("Assistant Lecturer"));
        DesignationComboData.add(new String("LabAssistant"));
        DesignationComboData.add(new String("LabHead"));
        DesignationCombo.setItems(DesignationComboData);
        AddButton.setDisable(true);
        DeleteButton.setDisable(true);
        TeacherTable.setEditable(true);
        TeacherTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TeacherTable.setPlaceholder(new Label("YOUR TABLE IS EMPTY"));
        FirstNameField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (FirstNameField.isFocused()) {
                    AddButton.setDisable(false);
                }
            }
        });
        TeacherTable.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> Observable, Boolean oldValue, Boolean newValue) {
                if (TeacherTable.isFocused()) {
                    DeleteButton.setDisable(false);
                }
            }
        });

    }

    public static void loadDataTeacher(){
        try(BufferedReader br = new BufferedReader(new FileReader("./teacher.txt"))){
            String thisLine="";
            while((thisLine= br.readLine())!=null){
                String[] split = thisLine.split(" ");
                String FirstName = split[0];
                String LastName = split[1];
                int IdNo = Integer.parseInt(split[2]);
                double PhoneNo = Double.parseDouble(split[3]);
                int Experience = Integer.parseInt(split[4]);
                String Department = (split[5]);
                String SubjectTeaches = split[6];
                String Qualification = split[7];
                String Designation = split[8];
                String Faculty = split[9];

                Teacher readData = new Teacher(FirstName,LastName,IdNo,PhoneNo,Experience,Department,SubjectTeaches,Qualification,Designation,Faculty);
                ObservableTeacherList.add(readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public  void DepartmentCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Teacher, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Teacher, String>) e;
        Teacher teacher = cellEditEvent.getRowValue();
        teacher.setDepartment(cellEditEvent.getNewValue());
    }


    public    void DesignationCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Teacher, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Teacher, String>) e;
        Teacher teacher = cellEditEvent.getRowValue();
        teacher.setDesignation(cellEditEvent.getNewValue());
    }


    public  void ExperienceCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Teacher, Integer> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Teacher, Integer>) e;
        Teacher teacher = cellEditEvent.getRowValue();
        teacher.setExperience(cellEditEvent.getNewValue());
    }


    public   void FacultyCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Teacher, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Teacher, String>) e;
        Teacher teacher = cellEditEvent.getRowValue();
        teacher.setFaculty(cellEditEvent.getNewValue());
    }


    public    void FirstNameCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Teacher, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Teacher, String>) e;
        Teacher teacher = cellEditEvent.getRowValue();
        teacher.setFirstName(cellEditEvent.getNewValue());
    }


    public void IdNoCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Teacher, Integer> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Teacher, Integer>) e;
        Teacher teacher = cellEditEvent.getRowValue();
        teacher.setIdNo(cellEditEvent.getNewValue());
    }


    public void LastNameCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Teacher, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Teacher, String>) e;
        Teacher teacher = cellEditEvent.getRowValue();
        teacher.setLastName(cellEditEvent.getNewValue());
    }


    public void PhoneNoCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Teacher, Double> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Teacher, Double>) e;
        Teacher teacher = cellEditEvent.getRowValue();
        teacher.setPhoneNo(cellEditEvent.getNewValue());
    }


    public   void QualificationCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Teacher, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Teacher, String>) e;
        Teacher teacher = cellEditEvent.getRowValue();
        teacher.setQualification(cellEditEvent.getNewValue());
    }


    public    void SubjectTeachesCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Teacher, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Teacher, String>) e;
        Teacher teacher= cellEditEvent.getRowValue();
        teacher.setSubjectTeaches(cellEditEvent.getNewValue());
    }

    public void handleAddButtonClick(ActionEvent event) {
        if (ObservableTeacherList.size() < 10) {
            if(isValidInput(event)){
                if(FacultyCombo.getValue().equals("Permanent")){
                    Teacher teacher =new Teacher();
                    teacher.setFirstName(FirstNameField.getText());
                    teacher.setLastName(LastNameField.getText());
                    teacher.setIdNo(Integer.parseInt(IdNoField.getText()));
                    teacher.setExperience(Integer.parseInt(ExperienceField.getText()));
                    teacher.setSubjectTeaches(SubjectTeachesField.getText());
                    teacher.setPhoneNo(Double.parseDouble(PhoneNoField.getText()));
                    teacher.setDepartment(DepartmentField.getText());
                    teacher.setQualification(QualificationCombo.getValue());
                    teacher.setDesignation(DesignationCombo.getValue());
                    teacher.setFaculty(FacultyCombo.getValue());
                    ObservableTeacherList.add(teacher);
                    TeacherTable.setItems(ObservableTeacherList);
                    System.out.println(teacher.toString());
                    FirstNameField.clear();
                    LastNameField.clear();
                    IdNoField.clear();
                    ExperienceField.clear();
                    DepartmentField.clear();
                    SubjectTeachesField.clear();
                    PhoneNoField.clear();
                    FacultyCombo.setValue("Faculty");
                    QualificationCombo.setValue("Qualification");
                    DesignationCombo.setValue("Designation");
                }
                else if(FacultyCombo.getValue().equals("Temporary")){
                    Teacher teacher =new Teacher();
                    teacher.setFirstName(FirstNameField.getText());
                    teacher.setLastName(LastNameField.getText());
                    teacher.setIdNo(Integer.parseInt(IdNoField.getText()));
                    teacher.setExperience(Integer.parseInt(ExperienceField.getText()));
                    teacher.setSubjectTeaches(SubjectTeachesField.getText());
                    teacher.setPhoneNo(Double.parseDouble(PhoneNoField.getText()));
                    teacher.setDepartment(DepartmentField.getText());
                    teacher.setQualification(QualificationCombo.getValue());
                    teacher.setDesignation(DesignationCombo.getValue());
                    teacher.setFaculty(FacultyCombo.getValue());
                    ObservableTeacherList.add(teacher);
                    TeacherTable.setItems(ObservableTeacherList);
                    System.out.println(teacher.toString());
                    FirstNameField.clear();
                    LastNameField.clear();
                    IdNoField.clear();
                    ExperienceField.clear();
                    DepartmentField.clear();
                    SubjectTeachesField.clear();
                    PhoneNoField.clear();
                    FacultyCombo.setValue("Faculty");
                    QualificationCombo.setValue("Qualification");
                    DesignationCombo.setValue("Designation");

                }
            }
        }else {
            Alert sizeAlert = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            sizeAlert.setContentText("You may only hold 10 Students at this time");
            sizeAlert.initModality(Modality.APPLICATION_MODAL);
            sizeAlert.initOwner(owner);
            sizeAlert.showAndWait();
            if (sizeAlert.getResult() == ButtonType.OK) {
                sizeAlert.close();
                FirstNameField.clear();
                LastNameField.clear();
                IdNoField.clear();
                ExperienceField.clear();
                DepartmentField.clear();
                SubjectTeachesField.clear();
                PhoneNoField.clear();
                FacultyCombo.setValue("Faculty");
                QualificationCombo.setValue("Qualification");
                DesignationCombo.setValue("Designation");
            }
        }
    }private boolean isValidInput(ActionEvent event) {
        boolean validInput = true;
        if(FirstNameField == null || FirstNameField.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyFirstName = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyFirstName.setContentText("First name is EMPTY");
            emptyFirstName.initModality(Modality.APPLICATION_MODAL);
            emptyFirstName.initOwner(owner);
            emptyFirstName.showAndWait();
            if(emptyFirstName.getResult() == ButtonType.OK) {
                emptyFirstName.close();
                FirstNameField.requestFocus();
            }
        }   if(LastNameField == null || LastNameField.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyLastName = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyLastName.setContentText("Last name is EMPTY");
            emptyLastName.initModality(Modality.APPLICATION_MODAL);
            emptyLastName.initOwner(owner);
            emptyLastName.showAndWait();
            if(emptyLastName.getResult() == ButtonType.OK) {
                emptyLastName.close();
                LastNameField.requestFocus();
            }
        }
        if(IdNoField== null || IdNoField.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyIdNoField = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyIdNoField.setContentText("Registration Number is EMPTY");
            emptyIdNoField.initModality(Modality.APPLICATION_MODAL);
            emptyIdNoField.initOwner(owner);
            emptyIdNoField.showAndWait();
            if(emptyIdNoField.getResult() == ButtonType.OK) {
                emptyIdNoField.close();
                IdNoField.requestFocus();
            }
        }
        if(ExperienceField == null || ExperienceField.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyExperienceField = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyExperienceField.setContentText("Phone Number is EMPTY");
            emptyExperienceField.initModality(Modality.APPLICATION_MODAL);
            emptyExperienceField.initOwner(owner);
            emptyExperienceField.showAndWait();
            if(emptyExperienceField.getResult() == ButtonType.OK) {
                emptyExperienceField.close();
                ExperienceField.requestFocus();

            }
        }
        if(DepartmentField == null ||DepartmentField.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyDepartmentField = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyDepartmentField.setContentText("Current Sem is EMPTY");
            emptyDepartmentField.initModality(Modality.APPLICATION_MODAL);
            emptyDepartmentField.initOwner(owner);
            emptyDepartmentField.showAndWait();
            if(emptyDepartmentField.getResult() == ButtonType.OK) {
                emptyDepartmentField.close();
                DepartmentField.requestFocus();
            }
        }
        if(SubjectTeachesField == null || SubjectTeachesField.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptySubjectTeachesField = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptySubjectTeachesField.setContentText("Cgpa  is EMPTY");
            emptySubjectTeachesField.initModality(Modality.APPLICATION_MODAL);
            emptySubjectTeachesField.initOwner(owner);
            emptySubjectTeachesField.showAndWait();
            if(emptySubjectTeachesField.getResult() == ButtonType.OK) {
                emptySubjectTeachesField.close();
                SubjectTeachesField.requestFocus();
            }
        }
        if(QualificationCombo == null ||  QualificationCombo.getValue().trim().isEmpty()) {
            validInput = false;
            Alert emptyQualificationCombo = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyQualificationCombo.setContentText("Gender is EMPTY");
            emptyQualificationCombo.initModality(Modality.APPLICATION_MODAL);
            emptyQualificationCombo.initOwner(owner);
            emptyQualificationCombo.showAndWait();
            if(emptyQualificationCombo.getResult() == ButtonType.OK) {
                emptyQualificationCombo.close();
                QualificationCombo.requestFocus();
            }
        }  if(DesignationCombo == null || DesignationCombo.getValue().trim().isEmpty()) {
            validInput = false;
            Alert emptyDesignationCombo = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyDesignationCombo.setContentText("Religion is EMPTY");
            emptyDesignationCombo.initModality(Modality.APPLICATION_MODAL);
            emptyDesignationCombo.initOwner(owner);
            emptyDesignationCombo.showAndWait();
            if(emptyDesignationCombo.getResult() == ButtonType.OK) {
                emptyDesignationCombo.close();
                DesignationCombo.requestFocus();
            }
        }  if(PhoneNoField == null || PhoneNoField.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyPhoneNoField = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyPhoneNoField.setContentText("Department is EMPTY");
            emptyPhoneNoField.initModality(Modality.APPLICATION_MODAL);
            emptyPhoneNoField.initOwner(owner);
            emptyPhoneNoField.showAndWait();
            if(emptyPhoneNoField.getResult() == ButtonType.OK) {
                emptyPhoneNoField.close();
                PhoneNoField.requestFocus();
            }
        }  if(FacultyCombo == null || FacultyCombo.getValue().trim().isEmpty()) {
            validInput = false;
            Alert emptyFacultyCombo = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyFacultyCombo.setContentText("Program Manager is EMPTY");
            emptyFacultyCombo.initModality(Modality.APPLICATION_MODAL);
            emptyFacultyCombo.initOwner(owner);
            emptyFacultyCombo.showAndWait();
            if(emptyFacultyCombo.getResult() == ButtonType.OK) {
                emptyFacultyCombo.close();
                FacultyCombo.requestFocus();
            }
        }


        return validInput;
    }




  public  void handleClearButtonClick(ActionEvent event) {
        FirstNameField.clear();
        LastNameField.clear();
        IdNoField.clear();
        ExperienceField.clear();
        DepartmentField.clear();
        SubjectTeachesField.clear();
        PhoneNoField.clear();
        FacultyCombo.setValue("Faculty");
        QualificationCombo.setValue("Qualification");
        DesignationCombo.setValue("Designation");
    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void SwitchToStudentTable(ActionEvent event) throws IOException{
        root= FXMLLoader.load(getClass().getResource("StudentTable.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void SwitchToAdminOptionPortal(ActionEvent event) throws IOException{
        root= FXMLLoader.load(getClass().getResource("AdminOption.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void handleDeleteButtonClick(ActionEvent event) {
        if(!ObservableTeacherList.isEmpty()){
            System.out.println("Delete button CLicked");
            Alert deleteAlert = new Alert(Alert.AlertType.WARNING, "Confirm", ButtonType.OK, ButtonType.CANCEL);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            deleteAlert.setContentText("Are you sure you want to delete this?\n\nTHIS CANNOT BE UNDONE.");
            deleteAlert.initModality(Modality.APPLICATION_MODAL);
            deleteAlert.initOwner(owner);
            deleteAlert.showAndWait();
            if(deleteAlert.getResult() == ButtonType.OK){
                ObservableTeacherList.removeAll(TeacherTable.getSelectionModel().getSelectedItem());
                TeacherTable.getSelectionModel().clearSelection();
            }
            else{
                deleteAlert.close();

            }
        }

    }


    public void handleSave(ActionEvent event) throws IOException {
        //   Stage secondaryStage = new Stage();
        // FileChooser fileChooser = new FileChooser();
        /// fileChooser.setTitle("Save-Student-Table");
        //fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        if(ObservableTeacherList.isEmpty()) {
            //  secondaryStage.initOwner(this.filemenu.getScene().getWindow());
            Alert emptyTableAlert = new Alert(Alert.AlertType.ERROR, "EMPTY TABLE", ButtonType.OK);
            emptyTableAlert.setContentText("You have nothing to save");
            emptyTableAlert.initModality(Modality.APPLICATION_MODAL);
            emptyTableAlert.initOwner(this.filemenu.getScene().getWindow());
            emptyTableAlert.showAndWait();
            if(emptyTableAlert.getResult() == ButtonType.OK) {
                emptyTableAlert.close();
            }
        }
        else {
            //   File file = fileChooser.showSaveDialog(secondaryStage);
            File tt = new File("teacher.txt");
            if(!tt.exists()){
                tt.createNewFile();

            }
            saveFile(TeacherTable.getItems(), tt);
        }
    }
    public void saveFile(ObservableList<Teacher> ObservableTeacherList, File tt) {
        try {
            FileWriter append =new FileWriter(tt.getName(),true);
            //   BufferedWriter outWriter = new BufferedWriter(new FileWriter(tt));
//jo comment mara hai upar usse file me data add hoga or neche wala jo chal raha hai abhi us se overwrite
            BufferedWriter outWriter = new BufferedWriter(new FileWriter(tt));

            for(Teacher teacher : ObservableTeacherList) {
                outWriter.write(teacher.toString());
                outWriter.newLine();
            }
            //System.out.println(observableStudentList.toString());
            Alert SuccessAlert = new Alert(Alert.AlertType.INFORMATION, "Done", ButtonType.OK);
            SuccessAlert.setContentText("Save Succesfull");
            SuccessAlert.showAndWait();
            if(SuccessAlert.getResult() == ButtonType.OK) {
                SuccessAlert.close();
            }
            outWriter.close();
        } catch (IOException e) {
            Alert ioAlert = new Alert(Alert.AlertType.ERROR, "OOPS!", ButtonType.OK);
            ioAlert.setContentText("Sorry. An error has occurred.");
            ioAlert.showAndWait();
            if(ioAlert.getResult() == ButtonType.OK) {
                ioAlert.close();
            }
        }
    }

    public void filterStudentList(String oldValue, String newValue) {
        ObservableList<Teacher> filteredList = FXCollections.observableArrayList();
        if(filterInput == null || (newValue.length() < oldValue.length()) || newValue == null) {
            TeacherTable.setItems(ObservableTeacherList);
        }
        else {
            newValue = newValue.toUpperCase();
            for(Teacher teacher :TeacherTable.getItems()) {
                String filterFirstName =  teacher.getFirstName();
                String filterLastName =  teacher.getLastName();
                if(filterFirstName.toUpperCase().contains(newValue) || filterLastName.toUpperCase().contains(newValue)) {
                    filteredList.add(teacher);
                }
            }
            TeacherTable.setItems(filteredList);
        }
    }

}
