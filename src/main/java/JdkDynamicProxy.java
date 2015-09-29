import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by xinyuangui on 15/9/29.
 */
public class JdkDynamicProxy implements InvocationHandler {
    Object service;

    public JdkDynamicProxy(Object service) {
        this.service = service;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(service, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("被代理的方法执行后");
    }

    private void before() {
        System.out.println("被代理的方法执行前");
    }
}
