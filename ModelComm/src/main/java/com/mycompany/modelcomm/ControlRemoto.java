
package com.mycompany.modelcomm;

/**
 *
 * @author HP
 */
public class ControlRemoto {
    private Command slot; // Almacena el comando actual

    public void setCommand(Command command) {
        slot = command; // Asigna un comando al control remoto
    }

    public void botonPresionado() {
        slot.execute(); // Ejecuta el comando actual
    }

    public void botonDeshacerPresionado() {
        slot.undo(); // Deshace el comando actual
    }
}
