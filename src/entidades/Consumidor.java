package entidades;

public class Consumidor implements Runnable {
    private final Buffer buffer;

    // PEGA O BUFFER
    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            // try - TENTA RETIRAR ALGO DO BUFFER
            try {
                // SEMPRE VAI ESPERAR PRA DE 0 1000 MILISEGUNDOS
                int tempoEspera = (int) (Math.random() * 1000);
                Thread.sleep(tempoEspera);
                // CONSOME
                buffer.consumir();
            } catch (InterruptedException e) {
                // SE VAZIO AVISA E NÃO TENTA RETIRAR NADA
                System.out.println("[Consumidor] Interrompido! ");
                break;

            }

        }
    }
}
