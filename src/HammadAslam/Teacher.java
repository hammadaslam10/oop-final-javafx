package HammadAslam;

import javafx.beans.property.*;

public class Teacher {
    private StringProperty FirstName =new SimpleStringProperty(this,"Firstname", "");
    private StringProperty LastName=new SimpleStringProperty(this,"LastName", "");
    private LongProperty IdNo = new SimpleLongProperty(this,"IdNo",0);
    private DoubleProperty Experience = new SimpleDoubleProperty(this,"Experience",0.0);
    private StringProperty Department= new SimpleStringProperty(this,"Department","");
    private StringProperty SubjectTeaches = new SimpleStringProperty(this,"SubjectTeaches","");
    private LongProperty PhoneNo = new SimpleLongProperty(this,"PhoneNo",0);
    private StringProperty Qualification=new SimpleStringProperty(this,"Qualification","");
    private StringProperty Designation =new SimpleStringProperty(this,"Designation","");
    private StringProperty Faculty =new SimpleStringProperty(this,"Faculty","");

    public Teacher(){

    }
    //public Teacher(String firstName, String lastName, int idNo, int experience, String department, String subjectTeaches, double phoneNo, String qualification, String designation, String faculty) {

    public Teacher(String firstName, String lastName, long idNo, long phoneNo, double experience, String department, String subjectTeaches, String qualification, String designation, String faculty) {
            this.FirstName = new SimpleStringProperty(firstName);
            this.LastName = new SimpleStringProperty(lastName);
            this.IdNo = new SimpleLongProperty(idNo);
            this.PhoneNo = new SimpleLongProperty(phoneNo);
            this.Experience =new SimpleDoubleProperty(experience);
            this.Department = new SimpleStringProperty(department);
            this.SubjectTeaches = new SimpleStringProperty(subjectTeaches);
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

    public LongProperty phoneNoProperty() {
        return PhoneNo;
    }

    public StringProperty departmentProperty() {
        return Department;
    }

    public DoubleProperty experienceProperty() {
        return Experience;
    }

    public StringProperty subjectTeachesProperty() {
        return SubjectTeaches;
    }

    public LongProperty idNoProperty() {
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
        return getFirstName() +" "+ getLastName() +" "+getIdNo()+" "+getPhoneNo()+" "+getExperience()+" "+getDepartment()+" "+getSubjectTeaches()+" "+getQualification()+" "+getDesignation()+" "+getFaculty();
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

    public double getExperience() {
        return Experience.get();
    }

    public long getIdNo() {
        return IdNo.get();
    }

    public long getPhoneNo() {
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

    public void setIdNo(long idNo) {
        this.IdNo.set(idNo);
    }

    public void setPhoneNo(long phoneNo) {
        this.PhoneNo.set(phoneNo);
    }

    public void setDesignation(String designation) {
        this.Designation.set(designation);
    }

    public void setExperience(double experience) {
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
