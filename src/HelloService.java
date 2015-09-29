/**
 * Created by xinyuangui on 15/9/29.
 */
public class HelloService implements Service {
    @Override
    public void sayHello(String name) {
        System.out.println("我叫:"+name);
    }
}
