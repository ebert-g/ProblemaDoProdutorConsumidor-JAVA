import entidades.Buffer;
import entidades.Consumidor;
import entidades.Produtor;

public class App {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
        Produtor produtor = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);
        Thread threadProdutor = new Thread(produtor);
        Thread threadConsumidor = new Thread(consumidor);
        threadProdutor.start();
        threadConsumidor.start();

    }
}