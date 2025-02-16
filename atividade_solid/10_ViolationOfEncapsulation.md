## Questão 10 - ViolationOfEncapsulation

Erro encontrado nessa questão se trata sobre principio de responsabilidade única, pois e de sua responsabilidade modificar os dados internamente, dessa forma está levando o codigo a um alto acoplamento.

Codigo errado.

```java
    public class ViolationOfEncapsulation {
        public static void main(String[] args) {
            Person person = new Person();
            person.name = "John Doe";
            person.age = 30;
            System.out.println(person.name + " is " + person.age + " years old.");
        }
    }

    class Person {
        public String name;
        public int age;
    }
```

Codigo corrigido.

```java
    public class ViolationOfEncapsulation {
        public static void main(String[] args) {
            Person pessoa = new Person("Pedro Spindola", 25);
            System.out.println(pessoa);
        }
    }

    class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

```
