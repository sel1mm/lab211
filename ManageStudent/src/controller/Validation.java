package controller;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Validation {
    private static Scanner sc = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        do {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    System.out.println("Please input number in rage [" + min + ", " + max + "]");
                    System.out.print("Enter again: ");

                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        } while(true);
    }

    public static String checkInputString() {
        do {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                String[] words = result.split("\\s+");
                StringBuilder sb = new StringBuilder();
                for(String word : words){
                    sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
                }
                result = sb.toString().trim();
                return result;
            }
        } while(true);
    }

    public static boolean checkInputYN() {
        do {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        } while(true);
    }

    public static boolean checkInputUD() {
        do {
            String result = checkInputString();
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.out.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        } while(true);
    }

    public static String checkInputCourse() {
        do {
            String result = checkInputString();
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.out.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        } while(true);
    }

    public static boolean checkStudentExist(ArrayList<Student> listStudent, String id,
            String studentName, String semester, String courseName) {
        for (Student student : listStudent) {
            if (id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkReportExist(ArrayList<Report> listReport, String name,
            String course, int total) {
        for (Report report : listReport) {
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkCourseExist(ArrayList<Student> listStudent, String id, String semester, String course){
        for(Student student : listStudent){
            if(id.equalsIgnoreCase(student.getId())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && course.equalsIgnoreCase(student.getCourseName())) return true;
        }
        return false;
    }

    public static boolean checkIdExist(ArrayList<Student> listStudent, String id, String name) {
        for (Student student : listStudent) {
            if (id.equalsIgnoreCase(student.getId())
                    && !name.equalsIgnoreCase(student.getStudentName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkChangeInfomation(Student student, String id,
            String name, String semester, String course) {
        if (id.equalsIgnoreCase(student.getId())
                && name.equalsIgnoreCase(student.getStudentName())
                && semester.equalsIgnoreCase(student.getSemester())
                && course.equalsIgnoreCase(student.getCourseName())) {
            return true;
        }
        return false;
    }

}