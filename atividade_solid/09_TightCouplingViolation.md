## Questão 09 - TightCouplingViolation

O problema está na violação do princípio da inversão de dependência, pois o módulo Car e de alto nivel e está dependendo do módulo Engine que é de baixo nivel, isso fere os princípios do DIP.

Código errado

```java
    public class TightCouplingViolation {
        public static void main(String[] args) {
            Engine engine = new Engine();
            Car car = new Car(engine);
            car.start();
        }
    }

    class Engine {
        public void start() {
            System.out.println("Engine started");
        }
    }

    class Car {
        private Engine engine;

        public Car(Engine engine) {
            this.engine = engine;
        }

        public void start() {
            engine.start();
            System.out.println("Car is running");
        }
    }
```

Código corrigido

```java
    public class TightCouplingViolation {
        public static void main(String[] args) {
            Engine motor = new MotorCombustivel();
            Car car = new Car(motor);
            car.start();
        }
    }

    class Engine {
        public void start();
    }

    class MotorCombustivel implements Engine {
        @Override
        public void start() {
            System.out.println("Motor combustivel ligado");
        }
    }

    class Car {
        private Engine engine;

        public Car(Engine engine) {
            this.engine = engine;
        }

        public void start() {
            engine.start();
            System.out.println("Car is running");
        }
    }
```
