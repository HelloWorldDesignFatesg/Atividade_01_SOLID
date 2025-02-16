## Questão 08 - SingleResponsibilityViolation

Violação do principio de responsabilidade única, onde a class Invoice está com duas responsabilidade de diferente função, imprimir fatura e salva fatura no banco de dados.

Código errado

```java
    public class SingleResponsibilityViolation {
        public static void main(String[] args) {
            Invoice invoice = new Invoice(1000);
            invoice.printInvoice();
            invoice.saveToDatabase();
        }
    }

    class Invoice {
        private double amount;

        public Invoice(double amount) {
            this.amount = amount;
        }

        public void printInvoice() {
            System.out.println("Invoice amount: " + amount);
        }

        public void saveToDatabase() {
            System.out.println("Saving invoice to database...");
        }
    }
```

Código corrigido

```java
    public class SingleResponsibilityCorrect {
        public static void main(String[] args) {
            Invoice invoice = new Invoice(1000);
            ImprimirFatura printer = new ImprimirFatura();
            SalvarFatura repository = new SalvarFatura();

            printer.imprimir(invoice);
            repository.salva(invoice);
        }
    }

    class Invoice {
        private double amount;

        public Invoice(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }
    }

    class ImprimirFatura {
        public void imprimir(Invoice invoice) {
            System.out.println("Invoice amount: " + invoice.getAmount());
        }
    }

    class SalvarFatura {
        public void salva(Invoice invoice) {
            System.out.println("Saving invoice to database...");
        }
    }
```
