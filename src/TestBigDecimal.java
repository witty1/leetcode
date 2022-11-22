import java.math.BigDecimal;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/9/14 11:20
 */
public class TestBigDecimal {

    {
        a = 1;
    }
    private  int a;


    public void test(){}

    public static void testStatic(){

    }

    public static void main(String[] args) {
        TestBigDecimal t = new TestBigDecimal();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            t.a++;
        }
        System.out.println(System.currentTimeMillis() - start);
        int b = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            b++;
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
