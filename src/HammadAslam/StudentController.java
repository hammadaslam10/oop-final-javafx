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
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.converter.NumberStringConverter;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TableColumn<Student, String> FirstNameCol;

    @FXML
    private TableColumn<Student, String> LastNameCol;

    @FXML
    private TableColumn<Student, Number> RegistrationNoCol;

    @FXML
    private TableColumn<Student, Number> PhoneNoCol;

    @FXML
    private TableColumn<Student, Number> CurrentSemCol;

    @FXML
    private TableColumn<Student, Number> CgpaCol;

    @FXML
    private TableColumn<Student, String> DepartmentCol;

    @FXML
    private TableColumn<Student, String> ProgramManagerCol;

    @FXML
    private TableColumn<Student, String> GenderCol;

    @FXML
    private TableColumn<Student, String> ReligionCol;

    @FXML
    private TextField FirstNameField;

    @FXML
    private TextField LastNameField;

    @FXML
    private TextField RegistrationNoField;

    @FXML
    private TextField PhoneNoField;

    @FXML
    private TextField CurrentSemField;

    @FXML
    private TextField CgpaField;

    @FXML
    private ComboBox<String> GenderCombo;
    ObservableList<String> GenderComboData = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> ReligionCombo;
    ObservableList<String> ReligionComboData = FXCollections.observableArrayList();
    @FXML
    private Button AddButton;

    @FXML
    private TableView<Student> StudentTable;

    @FXML
    private Button DeleteButton;

    @FXML
    private TextField DepartmentField;

    @FXML
    private TextField ProgramManagerField;

    @FXML
    private TextField filterInput;
    static ObservableList<Student> ObservableStudentList =FXCollections.observableArrayList();
    @FXML
    private MenuButton filemenu;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //add Listener to filterField
        filterInput.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterStudentList((String) oldValue, (String) newValue);

            }
        });
    StudentTable.setEditable(true);
    FirstNameCol.setOnEditCommit(e->FirstNameCol_OnEditCommit(e));
    LastNameCol.setOnEditCommit(e->LastNameCol_OnEditCommit(e));
    RegistrationNoCol.setOnEditCommit(e->RegistrationNoCol_OnEditCommit(e));
    PhoneNoCol.setOnEditCommit(e->PhoneNo_OnEditCommit(e));
    CurrentSemCol.setOnEditCommit(this::CurrentSemCol_OnEditCommit);
    CgpaCol.setOnEditCommit(e->CgpaCol_OnEditCommit(e));
    GenderCol.setOnEditCommit(e-> GenderCol_OnEditCommit(e));
    ReligionCol.setOnEditCommit(e->ReligionCol_OnEditCommit(e));
    DepartmentCol.setOnEditCommit(e->DepartmentCol_OnEditCommit(e));
    ProgramManagerCol.setOnEditCommit(e->ProgramManagerCol_OnEditCommit(e));

    StudentTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    FirstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
    LastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
    RegistrationNoCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
    PhoneNoCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
    CurrentSemCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
    CgpaCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
    GenderCol.setCellFactory(TextFieldTableCell.forTableColumn());
    ReligionCol.setCellFactory(TextFieldTableCell.forTableColumn());
    DepartmentCol.setCellFactory(TextFieldTableCell.forTableColumn());
    ProgramManagerCol.setCellFactory(TextFieldTableCell.forTableColumn());

    FirstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    LastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    RegistrationNoCol.setCellValueFactory(cellData -> cellData.getValue().registrationNoProperty());
    PhoneNoCol.setCellValueFactory(cellData -> cellData.getValue().phoneNoProperty());
    CurrentSemCol.setCellValueFactory(cellData -> cellData.getValue().currentSemProperty());
    CgpaCol.setCellValueFactory(cellData -> cellData.getValue().cgpaProperty());
    GenderCol.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
    ReligionCol.setCellValueFactory(cellData -> cellData.getValue().religionProperty());
    DepartmentCol.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());
    ProgramManagerCol.setCellValueFactory(cellData -> cellData.getValue().programManagerProperty());

<<<<<<< HEAD:TABLE/src/sample/Controller.java
<<<<<<< HEAD
=======
>>>>>>> 08e625c215e3c627778218ea7b0ef9416d87984c:src/HammadAslam/StudentController.java
    StudentTable.setItems(ObservableStudentList);

    GenderComboData.add(new String("MALE"));
    GenderComboData.add(new String("FEMALE"));
    GenderCombo.setItems(GenderComboData);
    ReligionComboData.add(new String("MUSLIM"));
    ReligionComboData.add(new String("NON-MUSLIM"));
    ReligionCombo.setItems(ReligionComboData);
    AddButton.setDisable(true);
    DeleteButton.setDisable(true);
    StudentTable.setEditable(true);
    StudentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    StudentTable.setPlaceholder(new Label("YOUR TABLE IS EMPTY"));
    FirstNameField.focusedProperty().addListener(new ChangeListener<Boolean>() {
<<<<<<< HEAD:TABLE/src/sample/Controller.java
=======
    GenderComboData.add(new String("MALE"));
        GenderComboData.add(new String("FEMALE"));
        GenderCombo.setItems(GenderComboData);
        ReligionComboData.add(new String("MUSLIM"));
        ReligionComboData.add(new String("NON-MUSLIM"));
        ReligionCombo.setItems(ReligionComboData);
        AddButton.setDisable(true);
        DeleteButton.setDisable(true);
        StudentTable.setEditable(true);
        StudentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        StudentTable.setPlaceholder(new Label("YOUR TABLE IS EMPTY"));
        FirstNameField.focusedProperty().addListener(new ChangeListener<Boolean>() {
>>>>>>> 729ff8ef47a5f07a4b4e2f2ac7d1f2909342b514
=======
>>>>>>> 08e625c215e3c627778218ea7b0ef9416d87984c:src/HammadAslam/StudentController.java
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (FirstNameField.isFocused()) {
                    AddButton.setDisable(false);
                }
            }
        });
        StudentTable.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> Observable, Boolean oldValue, Boolean newValue) {
            if (StudentTable.isFocused()) {
                DeleteButton.setDisable(false);
            }
        }
    });

}
<<<<<<< HEAD:TABLE/src/sample/Controller.java
public void handleAddButtonClick(ActionEvent event) {
<<<<<<< HEAD
    if (ObservableStudentList.size() < 10) {
        if(isValidInput(event)){
            if(GenderCombo.getValue().equals("MALE")){
                Student student =new Student();
                student.setFirstName(FirstNameField.getText());
                student.setLastName(LastNameField.getText());
                student.setReligion(ReligionCombo.getValue());
                student.setDepartment(DepartmentField.getText());
                student.setPhoneNo(Integer.parseInt(PhoneNoField.getText()));
                student.setRegistrationNo(Integer.parseInt(RegistrationNoField.getText()));
                student.setCurrentSem(Integer.parseInt(CurrentSemField.getText()));
                student.setProgramManager(ProgramManagerField.getText());
                student.setGender(GenderCombo.getValue());
                student.setCgpa(Double.parseDouble(CgpaField.getText()));
                ObservableStudentList.add(student);
                System.out.println(student.toString());
                FirstNameField.clear();
                LastNameField.clear();
                RegistrationNoField.clear();
                PhoneNoField.clear();
                CgpaField.clear();
                CurrentSemField.clear();
                ProgramManagerField.clear();
                DepartmentField.clear();
                GenderCombo.setValue("Gender");
                ReligionCombo.setValue("Religion");
            }
            else if(GenderCombo.getValue().equals("FEMALE")){
                Student student =new Student();
                student.setFirstName(FirstNameField.getText());
                student.setLastName(LastNameField.getText());
                student.setReligion(ReligionCombo.getValue());
                student.setDepartment(DepartmentField.getText());
                student.setPhoneNo(Integer.parseInt(PhoneNoField.getText()));
                student.setRegistrationNo(Integer.parseInt(RegistrationNoField.getText()));
                student.setCurrentSem(Integer.parseInt(CurrentSemField.getText()));
                student.setProgramManager(ProgramManagerField.getText());
                student.setGender(GenderCombo.getValue());
                student.setCgpa(Double.parseDouble(CgpaField.getText()));
                ObservableStudentList.add(student);
                //System.out.println(ObservableStudentList);

                StudentTable.setItems(ObservableStudentList);
                //StudentTable.getColumns().addAll(FirstNameCol,LastNameCol,RegistrationNoCol,PhoneNoCol,CurrentSemCol,CgpaCol,DepartmentCol,ProgramManagerCol,GenderCol,ReligionCol);

=======
        if (ObservableStudentList.size() < 10) {
if(isValidInput(event)){
    if(GenderCombo.getValue().equals("MALE")){
        Student student =new Student();
        student.setFirstName(FirstNameField.getText());
        student.setLastName(LastNameField.getText());
        student.setReligion(ReligionCombo.getValue());
        student.setDepartment(DepartmentField.getText());
        student.setPhoneNo(Integer.parseInt(PhoneNoField.getText()));
        student.setRegistrationNo(Integer.parseInt(RegistrationNoField.getText()));
        student.setCurrentSem(Integer.parseInt(CurrentSemField.getText()));
        student.setProgramManager(ProgramManagerField.getText());
        student.setGender(GenderCombo.getValue());
        student.setCgpa(Double.parseDouble(CgpaField.getText()));
        ObservableStudentList.add(student);
        System.out.println(student.toString());
        FirstNameField.clear();
        LastNameField.clear();
        RegistrationNoField.clear();
        PhoneNoField.clear();
        CgpaField.clear();
        CurrentSemField.clear();
        ProgramManagerField.clear();
        DepartmentField.clear();
        GenderCombo.setValue("Gender");
        ReligionCombo.setValue("Religion");
    }
    if(GenderCombo.getValue().equals("FEMALE")){
        Student student =new Student();
        student.setFirstName(FirstNameField.getText());
        student.setLastName(LastNameField.getText());
        student.setReligion(ReligionCombo.getValue());
        student.setDepartment(DepartmentField.getText());
        student.setPhoneNo(Integer.parseInt(PhoneNoField.getText()));
        student.setRegistrationNo(Integer.parseInt(RegistrationNoField.getText()));
        student.setCurrentSem(Integer.parseInt(CurrentSemField.getText()));
        student.setProgramManager(ProgramManagerField.getText());
        student.setGender(GenderCombo.getValue());
        student.setCgpa(Double.parseDouble(CgpaField.getText()));
        ObservableStudentList.add(student);
        System.out.println(student.toString());
        FirstNameField.clear();
        LastNameField.clear();
        RegistrationNoField.clear();
        PhoneNoField.clear();
        CgpaField.clear();
        CurrentSemField.clear();
        ProgramManagerField.clear();
        DepartmentField.clear();
        GenderCombo.setValue("Gender");
        ReligionCombo.setValue("Religion");
    }
=======
>>>>>>> 08e625c215e3c627778218ea7b0ef9416d87984c:src/HammadAslam/StudentController.java

    public static void loadDataStudent(){
        try(BufferedReader br = new BufferedReader(new FileReader("./student.txt"))){
            String thisLine="";
            while((thisLine= br.readLine())!=null){
                String[] split = thisLine.split(" ");
                String FirstName = split[0];
                String LastName = split[1];
                int RegistrationNo = Integer.parseInt(split[2]);
                double PhoneNo = Double.parseDouble(split[3]);
                int CurrentSem = Integer.parseInt(split[4]);
                double Cgpa = Double.parseDouble(split[5]);
                String Department = split[6];
                String ProgramManager = split[7];
                String Gender = split[8];
                String Religion = split[9];

                Student readData = new Student(FirstName,LastName,Department,ProgramManager,Gender,RegistrationNo,PhoneNo,CurrentSem,Cgpa,Religion);
                ObservableStudentList.add(readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD:TABLE/src/sample/Controller.java
}else {
            Alert sizeAlert = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            sizeAlert.setContentText("You may only hold 10 Students at this time");
            sizeAlert.initModality(Modality.APPLICATION_MODAL);
            sizeAlert.initOwner(owner);
            sizeAlert.showAndWait();
            if (sizeAlert.getResult() == ButtonType.OK) {
                sizeAlert.close();
>>>>>>> 729ff8ef47a5f07a4b4e2f2ac7d1f2909342b514
=======

public void handleAddButtonClick(ActionEvent event) {
    if (ObservableStudentList.size() < 10) {
        if(isValidInput(event)){
            if(GenderCombo.getValue().equals("MALE")){
                Student student =new Student();
                student.setFirstName(FirstNameField.getText());
                student.setLastName(LastNameField.getText());
                student.setReligion(ReligionCombo.getValue());
                student.setDepartment(DepartmentField.getText());
                student.setPhoneNo(Double.parseDouble(PhoneNoField.getText()));
                student.setRegistrationNo(Integer.parseInt(RegistrationNoField.getText()));
                student.setCurrentSem(Integer.parseInt(CurrentSemField.getText()));
                student.setProgramManager(ProgramManagerField.getText());
                student.setGender(GenderCombo.getValue());
                student.setCgpa(Double.parseDouble(CgpaField.getText()));
                ObservableStudentList.add(student);
                StudentTable.setItems(ObservableStudentList);
                System.out.println(student.toString());
                FirstNameField.clear();
                LastNameField.clear();
                RegistrationNoField.clear();
                PhoneNoField.clear();
                CgpaField.clear();
                CurrentSemField.clear();
                ProgramManagerField.clear();
                DepartmentField.clear();
                GenderCombo.setValue("Gender");
                ReligionCombo.setValue("Religion");
            }
            else if(GenderCombo.getValue().equals("FEMALE")){
                Student student =new Student();
                student.setFirstName(FirstNameField.getText());
                student.setLastName(LastNameField.getText());
                student.setReligion(ReligionCombo.getValue());
                student.setDepartment(DepartmentField.getText());
                student.setPhoneNo(Double.parseDouble(PhoneNoField.getText()));
                student.setRegistrationNo(Integer.parseInt(RegistrationNoField.getText()));
                student.setCurrentSem(Integer.parseInt(CurrentSemField.getText()));
                student.setProgramManager(ProgramManagerField.getText());
                student.setGender(GenderCombo.getValue());
                student.setCgpa(Double.parseDouble(CgpaField.getText()));
                ObservableStudentList.add(student);
                //System.out.println(ObservableStudentList);

                StudentTable.setItems(ObservableStudentList);
                //StudentTable.getColumns().addAll(FirstNameCol,LastNameCol,RegistrationNoCol,PhoneNoCol,CurrentSemCol,CgpaCol,DepartmentCol,ProgramManagerCol,GenderCol,ReligionCol);

>>>>>>> 08e625c215e3c627778218ea7b0ef9416d87984c:src/HammadAslam/StudentController.java
                FirstNameField.clear();
                LastNameField.clear();
                RegistrationNoField.clear();
                PhoneNoField.clear();
                CgpaField.clear();
                CurrentSemField.clear();
                ProgramManagerField.clear();
                DepartmentField.clear();
                GenderCombo.setValue("Gender");
                ReligionCombo.setValue("Religion");
            }
        }
<<<<<<< HEAD:TABLE/src/sample/Controller.java
<<<<<<< HEAD
=======
>>>>>>> 08e625c215e3c627778218ea7b0ef9416d87984c:src/HammadAslam/StudentController.java
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
            RegistrationNoField.clear();
            PhoneNoField.clear();
            CgpaField.clear();
            CurrentSemField.clear();
            ProgramManagerField.clear();
            DepartmentField.clear();
            GenderCombo.setValue("Gender");
            ReligionCombo.setValue("Religion");
        }
    }
}
    private boolean isValidInput(ActionEvent event) {
        boolean validInput = true;
<<<<<<< HEAD:TABLE/src/sample/Controller.java
=======



    }    private boolean isValidInput(ActionEvent event) {
        Boolean validInput = true;
>>>>>>> 729ff8ef47a5f07a4b4e2f2ac7d1f2909342b514
=======
>>>>>>> 08e625c215e3c627778218ea7b0ef9416d87984c:src/HammadAslam/StudentController.java
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
        if(RegistrationNoField== null || RegistrationNoField.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyRegistrationNoField = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyRegistrationNoField.setContentText("Registration Number is EMPTY");
            emptyRegistrationNoField.initModality(Modality.APPLICATION_MODAL);
            emptyRegistrationNoField.initOwner(owner);
            emptyRegistrationNoField.showAndWait();
            if(emptyRegistrationNoField.getResult() == ButtonType.OK) {
                emptyRegistrationNoField.close();
                RegistrationNoField.requestFocus();
            }
        }
        if(PhoneNoField == null || PhoneNoField.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyPhoneNoField = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyPhoneNoField.setContentText("Phone Number is EMPTY");
            emptyPhoneNoField.initModality(Modality.APPLICATION_MODAL);
            emptyPhoneNoField.initOwner(owner);
            emptyPhoneNoField.showAndWait();
            if(emptyPhoneNoField.getResult() == ButtonType.OK) {
                emptyPhoneNoField.close();
                PhoneNoField.requestFocus();

            }
        }
        if(CurrentSemField == null || CurrentSemField.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyCurrentSemField = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyCurrentSemField.setContentText("Current Sem is EMPTY");
            emptyCurrentSemField.initModality(Modality.APPLICATION_MODAL);
            emptyCurrentSemField.initOwner(owner);
            emptyCurrentSemField.showAndWait();
            if(emptyCurrentSemField.getResult() == ButtonType.OK) {
                emptyCurrentSemField.close();
                CurrentSemField.requestFocus();
            }
        }
        if(CgpaField == null || CgpaField.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyCgpaField = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyCgpaField.setContentText("Cgpa  is EMPTY");
            emptyCgpaField.initModality(Modality.APPLICATION_MODAL);
            emptyCgpaField.initOwner(owner);
            emptyCgpaField.showAndWait();
            if(emptyCgpaField.getResult() == ButtonType.OK) {
                emptyCgpaField.close();
                CgpaField.requestFocus();
            }
        }
        if(GenderCombo == null ||  GenderCombo.getValue().trim().isEmpty()) {
            validInput = false;
            Alert emptyGenderCombo = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyGenderCombo.setContentText("Gender is EMPTY");
            emptyGenderCombo.initModality(Modality.APPLICATION_MODAL);
            emptyGenderCombo.initOwner(owner);
            emptyGenderCombo.showAndWait();
            if(emptyGenderCombo.getResult() == ButtonType.OK) {
                emptyGenderCombo.close();
                GenderCombo.requestFocus();
            }
        }  if(ReligionCombo == null || ReligionCombo.getValue().trim().isEmpty()) {
            validInput = false;
            Alert emptyReligionCombo = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyReligionCombo.setContentText("Religion is EMPTY");
            emptyReligionCombo.initModality(Modality.APPLICATION_MODAL);
            emptyReligionCombo.initOwner(owner);
            emptyReligionCombo.showAndWait();
            if(emptyReligionCombo.getResult() == ButtonType.OK) {
                emptyReligionCombo.close();
                ReligionCombo.requestFocus();
            }
        }  if(DepartmentField == null || DepartmentField.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyDepartmentField = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyDepartmentField.setContentText("Department is EMPTY");
            emptyDepartmentField.initModality(Modality.APPLICATION_MODAL);
            emptyDepartmentField.initOwner(owner);
            emptyDepartmentField.showAndWait();
            if(emptyDepartmentField.getResult() == ButtonType.OK) {
                emptyDepartmentField.close();
                DepartmentField.requestFocus();
            }
        }  if(ProgramManagerField == null || ProgramManagerField.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyProgramManagerField = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyProgramManagerField.setContentText("Program Manager is EMPTY");
            emptyProgramManagerField.initModality(Modality.APPLICATION_MODAL);
            emptyProgramManagerField.initOwner(owner);
            emptyProgramManagerField.showAndWait();
            if(emptyProgramManagerField.getResult() == ButtonType.OK) {
                emptyProgramManagerField.close();
                ProgramManagerField.requestFocus();
            }
        }


        return validInput;
    }
<<<<<<< HEAD:TABLE/src/sample/Controller.java
    public void handleSave(ActionEvent event) {
        Stage secondaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
<<<<<<< HEAD
        fileChooser.setTitle("Save-Student-Table");
=======
        fileChooser.setTitle("Save Student Table");
>>>>>>> 729ff8ef47a5f07a4b4e2f2ac7d1f2909342b514
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
=======

    public void handleSave(ActionEvent event) throws IOException {
     //   Stage secondaryStage = new Stage();
       // FileChooser fileChooser = new FileChooser();
       /// fileChooser.setTitle("Save-Student-Table");
        //fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
>>>>>>> 08e625c215e3c627778218ea7b0ef9416d87984c:src/HammadAslam/StudentController.java
        if(ObservableStudentList.isEmpty()) {
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
            File ss = new File("student.txt");
            if(!ss.exists()){
                ss.createNewFile();

            }
            saveFile(StudentTable.getItems(), ss);
        }
    }
    public void saveFile(ObservableList<Student> observableStudentList, File ss) {
        try {
FileWriter append =new FileWriter(ss.getName(),true);
         //   BufferedWriter outWriter = new BufferedWriter(new FileWriter(ss));
//jo comment mara hai upar usse file me data add hoga or neche wala jo chal raha hai abhi us se overwrite
            BufferedWriter outWriter = new BufferedWriter(new FileWriter(ss));

            for(Student students : observableStudentList) {
                outWriter.write(students.toString());
                outWriter.newLine();
            }
<<<<<<< HEAD:TABLE/src/sample/Controller.java
<<<<<<< HEAD
            //System.out.println(observableStudentList.toString());
=======
            System.out.println(observableStudentList.toString());
>>>>>>> 729ff8ef47a5f07a4b4e2f2ac7d1f2909342b514
=======
            //System.out.println(observableStudentList.toString());
            Alert SuccessAlert = new Alert(Alert.AlertType.INFORMATION, "Done", ButtonType.OK);
            SuccessAlert.setContentText("Save Succesfull");
            SuccessAlert.showAndWait();
            if(SuccessAlert.getResult() == ButtonType.OK) {
                SuccessAlert.close();
            }
>>>>>>> 08e625c215e3c627778218ea7b0ef9416d87984c:src/HammadAslam/StudentController.java
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



    public void handleClearButtonClick(ActionEvent event) {
        FirstNameField.clear();
        LastNameField.clear();
        RegistrationNoField.clear();
        PhoneNoField.clear();
        CgpaField.clear();
        CurrentSemField.clear();
        ProgramManagerField.clear();
        DepartmentField.clear();
        GenderCombo.setValue("Gender");
        ReligionCombo.setValue("Religion");

    }


    public void handleDeleteButtonClick(ActionEvent event) {
        if(!ObservableStudentList.isEmpty()){
            System.out.println("Delete button CLicked");
            Alert deleteAlert = new Alert(Alert.AlertType.WARNING, "Confirm", ButtonType.OK, ButtonType.CANCEL);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            deleteAlert.setContentText("Are you sure you want to delete this?\n\nTHIS CANNOT BE UNDONE.");
            deleteAlert.initModality(Modality.APPLICATION_MODAL);
            deleteAlert.initOwner(owner);
            deleteAlert.showAndWait();
            if(deleteAlert.getResult() == ButtonType.OK){
                ObservableStudentList.removeAll(StudentTable.getSelectionModel().getSelectedItem());
                StudentTable.getSelectionModel().clearSelection();
            }
            else{
                deleteAlert.close();

            }
        }

    }
    public void filterStudentList(String oldValue, String newValue) {
        ObservableList<Student> filteredList = FXCollections.observableArrayList();
        if(filterInput == null || (newValue.length() < oldValue.length()) || newValue == null) {
            StudentTable.setItems(ObservableStudentList);
        }
        else {
            newValue = newValue.toUpperCase();
            for(Student students :StudentTable.getItems()) {
                String filterFirstName = students.getFirstName();
                String filterLastName = students.getLastName();
                if(filterFirstName.toUpperCase().contains(newValue) || filterLastName.toUpperCase().contains(newValue)) {
                    filteredList.add(students);
                }
            }
            StudentTable.setItems(filteredList);
        }
    }




        public void CgpaCol_OnEditCommit(Event e) {
            TableColumn.CellEditEvent<Student, Double> cellEditEvent;
            cellEditEvent = (TableColumn.CellEditEvent<Student,Double>) e;
            Student student = cellEditEvent.getRowValue();
            student.setCgpa(cellEditEvent.getNewValue());
    }


    public void CurrentSemCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Student, Integer> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Student, Integer>) e;
        Student student = cellEditEvent.getRowValue();
        student.setCurrentSem(cellEditEvent.getNewValue());
    }

    public void DepartmentCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Student, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Student, String>) e;
        Student student = cellEditEvent.getRowValue();
        student.setDepartment(cellEditEvent.getNewValue());
    }


    public  void FirstNameCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Student, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Student, String>) e;
        Student student = cellEditEvent.getRowValue();
        student.setFirstName(cellEditEvent.getNewValue());
    }


    public void GenderCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Student, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Student, String>) e;
        Student student = cellEditEvent.getRowValue();
        student.setGender(cellEditEvent.getNewValue());
    }


    public void LastNameCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Student, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Student, String>) e;
        Student student = cellEditEvent.getRowValue();
        student.setLastName(cellEditEvent.getNewValue());
    }


    public void PhoneNo_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Student, Double> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Student, Double>) e;
        Student student = cellEditEvent.getRowValue();
        student.setPhoneNo(cellEditEvent.getNewValue());
    }


    public void ProgramManagerCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Student, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Student, String>) e;
        Student student = cellEditEvent.getRowValue();
        student.setProgramManager(cellEditEvent.getNewValue());
    }

    public void RegistrationNoCol_OnEditCommit(Event e) {

        TableColumn.CellEditEvent<Student, Integer> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Student, Integer>) e;
        Student student = cellEditEvent.getRowValue();
        student.setRegistrationNo(cellEditEvent.getNewValue());
    }


   public void ReligionCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Student, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Student, String>) e;
        Student student = cellEditEvent.getRowValue();
        student.setReligion(cellEditEvent.getNewValue());
    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void SwitchToTeacherTable(ActionEvent event) throws IOException{
        root= FXMLLoader.load(getClass().getResource("TeacherTable.fxml"));
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




}

