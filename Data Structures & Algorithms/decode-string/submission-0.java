class Solution {
    private int i = 0;

    public String decodeString(String s) {
        return helper(s);
    }

    private String helper(String s){
        StringBuilder result = new StringBuilder();
        int k = 0;

        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                k = k * 10 + (c - '0');
            } else if(c =='['){
                i++;
                String subResult = helper(s);
                while(k-- > 0) result.append(subResult);
                k = 0;
            } else if(c == ']'){
                return result.toString();
            }else{
                result.append(c);
            }
            i++;
        }
        return result.toString();
    }
}