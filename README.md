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

Condição corrida: duas threads tentando acessar o mesmo recurso, como evitar:

```Java
public class Contador {
private int contagem = 0;

    public void incrementar() {
        synchronized (this) {
            contagem++;
        }
        System.out.println(“Incrementado com sucesso!”)
    }
}
//Método geral de sicronnização:
synchronized (objeto a se sincronizar) {
parte do código a ser sincronizada
}
```

"lock intrínseco" ou "monitor interno". Cada objeto em Java tem um lock intrínseco associado a ele. Quando um método é synchronized, ele usa o lock do objeto. Se for um método estático synchronized, ele usa o lock do objeto que representa a classe (Class object).
Implementação:
```Java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Contador {
private int contagem = 0;
private final Lock lock = new ReentrantLock();

    public void incrementar() {
        lock.lock();
        try {
            contagem++;
        } finally {
            lock.unlock();
        }
    }
}
```
- importante: método join -- Utilizado após iniciar um thread, para evitar erros, em uma thread, isso faz com que a thread atual (a que chama o join()) espere até que a thread em que o método join() foi chamado seja encerrada.

conforme exemplo:   
```Java
saqueJoao.start();
saqueMaria.start();

  try {
          saqueDoJoao.join();
            saqueDaMaria.join();
        } catch (InterruptedException e) {
        throw new RuntimeException(e);
        }

```



