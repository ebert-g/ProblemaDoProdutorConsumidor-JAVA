import entidades.Buffer;
import entidades.Consumidor;
import entidades.Produtor;

public class App {
    public static void main(String[] args) {
        // CRIA O BUFFER
        Buffer buffer = new Buffer(10);
        // PRODUTOR E CONSUMIDOR
        Produtor produtor = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);
        // CRIA AS DUAS THREAD
        Thread threadProdutor = new Thread(produtor);
        Thread threadConsumidor = new Thread(consumidor);
        // START NAS DUAS
        threadProdutor.start();
        threadConsumidor.start();

    }
}