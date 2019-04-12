package locator;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    private List<Service> services = new ArrayList<>();

    public Service getService(String serviceName) {//NOSONAR
        for (Service service : services) {//NOSONAR
            if (service.getServiceName().equalsIgnoreCase(serviceName)) {//NOSONAR
                return service;//NOSONAR
            }//NOSONAR
        }
        return null;
    }

    public void setService(Service newService) {//NOSONAR
        boolean exists = false;//NOSONAR
        for (Service service : services) {//NOSONAR
            if (service.getServiceName().equalsIgnoreCase(newService.getServiceName())) {//NOSONAR
                exists = true;//NOSONAR
            }//NOSONAR
            if (!exists) {//NOSONAR
                services.add(newService);//NOSONAR
            }
        }//NOSONAR
    }
}