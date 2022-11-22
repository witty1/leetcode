package weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/9/24 15:30
 */
public class Year2022 {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int len = temperatureA.length - 1;
        int[] trendA = new int[len];
        int[] trendB = new int[len];
        for (int i = 1; i < temperatureA.length; i++) {
            int pre = i - 1;
            trendA[pre] = Integer.compare(temperatureA[i] - temperatureA[pre], 0);
            trendB[pre] = Integer.compare(temperatureB[i] - temperatureB[pre], 0);

        }
        int ans = 0;
        for (int i = 0; i < trendA.length; i++) {
            if (trendA[i] == trendB[i]) {
                int j = i;
                while (j < trendA.length && trendA[j] == trendB[j]) {
                    j++;
                }
                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }

    public int transportationHub(int[][] path) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> left = new HashSet<>();
        HashSet<Integer> all = new HashSet<>();

        for (int[] arrs : path) {
            left.add(arrs[0]);
            int count = map.getOrDefault(arrs[1], 0);
            map.put(arrs[1], ++count);
            all.add(arrs[0]);
            all.add(arrs[1]);
        }
        int ans = -1;
        int count = all.size() - 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= count && !left.contains(entry.getKey())) {
                ans = entry.getKey();
            }
        }
        return ans;
    }

    public static int[][] ballGame(int num, String[] plate) {
        ArrayList<int[]> list = new ArrayList<>();
        char[][] plateMap = new char[plate.length][plate[0].length()];
        for (int i = 0; i < plate.length; i++) {
            char[] array = plate[i].toCharArray();
            for (int j = 0; j < array.length; j++) {
                plateMap[i][j] = array[j];
                if (array[j] == 'O') {
                    list.add(new int[]{i, j});
                }
            }
        }
        ArrayList<int[]> ansList = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        int[][] point = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            System.out.println("起始位置：" + Arrays.toString(arr));

            for (int j = 0; j < point.length; j++) {
                int step = num;
                System.out.println("当前方向" + Arrays.toString(point[j]));
                int x = arr[0], y = arr[1];
                while (step >= 0) {
                    if (!valid(x, y, plate)) {
                        System.out.println("退出");
                        break;
                    }

                    if ((x == 0 || x == plate.length - 1 ) && plateMap[x][y] == '.') {
                        String key = x + "_" + y;
                        if (!set.contains(key)){
                            System.out.print("添加：");
                            System.out.println(Arrays.toString(new int[]{x,y}));
                            set.add(key);
                            ansList.add(new int[]{x, y});
                        }
                        break;
                    }
                    x += point[j][0];
                    y += point[j][1];
                    System.out.println(Arrays.toString(new int[]{x,y}));
                    // {-1,0} ->  {0, 1}
                    //{1,0} -> {0, 1}
                    //"W" 表示逆时针转向器（弹珠经过时方向将逆时针旋转 90 度）；
                    //"E" 表示顺时针转向器（弹珠经过时方向将顺时针旋转 90 度
                    step--;
                    while (valid(x, y ,plate) && plateMap[x][y] != '.' && step >= 0){
                        if (plateMap[x][y] == 'E') {
                            if (j == 0){
                                y++;
                            }else if (j == 1) {
                                x--;
                            }else if (j == 2){
                                y--;
                            }else {
                                x++;
                            }
                        }else if (plateMap[x][y] == 'W'){
                            if (j == 0){
                                y--;
                            }else if (j == 1) {
                                x++;
                            }else if (j == 2){
                               y++;
                            }else {
                                x--;
                            }
                        }
                        System.out.println(Arrays.toString(new int[]{x,y}));

                        step--;
                    }

                }
            }
        }
        System.out.println("ans size " + ansList.size());
        int[][] ans = new int[ansList.size()][ansList.size() > 0 ? 2 : 0];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    public static boolean valid(int x, int y, String[] plate){
        return x >= 0 && x < plate.length && y >= 0 && y < plate[0].length();
    }

    public static void turn(int x, int y, int[] point){

    }



    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(ballGame(4, new String[]{"..E.", ".EOW", "..W."})));
    }
}
