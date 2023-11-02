package PriorityQueue.Hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JavaPriorityQueue {
class Student {
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

    public String getName() {
        return fname;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        //Complete your code
        if (a.getCGPA() < b.getCGPA()) return 1;
        if (a.getCGPA() > b.getCGPA()) return -1;
        if (!a.getName().equals(b.getName())) {
            return a.getName().compareTo(b.getName());
        }
        if (a.getId() < b.getId()) return 1;
        if (a.getId() > b.getId()) return -1;
        return 0;
    }
}

class Priorities {
    Comparator comp = new StudentComparator();

    public ArrayList<Student> getStudents(List<String> events) {
        ArrayList<Student> ans = new ArrayList<>();
        PriorityQueue<Student> pq = new PriorityQueue<>(comp);

        for (String i : events) {
            String[] s = i.split("\\s");
            if (s.length > 1 && s[0].equals("ENTER")) {
                pq.add(new Student(Integer.valueOf(s[3]), s[1], Double.valueOf(s[2])));
                continue;
            }
            if (s[0].equals("SERVED") && !pq.isEmpty()) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        return ans;
    }
}
}