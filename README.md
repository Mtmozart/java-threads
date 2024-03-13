# notas sobre o curso de threads

- Simulação de paralelismo: situações que ocorrem que podem ocorrer ao mesmo tempo, mas não deveriam

- As threads, em java, são utilizadas para trabalhar com coisas paralelas.
### Mas o que são threads ?
Ela é uma  classe que é mapeada diretamente  com o sistema operacional, implementando Runnable na classe desejada.
Ressalta-se que ela é uma linha de execução, conforme image:
![Imagem alura threads](https://cdn1.gnarususercontent.com.br/1/795715/90af46c4-4671-4c8b-90d0-b25255031be2.png)

[mais sobre threads](https://cursos.alura.com.br/course/java-threads-criar-gerenciar-aplicar-spring/task/151413)

### Como a usar:

```Java
//PARTE 01
public class OperacaoSaque implements Runnable{}
//Método do contrato
@Override
public void run() {
    this.executa();
}
//criacação de instância
 Thread thread = new Thread("parâmetro");

//execução
thread.start();

//verificando ordem de execução, deve ser posta no método que chama a threads.
    System.out.println( Thread.currentThread().getName());

```

- Outro ponto importante é que a Thread já implementa Runnable, ou seja, pode-se criar sublclase e sobscrever, conforme exemplo:
```Java
public class Multiplicador extends Thread {
public void run () {
// calculo demorado
}
}
//usando método do Runnable
Multiplicador multiplicador = new Multiplicador();
multiplicador.start();

```

Ponto negativo: Herança por preguiça: Refere-se à prática de herdar ou estender uma classe simplesmente para reutilizar código, sem considerar adequadamente a relação de herança e a estrutura do sistema.



