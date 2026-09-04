class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] s_sort = s.toCharArray();
        char[] t_sort = t.toCharArray();
        Arrays.sort(s_sort);
        Arrays.sort(t_sort);
        return Arrays.equals(s_sort, t_sort);
    }
}
