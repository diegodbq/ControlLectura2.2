
package com.mycompany.modelcomm;


public interface Command {
    void execute(); // Método para ejecutar el comando
    void undo();    // Método para deshacer el comando
}
