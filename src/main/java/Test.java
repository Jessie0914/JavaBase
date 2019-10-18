/**
 * @program: Test
 * @description:
 * @author: shishi
 * @create: 2019-10-11 16:20
 **/

public class Test {
    public static int A = 1;
    static {
        A = 2;
    }
}

class B extends Test{
    static int Q = Test.A;

    public static void main(String[] args) {
        System.out.println(Q);
    }
}
