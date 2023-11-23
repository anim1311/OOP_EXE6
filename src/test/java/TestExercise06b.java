/**
 * DO NOT EDIT THIS FILE 
 * author: Ronny Hartanto (2022)
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.GregorianCalendar;
import java.util.Date;

public class TestExercise06b {

  @Test   
  public void test01()
  {
    PrintStream originalOut = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bos));
    GregorianCalendar date = new GregorianCalendar(1990, 01, 01);
    Student student1 = new Student("Stud1", "Fam1");
    student1.setDegree(StudyCourse.ME);
    assertEquals("Stud1", student1.getName());
    assertEquals("Stud1.Fam1@hsrw.org", student1.getEmail());
    student1.setName("Student1");
    assertEquals("Student1",student1.getName());
    assertEquals(student1.getDegree(), StudyCourse.ME);
    Student student2 = new Student("Stud2", "Fam2");
    User us = student2;
    assertEquals("Fam2", student2.getFamilyName());
    student2.setFamilyName("Family2");
    assertEquals("Family2",us.getFamilyName());
    assertEquals("Stud2.Family2@hsrw.org", us.getEmail());
    assertEquals(student2.getID(), "10001");
    student2.setDegree("EL");
    assertEquals(student2.getDegree(), StudyCourse.EL);
    Student student3 = new Student("Stud3", "Fam3", date.getTime());
    student3.setDegree(StudyCourse.IE);
    Student student4 = new Student("Stud4", "Fam4", date.getTime());
    assertEquals(student4.getID(), "10003");
    assertEquals(student3.getBirthday(), date.getTime());
    student4.setDegree("MME");
    assertEquals("Mechanical Engineering, M.Sc.", student4.getDegreeDescription());
    Student student5 = new Student("Stud5", "Fam5");
    student5.setDegree(StudyCourse.MSE);
    assertEquals(student5.getDegree(), StudyCourse.MSE);
    Student student6 = new Student("Stud6", "Fam6");
    assertEquals(student6.getID(), "10005");
    student6.setDegree("BMS");
    assertEquals(student6.getDegree(), StudyCourse.BMS);
    Student student7 = new Student("Stud7", "Fam7", date.getTime());
    student7.setDegree(StudyCourse.SCB);
    Student student8 = new Student("Stud8", "Fam8", date.getTime());
    assertEquals(student8.getID(), "10007");
    assertEquals(student8.getBirthday(), date.getTime());
    student8.setDegree("MBB");
    assertEquals("Mechanical Engineering, B.Sc.", student1.getDegreeDescription());     
    System.setOut(originalOut);
  }
  @Test
  public void test02()
  {
    PrintStream originalOut = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bos));
    GregorianCalendar date = new GregorianCalendar(1990, 01, 01);
    Student student1 = new Student("A", "B");
    student1.setDegree(StudyCourse.ME);
    assertEquals(student1.getDegree(), StudyCourse.ME);
    Student student2 = new Student("C", "D");
    assertEquals(student2.getID(), "10001");
    student2.setDegree("EL");
    assertEquals(student2.getDegree(), StudyCourse.EL);
    Student student3 = new Student("E", "F", date.getTime());
    Student student4 = new Student("G", "H", date.getTime());
    assertEquals(student4.getID(), "10003");
    User user = student4;
    assertEquals(user.getFQUN(), "10003@student.hsrw");
    assertEquals(((User) student3).getBirthday(), date.getTime());
    student4.setDegree("MME");
    assertEquals("Mechanical Engineering, M.Sc.", student4.getDegreeDescription());
    Professor prof1 = new Professor("xye", "X", "Ye");
    Professor prof2 = new Professor("abc", "A", "Bc", date.getTime());
    assertEquals(prof1.getFaculty(), Faculty.TUB);
    assertEquals(prof1.getFQUN(), "xye@staff.hsrw");
    prof2.setFaculty(Faculty.KU);
    prof2.setPhone(555);
    assertEquals(prof2.getFaculty(), Faculty.KU);
    assertEquals(prof2.getPhone(), "+49 2842 908 555");
    user = prof2;
    assertEquals(user.getFQUN(), "abc@staff.hsrw");
    Course oop = new Course("EL-2309", "Object Oriented Programming", prof1, 5);
    Classroom oop_class = new Classroom(oop, "09 01 020");
    oop_class.addStudent(student1);
    oop_class.addStudent(student2);
    oop_class.addStudent(student3);
    oop_class.addStudent(student4);
    assertEquals("A.B@hsrw.org, C.D@hsrw.org, E.F@hsrw.org, G.H@hsrw.org", oop_class.getParticipantsEmail());  
    assertEquals(4, oop_class.getTotalParticipants());
    System.setOut(originalOut);
  }
  @Test
  public void test03()
  {
    PrintStream originalOut = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bos));
    GregorianCalendar date = new GregorianCalendar(1990, 01, 01);
    GregorianCalendar date2 = new GregorianCalendar(2022, 04, 28);
    Student student1 = new Student("A", "B");
    student1.setDegree(StudyCourse.ME);
    assertEquals(student1.getDegree(), StudyCourse.ME);
    Student student2 = new Student("C", "D");
    assertEquals(student2.getID(), "10001");
    student2.setDegree("EL");
    assertEquals(student2.getDegree(), StudyCourse.EL);
    Student student3 = new Student("E", "F", date.getTime());
    Student student4 = new Student("G", "H", date.getTime());
    assertEquals(student4.getID(), "10003");
    User user = student4;
    assertEquals(user.getFQUN(), "10003@student.hsrw");
    assertEquals(((User) student3).getBirthday(), date.getTime());
    student4.setDegree("MME");
    assertEquals("Mechanical Engineering, M.Sc.", student4.getDegreeDescription());
    Professor prof1 = new Professor("xye", "X", "Ye");
    Professor prof2 = new Professor("abc", "A", "Bc", date.getTime());
    assertEquals(prof1.getFaculty(), Faculty.TUB);
    assertEquals(prof1.getFQUN(), "xye@staff.hsrw");
    prof2.setFaculty(Faculty.KU);
    prof2.setPhone(555);
    assertEquals(prof2.getFaculty(), Faculty.KU);
    assertEquals(prof2.getPhone(), "+49 2842 908 555");
    user = prof2;
    assertEquals(user.getFQUN(), "abc@staff.hsrw");
    Course oop = new Course("EL-2309", "Object Oriented Programming", prof1, 5);
    Course de = new Course("EL-2302", "Digital Electronics", prof1, 5);
    Classroom oop_class = new Classroom(oop, "01 02 005");
    Classroom de_class = new Classroom(de, "01 02 006", date2.getTime());
    assertEquals("WS2022/23", oop_class.getTerm());
    assertEquals("SS2022", de_class.getTerm());
    assertEquals("EL-2309-WS2022/23", oop_class.getID());
    assertEquals("EL-2302-SS2022", de_class.getID());
    oop_class.addStudent(student1);
    oop_class.addStudent(student2);
    oop_class.addStudent(student3);
    oop_class.addStudent(student4);
    assertEquals("A.B@hsrw.org, C.D@hsrw.org, E.F@hsrw.org, G.H@hsrw.org", oop_class.getParticipantsEmail());  
    assertEquals(4, oop_class.getTotalParticipants());
    System.setOut(originalOut);
  }

       
}
