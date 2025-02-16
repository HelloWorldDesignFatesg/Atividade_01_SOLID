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
A correção deve ser feita **delegando as respectivas funcionalidades** a classes diferentes.
