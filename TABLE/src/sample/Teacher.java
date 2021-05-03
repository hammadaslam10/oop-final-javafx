package sample;

import javafx.beans.property.*;

public class Teacher {
    private StringProperty FirstName =new SimpleStringProperty(this,"Firstname", "");
    private StringProperty LastName=new SimpleStringProperty(this,"LastName", "");
    private IntegerProperty IdNo = new SimpleIntegerProperty(this,"IdNo",0);
    private IntegerProperty Experience = new SimpleIntegerProperty(this,"Experience",0);
    private StringProperty Department= new SimpleStringProperty(this,"Department","");
    private StringProperty SubjectTeaches = new SimpleStringProperty(this,"SubjectTeaches","");
    private DoubleProperty PhoneNo = new SimpleDoubleProperty(this,"PhoneNo",0.0);
    private StringProperty Qualification=new SimpleStringProperty(this,"Qualification","");
    private StringProperty Designation =new SimpleStringProperty(this,"Designation","");
    private StringProperty Faculty =new SimpleStringProperty(this,"Faculty","");

    public Teacher(){

    }
    public Teacher(String firstName, String lastName, int idNo, int experience, String department, String subjectTeaches, double phoneNo, String qualification, String designation, String faculty) {
        this.FirstName = new SimpleStringProperty(firstName);
        this.LastName = new SimpleStringProperty(lastName);
        this.IdNo = new SimpleIntegerProperty(idNo);
        this.Experience =new SimpleIntegerProperty(experience);
        this.Department = new SimpleStringProperty(department);
        this.SubjectTeaches = new SimpleStringProperty(subjectTeaches);
        this.PhoneNo = new SimpleDoubleProperty(phoneNo);
        this.Qualification = new SimpleStringProperty(qualification);
        this.Designation = new SimpleStringProperty(designation);
        this.Faculty = new SimpleStringProperty(faculty);
    }

    public StringProperty firstNameProperty() {
        return FirstName;
    }

    public StringProperty lastNameProperty() {
        return LastName;
    }

    public DoubleProperty phoneNoProperty() {
        return PhoneNo;
    }

    public StringProperty departmentProperty() {
        return Department;
    }

    public IntegerProperty experienceProperty() {
        return Experience;
    }

    public StringProperty subjectTeachesProperty() {
        return SubjectTeaches;
    }

    public IntegerProperty idNoProperty() {
        return IdNo;
    }

    public StringProperty designationProperty() {
        return Designation;
    }

    public StringProperty facultyProperty() {
        return Faculty;
    }

    public StringProperty qualificationProperty() {
        return Qualification;
    }

    @Override
    public String toString() {
        return "|" + getFirstName() + "|" + getLastName() +"|"+getIdNo()+"|"+getPhoneNo()+"|"+getExperience()+"|"+getDepartment()+"|"+getSubjectTeaches()+"|"+getQualification()+"|"+getDesignation()+"|"+getFaculty();
    }

    public String getDepartment() {
        return Department.get();
    }

    public String getFirstName() {
        return FirstName.get();
    }

    public String getLastName() {
        return LastName.get();
    }

    public int getExperience() {
        return Experience.get();
    }

    public int getIdNo() {
        return IdNo.get();
    }

    public double getPhoneNo() {
        return PhoneNo.get();
    }

    public String getDesignation() {
        return Designation.get();
    }

    public String getFaculty() {
        return Faculty.get();
    }

    public String getQualification() {
        return Qualification.get();
    }

    public String getSubjectTeaches() {
        return SubjectTeaches.get();
    }

    public void setFirstName(String firstName) {
        this.FirstName.set(firstName);
    }

    public void setDepartment(String department) {
        this.Department.set(department);
    }

    public void setLastName(String lastName) {
        this.LastName.set(lastName);
    }

    public void setIdNo(int idNo) {
        this.IdNo.set(idNo);
    }

    public void setPhoneNo(double phoneNo) {
        this.PhoneNo.set(phoneNo);
    }

    public void setDesignation(String designation) {
        this.Designation.set(designation);
    }

    public void setExperience(int experience) {
        this.Experience.set(experience);
    }

    public void setFaculty(String faculty) {
        this.Faculty.set(faculty);
    }

    public void setQualification(String qualification) {
        this.Qualification.set(qualification);
    }

    public void setSubjectTeaches(String subjectTeaches) {
        this.SubjectTeaches.set(subjectTeaches);
    }
}
