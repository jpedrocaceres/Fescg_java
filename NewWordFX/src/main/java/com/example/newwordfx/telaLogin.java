package com.example.newwordfx;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class telaLogin extends Application {

    private JTextField textoLogin;
    private JPasswordField campoSenha;
    private JButton logarButton;
    public Funcoes funcoes = new Funcoes();
    @Override
    public void start(Stage stage) throws Exception {

        JFrame miJFrame = new JFrame("Login Nantes Barbearia");
        miJFrame.setSize(500,300);

        // componente JPanel
        JPanel miJPanel = new JPanel();
        miJPanel.setLayout(new FlowLayout());
        miJPanel.setSize(500, 300);
        JLabel BV;

        BV = new JLabel("Bem Vindo a JNantes Barbearia!");
        BV.setBounds(100,20, 200,50);

        //componente Login
        JLabel l1 = new JLabel("Login:");
        l1.setBounds(50,200, 100,30);
        textoLogin = new JTextField();
        textoLogin.setBounds(100,200, 200,30);

        //componete de senha

        JLabel l2=new JLabel("Senha:");
        l2.setBounds(50,250, 100,30);
        campoSenha = new JPasswordField();
        campoSenha.setBounds(100,250, 200,30);


        //componente de botão
        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 150,20);
        logarButton = new JButton("Entrar");
        logarButton.setBounds(200,300,100,30);

        logarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = textoLogin.getText();
                String senha = campoSenha.getText();
                funcoes.valida_login(login, senha);
                miJFrame.dispose();
            }
        });

        // centralizar os componentes de JPanel
        miJPanel.setLayout(new GridBagLayout());



        // Conecta os componentes ao painel
        miJFrame.add(textoLogin);
        miJFrame.add(campoSenha);
        miJFrame.add(BV);
        miJFrame.add(l1); miJFrame.add(l2);

        miJFrame.setLayout(null);
        miJFrame.setVisible(true);
        miJFrame.add(logarButton);

        // conectar Jpanel a JFrame
        miJFrame.add(miJPanel);

        // hacer visible JFrame
        miJFrame.setVisible(true);
        miJFrame.setSize(400,500);
        miJFrame.setLocationRelativeTo(null);
        miJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public void tela_Menu(){
        // componente JFrame
        JFrame Frame = new JFrame("Nantes Barbearia");
        Frame.setSize(350,500);

        // componente JPanel
        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());
        painel.setSize(350, 500);
        JLabel inicial;

        inicial = new JLabel("Bem Vindo a Nantes Barbearia!");
        inicial.setBounds(80,20, 200,40);

        //Botão para chamar a tela de cadastro de barbeiro
        JButton cadastroBarbeiro = new JButton("Cadastro Funcionário");
        cadastroBarbeiro.setBounds(75,100,200,40);
        cadastroBarbeiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela_cadastro_funcionario();
                Frame.setVisible(false);
            }
        });

        JButton cadastroProduto = new JButton("Cadastro de Produto ou Serviço");
        cadastroProduto.setBounds(75,150,200,40);
        cadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tela_cadastro_servico();
                Frame.setVisible(false);
            }
        });

        JButton cadastroCliente = new JButton("Cadastro Cliente");
        cadastroCliente.setBounds(75,200,200,40);
        cadastroCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela_cadastro_cliente();
                Frame.setVisible(false);
            }
        });

        JButton servico = new JButton("Realize servico");
        servico.setBounds(75,250,200,40);
        servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tela_ordem_servico();
                Frame.setVisible(false);
            }
        });



        JButton relatorio = new JButton("Gerar relatorio");
        relatorio.setBounds(75,300,200,40);
        relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                //tela_relatorio();
            }
        });

        JButton sair = new JButton("Sair");
        sair.setBounds(75,350,200,40);
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        // centralizar os componentes de JPanel
        painel.setLayout(new GridBagLayout());

        // Conecta os componentes ao painel
        Frame.add(inicial);
        Frame.add(cadastroBarbeiro);
        Frame.add(cadastroProduto);
        Frame.add(cadastroCliente);
        Frame.add(servico);
        Frame.add(relatorio);
        Frame.add(sair);
        Frame.setLayout(null);
        Frame.setVisible(true);


        // conectar Jpanel a JFrame
        Frame.add(painel);

        // hacer visible JFrame
        Frame.setVisible(true);
        Frame.setLocationRelativeTo(null);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Isso fecha o aplicativo quando a janela é fechada

    }

    public void tela_cadastro_funcionario(){

        // componente JFrame
        JFrame miJFrame = new JFrame("Cadastro de Funcionário");
        miJFrame.setSize(400,400);

        // componente JPanel
        JPanel miJPanel = new JPanel();
        miJPanel.setLayout(new FlowLayout());
        miJPanel.setSize(400, 400);
        JLabel BV;

        BV = new JLabel("Cadastre novo Funcionário!");
        BV.setBounds(100,5, 200,50);

        //componente
        JLabel l1, l2, l3, l4, l5;
        JTextField textoNome;
        JTextField textoTelefone;
        JTextField textoLogin;
        JTextField textoSenha;
        JTextField textoPrivilegio;

        l1 = new JLabel("Nome:");
        l1.setBounds(40,50, 100,30);
        textoNome = new JTextField();
        textoNome.setBounds(100,50, 200,30);

        //componete de senha

        l2=new JLabel("Número:");
        l2.setBounds(40,100, 100,30);
        textoTelefone = new JTextField();
        textoTelefone.setBounds(100,100, 200,30);

        l3=new JLabel("Login:");
        l3.setBounds(40,150, 100,30);
        textoLogin = new JTextField();
        textoLogin.setBounds(100,150, 200,30);

        l4=new JLabel("Senha:");
        l4.setBounds(40,200, 100,30);
        textoSenha = new JPasswordField();
        textoSenha.setBounds(100,200, 200,30);

        l5=new JLabel("Privilegio:");
        l5.setBounds(40,250, 100,30);
        textoPrivilegio = new JTextField();
        textoPrivilegio.setBounds(100,250, 200,30);


        //componente de botão

        JButton button = new JButton("Efetuar cadastro");
        button.setBounds(200,300,150,30);
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String nome = textoNome.getText();
                int telefone = Integer.parseInt(textoTelefone.getText());
                String login = textoLogin.getText();
                String senha = textoSenha.getText();
                int privilegio = Integer.parseInt(textoPrivilegio.getText());


                // Chame o método inserirBarbeiro com os valores lidos dos campos
                funcoes.inserir_barbeiro(nome, telefone, login, senha, privilegio);
                miJFrame.dispose();
                tela_Menu();
            }
        });

        // centralizar os componentes de JPanel
        miJPanel.setLayout(new GridBagLayout());



        // Conecta os componentes ao painel
        miJFrame.add(BV);
        miJFrame.add(l1); miJFrame.add(l2); miJFrame.add(l3); miJFrame.add(l4); miJFrame.add(l5);
        miJFrame.add(textoNome);
        miJFrame.add(textoTelefone);
        miJFrame.add(textoLogin);
        miJFrame.add(textoSenha);
        miJFrame.add(textoPrivilegio);
        miJFrame.add(button);
        miJFrame.setLayout(null);
        miJFrame.setVisible(true);


        // conectar Jpanel a JFrame
        miJFrame.add(miJPanel);

        // fazer JFrame visivel
        miJFrame.setLocationRelativeTo(null);
        miJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    };

    public void tela_cadastro_servico(){

        // componente JFrame
        JFrame miJFrame = new JFrame("Cadastro produto ou serviço");
        miJFrame.setSize(400,250);

        // componente JPanel
        JPanel miJPanel = new JPanel();
        miJPanel.setLayout(new FlowLayout());
        miJPanel.setSize(400, 250);
        JLabel BV;

        BV = new JLabel("Cadastre novo Produto");
        BV.setBounds(100,10, 200,50);

        //componente
        JLabel l1, l2;
        JTextField textoNome;
        JTextField textoPreco;

        l1 = new JLabel("Nome:");
        l1.setBounds(50,50, 100,30);
        textoNome = new JTextField();
        textoNome.setBounds(100,50, 200,30);

        //componete de senha

        l2=new JLabel("Preço:");
        l2.setBounds(50,100, 100,30);
        textoPreco = new JTextField();
        textoPreco.setBounds(100,100, 200,30);


        //componente de botão

        JButton button = new JButton("Efetuar cadastro");
        button.setBounds(200,150,150,30);
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String nome = textoNome.getText();
                String preco = textoPreco.getText();
                float numero = 0;
                try {
                    // Tenta converter o texto em um número decimal (3,2)
                    numero = Float.parseFloat(preco.replace(',', '.')); // Substitui ',' por '.' para tornar a conversão válida
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,"O texto da label não é um número decimal válido.");
                }
                // Chame o método inserirBarbeiro com os valores lidos dos campos
                funcoes.inserirServico(nome, numero);
                miJFrame.dispose();
                tela_Menu();
            }

        });

        // centralizar os componentes de JPanel
        miJPanel.setLayout(new GridBagLayout());



        // Conecta os componentes ao painel
        miJFrame.add(BV);
        miJFrame.add(l1); miJFrame.add(l2);
        miJFrame.add(textoNome);
        miJFrame.add(textoPreco);
        miJFrame.add(button);
        miJFrame.setLayout(null);
        miJFrame.setVisible(true);


        // conectar Jpanel a JFrame
        miJFrame.add(miJPanel);

        // fazer JFrame visivel
        miJFrame.setLocationRelativeTo(null);

    };

    public void tela_cadastro_cliente(){
        // componente JFrame
        JFrame miJFrame = new JFrame("Cadastro de Cliente");
        miJFrame.setSize(400,250);

        // componente JPanel
        JPanel miJPanel = new JPanel();
        miJPanel.setLayout(new FlowLayout());
        miJPanel.setSize(400, 250);
        JLabel BV;

        BV = new JLabel("Realize novo cadastro de cliente!");
        BV.setBounds(100,5, 200,50);

        //componentes
        JLabel l1, l2;
        JTextField textoNome;
        JTextField textoTelefone;

        //Componente nome do cliente
        l1 = new JLabel("Nome do cliente:");
        l1.setBounds(40,50, 100,30);
        textoNome = new JTextField();
        textoNome.setBounds(150,50, 200,30);


        //Componente telefone do cliente
        l2=new JLabel("Número de telefone:");
        l2.setBounds(40,100, 100,30);
        textoTelefone = new JTextField();
        textoTelefone.setBounds(150,100, 200,30);


        //componente de botão

        JButton button = new JButton("Efetuar cadastro");
        button.setBounds(200,150,150,30);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String nome = textoNome.getText();
                String telefone = textoTelefone.getText();
                int numero = 0;
                try {
                    // Tenta converter o texto em um número decimal (3,2)
                    numero = Integer.valueOf(telefone); // Converte o campo capturado em String para int
                } catch (NumberFormatException e) {
                    System.err.println("O número inserido não é um número de telefone válido.");
                }
                // Chame o método inserirBarbeiro com os valores lidos dos campos
                funcoes.cadastrarCliente(nome, numero);
                miJFrame.dispose();
                tela_Menu();
            }

        });

        // centralizar os componentes de JPanel
        miJPanel.setLayout(new GridBagLayout());



        // Conecta os componentes ao painel
        miJFrame.add(BV);
        miJFrame.add(l1); miJFrame.add(l2);
        miJFrame.add(textoNome);
        miJFrame.add(textoTelefone);
        miJFrame.add(button);
        miJFrame.setLayout(null);
        miJFrame.setVisible(true);


        // conectar Jpanel a JFrame
        miJFrame.add(miJPanel);

        // fazer JFrame visivel
        miJFrame.setLocationRelativeTo(null);
    };

    public void tela_ordem_servico(){
        HashMap<String, String> funcionarios = funcoes.lista_funcionarios();
        HashMap<String, String> servico = funcoes.lista_servicos();
        String[] comboFunc = funcionarios.keySet().toArray(new String[0]);
        String[] comboServ = servico.keySet().toArray(new String[0]);

        // componente JFrame
        JFrame miJFrame = new JFrame("Ordem de serviço");
        miJFrame.setSize(400,300);

        // componente JPanel
        JPanel miJPanel = new JPanel();
        miJPanel.setLayout(new FlowLayout());
        miJPanel.setSize(400, 300);
        JLabel BV;

        BV = new JLabel("Realize novo serviço!");
        BV.setBounds(100,5, 200,50);

        //componente
        JLabel l1, l2, l3;
        JTextField textoNome;
        l1 = new JLabel("Nome do cliente:");
        l1.setBounds(40,50, 100,30);
        textoNome = new JTextField();
        textoNome.setBounds(150,50, 200,30);

        //componete serviço

        l2=new JLabel("Qual o serviço:");
        l2.setBounds(40,100, 100,30);
        final JComboBox comboBoxSev = new JComboBox(comboServ);
        comboBoxSev.setBounds(150,100, 200,30);

        //Componente berbeiro
        l3=new JLabel("Qual funcionario:");
        l3.setBounds(40,150, 100,30);
        final JComboBox comboBoxFun = new JComboBox(comboFunc);
        comboBoxFun.setBounds(150,150, 200,30);


        //componente de botão

        JButton button = new JButton("Efetuar cadastro");
        button.setBounds(200,200,150,30);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int nome = Integer.parseInt(textoNome.getText());
                String nomeSvSelecionado = (String) comboBoxSev.getItemAt(comboBoxSev.getSelectedIndex());
                int servicoSel = Integer.parseInt(servico.get(nomeSvSelecionado));
                String nomeFunSel = (String) comboBoxFun.getItemAt(comboBoxFun.getSelectedIndex());
                int funcionariosSel = Integer.parseInt(funcionarios.get(nomeFunSel));

                // Chame o método inserirBarbeiro com os valores lidos dos campos
                Funcoes.ordem_servico(nome, servicoSel, funcionariosSel);

            }
        });

        // centralizar os componentes de JPanel
        miJPanel.setLayout(new GridBagLayout());



        // Conecta os componentes ao painel
        miJFrame.add(BV);
        miJFrame.add(l1); miJFrame.add(l2); miJFrame.add(l3);
        miJFrame.add(textoNome);
        miJFrame.add(comboBoxSev);
        miJFrame.add(comboBoxFun);
        miJFrame.add(button);
        miJFrame.setLayout(null);
        miJFrame.setVisible(true);


        // conectar Jpanel a JFrame
        miJFrame.add(miJPanel);

        // fazer JFrame visivel
        miJFrame.setLocationRelativeTo(null);
    };

    public static void main(String[] args) {
        launch();
    }
}
