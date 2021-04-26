package HammadAslam;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Signup{
    public String uname;
    public String pass;

    public void signup(){
        try {
            System.out.println("enter User name");
            Scanner s1 = new Scanner(System.in);
            this.uname = s1.nextLine();
            System.out.println("Enter password");
            Scanner s2 = new Scanner(System.in);
            this.pass = s2.nextLine();



            File f1 = new File("Staff.txt");
            if (!f1.exists()) {
                f1.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(f1.getName(), true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write(  uname +",");
            bw.write(  pass  +"\n");
            bw.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}




/*import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class Signup {

    public void signup() {
        System.out.println("Enter Username");
        Scanner s1 = new Scanner(System.in);
        String uname = s1.nextLine();
        System.out.println("Enter password");
        Scanner s2 = new Scanner(System.in);
        int pass = s2.nextInt();
        try {
            File staff1 = new File("Staff.txt");
            if (staff1.createNewFile()) {
                FileWriter staff = new FileWriter("Staff.txt");
                staff.write(uname);
                staff.write(pass);
                staff.close();
                System.out.println("You have been registered!");
            }
        }
        catch (IOException e){
            System.out.println("An error occured");
        }
    }
}*/