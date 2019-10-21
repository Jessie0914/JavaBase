package p6_object_oriented.p6_1_design_pattern.created.singleton.imp5;

/**
 * @ClassName Singleton
 * @Description 静态内部类
 * @Author shishi
 * @Date 2019/10/19 21:03
 **/

/**
 * 总结：
 * 这种用静态内部类实现的单例模式既可以延迟实例化，节约资源，也是线程安全的
 */
public class Singleton {
    // 私有的构造函数
    private Singleton(){}

    // 私有静态内部类
    // 当外部类加载的时候并不会被加载
    // 只有当自己被用到时（这里是指有人调用公有的访问函数时）才会被加载，且只会被加载一次
    private static class SingletonHolder{
        private static final Singleton singletonInstance = new Singleton();
    }

    // 公有的外部访问函数
    public Singleton getSingletonInstance(){
        return SingletonHolder.singletonInstance;
    }
}
