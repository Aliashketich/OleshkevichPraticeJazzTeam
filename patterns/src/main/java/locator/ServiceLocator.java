package locator;

class ServiceLocator {
    private static Cache cache = new Cache();

    static Service getService(String serviceName) {
        Service currentService = cache.getService(serviceName);
        if (currentService == null) {
            InitialContext initialContext = new InitialContext();
            currentService = (Service) initialContext.searchForTheRequiredService(serviceName);
            cache.setService(currentService);
            return currentService;
        }
        return currentService;
    }
}