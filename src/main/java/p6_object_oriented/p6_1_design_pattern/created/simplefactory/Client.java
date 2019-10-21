package p6_object_oriented.p6_1_design_pattern.created.simplefactory;

/**
 * @ClassName Client
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/20 16:17
 **/
public class Client {
    public static void main(String[] args) {
        // client不知道Product有几个子类，也不需要知道创建子类的细节
        // 只需要把创建对象的工作全部交给SimpleFactory()去完成即可
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
        // do something with the product
        // …………
    }
}
