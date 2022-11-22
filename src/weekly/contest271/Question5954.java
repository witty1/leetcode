package weekly.contest271;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/12/12 10:53
 */
public class Question5954 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int count = 0;
        int ca = capacityA, cb = capacityB;
        for (int i = 0, j = plants.length - 1; i <= j; i++, j--) {
            if (i != j ){
                if (ca < plants[i]){
                    count++;
                    ca = capacityA;
                }
                ca -= plants[i];
                if (cb < plants[j]){
                    count++;
                    cb = capacityB;
                }
                cb -= plants[j];
            }else {
                if (ca >= cb){
                    if (ca < plants[i]){
                        count++;
                    }
                }else{
                    if (cb < plants[i]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
