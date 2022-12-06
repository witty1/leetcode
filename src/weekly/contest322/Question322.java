package weekly.contest322;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-322/
 * @since 2022/12/5 20:23
 */
public class Question322 {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        if (s[0].charAt(0) != s[s.length - 1].charAt(s[s.length - 1].length() - 1)) {
            return false;
        }
        for (int i = 0; i < s.length; i++) {
            if (i + 1 < s.length && s[i].charAt(s[i].length() - 1) != s[i + 1].charAt(0)) {
                return false;
            }
        }

        return true;
    }

    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int pre = 0;
        long ans = 0;
        for (int i = 0, j = skill.length - 1; i < j; i++, j--) {
            int cnt = skill[i] + skill[j];
            if (pre != 0 && cnt != pre) {
                return -1;
            } else {
                pre = cnt;
            }
            ans += (long) skill[i] * skill[j];
        }
        return ans;
    }

    Integer ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        HashMap<Integer, ArrayList<Node>> map = new HashMap<>();
        for (int[] road : roads) {
            ArrayList<Node> list = map.getOrDefault(road[0], new ArrayList<>());
            list.add(new Node(road[1], road[2]));
            ArrayList<Node> list1 = map.getOrDefault(road[1], new ArrayList<>());
            list1.add(new Node(road[0], road[2]));
            map.put(road[0], list);
            map.put(road[1], list1);
        }
        int[] visit = new int[n + 1];
        dfs(map, 1, -1,n, visit);
        return ans;
    }


    public void dfs(HashMap<Integer, ArrayList<Node>> map, int cur, int parent, int target, int[] visit) {
        if (visit[cur] == 1) {
            return;
        }
        int ans = Integer.MAX_VALUE;
        for (Node node : map.get(cur)) {
            visit[cur] = 1;
            ans = Math.min(node.weight, ans);
            dfs(map, node.val, cur, target, visit);
        }
    }


class Node {
    int weight;
    int val;

    public Node(int val, int weight) {
        this.val = val;
        this.weight = weight;
    }

}

    public static void main(String[] args) {
        Question322 question322 = new Question322();
//        System.out.println(question322.minScore(4, new int[][]{{1, 2, 2}, {1, 3, 4}, {3, 4, 7}}));
        System.out.println(question322.minScore(4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}));
    }
}
