## **EXERCÍCIO 3**

### **Código Original (Com Dependências Rígidas)**
```java
public class HardCodedDependencies {
    public static void main(String[] args) {
        Report report = new Report();
        report.generatePDFReport();
    }
}

class Report {
    public void generatePDFReport() {
        System.out.println("Generating PDF Report...");
    }
}
```

### **Problema**
O código acima contém **dependências rígidas (hard-coded dependencies)**, o que **viola o Dependency Inversion Principle (DIP)**. A classe `Report` depende diretamente de uma implementação específica (`generatePDFReport()`), restringindo-se a gerar apenas relatórios em PDF.

Se quisermos gerar um relatório em HTML, CSV ou XML, precisaríamos modificar a classe `Report`, **quebrando o princípio do Aberto/Fechado (OCP - Open/Closed Principle)**.

### **Correção (Usando Injeção de Dependência e Interfaces)**
A correção pode ser feita criando uma interface para representar a geração de relatórios. Cada formato de relatório implementa essa interface.

```java
interface IReportGenerator {
    void generate();
}
```

#### **Implementação para Relatórios em PDF**
```java
public class PDFReportGenerator implements IReportGenerator {
    public void generate() {
        System.out.println("Generating PDF Report...");
    }
}
```

#### **Classe `Report` Corrigida (Usando Injeção de Dependência)**
```java
class Report {
    private IReportGenerator reportGenerator;

    public Report(IReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public void generateReport() {
        reportGenerator.generate();
    }
}
```

#### **Classe Principal (Uso da Solução Corrigida)**
```java
public class HardCodedDependenciesFixed {
    public static void main(String[] args) {
        IReportGenerator pdfGenerator = new PDFReportGenerator();
        Report report = new Report(pdfGenerator);
        report.generateReport();
    }
}
```

### **Benefícios da Solução**
**Segregação de responsabilidades**: A classe `Report` não precisa mais saber como os relatórios são gerados.  
**Facilidade de extensão**: Podemos adicionar novos formatos de relatório sem modificar a classe `Report`.  
**Adesão aos princípios SOLID**: Respeita o **DIP** e o **OCP**, tornando o código mais modular e sustentável.