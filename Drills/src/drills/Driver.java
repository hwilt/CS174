/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drills;

/**
 *
 * @author wilth
 */
public class Driver {
    public static void main(String[] args) {
      Student[] s = Student.makeStudents();
      for (int i = 0; i < s.length; i++) {
        System.out.print(s[i].getClassYear() + ".");
      }
    }
}