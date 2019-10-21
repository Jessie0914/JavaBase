package p6_object_oriented.p6_1_design_pattern.created.singleton.imp1;

/**
 * @ClassName Singleton
 * @Description 懒汉式——延迟实例化
 * @Author shishi
 * @Date 2019/10/19 20:21
 **/

/**
 * 总结：
 * 优点：延迟实例化
 * 可以看到，如果没有调用那个公有的访问实例的方法的话，是不会创建这个类的实例变量的，这就节省了资源
 *
 * 缺点：线程不安全
 * 如果有两个线程同时进入27行代码中去，都以为实例还没有被创建，就会同时创建两个实例
 */
public class Singleton {
    // 一个私有的静态变量
    private static Singleton singletonInstance;

    // 一个私有的构造函数
    private Singleton(){}

    // 一个公有的访问实例函数
    public static Singleton getSingletonInstance(){
        // 如果还没有被创建，就先创建，然后返回
        if (singletonInstance==null){
            singletonInstance =  new Singleton();
        }
        return singletonInstance;
    }
}
