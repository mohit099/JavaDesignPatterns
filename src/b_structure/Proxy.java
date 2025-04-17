package b_structure;

import java.util.Arrays;
import java.util.List;

interface Internet {
    void connectTo(String serverHost);
}

class RealInternet implements Internet {
    @Override
    public void connectTo(String serverHost) {
        System.out.println("Connecting to " + serverHost);
    }
}

class ProxyInternet implements Internet {
    private static List<String> blockedSites = Arrays.asList("abc.com", "xyz.com");
    private RealInternet realInternet = new RealInternet();

    @Override
    public void connectTo(String serverHost) {
        if (blockedSites.contains(serverHost)) {
            System.out.println("Access Denied: " + serverHost + " is blocked.");
        } else {
            realInternet.connectTo(serverHost); // Forwarding request to the real object
        }
    }
}


public class Proxy {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();

        internet.connectTo("google.com");
        internet.connectTo("abc.com");
    }
}
