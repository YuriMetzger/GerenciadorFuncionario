
package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Funcionario {
    private int codigo;
    private String cpf;
    private String rg;
    private String nome;
    private String situacao;
    private String dataNasc;
    private String dataAdmissao;
    private String descricao;
    private String beneficios;
    private String cargo;
    private String email;
    private String nacionalidade;
    private final Conexao conexao = new Conexao();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Funcionario(int codigo, String cpf, String rg, String nome, String situacao, String dataNasc, String dataAdmissao, String descricao, String beneficios, String cargo, String email, String nacionalidade) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.situacao = situacao;
        this.dataNasc = dataNasc;
        this.dataAdmissao = dataAdmissao;
        this.descricao = descricao;
        this.beneficios = beneficios;
        this.cargo = cargo;
        this.email = email;
        this.nacionalidade = nacionalidade;
    }

    public Funcionario(){
        
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public ArrayList<Funcionario> listarFuncionario() throws SQLException
    {
        ResultSet rs;
        ArrayList<Funcionario> lista;
        
        try (Statement st = conexao.getConexao().createStatement()) {
            rs = st.executeQuery(
                    "select * from funcionario");
            lista = new ArrayList<>();
            
            while(rs.next())
            {
            //lista.add( new Funcionario( rs.getInt("idFuncionario") ,rs.getString("nome_funcionario") , rs.getString("cpf, ") ) );
            }
        }
        conexao.close();
        
        return lista;
    }

  
}
