import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class RegularStudent extends Student {
    private String region;
    static Scanner input = new Scanner(System.in);
    public RegularStudent(String studentName, String sex, int birthDate, String stream, String region, int admissionNumber) {
        super(studentName, sex, birthDate, stream, admissionNumber);// using super keyword to call the father constructor
        this.region = region;
    }
    // an array list for storing regular student's info
    static ArrayList<RegularStudent> regStudent = new ArrayList<>();
    int age;
    public void succesfulMessage(RegularStudent regularStudent){

            // calculate student's age
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter currentYear = DateTimeFormatter.ofPattern("yyyy");
            age = Integer.parseInt(currentYear.format(now)) - getbirthDate();

        if(!regStudent.isEmpty() && (age >= 1)){
            for(RegularStudent currentStudentInfo: regStudent){
               if(currentStudentInfo.getAdmissionNumber() == regularStudent.getAdmissionNumber()){
                   System.out.println("\nThe student is already exists\n");
                   break;
               }
               else {
                   regStudent.add(regularStudent);
                   System.out.println("Regular student " + getStudentName() + " has been registered for " + getStream());
                   studentSlip();
                   break;
       }
               }
       }else if(regStudent.isEmpty() && (age >= 1)){
               regStudent.add(regularStudent);
               System.out.println("Regular student " + getStudentName() + " has been registered for " + getStream());
               studentSlip();
       }else {System.out.println("Student's age cannot be less than one!");}
    }
    public static void DisplayDataBaseEntry(){// Display the registered students
        System.out.println("-----| Registered Regular Students |------\n");
        if(regStudent.isEmpty()){
            System.out.println("\tNo regular student has been registered yet!\n");
        }
        else{
        for(RegularStudent student: regStudent){
            
            System.out.println("\tStudent Name: " + student.getStudentName());
            System.out.println("\tAdimission Number: " + student.getAdmissionNumber());
            System.out.println("\tBirth year: " +  student.getbirthDate());
            System.out.println("\tSex: " + student.getSex());
            System.out.println("\tStudent Stream: " + student.getStream());
            System.out.println("\tRegion: " + student.region + "\n"); 
        }
    }
    }
    static Main mainObject;
    static void update(){ // update student info
        if(regStudent.isEmpty())
        System.out.println("\nNothing to be updated, no student has registered yet!\n");
 
        else{
           for(RegularStudent student: regStudent){
             System.out.print("Enter student's Adimission to be updated: ");
             int currentId = input.nextInt();
             if(student.getAdmissionNumber() == currentId){
                 regStudent.remove(student);
                 System.out.println("Enter the new student's info"); 
                 Main.studentInput(); 
                 break;
             }
             else if(!(student.getAdmissionNumber() == currentId)){
                 System.out.println("The Adimission you entered is wrong!");}
         }
        }
    }
    static void delete(){ // delete student info
        if(regStudent.isEmpty())
        System.out.println("Nothing to be deleted, no student has registered yet!");
        else{
             for(RegularStudent student: regStudent){
            System.out.print("Enter student's Admission to be deleted: ");
            int deleteId = input.nextInt();
            if(student.getAdmissionNumber() == deleteId){
                regStudent.remove(student);
                System.out.println(student.getStudentName() + " has been deleted successfully!");
                break;
            }
            else if(!(student.getAdmissionNumber() == deleteId)){
                System.out.println("The Admission you entered is wrong!");}
        }

        }
    }
    // generate a registration slip
    void studentSlip(){
        // get the info from the list, the last one is the current
        RegularStudent currentStudentInfo = regStudent.get(regStudent.size() - 1);
            String aCourse, instrac, courseCode;
            String name = currentStudentInfo.getStudentName();
            String stream  = currentStudentInfo.getStream();
            String sex = currentStudentInfo.getSex();
            int idNumber = currentStudentInfo.getAdmissionNumber();
            String region = currentStudentInfo.region;
    
            if(Main.isNatural){// if the student registered for natural assign the following
                aCourse = "Physics";
                instrac = "Elias";
                courseCode = "Phy1";
            } 
            else {   // if the student is social student
            aCourse = "Economic";
            instrac = "Urgesa";
            courseCode = "Eco1";
        }
            //get the registered time
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
            LocalDateTime now = LocalDateTime.now();
            String formatedDate = dateFormatter.format(now);

            // print registration slip
            System.out.println("+----------------------------------------------------------------------------------+\n"+
                               "  |Collage | Institute  : Freshmen              | Issue Date:    " + formatedDate +"            \n"+
                               "----------------------------------------------------------------------------------\n"+
                               "        Program Name    : Freshmen                 | Semester  : Year I  Semester I  \n"+
                               "----------------------------------------------------------------------------------\n"+
                               "                       Student Registration Slip                                  \n"+
                               "-----------------------------------------------------------------------------------\n"+
                               "  |Modality: Regular    | Region : "+region+"       Stream: " + stream +"              \n"+
                               "  |Student Name         : " + name  + "             Sex: " + sex + "                    \n"+
                               "  |ID/ Admission Number : "+idNumber+ "             Age  : " +age+"  \n"+
                              "----------------------------------------------------------------------------------\n"+
                              "     #  |  course Title           |     Course Code       |  Cr.Hr   | Instructor \n"+
                              "------------------------------------------------------------------------------------\n"+
                              "     1  | English skill I         |     Eng1              |    3     |  Sofia     \n"+
                              "     2  | Geography               |     geo1              |    3     |  Endris    \n"+
                              "     3  |Logic & Critical Thinking|     Log1              |    3     |  Zelalem   \n"+
                              "     4  | Mathematics             |     Math2             |    3     |  Mohamed   \n"+
                              "     5  | Psychology              |     Psyc              |    3     |  Kidist    \n"+
                              "     6  |" + aCourse + "                 |     "+courseCode+ "              |    3     |"+instrac+ "\n"+
                              "------------------------------------------------------------------------------------\n"+
                              "                                                  Total   |   18     |             \n"+
                              "-----------------------------------------------------------------------------------\n"+
                              " Advisore:                                                | Registrar Name:       \n"+
                              "-----------------------------------------------------------------------------------");
        }
    @Override
    public void succesfulMessage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'succesfulMessage'");
    }
}