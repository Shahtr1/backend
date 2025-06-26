package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloServiceProxy {

    public static void main(String[] args) {
        HelloService realService = new HelloServiceImpl();

        HelloService proxyInstance = (HelloService) Proxy.newProxyInstance(
                HelloService.class.getClassLoader(),
                new Class<?>[] { HelloService.class },
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("[Before] Calling method: " + method.getName());
                        Object result = method.invoke(realService, args);
                        System.out.println("[After] Method returned: " + result);
                        return result;
                    }
                });

        proxyInstance.sayHello("CLAY");

    }
}

// Generated class be like
/*
 * public final class $Proxy0 extends Proxy implements HelloService {
 * public $Proxy0(InvocationHandler h) {
 * super(h);
 * }
 * 
 * public String sayHello(String name) {
 * return (String) h.invoke(this, HelloService.class.getMethod("sayHello",
 * String.class), new Object[]{name});
 * }
 * }
 */