package com.example.newwordfx;


import javax.swing.*;
import java.sql.*;
import java.util.*;


public class Funcoes {
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/bd_barber";
    public static String USER = "admin";
    public static String PASS = "mysql";
    public static Connection conexao;
    public Statement statement;
    public ResultSet resultset;



    boolean getConnection(){
        boolean result = true;
        try{
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASS);
            result = true;
        } catch (ClassNotFoundException | SQLException e) {
            result = false;
            throw new RuntimeException("erro na conexão: ", e);
        }
        return result;
    }

    public void valida_login(String login, String senha){
        try{

            getConnection();
            String sql_login = "SELECT login,senha FROM funcionario WHERE login = '" + login + "'AND senha= '" +senha+"'";
            executeSQL_login(sql_login);
            if (resultset.next()){
                telaLogin conn = new telaLogin();
                conn.tela_Menu();

            }else{
                JOptionPane.showMessageDialog(null, "O Login ou senha está incorreta");

            }

        } catch (SQLException e){
            System.out.println("erro: " + e);
        }


    }

    public PreparedStatement executeSQL_login(String sql_login) {
        try{
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql_login);
        }catch(SQLException sqlException){
            System.out.println("Não foi possivel executar o comando: \n" + sqlException + "\n o SQL passado foi: "+sql_login);
        }
        return null;
    }

    public void inserir_barbeiro(String nome, int telefone, String login, String senha, int privilegio){

        String sql_barbeiro = "INSERT INTO funcionario (id_funcionario, nome, telefone, login, senha, privilegio) VALUES (null,?,?,?,?,?)";

        try {
            getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql_barbeiro);
            stmt.setString(1, nome);
            stmt.setString(2, String.valueOf(telefone));
            stmt.setString(3, login);
            stmt.setString(4, senha);
            stmt.setString(5, String.valueOf(privilegio));
            // Executa a inserção dos dados no Banco de Dados
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Inserção Bem-Sucedida");

            } else {
                JOptionPane.showMessageDialog(null, "Inserção não foi Bem-Sucedida");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao Banco de Dados");
        }

    }

    public void inserirServico(String nome, Float numero) {

        // Consulta SQL de inserção
        String sqlInsercao = "INSERT INTO servico (id, nome, preco) VALUES (null, ?, ?)";

        try {
            Connection conexao = DriverManager.getConnection(URL, USER, PASS);

            // Cria uma declaração preparada com parâmetros
            PreparedStatement stmt = conexao.prepareStatement(sqlInsercao);
            stmt.setString(1, nome);
            stmt.setFloat(2, numero);//erro no tipo para inserção, banco conta como decimal

            // Executa a inserção
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Inserção Bem-sucedida");

            } else {
                JOptionPane.showMessageDialog(null, "Inserção não foi Bem-sucedida");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados no Banco de Dados");
        }
    }

    public void cadastrarCliente(String nome, int numero) {

        // Consulta SQL de inserção
        String sqlInsercao = "INSERT INTO cliente (id, nome, telefone) VALUES (null, ?, ?)";

        try {
            Connection conexao = DriverManager.getConnection(URL, USER, PASS);

            // Cria uma declaração preparada com parâmetros
            PreparedStatement stmt = conexao.prepareStatement(sqlInsercao);
            stmt.setString(1, nome);
            stmt.setInt(2, numero);

            // Executa a inserção
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Inserção Bem-sucedida");

            } else {
                JOptionPane.showMessageDialog(null, "Inserção não foi Bem-sucedida");
            }

            /*// Fecha a conexão
            stmt.close();
            conexao.close();*/
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados no Banco de Dados");
        }
    }
    public HashMap<String, String> lista_funcionarios() {
        String sql_funcionarios = "SELECT nome, id_funcionario FROM funcionario";
        Map<String, String> listaFuncionario = new HashMap<>();
        try {
            Connection conexao = DriverManager.getConnection(URL, USER, PASS);
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql_funcionarios);

            while (resultset.next()) {
                String valor = resultset.getString("nome");
                String id = resultset.getString("id_funcionario");
                listaFuncionario.put(valor, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (HashMap<String, String>) listaFuncionario;
    }

    public HashMap<String, String> lista_servicos() {
        String sql_servicos = "SELECT nome, id FROM servico";
        Map<String, String> listaServico = new HashMap<>();
        try {
            Connection conexao = DriverManager.getConnection(URL, USER, PASS);
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql_servicos);

            while (resultset.next()) {
                String valor = resultset.getString("nome"); // Substitua "nome" pelo nome da coluna
                String id = resultset.getString("id");
                listaServico.put(valor, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (HashMap<String, String>) listaServico;
    }

    public static void ordem_servico(int nome, int servicoSel, int funcionariosSel) {
        System.out.println("Nome: "+nome);
        System.out.println("Nome: "+servicoSel);
        System.out.println("Nome: "+funcionariosSel);

        // Consulta SQL de inserção
        String sqlInsercao = "INSERT INTO ordem_servico (id, id_cliente, id_servico, id_funcionario) VALUES (null, ?, ?,?)";

        try {
            Connection conexao = DriverManager.getConnection(URL, USER, PASS);

            // Cria uma declaração preparada com parâmetros
            PreparedStatement stmt = conexao.prepareStatement(sqlInsercao);
            stmt.setInt(1, nome);
            stmt.setInt(2, servicoSel);
            stmt.setInt(3, funcionariosSel);

            // Executa a inserção
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Inserção Bem-sucedida");

            } else {
                JOptionPane.showMessageDialog(null, "Inserção não foi Bem-sucedida");
            }

            /*// Fecha a conexão
            stmt.close();
            conexao.close();*/
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados no Banco de Dados");
        }
    }

}
