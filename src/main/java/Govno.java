import entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Govno {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Egor", 4, 20));
        students.add(new Student("Masha", 4, 21));
        students.add(new Student("Sasha", 3, 19));
        students.add(new Student("Nastya", 2, 18));
        students.add(new Student("Dima", 1, 17));

        Govno govnyashka = new Govno();
//        govnyashka.deleteByMax(students);
//        govnyashka.deleteByMin(students);
//        govnyashka.deleteAllNoX(students);
//        govnyashka.ageSum(students);
        govnyashka.checkByletter(students);
    }

    public void deleteByMax(List<Student> students) {
        Integer maxage = 0;
        int id = 0;
        for (int a = 0; a < students.size(); a++) {
            Student currentstudent = students.get(a);
            Integer currensage = currentstudent.getAge();
            if (currensage > maxage) {
                maxage = currensage;
                id = a;
            }
        }

        students.remove(id);
        listToString(students);
    }

    public void deleteByMin(List<Student> students) {
        Integer minAge = null;
        int id = 0;
        for (int b = 0; b < students.size(); b++) {
            Student currentStudent = students.get(b);
            Integer currentAge = currentStudent.getAge();
            if (minAge == null || minAge > currentAge) {
                minAge = currentAge;
                id = b;
            }
        }
        students.remove(id);
        listToString(students);

    }


    public void deleteAllNoX(List<Student> students) {

        System.out.print("Vvedite course: ");
        Scanner egor = new Scanner(System.in);
        Integer X = egor.nextInt();

        List<Student> deleteStudents = new ArrayList<Student>();
        for (int a = 0; a < students.size(); a++) {
            Student currentStudent = students.get(a);
            Integer currentCourse = currentStudent.getCourse();
            if (!currentCourse.equals(X)) {
                deleteStudents.add(currentStudent);
            }
        }

        students.removeAll(deleteStudents);
        listToString(students);
    }

    public void ageSum(List<Student> student){
        Integer sum =0;
        for (int a=0; a<student.size(); a++){
            sum += student.get(a).getAge();
        }
        System.out.println(sum);
    }

    public void checkByletter(List<Student> students){
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.next();
        List<Student> includedStudents = new ArrayList<Student>();
        for(int a=0; a<students.size(); a++){
          String name = students.get(a).getName();
          if(name.contains(letter)){
              includedStudents.add(students.get(a));
          }
        }
        listToString(includedStudents);
    }

    public static void listToString(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}