
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
 
public class Main {
 
    static class Subdivision {
        int id;
        String name;
 
        public Subdivision(int i, String tmp) {
            id = i;
            name = tmp;
        }
    }
 
    static class Worker {
        String id, salary, name, gender, birthday, test;
        Subdivision subdivision;
 
        public Worker(String a, String b, String c, String d, String e, String f) {
            id = a;
            name = b;
            birthday = c;
            gender = d;
            salary = e;
            test = f;
        }
    }
 
    public static void main(String[] args) {
        String csvFilePath = "foreign_names.csv";
        BufferedReader page = null;
        HashSet<String> subdivision = new HashSet<>();
        try {
            page = new BufferedReader(new FileReader(csvFilePath));
            List<Worker> empList = new ArrayList<>();
            String input;
            page.readLine();
            while ((input = page.readLine()) != null) {
                String[] employeeDetails = input.split(";");
                if (employeeDetails.length > 2) {
                    Worker tmp = new Worker(employeeDetails[0], employeeDetails[1],
                            employeeDetails[2], employeeDetails[3], employeeDetails[5], employeeDetails[4]);
                    empList.add(tmp);
                    subdivision.add(employeeDetails[4]);
                }
            }
            Map<String, Subdivision> sub = new HashMap<>();
            for (String tmp:
                 subdivision) {
                sub.put(tmp, new Subdivision((int) (Math.random() * 20000), tmp));
            }
            for (Worker tmp : empList) {
                tmp.subdivision = sub.get(tmp.test);
                System.out.println(tmp.id + " " + tmp.name + " " + tmp.gender
                        + " " + tmp.birthday + " " + tmp.subdivision.id + " " + tmp.salary);
            }
 
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                assert page != null;
                page.close();
            } catch (IOException ie) {
                System.out.println("Ошибка");
                ie.printStackTrace();
            }
        }
    }
}