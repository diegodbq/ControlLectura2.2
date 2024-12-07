/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package animal;

/**
 *
 * @author HP
 */
public class Animal{
  String nombre;
  String tipo;
  String sexo;
  int Edad;
  String Tamaño;
   
  
  public Animal(String nombre, String tipo, String sexo, int Edad, String Tamaño){
      this.nombre=nombre;
      this.tipo=tipo;
      this.sexo=sexo;
      this.Edad=Edad;
      this.Tamaño=Tamaño;
      
  
  }

    public void disponible(String Animal) {
        System.out.println("el animal es"+ Animal);
    }
    
}