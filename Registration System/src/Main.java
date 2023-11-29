import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // creating some objects to get access to  methods and variables in other classes
    static InternationalStudent internationalStudent;
    static RegularStudent regularStudent;
    static boolean isRegular = false, isNatural = false;
    static Student student;

    static void studentInput(){ // enter some studnt's info 
       
    System.out.println();
       try {
        Scanner inputInfo = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String studentName = inputInfo.nextLine().toUpperCase();
        if(!studentName.matches("[a-zA-Z+' ']+"))// if the name contain something other than letter and space throw an exception
        throw new AssertionError();
        System.out.print("Enter student's Admission/ID number: ");
        int admissionNumber = inputInfo.nextInt();
        inputInfo.nextLine();
        
        System.out.print("Enter student's stream:\n1. Natural Scinece\n2. Social Science ");
        String studentStream = inputInfo.nextLine();
        if(studentStream.equals("1")){
            studentStream = "NATURAL SCIENCE";
            isNatural = true;
        }else if(studentStream.equals("2")){
             studentStream = "SOCIAL SCIENCE"; 
             isNatural = false;
        }
        else// raise an exception if the user enter something other than 1 and 2
        throw new AssertionError();
        System.out.println("Enter your Gender: \n1. Male \n2. Female \n3. Other");
        String gender = inputInfo.nextLine();
        if(gender.equals("1"))
        gender = "MALE";
        else if(gender.equals("2"))
        gender = "FEMALE";
        else if(gender.equals("3"))
        gender = "OTHER";
        else
        throw new AssertionError();
        System.out.print("Enter student's birth date: ");
        int birthDate = inputInfo.nextInt();
        inputInfo.nextLine();// for the behavior of int, since it jumps stuffs haha!
        
        
        if(isRegular){// a the user his region if he is a regular meaning ethiopian
        System.out.print("Enter student's region: ");
        String region = inputInfo.nextLine().toUpperCase();
        RegularStudent regularStudent = new RegularStudent(studentName, gender, birthDate, studentStream, region, admissionNumber);
        regularStudent.succesfulMessage(regularStudent);
        }
        else if(!isRegular){// ask nationality if student is international student
        System.out.print("Enter student's nationality: ");
        String nationality = inputInfo.nextLine().toUpperCase();
        InternationalStudent internationalStudent = new InternationalStudent(studentName, gender, birthDate, studentStream, nationality, admissionNumber);
        internationalStudent.succesfulMessage(internationalStudent);
        
        }
    
        
    }   // catch if any error occurs in our try block
       catch (InputMismatchException ex){
        System.out.println("Please Enter a number in the place of ID or birth year!");
       }
       catch(AssertionError ex){
        System.out.println("\nInvalid Input!");
       }
    }

    public static void main(String[] args) {
        // just a title
        System.out.println("\n----------------------------------------------------------------------");
        System.out.println("----| Haramaya University Freshman Student's Registration System |----");
        System.out.println("-----------------------------------------------------------------------\n");
        
        boolean working = true;
        while(working){ // keep iterating until we exit
        Scanner input = new Scanner(System.in);
        System.out.println("Enter as: \n\n1. Student\n2. Admin\n3. Exit");
        String entryChoice = input.nextLine();

        if(entryChoice.equals("1")){// a student can only register
            System.out.println("Register as: \n1. Regular Student\n2. International Student");
            String registerChoice1 = input.nextLine();
            if(registerChoice1.equals("1")){
                isRegular = true;
                studentInput();
            }else if(registerChoice1.equals("2")){
                studentInput();
                isRegular = false;
            }else 
            System.out.println("Invalid input register as international or regular");

        }
        else if(entryChoice.equals("2")){
            //============================================
            //               USER NAME: admin          //
            //               PASSWORD: admin          //
            //=========================================

            System.out.print("Enter user name: ");// default user name and password for admin
            String userName = input.nextLine();
            System.out.print("Enter your password: ");
            String password = input.nextLine();
            if(userName.equals("admin") && password.equals("admin")){// check if user name and password matches
                boolean adminWorking = true;
                while (adminWorking) {

            System.out.println("Enter your choice: ");// what admin can do
            System.out.println("1. Register \n2. Display Student \n3. Update Student \n4. Delete Student \n5. Exit");
            String choice = input.nextLine();

        if(choice.equals("1")){// a student can be regular and international
             System.out.println("1. Regular Student\n2. International Student");
                String registerChoice = input.nextLine();
                if(registerChoice.equals("1")){
                    isRegular = true;
                    studentInput();
                } else if(registerChoice.equals("2")){
                    studentInput();
                    isRegular = false;
                }
                else
                System.out.println("Invalid input, choose regular or international");
            }
        else if(choice.equals("2")){
                    RegularStudent.displayRegistered();// display the registered students
                    InternationalStudent.displayRegistered();
                }
        else if(choice.equals("3")){// Update
            System.out.println("1. Update regular\n2. Update International");
            String choice2 = input.nextLine();
            if(choice2.equals("1")){
                     isRegular = true;
                     RegularStudent.update();
            }else if(choice2.equals("2")){
                    InternationalStudent.update();
                    isRegular = false;
            }       
            else 
            System.out.println("Invalid input, choose update regular or international");   
                }
        else if(choice.equals("4")){// delete a registered student
            System.out.println("1. delete regular\n2. Delete International");
            String choice3 = input.nextLine();
            if(choice3.equals("1")){
                     RegularStudent.delete();
            }
            else if(choice3.equals("2")){
                    InternationalStudent.delete();
               }
               else
               System.out.println("Invalid input choose delete regular or international");
            }      
        else if(choice.equals("5")){
             System.out.println("Exited Successfully!");
             System.exit(0);// terminate the program
            }
        else 
        System.out.println("Invaild input, choose one of the listed in menu.");

        System.out.println("Click one or anything to Continue\n2. Go to main menu\n3. Exit");
        String adminChoice2 = input.nextLine();
        if(adminChoice2.equals("2")){adminWorking = false;} 
        else if(adminChoice2.equals("3")){
            System.exit(0);// terminate the program
        }  
                }    
        }else {System.out.println("Password or user name incorect!");}
            }
             else if(entryChoice.equals("3")){
            System.exit(0);
        }
            else{
                System.out.println("Wrong input please try again!");
            }
        }
    }
}
