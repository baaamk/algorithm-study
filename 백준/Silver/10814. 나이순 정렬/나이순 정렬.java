import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        
        Collections.sort(list, (p1, p2) -> p1.age - p2.age);
        
        for(int i = 0; i < n; i++){
            bw.write(list.get(i).age + " " + list.get(i).name);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
    static class Person{
        int age;
        String name;
        
        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
}