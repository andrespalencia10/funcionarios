/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto1;

import iudigital.controller.FuncionarioController;
import iudigital.execute.Funcionario;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GAME
 */
public class Proyecto1 {
    
    
    
    public static void crear(FuncionarioController funcControl) {
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite el tipo de documednto: ");
            String tipoD = sc.nextLine();
            System.out.println("Tipo de documento: "+tipoD);
            System.out.println("=======================================");
            
            System.out.println("Digite el numero de documednto: ");
            String numeroD = sc.nextLine();
            System.out.println("Numero de documento: "+numeroD);
            System.out.println("=======================================");
            
            System.out.println("Digite el nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Tipo de documento: "+nombre);
            System.out.println("=======================================");
            
            System.out.println("Digite el apellido: ");
            String apellido = sc.nextLine();
            System.out.println("Tipo de apellido: "+apellido);
            System.out.println("=======================================");
            
            System.out.println("Digite el estado_civil: ");
            String estado = sc.nextLine();
            System.out.println("Tipo de estado: "+estado);
            System.out.println("=======================================");
            
            System.out.println("Digite el sexo: ");
            String sexo = sc.nextLine();
            System.out.println("Tipo de sexo: "+sexo);
            System.out.println("=======================================");
            
            System.out.println("Digite el direccion: ");
            String dire = sc.nextLine();
            System.out.println("Tipo de dire: "+dire);
            System.out.println("=======================================");
            
             System.out.println("Digite el fec: ");
            String fec = sc.nextLine();
            System.out.println("Tipo de fec: "+fec);
            System.out.println("=======================================");
            
            System.out.println("Digite el tele: ");
            int tele = sc.nextInt();
            
            System.out.println("Tipo de tele: "+tele);
            System.out.println("=======================================");
            
           
            
            Funcionario func = new Funcionario();
            func.setTipo_identificacion(tipoD);
            func.setNumero_identificacion(numeroD);
            func.setNombres(nombre);
            func.setApellidos(apellido);
            func.setEstado_civil(estado);
            func.setSexo(sexo);
            func.setDireccion(dire);
            func.setTelefono(tele);
            func.setFecha_nacimiento(fec);
            funcControl.crear(func);
            System.out.println("Funcionario creado correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void obtenerFuncionarios(FuncionarioController funcControl){
        
        try{
            List<Funcionario> func = funcControl.obtenerFuncionarios();
            if(func.isEmpty()){
                System.out.println("No hay funcionarios");
            } else {
                func.forEach(f -> {
                    System.out.println("id: "+f.getFuncionario_id());
                    System.out.println("tipo: "+f.getTipo_identificacion());
                    System.out.println("#: "+f.getNumero_identificacion());
                    System.out.println("nombre: "+f.getNombres());
                    System.out.println("apellido: "+f.getApellidos());
                    System.out.println("estado: "+f.getEstado_civil());
                    System.out.println("sexo: "+f.getSexo());
                    System.out.println("dire: "+f.getDireccion());
                    System.out.println("tele: "+f.getTelefono());
                    System.out.println("fec: "+f.getFecha_nacimiento());
                    System.out.println("===========================================");
                    System.out.println("===========================================");
                });
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void eliminarFuncionario(FuncionarioController funcControl){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite la ID del funcionario a eliminar: ");
            int id = sc.nextInt();
            System.out.println("Funcionario a eliminar: "+id);
            
            Funcionario funcExiste = funcControl.obtenerFuncionario(id);
            if(funcExiste == null){
                System.out.println("La Id del funcionario no existe");
                return;
            }
            
            funcControl.eliminarFuncionario(id);
            System.out.println("Funcionario Eliminado exitosamente");
            obtenerFuncionarios(funcControl);
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
     public static void main(String[] args) {
         
        FuncionarioController funcControl = new FuncionarioController();
      //  crear(funcControl);
        // obtenerFuncionarios(funcControl);
        // eliminarFuncionario(funcControl);
        
        Main jframe = new Main();
        
        jframe.setVisible(true);
         
    }

   
}

