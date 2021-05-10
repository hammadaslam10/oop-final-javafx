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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    public void MainScreen(ActionEvent event) throws Exception{

    }
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

        FXMLLoader load = new FXMLLoader(getClass().getResource("StudentPortal.fxml"));
        root=load.load();
        StudentInfo stdntInfo = load.getController();

        stdntInfo.NameLabel.setText("Name :- "+username);
        stdntInfo.RegistrationNumberLabel.setText("Registration No:- "+RegStrNumber);
        //stdntInfo.PhoneNumberLabel.setText(PhoneNo);
        //stdntInfo.CurrentSemLabel.setText(CurrentSem);
        stdntInfo.CgpaLabel.setText("Cgpa :- "+Cgpa);
        //stdntInfo.DepartementLabel.setText(Department);
        //stdntInfo.ProgramManagaerLabel.setText(ProgramManager);
        //stdntInfo.ReligionLabel.setText(Religion);


        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();



    }
    public void SwitchToStudent(ActionEvent event) throws Exception{

        root=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
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
     public void SwitchToSem1(ActionEvent event) throws Exception{
         root=FXMLLoader.load(getClass().getResource("Semester1.fxml"));
         stage=(Stage)((Node)event.getSource()).getScene().getWindow();
         scene=new Scene(root);
         stage.setScene(scene);
         stage.show();


     }
    public void SwitchToSem2(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("Semester2.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    public void SwitchToSem3(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("Semester3.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    public void SwitchToSem4(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("Semester4.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    public void SwitchToSem5(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("Semester5.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }public void SwitchToSem6(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("Semester6.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    public void SwitchToSem7(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("Semester7.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    public void SwitchToSem8(ActionEvent event) throws Exception{
        root=FXMLLoader.load(getClass().getResource("Semester8.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


    @FXML
    private TextField transcript;
    @FXML
    private CheckBox IntrodutionToComputerScience;

    @FXML
    private CheckBox IntrodutionToComputerScienceLab;

    @FXML
    private CheckBox FunddamentalsOfProgramming;

    @FXML
    private CheckBox FunddamentalsOfProgrammingLab;

    @FXML
    private CheckBox EnglishCompositionAndComprehension;

    @FXML
    private CheckBox CalculusAndAnalyticalGeometry;

    @FXML
    private CheckBox AppliedPhysics;

    @FXML
    private CheckBox AppliedPhysicsLab;

    public void AddSem1(ActionEvent event) throws Exception{
int total=0;
if(FunddamentalsOfProgrammingLab.isSelected()){
    total=total+1000;
}
        if(FunddamentalsOfProgramming.isSelected()){
            total=total+1000;
        }

if(IntrodutionToComputerScience.isSelected()){
    total=total+1000;
}
if(IntrodutionToComputerScienceLab.isSelected()){
    total=total+1000;
}

        if(EnglishCompositionAndComprehension.isSelected()){
            total=total+1000;
        }

        if(CalculusAndAnalyticalGeometry.isSelected()){
            total=total+1000;
        }

        if(AppliedPhysics.isSelected()){
            total=total+1000;
        }

        if(AppliedPhysicsLab.isSelected()){
            total=total+1000;
        }
        transcript.setText("The course Fee is"+ total +" PKR");


    }

    public void ClearSem1(ActionEvent event) throws Exception{
IntrodutionToComputerScienceLab.setSelected(false);
IntrodutionToComputerScience.setSelected(false);
FunddamentalsOfProgrammingLab.setSelected(false);
FunddamentalsOfProgramming.setSelected(false);
EnglishCompositionAndComprehension.setSelected(false);
CalculusAndAnalyticalGeometry.setSelected(false);
AppliedPhysicsLab.setSelected(false);
AppliedPhysics.setSelected(false);
transcript.clear();
    }
    @FXML
    private CheckBox ObjectOreientedProgramming;

    @FXML
    private CheckBox ObjectOreientedProgrammingLab;

    @FXML
    private CheckBox DigitalLogicDesign;

    @FXML
    private CheckBox DigitalLogicDesignLab;

    @FXML
    private CheckBox StatisticsAndProbability;

    @FXML
    private CheckBox CommunicationAndPresesntationSkill;
    @FXML
    private CheckBox Physcology;

    @FXML
    private CheckBox Sociology;

    @FXML
    private CheckBox DesignAndCreative;
   public void  Elective1Function(){
       if(DesignAndCreative.isSelected()){
           Sociology.setSelected(false);
           Physcology.setSelected(false);

       }

    }public void  Elective2Function(){
        if(Sociology.isSelected()){
            DesignAndCreative.setSelected(false);
            Physcology.setSelected(false);

        }
        }
        public void  Elective3Function(){
            if(Physcology.isSelected()){
                DesignAndCreative.setSelected(false);
                Sociology.setSelected(false);

            }

        }

            public void AddSem2(ActionEvent event) throws Exception{
int total=0;
if(DesignAndCreative.isSelected()==true || Sociology.isSelected()==true ||Physcology.isSelected()==true){
    total=total+1000;
}


if(ObjectOreientedProgrammingLab.isSelected()){
    total=total+1000;
}
if(ObjectOreientedProgramming.isSelected()){
    total=total+1000;
        }
if(DigitalLogicDesignLab.isSelected()){
    total=total+1000;
        }
        if(DigitalLogicDesign.isSelected()){
            total=total+1000;
        }
        if(StatisticsAndProbability.isSelected()){
            total=total+1000;
        }
        if(CommunicationAndPresesntationSkill.isSelected()){
            total=total+1000;
        }
        transcript.setText("The course Fee is"+ total +" PKR");

    }
    public void ClearSem2(ActionEvent event) throws Exception{
        ObjectOreientedProgramming.setSelected(false);
        ObjectOreientedProgrammingLab.setSelected(false);
        DesignAndCreative.setSelected(false);
        DigitalLogicDesign.setSelected(false);
        DigitalLogicDesignLab.setSelected(false);
        Sociology.setSelected(false);
        Physcology.setSelected(false);
        StatisticsAndProbability.setSelected(false);
        CommunicationAndPresesntationSkill.setSelected(false);
        transcript.clear();
    }

    @FXML
    private CheckBox ComputerOrganizationAndAssemblyLangugae;

    @FXML
    private CheckBox ComputerOrganizationAndAssemblyLangugaeLabLab;

    @FXML
    private CheckBox DataStructuresAndAlgorhithims;

    @FXML
    private CheckBox DataStructuresAndAlgorhithimsLab;

    @FXML
    private CheckBox DiscreteMathemeticalStructures;

    @FXML
    private CheckBox ProfessionalPractice;

    @FXML
    private CheckBox GraphTheory;

    @FXML
    private CheckBox DifferentialEquation;

    @FXML
    private CheckBox TheoryOfProgrammingLanguage;

    @FXML
    private CheckBox MultivarieateCalculus;

    @FXML
    private CheckBox NumericalComputing;

    public void AddSem3(ActionEvent event) throws Exception{
int total=0;
if(DifferentialEquation.isSelected()==true || GraphTheory.isSelected()==true || NumericalComputing.isSelected()==true || MultivarieateCalculus.isSelected()==true ||TheoryOfProgrammingLanguage.isSelected()==true){
   total=total+1000;
}
if(ComputerOrganizationAndAssemblyLangugae.isSelected()){
   total=total+1000;
}
        if(ComputerOrganizationAndAssemblyLangugaeLabLab.isSelected()){
            total=total+1000;
        }
        if(DataStructuresAndAlgorhithimsLab.isSelected()){
            total=total+1000;
        }
        if(DataStructuresAndAlgorhithims.isSelected()){
            total=total+1000;
        }
        if(DiscreteMathemeticalStructures.isSelected()){
            total=total+1000;
        }
        if(ProfessionalPractice.isSelected()){
            total=total+1000;
        }
        transcript.setText("The course Fee is"+ total +" PKR");

    }
    public void ClearSem3(ActionEvent event) throws Exception{
ComputerOrganizationAndAssemblyLangugae.setSelected(false);
ComputerOrganizationAndAssemblyLangugaeLabLab.setSelected(false);
DataStructuresAndAlgorhithims.setSelected(false);
DataStructuresAndAlgorhithimsLab.setSelected(false);
DiscreteMathemeticalStructures.setSelected(false);
ProfessionalPractice.setSelected(false);
DifferentialEquation.setSelected(false);
GraphTheory.setSelected(false);
NumericalComputing.setSelected(false);
MultivarieateCalculus.setSelected(false);
TheoryOfProgrammingLanguage.setSelected(false);
        transcript.clear();

    }

    public void CsSupportingFunction1Sem2(ActionEvent event) {
if(DifferentialEquation.isSelected()){
    GraphTheory.setSelected(false);
    NumericalComputing.setSelected(false);
    MultivarieateCalculus.setSelected(false);
    TheoryOfProgrammingLanguage.setSelected(false);

}
    }


    public void CsSupportingFunction2Sem2(ActionEvent event) {
        if(NumericalComputing.isSelected()){
            DifferentialEquation.setSelected(false);
            GraphTheory.setSelected(false);
            MultivarieateCalculus.setSelected(false);
            TheoryOfProgrammingLanguage.setSelected(false);

        }

    }


    public void CsSupportingFunction3Sem2(ActionEvent event) {
        if(GraphTheory.isSelected()){
            DifferentialEquation.setSelected(false);
            NumericalComputing.setSelected(false);
            MultivarieateCalculus.setSelected(false);
            TheoryOfProgrammingLanguage.setSelected(false);

        }

    }


    public    void CsSupportingFunction4Sem2(ActionEvent event) {
        if(MultivarieateCalculus.isSelected()){
            DifferentialEquation.setSelected(false);
            GraphTheory.setSelected(false);
            NumericalComputing.setSelected(false);
            TheoryOfProgrammingLanguage.setSelected(false);

        }

    }


public void CsSupportingFunction5Sem2(ActionEvent event) {
    if(TheoryOfProgrammingLanguage.isSelected()){
        DifferentialEquation.setSelected(false);
        GraphTheory.setSelected(false);
        NumericalComputing.setSelected(false);
        MultivarieateCalculus.setSelected(false);


    }

    }
    @FXML
    private CheckBox DesignAndAnalysisOfAlgorithms;

    @FXML
    private CheckBox FiniteAutmotaTheory;

    @FXML
    private CheckBox DataBaseSystems;

    @FXML
    private CheckBox DataBaseSystemsLab;

    @FXML
    private CheckBox LinearAlgebra;

    @FXML
    private CheckBox OrgazanizationalBehaviour;

    @FXML
    private CheckBox IntroductionToAccounting;

    @FXML
    private CheckBox ForeignLanguages;

    @FXML
    private CheckBox SystemsAdminiration;

    public void AddSem4(ActionEvent event) throws Exception{
        int total=0;
if(IntroductionToAccounting.isSelected()==true||OrgazanizationalBehaviour.isSelected()==true||SystemsAdminiration.isSelected()==true||ForeignLanguages.isSelected()==true){
    total=total+1000;

}
if(DesignAndAnalysisOfAlgorithms.isSelected()){
    total=total+1000;
}
        if(FiniteAutmotaTheory.isSelected()){
            total=total+1000;
        }
        if(DataBaseSystems.isSelected()){
            total=total+1000;
        }
        if(DataBaseSystemsLab.isSelected()){
            total=total+1000;
        }
        if(LinearAlgebra.isSelected()){
            total=total+1000;
        }
        transcript.setText("The course Fee is"+ total +" PKR");


    }
    public void ClearSem4(ActionEvent event) throws Exception{
DesignAndAnalysisOfAlgorithms.setSelected(false);
FiniteAutmotaTheory.setSelected(false);
DataBaseSystems.setSelected(false);
DataBaseSystemsLab.setSelected(false);
LinearAlgebra.setSelected(false);
IntroductionToAccounting.setSelected(false);
OrgazanizationalBehaviour.setSelected(false);
SystemsAdminiration.setSelected(false);
ForeignLanguages.setSelected(false);
        transcript.clear();
    }

    public void Elective1FunctionSem4(ActionEvent event) {
if(IntroductionToAccounting.isSelected()){
    OrgazanizationalBehaviour.setSelected(false);
    SystemsAdminiration.setSelected(false);
    ForeignLanguages.setSelected(false);

}
    }

    public void Elective2FunctionSem4(ActionEvent event) {
if(OrgazanizationalBehaviour.isSelected()){
    IntroductionToAccounting.setSelected(false);
    SystemsAdminiration.setSelected(false);
    ForeignLanguages.setSelected(false);

}
    }


    public void Elective3FunctionSem4(ActionEvent event) {
        if(SystemsAdminiration.isSelected()){
            IntroductionToAccounting.setSelected(false);
            OrgazanizationalBehaviour.setSelected(false);
            ForeignLanguages.setSelected(false);

        }

    }


    public void Elective4FunctionSem4(ActionEvent event) {
        if(ForeignLanguages.isSelected()){
            IntroductionToAccounting.setSelected(false);
            OrgazanizationalBehaviour.setSelected(false);
            SystemsAdminiration.setSelected(false);

        }

    }
    @FXML
    private CheckBox CompilerConstruction;

    @FXML
    private CheckBox OperatingSystem;

    @FXML
    private CheckBox OperatingSystemLab;

    @FXML
    private CheckBox SoftwareEngineering;

    public void AddSem5(ActionEvent event) throws Exception{
        int total=0;
        if(DifferentialEquation.isSelected()==true || GraphTheory.isSelected()==true || NumericalComputing.isSelected()==true || MultivarieateCalculus.isSelected()==true ||TheoryOfProgrammingLanguage.isSelected()==true){
            total=total+1000;
        }
        if(OperatingSystemLab.isSelected()){
            total=total+1000;

        }
        if(OperatingSystem.isSelected()){
            total=total+1000;

        }if(SoftwareEngineering.isSelected()){
            total=total+1000;

        }if(CompilerConstruction.isSelected()){
            total=total+1000;

        }
        transcript.setText("The course Fee is"+ total +" PKR");

    }
    public void ClearSem5(ActionEvent event) throws Exception{
        OperatingSystem.setSelected(false);
        OperatingSystemLab.setSelected(false);
        SoftwareEngineering.setSelected(false);
        CompilerConstruction.setSelected(false);
        DifferentialEquation.setSelected(false);
        GraphTheory.setSelected(false);
        NumericalComputing.setSelected(false);
        MultivarieateCalculus.setSelected(false);
        TheoryOfProgrammingLanguage.setSelected(false);
        transcript.clear();
    }
    @FXML
    private CheckBox ArtificalIntelligence;

    @FXML
    private CheckBox ArtificalIntelligenceLab;

    @FXML
    private CheckBox ComputerNetworksAndDataCommunication;

    @FXML
    private CheckBox ComputerNetworksAndDataCommunicationLab;

    @FXML
    private CheckBox TechnicalAndBussinessWriting;


    @FXML
    private CheckBox WebTechnologies;

    @FXML
    private CheckBox AndriodApplicationDevelopment;

    @FXML
    private CheckBox IosDevelopment;

    @FXML
    private CheckBox EthicalHacking;

    @FXML
    private CheckBox EmbededSystems;

    @FXML
    private CheckBox SoftwareProjectManagement;
    public void AddSem6(ActionEvent event) throws Exception{
int total=0;
        if(AndriodApplicationDevelopment.isSelected()==true||EthicalHacking.isSelected()==true||IosDevelopment.isSelected()==true ||EmbededSystems.isSelected()==true||SoftwareProjectManagement.isSelected()==true||WebTechnologies.isSelected()==true){
    total=total+1000;
}
        if(ArtificalIntelligenceLab.isSelected()){
            total=total+1000;

        }
        if(ArtificalIntelligence.isSelected()){
            total=total+1000;

        }  if(TechnicalAndBussinessWriting.isSelected()){
            total=total+1000;

        }  if(ComputerNetworksAndDataCommunicationLab.isSelected()){
            total=total+1000;

        }  if(ComputerNetworksAndDataCommunication.isSelected()){
            total=total+1000;

        }
        transcript.setText("The course Fee is"+ total +" PKR");


    }
    public void ClearSem6(ActionEvent event) throws Exception{
AndriodApplicationDevelopment.setSelected(false);
EthicalHacking.setSelected(false);
IosDevelopment.setSelected(false);
EmbededSystems.setSelected(false);
SoftwareProjectManagement.setSelected(false);
WebTechnologies.setSelected(false);
TechnicalAndBussinessWriting.setSelected(false);
ArtificalIntelligence.setSelected(false);
ArtificalIntelligenceLab.setSelected(false);
ComputerNetworksAndDataCommunication.setSelected(false);
ComputerNetworksAndDataCommunicationLab.setSelected(false);
        transcript.clear();
    }

    public void CsElectiveFunction1Sem6(ActionEvent event) {
if(AndriodApplicationDevelopment.isSelected()){
    EthicalHacking.setSelected(false);
    IosDevelopment.setSelected(false);
    EmbededSystems.setSelected(false);
    SoftwareProjectManagement.setSelected(false);
    WebTechnologies.setSelected(false);

}
    }


    public  void CsElectiveFunction2Sem6(ActionEvent event) {
        if( WebTechnologies.isSelected()){
            AndriodApplicationDevelopment.setSelected(false);
            EthicalHacking.setSelected(false);
            IosDevelopment.setSelected(false);
            EmbededSystems.setSelected(false);
            SoftwareProjectManagement.setSelected(false);

        }

    }


    public  void CsElectiveFunction3Sem6(ActionEvent event) {
        if( EthicalHacking.isSelected()){
            AndriodApplicationDevelopment.setSelected(false);
            IosDevelopment.setSelected(false);
            EmbededSystems.setSelected(false);
            SoftwareProjectManagement.setSelected(false);
            WebTechnologies.setSelected(false);

        }

    }


    public  void CsElectiveFunction4Sem6(ActionEvent event) {
        if(IosDevelopment.isSelected()){
            AndriodApplicationDevelopment.setSelected(false);
            EthicalHacking.setSelected(false);
            EmbededSystems.setSelected(false);
            SoftwareProjectManagement.setSelected(false);
            WebTechnologies.setSelected(false);

        }

    }


    public  void CsElectiveFunction5Sem6(ActionEvent event) {
        if(SoftwareProjectManagement.isSelected()){
            AndriodApplicationDevelopment.setSelected(false);
            EthicalHacking.setSelected(false);
            IosDevelopment.setSelected(false);
            EmbededSystems.setSelected(false);
            WebTechnologies.setSelected(false);

        }

    }


    public  void CsElectiveFunction6Sem6(ActionEvent event) {
        if(EmbededSystems.isSelected()){
            AndriodApplicationDevelopment.setSelected(false);
            EthicalHacking.setSelected(false);
            IosDevelopment.setSelected(false);
            SoftwareProjectManagement.setSelected(false);
            WebTechnologies.setSelected(false);

        }

    }
    @FXML
    private CheckBox FinalYearProject;

    @FXML
    private CheckBox ParallelAndDistributedComputing;
    @FXML
    private CheckBox HistoryOfScientificIdeas;

    @FXML
    private CheckBox BussinesAndTechnologyEthics;

    @FXML
    private CheckBox ManagementPrinciples;

    @FXML
    private CheckBox ResearchReport;


    public void AddSem7(ActionEvent event) throws Exception{
        int total=0;
        if(AndriodApplicationDevelopment.isSelected()==true||EthicalHacking.isSelected()==true||IosDevelopment.isSelected()==true ||EmbededSystems.isSelected()==true||SoftwareProjectManagement.isSelected()==true||WebTechnologies.isSelected()==true){
            total=total+1000;
        }
        if(ResearchReport.isSelected()==true||ManagementPrinciples.isSelected()==true||HistoryOfScientificIdeas.isSelected()==true||BussinesAndTechnologyEthics.isSelected()==true){
            total=total+1000;

        }
        if(FinalYearProject.isSelected()){
            total=total+1000;

        }if(ParallelAndDistributedComputing.isSelected()){
            total=total+1000;

        }
        transcript.setText("The course Fee is"+ total +" PKR");

    }
    public void ClearSem7(ActionEvent event) throws Exception{
        FinalYearProject.setSelected(false);
        ParallelAndDistributedComputing.setSelected(false);
        AndriodApplicationDevelopment.setSelected(false);
        EthicalHacking.setSelected(false);
        IosDevelopment.setSelected(false);
        EmbededSystems.setSelected(false);
        SoftwareProjectManagement.setSelected(false);
        WebTechnologies.setSelected(false);
        ResearchReport.setSelected(false);
        ManagementPrinciples.setSelected(false);
        HistoryOfScientificIdeas.setSelected(false);
        BussinesAndTechnologyEthics.setSelected(false);
        transcript.clear();

    }
    public  void UniElectiveFunction1Sem7(ActionEvent event) {
        if(HistoryOfScientificIdeas.isSelected()){
            ResearchReport.setSelected(false);
            ManagementPrinciples.setSelected(false);
            BussinesAndTechnologyEthics.setSelected(false);

        }

    }
    public  void UniElectiveFunction2Sem7(ActionEvent event) {
        if(BussinesAndTechnologyEthics.isSelected()){
            ResearchReport.setSelected(false);
            ManagementPrinciples.setSelected(false);
            HistoryOfScientificIdeas.setSelected(false);


        }

    }
    public  void UniElectiveFunction3Sem7(ActionEvent event) {
        if(ManagementPrinciples.isSelected()){
            ResearchReport.setSelected(false);
            HistoryOfScientificIdeas.setSelected(false);
            BussinesAndTechnologyEthics.setSelected(false);

        }

    }

    public  void UniElectiveFunction4Sem7(ActionEvent event) {
        if(ResearchReport.isSelected()){
            ManagementPrinciples.setSelected(false);
            HistoryOfScientificIdeas.setSelected(false);
            BussinesAndTechnologyEthics.setSelected(false);

        }

    }

    @FXML
    private CheckBox FinalYearProject2;

    @FXML
    private CheckBox InformationSecurity;
    @FXML
    private CheckBox PakistanAndIslamicStudies;


    public void AddSem8(ActionEvent event) throws Exception{
        int total=0;
        if(AndriodApplicationDevelopment.isSelected()==true||EthicalHacking.isSelected()==true||IosDevelopment.isSelected()==true ||EmbededSystems.isSelected()==true||SoftwareProjectManagement.isSelected()==true||WebTechnologies.isSelected()==true){
            total=total+1000;
        }
        if(ResearchReport.isSelected()==true||ManagementPrinciples.isSelected()==true||HistoryOfScientificIdeas.isSelected()==true||BussinesAndTechnologyEthics.isSelected()==true){
            total=total+1000;

        }
        if(FinalYearProject2.isSelected()){
            total=total+1000; 
        }
        if(InformationSecurity.isSelected()){
            total=total+1000;
        }if(PakistanAndIslamicStudies.isSelected()){
            total=total+1000;
        }
        transcript.setText("The course Fee is"+ total +" PKR");

    }
    public void ClearSem8(ActionEvent event) throws Exception{
        AndriodApplicationDevelopment.setSelected(false);
        EthicalHacking.setSelected(false);
        IosDevelopment.setSelected(false);
        EmbededSystems.setSelected(false);
        SoftwareProjectManagement.setSelected(false);
        WebTechnologies.setSelected(false);
        ResearchReport.setSelected(false);
        ManagementPrinciples.setSelected(false);
        HistoryOfScientificIdeas.setSelected(false);
        BussinesAndTechnologyEthics.setSelected(false);
        FinalYearProject2.setSelected(false);
        InformationSecurity.setSelected(false);
        PakistanAndIslamicStudies.setSelected(false);
        transcript.clear();
    }


}


