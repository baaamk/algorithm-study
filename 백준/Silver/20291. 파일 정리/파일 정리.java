import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> tree = new TreeMap<>();
        for(int i = 0; i < n; i++){
            String name = br.readLine();
            String expand = name.substring(name.indexOf(".") + 1);
            tree.put(expand, tree.getOrDefault(expand, 0) + 1);
        }
        for(String key : tree.keySet()){
            bw.write(key + " " + tree.get(key));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}