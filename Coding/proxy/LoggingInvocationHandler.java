package proxy;

import java.lang.reflect.*;

public class LoggingInvocationHandler implements InvocationHandler {
    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1. Log method details
        System.out.println("Invoking method: " + method.getName());

        // 2. Print argument values
        if (args != null) {
            for (Object arg : args) {
                System.out.println(" -> arg: " + arg);
            }
        }

        // 3. Delegate to actual object (target)
        Object result = method.invoke(target, args);

        // 4. Log result
        System.out.println("Method returned: " + result);

        // 5. Return result
        return result;
    }

    public static void main(String[] args) {
        HelloService realService = new HelloServiceImpl();

        HelloService proxy = (HelloService) Proxy.newProxyInstance(
                HelloService.class.getClassLoader(),
                new Class<?>[] { HelloService.class },
                new LoggingInvocationHandler(realService));

        proxy.sayHello("CLAY");
    }
}
