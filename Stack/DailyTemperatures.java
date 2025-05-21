package Stack;

import java.util.Stack;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];

            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[] { t, i });
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = dailyTemperatures(new int[] { 30, 38, 30, 36, 35, 40, 28 });
        for (int i : res)
            System.out.print(i + " ");
    }

}

// Day 0 → 73
// Stack empty → push
// stack = [[73, 0]]

// Day 1 → 74
// 74 > 73 → pop [73, 0]
// res[0] = 1 - 0 = 1
// stack = []
// Push [74, 1]
// stack = [[74, 1]]
// res = [1, 0, 0, 0, 0, 0, 0, 0]

// Day 2 → 75
// 75 > 74 → pop [74, 1]
// res[1] = 2 - 1 = 1
// Push [75, 2]
// stack = [[75, 2]]
// res = [1, 1, 0, 0, 0, 0, 0, 0]

// Day 3 → 71
// 71 < 75 → can't pop
// Push [71, 3]
// stack = [[75, 2], [71, 3]]

// Day 4 → 69
// 69 < 71 → can't pop
// Push [69, 4]
// stack = [[75, 2], [71, 3], [69, 4]]

// Day 5 → 72
// 72 > 69 → pop [69, 4]
// res[4] = 5 - 4 = 1
// 72 > 71 → pop [71, 3]
// res[3] = 5 - 3 = 2
// 72 < 75 → stop
// Push [72, 5]
// stack = [[75, 2], [72, 5]]
// res = [1, 1, 0, 2, 1, 0, 0, 0]

// Day 6 → 76
// 76 > 72 → pop [72, 5]
// res[5] = 6 - 5 = 1
// 76 > 75 → pop [75, 2]
// res[2] = 6 - 2 = 4
// Stack empty
// Push [76, 6]
// stack = [[76, 6]]
// res = [1, 1, 4, 2, 1, 1, 0, 0]

// Day 7 → 73
// 73 < 76 → can't pop
// Push [73, 7]
// stack = [[76, 6], [73, 7]]
// res = [1, 1, 4, 2, 1, 1, 0, 0]

// ✅ Final Answer:
// res = [1, 1, 4, 2, 1, 1, 0, 0]
// Each number tells how many days ahead you'll get a warmer temperature.