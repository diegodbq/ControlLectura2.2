
package com.mycompany.modelcomm;


public class ApagarLuzCommand implements Command {
    private Luz luz; // Referencia al receptor (Luz)

    public ApagarLuzCommand(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void execute() {
        luz.apagar(); // Llama al método apagar() del receptor
    }

    @Override
    public void undo() {
        luz.encender(); // Llama al método encender() del receptor
    }
}