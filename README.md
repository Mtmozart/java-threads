# notas sobre o curso de threads

- Simulação de paralelismo: situações que ocorrem que podem ocorrer ao mesmo tempo, mas não deveriam

- As threads, em java, são utilizadas para trabalhar com coisas paralelas.
### Mas o que são threads ?
Ela é uma  classe que é mapeada diretamente  com o sistema operacional, implementando Runnable na classe desejada.
Ressalta-se que ela é uma linha de execução, conforme image:
![Imagem alura threads](https://cdn1.gnarususercontent.com.br/1/795715/90af46c4-4671-4c8b-90d0-b25255031be2.png)


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

```
