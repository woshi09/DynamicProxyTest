import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * Created by xinyuangui on 15/9/29.
 */
public class MainClass {
    public static void main(String[] args) {
        Service service = new HelloService();
        Weather weather = new RainWeather();

        JdkDynamicProxy dynamicHelloService = new JdkDynamicProxy(service);
        service = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), dynamicHelloService);
        service.sayHello("真实服务");
        System.out.println();

        dynamicHelloService = new JdkDynamicProxy(weather);
        weather= (Weather) Proxy.newProxyInstance(weather.getClass().getClassLoader(),weather.getClass().getInterfaces(),dynamicHelloService);
        weather.getWeather();
        System.out.println();

        CglibDynamicProxy cglibDynamicProxy=new CglibDynamicProxy();
        CglibService cglibService= (CglibService) Enhancer.create(CglibService.class,cglibDynamicProxy);
        cglibService.sayHello();
    }
}
