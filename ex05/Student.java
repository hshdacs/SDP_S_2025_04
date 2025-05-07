package ex05;

public class Student extends Person {

    private String studyProgram;

    // this is the hidden and automatically provided
    // default ctor
//    public Student() {
//        super();
//    }

    public Student(String name, int age, char gender,
                    String studyProgram) {
        super(name, age, gender);
        this.studyProgram = studyProgram;
    }

}
