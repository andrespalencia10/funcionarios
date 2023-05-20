/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iudigital.controller;

import iudigital.data.FuncionarioDao;
import iudigital.execute.Funcionario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author GAME
 */
public class FuncionarioController {
    
    private FuncionarioDao funcDao;

    public FuncionarioController() {
        
        funcDao = new FuncionarioDao();
    }
    
    public List<Funcionario> obtenerFuncionarios() throws SQLException{
        
        return funcDao.obtenerFuncionarios();
    }
    
    public void crear(Funcionario func) throws SQLException {
        funcDao.crear(func);
    }
    
    public Funcionario obtenerFuncionario(int id) throws SQLException {
        return funcDao.obtenerFuncionario(id);
    }
    
    public void actualizarFuncionario(int id, Funcionario func) throws SQLException {
        funcDao.actualizarFuncionario(id, func);
    }
    
    public void eliminarFuncionario(int id) throws SQLException {
        funcDao.eliminarFuncionario(id);
    }
}
