class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch - 'A' + 'a');
                sb.append(ch);
            } else if (ch >= '0' && ch <= '9') { 
                sb.append(ch);
            }
        }
        
        int left = 0;
        int right = sb.length() - 1;
        
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}