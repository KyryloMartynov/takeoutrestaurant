package project.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RestaurantClient {
    private final static Scanner sc = new Scanner(System.in);
    public static RestaurantService server;

    static {
        QName qname = new QName("http://client.project/", "RestaurantServiceImplService");
        Service service = null;
        try {
            service = Service.create(new URL("http://localhost:9090/restaurant?wsdl"), qname);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        server = service.getPort(RestaurantService.class);
    }
}
