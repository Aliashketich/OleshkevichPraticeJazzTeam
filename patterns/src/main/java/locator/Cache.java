package locator;

import java.util.ArrayList;
import java.util.List;

class Cache {
    private List<Service> services = new ArrayList<>();

    Service getService(String serviceName) {
        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(serviceName)) {
                System.out.println("Returned from cache " + service.getName() + " service");
                return service;
            }
            return null;
        }
        return null;
    }

    void setService(Service newService) {
        boolean exists = false;
        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(newService.getName())) {
                exists = true;
            }
            if (!exists) {
                services.add(newService);
            }
        }
    }
}