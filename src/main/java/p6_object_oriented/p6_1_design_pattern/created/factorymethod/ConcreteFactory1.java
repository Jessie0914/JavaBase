package p6_object_oriented.p6_1_design_pattern.created.factorymethod;

/**
 * @ClassName ConcreteFactory1
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/20 16:48
 **/
public class ConcreteFactory1 extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}
