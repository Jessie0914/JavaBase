package p6_object_oriented.p6_1_design_pattern.created.factorymethod;

/**
 * @ClassName Factory
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/20 16:44
 **/
public abstract class Factory {
    public abstract Product factoryMethod();

    public void doSomething(){
        Product product = factoryMethod();

        // doSomething with the product
        // …………
    }
}
