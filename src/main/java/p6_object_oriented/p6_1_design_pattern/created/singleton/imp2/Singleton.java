package p6_object_oriented.p6_1_design_pattern.created.singleton.imp2;

/**
 * @ClassName Singleton
 * @Description 饿汉式——直接实例化
 * @Author shishi
 * @Date 2019/10/19 20:41
 **/

/**
 * 总结：
 * 优点：线程安全
 * 缺点：无论有没有用到这个类，都会创建一个实例，浪费资源
 */
public class Singleton {
    // 直接实例化
    private static Singleton singletonInstance = new Singleton();

    private Singleton(){}

    public static Singleton getSingletonInstance(){
        return singletonInstance;
    }
}
