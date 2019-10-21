package p6_object_oriented.p6_1_design_pattern.created.factorymethod;

/**
 * @ClassName ConcreteFactory2
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/20 16:49
 **/
public class ConcreteFactory2 extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }
}
