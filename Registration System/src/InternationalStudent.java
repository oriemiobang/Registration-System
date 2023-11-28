import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class InternationalStudent extends  Student{
    static Scanner input = new Scanner(System.in);
    String nationality;
    public InternationalStudent(String studentName, String sex, int birthDate, String major, String nationality, int admissionNumber) {
        super(studentName, sex, birthDate, major, admissionNumber);  // call super class constractor
        this.nationality = nationality;
    }
    // Store the student's info in an array list
     static ArrayList<InternationalStudent> internStudentList = new ArrayList<>();  
    int age;


     // Add student's info to the list and display a succesful message
    public void succesfulMessage(InternationalStudent internationalStudent){
        // calculate student's age
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter currentYear = DateTimeFormatter.ofPattern("yyyy");
        age = Integer.parseInt(currentYear.format(now)) - getbirthDate();
      
        if((!internStudentList.isEmpty()) && (age >= 1)){
             for(InternationalStudent currentStudentInfo: internStudentList){
                if(currentStudentInfo.getAdmissionNumber() == internationalStudent.getAdmissionNumber()){
                    System.out.println("\nThe student is already exists\n");
                    break;
                }
                else {
                    internStudentList.add(internationalStudent);
                    System.out.println("International student " + getStudentName() + " has been registered for " + getStream());
                    studentSlip();
                    break;
        }
                }
        }else if(internStudentList.isEmpty() && (age >= 1)){
                internStudentList.add(internationalStudent);
                System.out.println("International student " + getStudentName() + " has been registered for " + getStream());
                studentSlip();
        }else {
            System.out.println("Student's age can not be less than one!");
        }
        
        }
    public static void displayRegistered(){// Display the registered students
        System.out.println("-----| Registered International Students |----\n");
        if(internStudentList.isEmpty()){
            System.out.println("\t No international student has been registered yet!\n");
        }
        else{
        for(InternationalStudent student: internStudentList){
            System.out.println("\tStudent Name: " + student.getStudentName());
            System.out.println("\tStudent ID: " + student.getAdmissionNumber());
            System.out.println("\tBirth year: " +  student.getbirthDate());
            System.out.println("\tSex: " + student.getSex());
            System.out.println("\tStudent Stream: " + student.getStream());
            System.out.println("\tNationality: " + student.nationality + "\n");
        }}
    }
    static Main mainObject;
    static void update(){ // update student info
        for(InternationalStudent student: internStudentList){
            System.out.print("Enter student's Adimission/ID to be updated: ");
            int currentId = input.nextInt();
            if(student.getAdmissionNumber() == currentId){
                internStudentList.remove(student);
                System.out.println("Enter the new student's Info\n");
                Main.studentInput();
                break;
            }else if(student.getAdmissionNumber() == currentId) {
                System.out.println("The Adimission/ID you entered is wrong!");}
        }
    }
    static void delete(){// delete student info
        for(InternationalStudent student: internStudentList){
            System.out.print("Enter Student's Admission/ID to be deleted: ");
            int deletePerson = input.nextInt();
            if(student.getAdmissionNumber() == deletePerson){
                internStudentList.remove(student);
                System.out.println(student.getStudentName() + " has been deleted successfully!");
                break;
            }else if(!(student.getAdmissionNumber() == deletePerson)){
                System.out.println("The Addimision/ID you entered is wrong!");}
        }
    }
    // generate student slip
    void studentSlip(){
        // get the student info from the list
        InternationalStudent currentStudentInfo = internStudentList.get(internStudentList.size() - 1);
            String aCourse, instrac, courseCode;
            String name = currentStudentInfo.getStudentName();
            String stream  = currentStudentInfo.getStream();
            String sex = currentStudentInfo.getSex();
            int idNumber = currentStudentInfo.getAdmissionNumber();
            String nationality = currentStudentInfo.nationality;
           
            // assign the following if student is natural
            if(Main.isNatural){
                aCourse = "Physics";
                instrac = "Elias";
                courseCode = "Phy1";// the course codes are not real, just for practice purpose
            } 
            else {// if studnet is the social student
            aCourse = "Economic";
            instrac = "Urgesa";
            courseCode = "Eco1";
        } 
            // get registered date
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
            LocalDateTime now = LocalDateTime.now();
            String formatedDate = dateFormatter.format(now);
           
            // print registration slip
            System.out.println("\n+----------------------------------------------------------------------------------+\n"+
                               "  |Collage | Institute  : Freshmen                 | Issue Date:    " +formatedDate+ "\n"+
                               "----------------------------------------------------------------------------------\n"+
                               "     Program Name      : Freshmen                    | Semester  : Year I  Semester I  \n"+
                               "----------------------------------------------------------------------------------\n"+
                               "                       Student Registration Slip                                  \n"+
                               "-----------------------------------------------------------------------------------\n"+
                               "  |Student Modality     | International : "+nationality+"       Stream: " + stream +"\n"+
                               "  |Student Name         : " + name  + "                         Sex: " + sex + "\n"+
                               "  |ID/ Admission Number : "+idNumber+ "                         Age: "+age+ "\n"+
                               "----------------------------------------------------------------------------------\n"+
                               "     #  |  course Title           |     Course Code       |  Cr.Hr   | Instructor \n"+
                               "------------------------------------------------------------------------------------\n"+
                               "     1  | English skill I         |     Eng1              |    3     |  Sofia     \n"+
                               "     2  | Geography               |     geo1              |    3     |  Endris    \n"+
                               "     3  |Logic & Critical Thinking|     Log1              |    3     |  Zelalem   \n"+
                               "     4  | Mathematics             |     Math2             |    3     |  Mohamed   \n"+
                               "     5  | Psychology              |     Psyc              |    3     |  Kidist    \n"+
                               "     6  | " + aCourse + "         | "+courseCode+ " +     |    3     |   "+instrac+ "\n"+
                               "------------------------------------------------------------------------------------\n"+
                               "                                                  Total   |   18     |             \n"+
                               "-----------------------------------------------------------------------------------\n"+
                               " Advisore:                                                | Registrar Name:       \n"+
                               "------------------------------------------------------------------------------------");
        }
    @Override
    public void succesfulMessage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'succesfulMessage'");
    }
}