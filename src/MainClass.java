import java.lang.reflect.Proxy;

/**
 * Created by xinyuangui on 15/9/29.
 */
public class MainClass {
    public static void main(String[] args) {
        Service service = new HelloService();
        Weather weather = new RainWeather();

        MyDynamicProxy dynamicHelloService = new MyDynamicProxy(service);
        service = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), dynamicHelloService);
        service.sayHello("真实服务");

        dynamicHelloService = new MyDynamicProxy(weather);
        weather= (Weather) Proxy.newProxyInstance(weather.getClass().getClassLoader(),weather.getClass().getInterfaces(),dynamicHelloService);
        weather.getWeather();
    }
}
