
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
    private int cargo;
    private String email;
    private String naturalidade;
    private final Conexao conexao = new Conexao();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Funcionario(int codigo, int aInt1, String cpf, String rg, String nome, String situacao, String dataNasc, String dataAdmissao, String descricao, int cargo, String email, String naturalidade) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.situacao = situacao;
        this.dataNasc = dataNasc;
        this.dataAdmissao = dataAdmissao;
        this.descricao = descricao;
        this.cargo = cargo;
        this.email = email;
        this.naturalidade = naturalidade;
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

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
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
                lista.add( new Funcionario(rs.getInt("idFuncionario"), rs.getInt("codigo"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nome_funcionario"), rs.getString("situacao"), rs.getString("dataNasc"), rs.getString("dataAdmissao"), rs.getString("descricao"), rs.getInt("cargo"), rs.getString("email"), rs.getString("naturalidade")));             
            }
        }
        conexao.close();
        
        return lista;
    }  
}
