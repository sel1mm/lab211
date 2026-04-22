package controller;

import model.*;
import java.util.ArrayList;
import java.util.Collections;

public class Manager {
    public static void menu() {
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");
        System.out.print(" Enter your choice: ");
    }

    public static void createStudent(ArrayList<Student> listStudent) {
        if (listStudent.size() > 10) {
            System.out.print("Do you want to continue (Y/N): ");
            if (Validation.checkInputYN() == false) {
                return;
            }
        }
        while (true) {
            System.out.print("Enter id: ");
            String id = Validation.checkInputString();
            System.out.print("Enter name student: ");
            String name = Validation.checkInputString();
            if (Validation.checkIdExist(listStudent, id, name) == true) {
                System.out.println("Id has exist student. Pleas re-input.");
                continue;
            }
            System.out.print("Enter semester: ");
            String semester = Validation.checkInputString();
            System.out.print("Enter name course: ");
            String course = Validation.checkInputCourse();
            if (Validation.checkStudentExist(listStudent, id, name, semester, course) == false) {
                listStudent.add(new Student(id, name, semester, course));
                System.out.println("Add student success.");
                return;
            }
            System.out.println("Duplicate.");

        }
    }


    public static void findAndSort(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        ArrayList<Student> listStudentFindByName = listStudentFindByName(listStudent);
        if (listStudentFindByName.isEmpty()) {
            System.out.println("Not exist.");
        } else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
            for (Student student : listStudentFindByName) {
                student.print();
            }
        }
    }

    public static ArrayList<Student> listStudentFindByName(ArrayList<Student> listStudent) {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        System.out.print("Enter name to search: ");
        String name = Validation.checkInputString();
        for (Student student : listStudent) {
            if (student.getStudentName().contains(name)) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }
 
    public static void updateOrDelete(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        System.out.print("Enter id: ");
        String id = Validation.checkInputString();
        ArrayList<Student> listStudentFindByName = getListStudentById(listStudent, id);
        if (listStudentFindByName.isEmpty()) {
            System.out.println("Not found student.");
            return;
        } else {
            Student student = getStudentByListFound(listStudentFindByName);
            System.out.print("Do you want to update (U) or delete (D) student: ");
            if (Validation.checkInputUD()) {
                    System.out.print("Enter name student: ");
                    String name = Validation.checkInputString();
                do{
                    System.out.print("Enter semester: ");
                    String semester = Validation.checkInputString();
                    System.out.print("Enter name course: ");
                    String course = Validation.checkInputCourse();
                    if(Validation.checkCourseExist(listStudent, id, semester, course)){
                        System.out.println("This semester already has exist this course");
                        continue;           
                    }
                    if (Validation.checkChangeInfomation(student, id, name, semester, course)) {
                        System.out.println("Nothing change.");
                    }
                    if (!Validation.checkStudentExist(listStudent, id, name, semester, course)) {
                        setNameListStudentById(listStudent, id, name);
                        student.setSemester(semester);
                        student.setCourseName(course);
                        System.out.println("Update success.");
                    }
                    return;
                } while(true);
            } else {
                listStudent.remove(student);
                System.out.println("Delete success.");
                return;
            }
        }
    }

    public static Student getStudentByListFound(ArrayList<Student> listStudentFindByName) {
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        for (Student student : listStudentFindByName) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.print("Enter student: ");
        int choice = Validation.checkInputIntLimit(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice - 1);
    }

    public static ArrayList<Student> getListStudentById(ArrayList<Student> listStudent, String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : listStudent) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }
    
    public static ArrayList<Student> setNameListStudentById(ArrayList<Student> listStudent, String id, String name){
        for(Student student : listStudent){
            if(id.equalsIgnoreCase(student.getId())){
                student.setStudentName(name);
            }
        }
        return listStudent;
    }

    public static void reportTotalCourse(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        ArrayList<Report> listReport = new ArrayList<>();
            for (Student student : listStudent) {
                int total = 0;
                String id = student.getId();
                String courseName = student.getCourseName();
                String studentName = student.getStudentName();
                for (Student studentCountTotal : listStudent) {
                    if (id.equalsIgnoreCase(studentCountTotal.getId())
                            && courseName.equalsIgnoreCase(studentCountTotal.getCourseName())) {
                        total++;
                    }
                }
                if (Validation.checkReportExist(listReport, studentName,
                        courseName, total) == false) {
                    listReport.add(new Report(studentName, courseName, total));
                }
            }
        for (int i = 0; i < listReport.size(); i++) {
            System.out.printf("%-15s|%-10s|%-5d\n", listReport.get(i).getStudentName(),
                    listReport.get(i).getCourseName(), listReport.get(i).getTotalCourse());
        }
    }
}