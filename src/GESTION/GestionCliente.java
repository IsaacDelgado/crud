/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GESTION;

import CapaDatos.Conexion;
import POCO.Cliente;
import java.sql.SQLException;


/**
 *
 * @author Isaac
 */
public class GestionCliente implements IGestion
{

    public GestionCliente() 
    {
        Conexion.setCadena("jdbc:mySql://localhost/facturacion");
        Conexion.setUsuario("root");
        Conexion.setPass("");
    }
    
    private Cliente client=new Cliente();
    public Cliente getCliente()
    {
    return client;
    }
    public void setCliente(Cliente client)
    {
    this.client=client;
    }
    @Override
    public void Ingresar() throws SQLException {
    try{
        Conexion.GetInstancia().Conectar();
        Conexion.GetInstancia().Ejecutar("insert into cliente(cedula,nombre,direccion,cupo) values ('"+this.client.getCedula()+"','"+this.client.getNombre()+"','"+this.client.getDireccion()+"',"+this.client.getCupo()+")");
        Conexion.GetInstancia().Desconectar();
    }
    catch(SQLException e)
    {
        throw e;
    }
    
    }

    @Override
    public void Modificar() throws SQLException {
    try{
        Conexion.GetInstancia().Conectar();
        Conexion.GetInstancia().Ejecutar("UPDATE cliente SET nombre='"+this.client.getNombre()+"', direccion = '"+this.client.getDireccion()+"', cupo = '"+this.client.getCupo()+"' WHERE cedula = "+this.client.getCedula());
        Conexion.GetInstancia().Desconectar();
    }
    catch(SQLException e)
    {
        throw e;
    }
    }

    @Override
    public void Nuevo() throws SQLException {
    
        this.client.setCedula(" ");
        this.client.setNombre(" ");
        this.client.setDireccion(" ");
        this.client.setCupo(0);
        
    
    }

    @Override
    public void Eliminar() throws SQLException {
    try{
        Conexion.GetInstancia().Conectar();
        Conexion.GetInstancia().Ejecutar("DELETE FROM Cliente WHERE Cedula = "+client.getCedula());
        Conexion.GetInstancia().Desconectar();
        }
    catch(SQLException e)
    {
        throw e;
    }
    }

    @Override
    public void Consultar() throws SQLException {
    try{
        Conexion.GetInstancia().Conectar();
        Conexion.GetInstancia().Ejecutar("select from cliente WHERE Cedula = "+client.getCedula());
        Conexion.GetInstancia().Desconectar();
    }
    catch(SQLException e)
    {
        throw e;
    }
    }
    
}
