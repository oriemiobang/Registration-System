public abstract class Student {
    private String studentName;
    private String sex;
    private int birthDAte;
    private String stream;
    private int admissionNumber;
   

    public Student(String studentName, String sex, int birthDAte, String stream, int admissionNumber){
        this.studentName = studentName;
        this.sex = sex;
        this.birthDAte = birthDAte;
        this.stream = stream;
        this.admissionNumber = admissionNumber;
    }

    // abstract method to define the body later
    public abstract void succesfulMessage();
    
        // =========== define some getter and setter for private variables
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStream() {
        return stream;
    }
    public void set(String stream) {
        this.stream = stream;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getbirthDate() {
        return birthDAte;
    }
    public void setbirthDate(int birthDAte) {
        this.birthDAte = birthDAte;
    }
     public int getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(int admissionNumber) {
        this.admissionNumber = admissionNumber;
    }
}