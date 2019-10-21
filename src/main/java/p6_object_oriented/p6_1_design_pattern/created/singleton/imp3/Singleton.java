package p6_object_oriented.p6_1_design_pattern.created.singleton.imp3;

/**
 * @ClassName Singleton
 * @Description 懒汉式——解决“线程不安全”的问题
 * @Author shishi
 * @Date 2019/10/19 20:44
 **/

/**
 * 总结
 * 优点：在懒汉式"节约资源"的前提下还保证了"线程安全"
 *
 * 缺点：性能很差
 * 因为对getSingletonInstance方法加了锁，导致所有进入此方法的线程都要阻塞等待，
 * 即使实例已经创建好，仍然要阻塞等待。这回导致线程阻塞时间过长，因此该方法有性能问题，不推荐使用。
 */
public class Singleton {
    private static Singleton singletonInstance;

    private Singleton(){}

    // 对此方法加锁来保证线程安全
    public synchronized static Singleton getSingletonInstance(){
        if (singletonInstance == null){
            singletonInstance = new Singleton();
        }
        return singletonInstance;
    }
}
