package SortingAlgorithm.Hackerrank;

import java.util.*;

public class JavaSort {
static class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

static class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        if (a.getCgpa() < b.getCgpa()) return 1;
        if (a.getCgpa() > b.getCgpa()) return -1;
        if (!a.getFname().equals(b.getFname())) {
            return a.getFname().compareTo(b.getFname());
        }
        if (a.getId() < b.getId()) return 1;
        if (a.getId() > b.getId()) return -1;
        return 0;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases-- > 0) {
            int id = sc.nextInt();
            String fname = sc.next();
            double cgpa = sc.nextDouble();
            Student st = new Student(id, fname, cgpa);
            studentList.add(st);
        }
        Collections.sort(studentList, new StudentComparator());
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
}
