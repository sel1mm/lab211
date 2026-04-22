package controller;

import model.Student;
import java.util.ArrayList;

public class ManageStudent {

    public static void main(String[] args) {
        ArrayList<Student> listStudent = new ArrayList<>();
        Validation validation = new Validation();
        listStudent.add(new Student("1", "Nguyen Van A", "Spring", "java"));
        listStudent.add(new Student("1", "Nguyen Van A", "Summer", "java"));
        listStudent.add(new Student("1", "Nguyen Van A", "Fall", "java"));    
        listStudent.add(new Student("2", "Nguyen Van C", "Summer", ".net"));
        listStudent.add(new Student("3", "Nguyen Van B", "Spring", "c/c++"));
        while (true) {
            Manager.menu();
            int choice = validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    Manager.createStudent(listStudent);
                    break;
                case 2:
                    Manager.findAndSort(listStudent);
                    break;
                case 3:
                    Manager.updateOrDelete(listStudent);
                    break;
                case 4:
                    Manager.reportTotalCourse(listStudent);
                    break;
                case 5:
                    return;
            }

        }
    }

}