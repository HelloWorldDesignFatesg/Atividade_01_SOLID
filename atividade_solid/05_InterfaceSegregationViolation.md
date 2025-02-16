# **EXERCÍCIO 5** ## **InterfaceSegregationViolation.java** 

O código a seguir viola o **Princípio da Segregação de Interface** (Interface Segregation Principle - ISP), um dos princípios SOLID, pelos seguintes motivos: - 

**Interface Segregation Principle (ISP):

** A interface `Machine` força a implementação de três métodos: `print()`, `scan()` e `fax()`. No entanto, a classe `MultiFunctionPrinter` pode não precisar de todos esses métodos, ou outros tipos de máquinas podem precisar de apenas alguns deles. Isso resulta em uma implementação desnecessária de métodos que não são utilizados pela classe, o que violenta o princípio de que as interfaces devem ser específicas e não sobrecarregar os implementadores com métodos desnecessários. --- 
## 

**Correção** A correção consiste em criar interfaces menores e mais específicas, de forma que as classes implementem apenas os métodos que realmente necessitam. Dessa forma, uma classe que implementa a interface `Machine` poderá escolher apenas os métodos relevantes para sua função. 

```java 
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

class MultiFunctionPrinter implements Printer, Scanner, Fax {
    public void print() {
        System.out.println("Printing...");
    }

    public void scan() {
        System.out.println("Scanning...");
    }

    public void fax() {
        System.out.println("Faxing...");
    }
}

public class InterfaceSegregationSolved {
    public static void main(String[] args) {
        MultiFunctionPrinter printer = new MultiFunctionPrinter();
        printer.print();
        printer.scan();
        printer.fax();
    }
}
```
