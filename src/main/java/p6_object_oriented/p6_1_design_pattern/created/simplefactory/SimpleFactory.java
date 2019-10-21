package p6_object_oriented.p6_1_design_pattern.created.simplefactory;

/**
 * @ClassName SimpleFactory
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/20 14:56
 **/
public class SimpleFactory {

    public Product createProduct(int type){
        if (type==1){
            return new ConcreteProduct1();
        }else if (type==2){
            return new ConcreteProduct2();
        }
        return new ConcreteProduct();
    }
}
