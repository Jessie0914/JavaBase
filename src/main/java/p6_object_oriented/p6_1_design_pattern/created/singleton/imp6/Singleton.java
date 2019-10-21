package p6_object_oriented.p6_1_design_pattern.created.singleton.imp6;

/**
 * @ClassName Singleton
 * @Description 枚举类实现
 * @Author shishi
 * @Date 2019/10/20
 **/

/**
 * 总结：
 * 优点：
 * ①该实现在多次序列化和反序列化之后，不会得到多个实例
 * 而其他的实现需要加上transient关键字修饰所有的字段，并且实现序列化和反序列化的方法
 * ②该实现可以防止反射攻击，在其他实现中，可以通过setAccessible()方法将私有的构造函数的访问级别设置成public，然后调用构造函数从而实例化对象。
 * 如果要防止这种反射攻击，需要在构造函数中添加防止多次实例化的代码。
 * 该实现是由jvm保证只会实例化一次，所以不会有反射攻击。
 */
public enum Singleton {
    INSTANCE;

    private String objectName;

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public static void main(String[] args) {
        Singleton firstInstance = Singleton.INSTANCE;
        firstInstance.setObjectName("firstName");
        System.out.println(firstInstance.getObjectName());  // firstName
        Singleton secondInstance = Singleton.INSTANCE;
        secondInstance.setObjectName("secondName");
        // firstInstance和secondInstance是一个对象
        System.out.println(firstInstance.getObjectName());   // secondName
        System.out.println(secondInstance.getObjectName());  // secondName

        // 反射获取实例测试
        Singleton[] enumConstants = Singleton.class.getEnumConstants();
        for(Singleton enumConstant : enumConstants){
            System.out.println(enumConstant.getObjectName());   // secondName
        }
    }
}
