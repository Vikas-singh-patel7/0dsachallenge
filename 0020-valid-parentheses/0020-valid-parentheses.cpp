#include <string>
#include <stack>

class Solution {
public:
    bool isValid(std::string s) {
        // An odd-length string can never have all balanced pairs
        if (s.length() % 2 != 0) return false;

        std::stack<char> st;

        for (char c : s) {
            // Push expected closing brackets onto the stack
            if (c == '(') {
                st.push(')');
            } else if (c == '{') {
                st.push('}');
            } else if (c == '[') {
                st.push(']');
            } else {
                // If closing bracket arrives but stack is empty or mismatch found
                if (st.empty() || st.top() != c) {
                    return false;
                }
                st.pop();
            }
        }

        // Valid only if all opened brackets were properly matched and closed
        return st.empty();
    }
};