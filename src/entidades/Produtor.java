package entidades;
//IMPLEMENTA UMA INTERFACE QUE PERMITE USAR ESSA CLASSE COMO UM THREAD
public class Produtor implements Runnable {
    private final Buffer buffer;

    // PEGA O BUFFER
    public Produtor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            // try - TENTA COLOCAR ALGO NO BUFFER
            try {
                // SEMPRE VAI ESPERAR PRA DE 0 1000 MILISEGUNDOS
                int tempoEspera = (int) (Math.random() * 1000);
                Thread.sleep(tempoEspera);
                // PRODUZ
                buffer.produzir();
            } catch (InterruptedException e) {
                // SE CHEIO AVISA E NÃO TENTA COLOCAR NADA
                System.out.println("[Produtor] Interrompido! ");
                break;

            }

        }
    }

}
