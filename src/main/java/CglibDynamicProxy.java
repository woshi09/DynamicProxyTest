import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by xinyuangui on 15/9/29.
 */
public class CglibDynamicProxy implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void after() {
        System.out.println("被cglib代理的方法执行后");
    }

    private void before() {
        System.out.println("被cglib代理的方法执行前");
    }
}
