class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        //스킬에 처음이 없다면 바로 컷트
        //마지막은 안나와도 됨.
        int answer = 0;
        for(int i = 0; i < skill_trees.length; i++){
            if(check(skill, skill_trees[i])){
                answer++;
            }
            
        }
        
        
        
        return answer;
    }
    
    public static boolean check(String skill, String skillTree){
        int idx = 0;
        for(int i = 0; i < skillTree.length(); i++){
            char c = skillTree.charAt(i);
            if(skill.indexOf(c) == -1){
                continue;
            }
            
            if(c == skill.charAt(idx)){
                idx++;
                if(idx == skill.length()){
                    return true;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}