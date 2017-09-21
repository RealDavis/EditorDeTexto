package gui;

import java.io.IOException;
import javax.swing.*;
import util.ManipulaArquivoTxt;

public class JanelaPrincipal extends JFrame {

    private JMenuBar barraMenu;
    private JMenu mnArquivo;
    private JMenuItem miNovo;
    private JMenuItem miAbrir;
    private JMenuItem miSalvar;
    private JMenuItem miSair;
    private JScrollPane barraDeRolagem;
    private JTextArea taTexto;

    public JanelaPrincipal() {
        super("Editor de texto Java");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        barraMenu = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        miNovo = new JMenuItem("Novo");
        miAbrir = new JMenuItem("Abrir");
        miSalvar = new JMenuItem("Salvar");
        miSair = new JMenuItem("Sair");
        taTexto = new JTextArea();
        barraDeRolagem = new JScrollPane(taTexto, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        

        mnArquivo.add(miNovo);
        mnArquivo.add(miAbrir);
        mnArquivo.add(miSalvar);
        mnArquivo.addSeparator();
        mnArquivo.add(miSair);

        barraMenu.add(mnArquivo);

        this.setJMenuBar(barraMenu);
  
        this.getContentPane().add(barraDeRolagem);

        //Incio dos métodos que chamam outros métodos responsáveis pelas ações dos menus
        miNovo.addActionListener((java.awt.event.ActionEvent e) -> {
            miNovorOnClick();
        });

        miAbrir.addActionListener((java.awt.event.ActionEvent e) -> {
            miAbrirOnClick();
        });

        miSalvar.addActionListener((java.awt.event.ActionEvent e) -> {
            miSalvarOnClick();
        });

        miSair.addActionListener((java.awt.event.ActionEvent e) -> {
            miSairOnClick();
        });
        //Fim dos métodos

        this.setSize(640, 480);
        this.setVisible(true);

    }

    public static void main(String[] args) {

        new JanelaPrincipal();

    }

    /**
     *
     */
    private void miNovorOnClick() {
        taTexto.setText("");
    }

    /**
     *
     */
    private void miAbrirOnClick() {
        try {
            JFileChooser arquivo = new JFileChooser();
            int retorno = arquivo.showOpenDialog(null);

            if (retorno == JFileChooser.APPROVE_OPTION) {
                String nomeArquivo = arquivo.getSelectedFile().getAbsolutePath();
                String retorno2 = ManipulaArquivoTxt.lerArquivoTxt(nomeArquivo);

                taTexto.setText(retorno2);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", 1);
        }
    }

    /**
     *
     */
    private void miSalvarOnClick() {
        try {
            JFileChooser arquivo = new JFileChooser();
            int retorno = arquivo.showSaveDialog(null);

            if (retorno == JFileChooser.APPROVE_OPTION) {
                String nomeArquivo = arquivo.getSelectedFile().getAbsolutePath();
                String conteudo = taTexto.getText();

                boolean retorno2 = ManipulaArquivoTxt.gravarArquivoTexto(nomeArquivo, conteudo);

                if (retorno2 == true) {
                    JOptionPane.showMessageDialog(this, "Arquivo salvo", "Concluído", 1);
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", 1);
        }
    }

    private void miSairOnClick() {
        System.exit(0);
    }

}
