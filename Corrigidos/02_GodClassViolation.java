public class GodClassViolation {
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
    private GodClassViolation authService;
    private DashboardService dashboardService;
    private PaymentService paymentService;
    private ReportService reportService;

    public Application() {
        this.authService = new GodClassViolation();
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
