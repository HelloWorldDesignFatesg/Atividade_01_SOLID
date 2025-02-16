# Teste# **EXERCÍCIO 1**

## **DependencyInversionViolation.java**

```java
public class DependencyInversionViolation {
    public static void main(String[] args) {
        LightBulb bulb = new LightBulb();
        Switch lightSwitch = new Switch(bulb);
        lightSwitch.turnOn();
    }
}

class LightBulb {
    public void turnOn() {
        System.out.println("LightBulb is ON");
    }

    public void turnOff() {
        System.out.println("LightBulb is OFF");
    }
}

class Switch {
    private LightBulb bulb;

    public Switch(LightBulb bulb) {
        this.bulb = bulb;
    }

    public void turnOn() {
        bulb.turnOn();
    }

    public void turnOff() {
        bulb.turnOff();
    }
}
```

O código apresentado **viola o Princípio da Inversão de Dependência** (Dependency Inversion Principle - DIP), porque um **módulo de alto nível** (classe `Switch`) está dependendo de um **módulo de baixo nível** (classe `LightBulb`). Módulos de alto nível **não devem depender** de módulos de baixo nível. Ambos devem depender de abstrações.

O código também **quebra o princípio do fechamento para modificação** (OCP - Open/Closed Principle). Se quisermos trocar a `LightBulb` por outro dispositivo, como um **LED**, precisaríamos modificar a classe `Switch`.

### **Correção**
Podemos introduzir uma **interface** para representar dispositivos controláveis pelo interruptor. Assim, a classe `Switch` não dependerá mais da implementação concreta da `LightBulb`, mas sim da **abstração**, permitindo a introdução de novos dispositivos sem a necessidade de alterar a `Switch`.
