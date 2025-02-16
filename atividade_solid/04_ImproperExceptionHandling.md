# **EXERCÍCIO 4** ## **ImproperExceptionHandling.java

** O código a seguir viola dois princípios importantes do SOLID: 

- **Single Responsibility Principle (SRP):** A classe `Calculator` possui duas responsabilidades: 

1. Realizar a operação de divisão. 

2. Tratar exceções que possam ocorrer durante essa operação. Essa combinação dificulta a manutenção, pois a lógica de negócio está acoplada ao tratamento de erros.

 - **Open/Closed Principle (OCP):** Ao incorporar o tratamento de exceções dentro do método `divide`, qualquer alteração na estratégia de tratamento de erros exigirá a modificação da classe `Calculator`. Assim, a classe não está "fechada para modificação", dificultando a extensão do comportamento sem alterar seu código.

# **Correção**:

A correção consiste em delegar o tratamento de exceções ao chamador (no método `main`), permitindo que a classe `Calculator` se concentre apenas na operação de divisão. Dessa forma, o código fica mais flexível e alinhado aos princípios SOLID.

```java 
public class ImproperExceptionHandling {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            System.out.println("Result: " + calculator.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Divisão por zero não permitida!");
        }
    }
}
class Calculator {
    public int divide(int a, int b) {
        return a / b; // Apenas a divisão
    }
}
```


