
package com.mycompany.modelcomm;


public class EncenderLuzCommand implements Command {
    private Luz luz; // Referencia al receptor (Luz)

    public EncenderLuzCommand(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void execute() {
        luz.encender(); // Llama al método encender() del receptor
    }

    @Override
    public void undo() {
        luz.apagar(); // Llama al método apagar() del receptor
    }
}


