package Stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private static void backtrack(int openN, int closedN, int n, List<String> res, StringBuilder stack) {
        if (openN == closedN && openN == n) {
            res.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append('(');
            backtrack(openN + 1, closedN, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closedN < openN) {
            stack.append(')');
            backtrack(openN, closedN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, res, stack);
        return res;
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        for (String s : res)
            System.out.println(s);
    }
}

// DRY RUN

// Call: backtrack(0, 0, 3, "", res)

// ├── "(" → backtrack(1, 0, 3, "(", res)
// │ ├── "((" → backtrack(2, 0, 3, "((", res)
// │ │ ├── "(((" → backtrack(3, 0, 3, "(((", res)
// │ │ │ └── "((()" → backtrack(3, 1, 3, "((()", res)
// │ │ │ └── "((())" → backtrack(3, 2, 3, "((())", res)
// │ │ │ └── "((()))" ✅ add to result
// │ │ └── "(()" → backtrack(2, 1, 3, "(()", res)
// │ │ ├── "(()(" → backtrack(3, 1, 3, "(()(", res)
// │ │ │ └── "(()()" → backtrack(3, 2, 3, "(()()", res)
// │ │ │ └── "(()())" ✅ add to result
// │ │ └── "(())" → backtrack(2, 2, 3, "(())", res)
// │ │ └── "(())(" → backtrack(3, 2, 3, "(())(", res)
// │ │ └── "(())()" ✅ add to result
// │ └── "()" → backtrack(1, 1, 3, "()", res)
// │ ├── "()(" → backtrack(2, 1, 3, "()(", res)
// │ │ ├── "()((" → backtrack(3, 1, 3, "()((", res)
// │ │ │ └── "()(()" → backtrack(3, 2, 3, "()(()", res)
// │ │ │ └── "()(()))" → backtrack(3, 3, 3, "()(())", res) ✅ add
// │ │ └── "()()" → backtrack(2, 2, 3, "()()", res)
// │ │ └── "()()(" → backtrack(3, 2, 3, "()()(", res)
// │ │ └── "()()()" ✅ add to result

// Final result = [
// "((()))",
// "(()())",
// "(())()",
// "()(())",
// "()()()"
// ]
