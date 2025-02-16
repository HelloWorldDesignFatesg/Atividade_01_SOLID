# **EXERCÍCIO 2**

## **GodClassViolation.java**

```java
public class GodClassViolation {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}

class Application {
    public void run() {
        System.out.println("Running application...");
        authenticateUser();
        loadDashboard();
        processPayments();
        generateReports();
    }

    private void authenticateUser() {
        System.out.println("Authenticating user...");
    }

    private void loadDashboard() {
        System.out.println("Loading dashboard...");
    }

    private void processPayments() {
        System.out.println("Processing payments...");
    }

    private void generateReports() {
        System.out.println("Generating reports...");
    }
}
```

O código apresentado **viola o princípio da responsabilidade única** (SRP - Single Responsibility Principle) e cria uma **God Class** (Classe Deus). Essa classe **assume muitas responsabilidades**, concentrando múltiplas funcionalidades dentro de uma única entidade.

### **Correção**
A correção deve ser feita **delegando as respectivas funcionalidades** a classes diferentes:

```java
public class AuthenticationService {
    public void authenticateUser() {
        System.out.println("Authenticating user...");
    }
}

public class DashboardService {
    public void loadDashboard() {
        System.out.println("Loading dashboard...");
    }
}

public class PaymentService {
    public void processPayments() {
        System.out.println("Processing payments...");
    }
}

public class ReportService {
    public void generateReports() {
        System.out.println("Generating reports...");
    }
}

public class Application {
    private AuthenticationService authService;
    private DashboardService dashboardService;
    private PaymentService paymentService;
    private ReportService reportService;

    public Application() {
        this.authService = new AuthenticationService();
        this.dashboardService = new DashboardService();
        this.paymentService = new PaymentService();
        this.reportService = new ReportService();
    }

    public void run() {
        System.out.println("Running application...");
        authService.authenticateUser();
        dashboardService.loadDashboard();
        paymentService.processPayments();
        reportService.generateReports();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}
