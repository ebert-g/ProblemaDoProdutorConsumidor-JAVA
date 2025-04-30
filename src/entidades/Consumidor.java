package entidades;

public class Consumidor implements Runnable {
    private final Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int tempoEspera = (int) (Math.random() * 1000);
                Thread.sleep(tempoEspera);
                buffer.consumir();
            } catch (InterruptedException e) {
                System.out.println("[Consumidor] Interrompido! ");
                break;

            }

        }
    }
}
