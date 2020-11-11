/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drills;

public class Student {
    private int age;
    private String firstName;
    private String lastName;
    private String classYear;
    
    // Constructor.  When I say new Student(), it will call this
    // method to initialize a new object of type student
    /**
    * @param a Age of student I'm making
    * @param f First name of student I'm making
    * @param l Last name of student I'm making
    */
    public Student(int a, String f, String l, String cy) {
        age = a;
        firstName = f;
        lastName = l;
        classYear = cy;
    }

    public String getClassYear() {
      return classYear;
    }

    /**
     * Return an array of 20 students, the first 10 of whom
     * are freshmen and the last 10 of whom are sophomores
     */
    public static Student[] makeStudents() {
        Student[] s = new Student[20];
        /**s[0] = new Student(18, "Henry", "Wilt", "Freshman");
        s[1] = new Student(18, "Henry", "Wilt", "Freshman");
        s[2] = new Student(18, "Henry", "Wilt", "Freshman");
        s[3] = new Student(18, "Henry", "Wilt", "Freshman");
        s[4] = new Student(18, "Henry", "Wilt", "Freshman");
        s[5] = new Student(18, "Henry", "Wilt", "Freshman");
        s[6] = new Student(18, "Henry", "Wilt", "Freshman");
        s[7] = new Student(18, "Henry", "Wilt", "Freshman");
        s[8] = new Student(18, "Henry", "Wilt", "Freshman");
        s[9] = new Student(18, "Henry", "Wilt", "Freshman");
        s[10] = new Student(18, "Henry", "Wilt", "Sophomore");
        s[11] = new Student(18, "Henry", "Wilt", "Sophomore");
        s[12] = new Student(18, "Henry", "Wilt", "Sophomore");
        s[13] = new Student(18, "Henry", "Wilt", "Sophomore");
        s[14] = new Student(18, "Henry", "Wilt", "Sophomore");
        s[15] = new Student(18, "Henry", "Wilt", "Sophomore");
        s[16] = new Student(18, "Henry", "Wilt", "Sophomore");
        s[17] = new Student(18, "Henry", "Wilt", "Sophomore");
        s[18] = new Student(18, "Henry", "Wilt", "Sophomore");
        s[19] = new Student(18, "Henry", "Wilt", "Sophomore");
        */
        for(int i = 0; i <= 9; i++){
            s[i] = new Student(18, "Henry", "Wilt", "Freshman");
        }
        for(int j = 10; j <= 19; j++){
            s[j] = new Student(19, "Tom", "Brady", "Sophomore");
        }
        return s;
    }

}