/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author João e Thalia
 */
public class Agenda {
    private String titulo;
    private String nomeFuncionario;
    private int idFuncionario;
    private String prioridade;
    private String data;
    private String hora;
    private final Conexao conexao = new Conexao();
    
    public Agenda(String titulo, String nomeFuncionario, String prioridade, String data, String hora) {
        this.titulo = titulo;
        this.nomeFuncionario = nomeFuncionario;
        this.prioridade = prioridade;
        this.data = data;
        this.hora = hora;
    }

    public Agenda(){
        
    }
    
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public void cadastrarAgenda() throws SQLException
    {   
        if( verificarJaExistente( this.titulo, this.data, this.hora ) ){
            try (PreparedStatement pst = 
                    conexao.getConexao().prepareStatement(
                    "insert into agenda(idAgenda, titulo, data, prioridade, hora, idFuncionario)"
                            + " values (0,?,?,?,?,?)")) {
                pst.setString( 1, this.getTitulo() );
                pst.setString( 2, this.getData() );
                pst.setString( 3, this.getPrioridade() );
                pst.setString( 4, this.getHora() );
                pst.setInt( 5, this.getIdFuncionario() );
                
                pst.executeUpdate();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Agenda já existe!");
        }
        
        conexao.close();   
    }
    
    public boolean verificarJaExistente( String titulo, String data, String hora ) throws SQLException{
        
        ResultSet rs;
        int soma = 0;
        
        try (Statement st = conexao.getConexao().createStatement()) {
            rs = st.executeQuery("select count(*) as soma from agenda where titulo = '"+titulo+"'"
                    + " and data = "+data+" and hora = "+hora+""); 
            rs.first();
            soma = rs.getInt("soma");
        }
        conexao.close();
        return ( soma != 1 );
        
    }
    
}
