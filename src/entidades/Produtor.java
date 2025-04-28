package entidades;

public class Produtor implements Runnable {
    private final Buffer buffer;

    public Produtor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int tempoEspera =(int) (Math.random() * 1000);
                Thread.sleep(tempoEspera);
                buffer.produzir();
            } catch (InterruptedException e) {
                System.out.println("[Produtor] Interrompido! ");
                break;

            }

        }
    }

}
