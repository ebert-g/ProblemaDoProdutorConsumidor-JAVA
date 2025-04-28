package entidades;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
    private final List<Boolean> buffer;
    private final int capacidade;

    // Inicializando o buffer
    public Buffer(int capacidade) {
        this.capacidade = capacidade;
        this.buffer = new ArrayList<>(capacidade);

        for (int i = 0; i < capacidade; i++) {
            buffer.add(false);
        }
    }

    // Mostrar o buffer no console
    public void mostrarBuffer() {
        StringBuilder estado = new StringBuilder("Buffer: ");
        int ocupados = 0;

        for (Boolean ocupado : buffer) {
            if (ocupado) {
                estado.append("█ ");
                ocupados++;
            } else {
                estado.append("· ");
            }
        }

        int percentual = (ocupados * 100) / capacidade;
        System.out.println(estado.toString() + "-> " + percentual + "% ocupado");
        System.out.println();

    }

    // Produtor chama essa funação para colocar dentro do buffer
    public synchronized void produzir() {
        for (int i = 0; i < capacidade; i++) {
            if (!buffer.get(i)) {
                buffer.set(i, true);
                System.out.println("[Produtor] Produziu na posição " + i);
                mostrarBuffer();
                return;
            }
        }
        System.out.println("[Produtor] Buffer cheio! Não produziu.");
    }

    // Consumidor chama essa função para remover coisas dentro do buffer
    public synchronized void consumir() {
        for (int i = 0; i < capacidade; i++) {

            if (buffer.get(i)) {
                buffer.set(i, false);
                System.out.println("[Consumidor] Consumiu na posição " + i);
                mostrarBuffer();
                return;
            }
        }
        System.out.println("[Consumidor] Buffer vazio! Nada p/ consumir. ");
    }

}