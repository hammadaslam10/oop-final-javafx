package HammadAslam;
import javafx.beans.property.*;

public class Student {
    private StringProperty FirstName =new SimpleStringProperty(this,"Firstname", "");
    private StringProperty LastName=new SimpleStringProperty(this,"LastName", "");
    private StringProperty Department = new SimpleStringProperty(this,"Department");
    private StringProperty ProgramManager = new SimpleStringProperty(this,"ProgramManager","");
    private StringProperty Gender= new SimpleStringProperty(this,"Gender","");
    private IntegerProperty RegistrationNo = new SimpleIntegerProperty(this,"Registration",0);
    private DoubleProperty PhoneNo=new SimpleDoubleProperty(this,"PhoneNo",0.0);
    private IntegerProperty CurrentSem =new SimpleIntegerProperty(this,"CurrentSem",0);
    private DoubleProperty Cgpa =new SimpleDoubleProperty(this,"Cgpa",0.0);
    private StringProperty Religion = new SimpleStringProperty(this,"Religion","");

    Student(){

    }

    public Student(String firstName, String lastName, String department, String programManager, String gender, int registrationNo, double phoneNo, int currentSem, double cgpa, String religion) {
        FirstName = new SimpleStringProperty(firstName);
        LastName = new SimpleStringProperty(lastName);
        Department = new SimpleStringProperty(department);
        ProgramManager = new SimpleStringProperty(programManager);
        Gender = new SimpleStringProperty(gender);
        RegistrationNo = new SimpleIntegerProperty(registrationNo);
        PhoneNo = new SimpleDoubleProperty(phoneNo);
        CurrentSem = new SimpleIntegerProperty(currentSem);
        Cgpa = new SimpleDoubleProperty(cgpa);
        Religion = new SimpleStringProperty(religion);
    }

    public StringProperty departmentProperty() {
        return Department;
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

    public IntegerProperty registrationNoProperty() {
        return RegistrationNo;
    }

    public DoubleProperty cgpaProperty() {
        return Cgpa;
    }


    public StringProperty programManagerProperty() {
        return ProgramManager;
    }

    public StringProperty genderProperty() {
        return Gender;
    }

    public StringProperty religionProperty() {
        return Religion;
    }

    public String getFirstName() {
        return FirstName.get();
    }

    public String getLastName() {
        return LastName.get();
    }

    public double getCgpa() {
        return Cgpa.get();
    }

    public int getCurrentSem() {
        return CurrentSem.get();
    }

    public double getPhoneNo() {
        return PhoneNo.get();
    }

    public String getDepartment() {
        return Department.get();
    }

    public String getProgramManager() {
        return ProgramManager.get();
    }

    public int getRegistrationNo() {
        return RegistrationNo.get();
    }

    public String getGender() {
        return Gender.get();
    }

    public String getReligion() {
        return Religion.get();
    }

    public void setFirstName(String firstName) {
        this.FirstName.set(firstName);
    }

    public void setLastName(String lastName) {
        this.LastName.set(lastName);
    }

    public void setGender(String gender) {
        this.Gender.set(gender);
    }

    public void setCgpa(double cgpa) {
        this.Cgpa.set(cgpa);
    }

    public void setCurrentSem(int currentSem) {
        this.CurrentSem.set(currentSem);
    }

    public void setDepartment(String department) {
        this.Department.set(department);
    }

    public void setPhoneNo(double phoneNo) {
        this.PhoneNo.set(phoneNo);
    }

    public void setProgramManager(String programManager) {
        this.ProgramManager.set(programManager);
    }

    public void setRegistrationNo(int registrationNo) {
        this.RegistrationNo.set(registrationNo);
    }

    public void setReligion(String religion) {
        this.Religion.set(religion);
    }

    public IntegerProperty currentSemProperty() {
        return CurrentSem;
    }
    public String toString() {
        return getFirstName() + " " + getLastName() +" "+getRegistrationNo()+" "+getPhoneNo()+" "+getCurrentSem()+" "+getCgpa()+" "+getDepartment()+" "+getProgramManager()+" "+getGender()+" "+getReligion();
    }

}
/*private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
 public String getFirstName() {
 return firstName.get();
 }
 public StringProperty firstNameProperty() {
 return firstName;
 }
 public void setFirstName(String firstName) {
 this.firstName.set(firstName);
 }

 private StringProperty lastName = new SimpleStringProperty(this, "lastName", "");
 public String getLastName() {return lastName.get();}
 public StringProperty lastNameProperty() {return lastName;}
 public void setLastName(String lastName) {
 this.lastName.set(lastName);
 }

 private StringProperty major = new SimpleStringProperty(this, "major", "");
 public String getMajor() {
 return major.get();
 }
 public StringProperty majorProperty() {
 return major;
 }
 public void setMajor(String major) {
 this.major.set(major);
 }

 private DoubleProperty gradepoint = new SimpleDoubleProperty(this, "gradePoint", 0.0);
 public double getGradepoint() {
 return gradepoint.get();
 }
 public DoubleProperty gradepointProperty() {
 return gradepoint;
 }
 public void setGradepoint(double gradepoint) {
 this.gradepoint.set(gradepoint);
 }

 private StringProperty uin = new SimpleStringProperty(this, "uin", "");
 public String getUin() {
 return uin.get();
 }
 public StringProperty uinProperty() {
 return uin;
 }
 public void setUin(String uin) {
 this.uin.set(uin);
 }

 private StringProperty netID = new SimpleStringProperty(this, "netID", "");
 public String getNetID() {
 return netID.get();
 }
 public StringProperty netIDProperty() {
 return netID;
 }
 public void setNetID(String netID) {
 this.netID.set(netID);
 }

 private IntegerProperty age = new SimpleIntegerProperty(this, "age", 0);
 public int getAge() {
 return age.get();
 }
 public IntegerProperty ageProperty() {
 return age;
 }
 public void setAge(int age) {
 this.age.set(age);
 }

 private StringProperty gender = new SimpleStringProperty(this, "gender", "");
 public String getGender() {
 return gender.get();
 }
 public StringProperty genderProperty() {
 return gender;
 }
 public void setGender(String gender) {
 this.gender.set(gender);
 }


 //for console printing purposes
 public String toString() {

 return "First Name: " + getFirstName() + " | Last Name: " + getLastName() + " | UIN: " + getUin() + " | NetID: " + getNetID() + " | Major: " + getMajor() + " | Age: " + getAge() + " | GPA: " + getGradepoint() + " | Gender: " + getGender();
 }
 }
 */