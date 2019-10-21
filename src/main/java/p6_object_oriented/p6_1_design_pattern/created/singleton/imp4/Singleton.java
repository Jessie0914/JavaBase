package p6_object_oriented.p6_1_design_pattern.created.singleton.imp4;

/**
 * @ClassName Singleton
 * @Description 双重校验锁——线程安全
 * @Author shishi
 * @Date 2019/10/19 20:50
 **/

/**
 * 总结
 * 优点：线程安全，且延迟实例化，节约了资源
 */
public class Singleton {
    // 这里加上volatile关键字的原因是，jvm有指令重排的特性，单线程的情况下，不会出现问题；
    // 多线程的情况有可能出现问题，所以加上volatile关键字防止指令重排
    private volatile static Singleton singletonInstance;

    private Singleton(){}

    // 不对整个方法加锁，只对下面实例化的那部分代码加锁
    public static Singleton getSingletonInstance(){
        if (singletonInstance == null){
            // 在这里加锁
            synchronized (Singleton.class){
                // 并且在加锁之后，又重新判断了一遍实例变量是否为空
                // 是因为如果不加第二个if语句的话，当实例为null，且正好有两个线程进入第一个if下面的语句
                // 那么这两个线程就会实例化，虽然不是同时实例化，但就是一前一后地创建，仍然是线程不安全的
                // 所以加锁之后再加一句判断实例是否为空
                if (singletonInstance==null){
                    singletonInstance = new Singleton();
                }
            }
        }
        return singletonInstance;
    }
}
