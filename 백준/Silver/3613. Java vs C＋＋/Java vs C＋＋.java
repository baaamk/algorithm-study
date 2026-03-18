import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i = 0;
        String str = br.readLine();

        
        boolean hasUnder = false;
        boolean hasUpper = false;

        if(str.charAt(0) == '_' || str.charAt(str.length()-1) == '_' || Character.isUpperCase(str.charAt(0))){
            bw.write("Error!");
            bw.flush();
            return;
        }

        for(int j = 0; j < str.length(); j++){
            char c = str.charAt(j);

            if(c == '_'){
                hasUnder = true;
                if(j > 0 && str.charAt(j-1) == '_'){ // "__" 체크
                    bw.write("Error!");
                    bw.flush();
                    return;
                }
            }

            if(Character.isUpperCase(c)){
                hasUpper = true;
            }
        }

        if(hasUnder && hasUpper){
            bw.write("Error!");
            bw.flush();
            return;
        }

        
        if(str.contains("_")){
            while(i < str.length()){
                if(str.charAt(i) == '_'){
                    bw.write(Character.toUpperCase(str.charAt(i + 1)));
                    i++;
                } else {
                    bw.write(str.charAt(i));
                }
                i++;
            }
        } else {
            while(i < str.length()){
                if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                    bw.write("_");
                    bw.write(Character.toLowerCase(str.charAt(i)));
                } else {
                    bw.write(str.charAt(i));
                }
                i++;
            }
        }

        bw.flush();
        bw.close();
    }
}