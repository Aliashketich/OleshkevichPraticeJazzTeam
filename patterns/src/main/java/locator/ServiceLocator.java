package locator;

public class ServiceLocator {
    private static Cache cache = new Cache();

    public static Service getService(String serviceName) {
        Service service = cache.getService(serviceName);
        if (service != null) {
            return service;
        }
        InitialContext initialContext = new InitialContext();
        service = (Service) initialContext.searchForTheRequiredService(serviceName);
        cache.setService(service);
        return service;
    }
}