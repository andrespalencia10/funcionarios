/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iudigital.data;

import iudigital.conexion.Conexion;
import iudigital.execute.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GAME
 */
public class FuncionarioDao {

    private static final String getFuncionario = "select * from funcionarios";
    private static final String createFuncionario = "insert into funcionarios (tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento) "
            + "values(?,?,?,?,?,?,?,?,? )";
    private static final String getFuncionarioId = "select * from funcionarios f where funcionario_id = ?";
    private static final String updateFuncionario = "update funcionarios set "
            + "tipo_identificacion = ?, numero_identificacion = ?, nombres = ?, apellidos = ?,"
            + " estado_civil = ?, sexo = ?, direccion = ?, telefono = ?, fecha_nacimiento = ? where funcionario_id = ?";
    private static final String deleteFuncionario = "delete from funcionarios where funcionario_id = ?";

    public List<Funcionario> obtenerFuncionarios() throws SQLException {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            preparedStatement = con.prepareStatement(getFuncionario);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setFuncionario_id(result.getInt("funcionario_id"));
                funcionario.setTipo_identificacion(result.getString("tipo_identificacion"));
                funcionario.setNumero_identificacion(result.getString("numero_identificacion"));
                funcionario.setNombres(result.getString("nombres"));
                funcionario.setApellidos(result.getString("apellidos"));
                funcionario.setEstado_civil(result.getString("estado_civil"));
                funcionario.setSexo(result.getString("sexo"));
                funcionario.setDireccion(result.getString("direccion"));
                funcionario.setTelefono(result.getInt("telefono"));
                funcionario.setFecha_nacimiento(result.getString("fecha_nacimiento"));
                funcionarios.add(funcionario);

            }
            return funcionarios;
        } finally {
            if (con != null) {
                con.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (result != null) {
                result.close();
            }
        }

    }

    public void crear(Funcionario func) throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = Conexion.getConnection();
            preparedStatement = con.prepareStatement(createFuncionario);
            preparedStatement.setString(1, func.getTipo_identificacion());
            preparedStatement.setString(2, func.getNumero_identificacion());
            preparedStatement.setString(3, func.getNombres());
            preparedStatement.setString(4, func.getApellidos());
            preparedStatement.setString(5, func.getEstado_civil());
            preparedStatement.setString(6, func.getSexo());
            preparedStatement.setString(7, func.getDireccion());
            preparedStatement.setInt(8, func.getTelefono());
            preparedStatement.setString(9, func.getFecha_nacimiento());
            preparedStatement.executeUpdate();
        } finally {
            if (con != null) {
                con.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Funcionario obtenerFuncionario(int id) throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        Funcionario funcionario = null;

        try {
            con = Conexion.getConnection();
            preparedStatement = con.prepareStatement(getFuncionarioId);
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();

            if (result.next()) {
                funcionario = new Funcionario();
                funcionario.setFuncionario_id(result.getInt("funcionario_id"));
                funcionario.setTipo_identificacion(result.getString("tipo_identificacion"));
                funcionario.setNumero_identificacion(result.getString("numero_identificacion"));
                funcionario.setNombres(result.getString("nombres"));
                funcionario.setApellidos(result.getString("apellidos"));
                funcionario.setEstado_civil(result.getString("estado_civil"));
                funcionario.setSexo(result.getString("sexo"));
                funcionario.setDireccion(result.getString("direccion"));
                funcionario.setTelefono(result.getInt("telefono"));
                funcionario.setFecha_nacimiento(result.getString("fecha_nacimiento"));
            }
            return funcionario;
        } finally {
            if (con != null) {
                con.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (result != null) {
                result.close();
            }
        }
    }

    public void actualizarFuncionario(int id, Funcionario func) throws SQLException {

        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = Conexion.getConnection();
            preparedStatement = con.prepareStatement(updateFuncionario);
            preparedStatement.setString(1, func.getTipo_identificacion());
            preparedStatement.setString(2, func.getNumero_identificacion());
            preparedStatement.setString(3, func.getNombres());
            preparedStatement.setString(4, func.getApellidos());
            preparedStatement.setString(5, func.getEstado_civil());
            preparedStatement.setString(6, func.getSexo());
            preparedStatement.setString(7, func.getDireccion());
            preparedStatement.setInt(8, func.getTelefono());
            preparedStatement.setString(9, func.getFecha_nacimiento());
            preparedStatement.setInt(10, id);
            preparedStatement.executeUpdate();
        } finally {
            if (con != null) {
                con.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
    public void eliminarFuncionario(int id) throws SQLException {
         Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try {
            
            con = Conexion.getConnection();
            preparedStatement = con.prepareStatement(deleteFuncionario);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } finally {
             if (con != null) {
                con.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
