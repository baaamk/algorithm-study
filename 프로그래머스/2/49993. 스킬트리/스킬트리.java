class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        


        for(int i = 0; i < skill_trees.length; i++){
            String str = skill_trees[i];
            int idx = 0;
            boolean ok = true;
            for(int j =0; j<str.length(); j++){
                char c = str.charAt(j);
                if(skill.contains(String.valueOf(c))){
                    if(c == skill.charAt(idx)){
                        idx++;
                        if(idx == skill.length()){
                            break;
                        }
                    } else {
                        ok = false;
                        break;
                    }
                } 
                
            }
            if(ok){
                answer++;
            }
        }
        
        return answer;
    }
}