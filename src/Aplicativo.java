import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class Aplicativo {
    public static class MainWindow extends JFrame {

        public MainWindow(String title) {
            super(title);
            Components.Buttons button = new Components.Buttons("Login");
            Components.Buttons button2 = new Components.Buttons("Cadastro");
            Components.Labels label = new Components.Labels("Bem-vindo ao Tonhão Delivery");
            this.setSize(600, 600);
            getContentPane().setBackground(new Color(50, 50, 50));

            label.setSize(300, 100);
            label.setLocation(150, 100);
            button.setLocation(250, 400);
            button2.setLocation(250, 475);

            this.setLayout(null);
            this.add(button);
            this.add(button2);
            this.add(label);

            button.addActionListener(e -> {
                Components.Cadastro cad = new Components.Cadastro();
                Login janela = new Login("Login", null, null, null);
                this.setVisible(false);
                janela.setVisible(true);
            });
            button2.addActionListener(e -> {
                Cadastro janela = new Cadastro("Cadastro");
                this.setVisible(false);
                janela.setVisible(true);

            });

        }
    }

    public static class Login extends JFrame {
        public Login(String title, ArrayList<String> nome, ArrayList<String> cpf, ArrayList<String> endereco) {
            super(title);
            Components.Cadastro cad = new Components.Cadastro();
            ;
            this.setSize(600, 600);
            getContentPane().setBackground(new Color(50, 50, 50));
            this.setLayout(null);
//          -----------------------------------------------------------------------

//          Componentes
            Components.TextFiled text = new Components.TextFiled();
            Components.TextFiled text2 = new Components.TextFiled();
            Components.Labels label = new Components.Labels("Login");
            Components.Labels label2 = new Components.Labels("cpf");
            Components.Labels label3 = new Components.Labels("nome");
            Components.Password password = new Components.Password();
            Components.Buttons button = new Components.Buttons("enviar");
//          -----------------------------------------------------------------------

//          Propriedades dos componentes
            label.setLocation(250, 10);
            label2.setLocation(100, 230);
            label3.setLocation(100, 130);
            label.setSize(100, 100);
            label2.setSize(100, 100);
            label3.setSize(100, 100);
            text.setLocation(100, 300);
            text2.setLocation(100, 200);
            password.setLocation(100, 400);
            button.setLocation(200, 400);

            button.addActionListener(e -> {
                int n = nome.size();
                for (int i = 0; i < n; i++) {
                    if (nome.get(i).equals(text.getText()) && cpf.get(i).equals(text2.getText())) {
                        System.out.println("autenticado");
                        Home tela = new Home("Home", null, null, null);
                        this.setVisible(false);
                        tela.setVisible(true);
                    } else {
                        System.out.println("não-autorizado");
                        Components.Labels label4 = new Components.Labels("Cpf ou nome inválido!");
                        this.add(label4);
                        label4.setLocation(170, 400);
                        label4.setSize(200, 200);
                        label4.setFont(new Font("Arial", Font.BOLD, 17));
                        label4.setForeground(Color.RED);
                    }
                }


            });
//          -------------------------------------------------------------------------

//          adicionando os componentes na tela
            this.add(text);
            this.add(text2);
            this.add(label);
            this.add(label2);
            this.add(button);
            this.add(label3);

//          --------------------------------------------------------------------------

        }
    }

    public static class Cadastro extends JFrame {

        public Cadastro(String title) {

//          Tela
            super(title);
            this.setSize(600, 600);
            getContentPane().setBackground(new Color(50, 50, 50));
            this.setLayout(null);
//          -----------------------------------------------------------------------

//          Componentes
            Components.TextFiled text = new Components.TextFiled();
            Components.TextFiled text2 = new Components.TextFiled();
            Components.TextFiled text3 = new Components.TextFiled();
            Components.Labels label = new Components.Labels("Cadastro");
            Components.Labels label2 = new Components.Labels("cpf");
            Components.Labels label3 = new Components.Labels("nome");
            Components.Labels label5 = new Components.Labels("Endereço(x,y)");
            Components.Password password = new Components.Password();
            Components.Buttons button = new Components.Buttons("enviar");

//          -----------------------------------------------------------------------

//          Propriedades dos componentes
            label.setLocation(250, 10);
            label2.setLocation(100, 220);
            label3.setLocation(100, 320);
            label5.setLocation(100, 120);

            label.setSize(100, 100);
            label2.setSize(100, 100);
            label3.setSize(100, 100);
            label5.setSize(200, 100);

            text.setLocation(100, 400);
            text2.setLocation(100, 300);
            text3.setLocation(100, 200);

            password.setLocation(100, 400);
            button.setLocation(200, 500);

            button.addActionListener(e -> {
                Components.Cadastro cad = new Components.Cadastro();
                if (text.getText().isEmpty() || text2.getText().isEmpty() || text3.getText().isEmpty()) {
                    System.out.println("Preencha os Campos");
                } else {
                    cad.setEndereco(text3.getText());
                    cad.setCpf(text2.getText());
                    cad.setNome(text.getText());
                    Login tela = new Login("Login", cad.getNome(), cad.getCpf(), cad.getEndereco());
                    this.setVisible(false);
                    tela.setVisible(true);
                }

            });
//          -------------------------------------------------------------------------

//          adicionando os componentes na tela
            this.add(text);
            this.add(text2);
            this.add(label);
            this.add(label2);
            this.add(button);
            this.add(label3);
            this.add(text3);
            this.add(label5);
//          --------------------------------------------------------------------------


        }

    }

    public static class Home extends JFrame {

        Home(String title, ArrayList<String>nome, ArrayList<String> cnpj, ArrayList<String> endereco) {
            super(title);
            getContentPane().setBackground(new Color(50, 50, 50));
            this.setSize(1200, 1200);
            this.setLayout(null);

            Components.Labels label = new Components.Labels("Restaurantes");
            Components.Labels label5 = new Components.Labels("Nome");
            Components.Labels label6 = new Components.Labels("Cnpj");
            Components.Labels label7 = new Components.Labels("Endereço");
            Components.Buttons button = new Components.Buttons("Cadastrar Restaurantes");


            label.setLocation(500, 20);
            label.setSize(200, 200);
            label5.setLocation(100, 300);
            label5.setSize(200, 200);
            label6.setLocation(400, 300);
            label6.setSize(200, 200);
            label7.setLocation(700, 300);
            label7.setSize(200, 200);
            button.setSize(300, 50);
            button.setLocation(400, 200);

            this.add(button);
            this.add(label);
            this.add(label5);
            this.add(label6);
            this.add(label7);

            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent e) {
                    int n = nome.size();
                    System.out.println(nome);
                    System.out.println(n);
                    if(n > 0) {
                        for (int i = 0; i < n; i++) {
                            int y = 0;
                            Components.Labels label2 = new Components.Labels("");
                            Components.Labels label3 = new Components.Labels("");
                            Components.Labels label4 = new Components.Labels("");
                            Components.Buttons button2 = new Components.Buttons("ver cardapio");
                            label2.setText(nome.get(i));
                            label3.setText(cnpj.get(i));
                            label4.setText(endereco.get(i));
                            System.out.println(label2.getText());
                            System.out.println("caiu no for");
                            label2.setSize(100, 100);
                            label2.setLocation(100, y+400);
                            label2.setForeground(Color.red);
                            label3.setSize(100, 100);
                            label3.setLocation(400, y+400);
                            label3.setForeground(Color.red);
                            label4.setSize(100, 100);
                            label4.setLocation(700, y+400);
                            label4.setForeground(Color.red);
                            button2.setLocation(1000, y+420);
                            Home.super.add(label2);
                            Home.super.add(label3);
                            Home.super.add(label4);
                            Home.super.add(button2);
                        }
                    }
                    System.out.println("saiu do for");

                    super.windowOpened(e);
                }
            });
            button.addActionListener(e -> {

                FormRest tela = new FormRest("Cadastrar Restaurante");
                this.setVisible(false);
                tela.setVisible(true);



            });


        }

    }

    public static class FormRest extends JFrame {
        FormRest(String title) {
            super(title);
            this.setSize(600, 600);
            getContentPane().setBackground(new Color(50, 50, 50));
            this.setLayout(null);
//          -----------------------------------------------------------------------

//          Componentes
            Components.TextFiled text = new Components.TextFiled();
            Components.TextFiled text2 = new Components.TextFiled();
            Components.TextFiled text3 = new Components.TextFiled();
            Components.Labels label = new Components.Labels("Cadastro");
            Components.Labels label2 = new Components.Labels("CNPJ");
            Components.Labels label3 = new Components.Labels("Nome");
            Components.Labels label5 = new Components.Labels("Endereço(x,y)");
            Components.Password password = new Components.Password();
            Components.Buttons button = new Components.Buttons("enviar");

//          -----------------------------------------------------------------------

//          Propriedades dos componentes
            label.setLocation(250, 10);
            label2.setLocation(100, 220);
            label3.setLocation(100, 320);
            label5.setLocation(100, 120);

            label.setSize(100, 100);
            label2.setSize(100, 100);
            label3.setSize(100, 100);
            label5.setSize(200, 100);

            text.setLocation(100, 400);
            text2.setLocation(100, 300);
            text3.setLocation(100, 200);

            password.setLocation(100, 400);
            button.setLocation(200, 500);

            this.add(label);
            this.add(label2);
            this.add(label3);
            this.add(label5);
            this.add(text);
            this.add(text2);
            this.add(text3);
            this.add(button);

            button.addActionListener(e -> {
                Components.CadastrarRes cad = new Components.CadastrarRes();
                if (text.getText().isEmpty() || text2.getText().isEmpty() || text3.getText().isEmpty()) {
                    System.out.println("Preencha os Campos");
                }
                else {
                    cad.setCnpj(text2.getText());
                    cad.setNome(text.getText());
                    cad.setEndereco(text3.getText());
                    Home tela = new Home("Home",cad.getNome(),cad.getCnpj(),cad.getEndereco());
                    this.setVisible(false);
                    tela.setVisible(true);
                }

            });
        }
    }
}