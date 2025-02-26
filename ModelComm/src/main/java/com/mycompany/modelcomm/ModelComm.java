
package com.mycompany.modelcomm;


public class ModelComm {

    public static void main(String[] args) {
        Luz luz = new Luz(); // Crea el receptor

        Command encenderLuz = new EncenderLuzCommand(luz); // Crea los comandos
        Command apagarLuz = new ApagarLuzCommand(luz);

        ControlRemoto controlRemoto = new ControlRemoto(); // Crea el invocador

        controlRemoto.setCommand(encenderLuz); // Asigna el comando encenderLuz
        controlRemoto.botonPresionado(); // Ejecuta el comando (Luz encendida)
        controlRemoto.botonDeshacerPresionado(); // Deshace el comando (Luz apagada)

        controlRemoto.setCommand(apagarLuz); // Asigna el comando apagarLuz
        controlRemoto.botonPresionado(); // Ejecuta el comando (Luz apagada)
        controlRemoto.botonDeshacerPresionado(); // Deshace el comando (Luz encendida)
    }
}
