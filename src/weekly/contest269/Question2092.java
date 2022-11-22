package weekly.contest269;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/12/1 14:09
 * @description: https://leetcode-cn.com/problems/find-all-people-with-secret/
 */
public class Question2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        int[][] sortMeeting = new int[meetings.length][meetings[0].length];
        TreeMap<Integer, PriorityQueue<Integer>> treeMap = new TreeMap<>();
        HashMap<Integer, Integer> timeMap = new HashMap<>();

        //treeMap根据时间排序，queue根据已知晓的进行排序
        for (int i = 0; i < meetings.length; i++) {
            timeMap.put(i, meetings[i][2]);
            if (treeMap.containsKey(meetings[i][2])){
                PriorityQueue<Integer> queue = treeMap.get(meetings[i][2]);
                queue.add(meetings[i][0]);
            }else {
                PriorityQueue<Integer> queue = new PriorityQueue<>();
                queue.add(meetings[i][0]);
                treeMap.put(meetings[i][2], queue);
            }
        }
        HashSet<Integer> knowPerson = new HashSet<>();
        knowPerson.add(0);
        knowPerson.add(firstPerson);
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < meetings.length; i++) {
            for (int j = 0; j < meetings[0].length; j++) {

            }
        }
        return null;
    }
}
