package view;

import dao.ProdutoDAO;
import model.Produto;
import table.ProdutoTableModel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;


public class ProdutoView extends JFrame {
	
	private JPanel contentPane;
	private ProdutoDAO dao;
	
	JFrame frame = new JFrame("AVISO");

	public ProdutoView() {
		initComponents();
		dao = new ProdutoDAO();
		tbProduto.setModel(new ProdutoTableModel(dao.listarTodos()));
		btSalvar.setText("Salvar");
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoView frame = new ProdutoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    @SuppressWarnings("unchecked")
                        
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfCodigo.setEnabled(false);
        tfDescricao = new javax.swing.JTextField();
        tfPreco = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btSalvar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dao = new ProdutoDAO();
        		
        		Produto produto = new Produto();
        		produto.setDescricao_produto(tfDescricao.getText());        		
        		
        		if (!tfDescricao.getText().isEmpty() && !tfPreco.getText().isEmpty()) {
        			
        			produto.setPreco_produto(Double.parseDouble(tfPreco.getText()));
        			
	        		if (tfCodigo.getText().isEmpty()) {        			
		        		dao.inserir(produto);
	        		} else {
	        			produto.setCodigo_produto(Integer.parseInt(tfCodigo.getText()));
	        			dao.alterar(produto);
	        		}
	        		
	        		tbProduto.setModel(new ProdutoTableModel(dao.listarTodos()));
	        		btExcluir.setEnabled(false);
	        		ClearInputs();
	        		
        		} else {
        			JOptionPane.showMessageDialog(frame,
                	        "Preencher todos os campos",
                	        "AVISO",
                	        JOptionPane.ERROR_MESSAGE);
        		}
        		        		
        	}
        });
        btExcluir = new javax.swing.JButton();
        btExcluir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dao = new ProdutoDAO();
        		
        		Produto produto = new Produto();
        		produto.setDescricao_produto(tfDescricao.getText());
        		produto.setCodigo_produto(Integer.parseInt(tfCodigo.getText()));
        		
        		dao.excluir(produto);
        		
        		tbProduto.setModel(new ProdutoTableModel(dao.listarTodos()));
        		btExcluir.setEnabled(false);
        		ClearInputs();
        	}
        });
        btExcluir.setEnabled(false);
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduto = new javax.swing.JTable();
        tbProduto.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		tfCodigo.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), ProdutoTableModel.COL_CODIGO_PRODUTO).toString());
        		tfDescricao.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), ProdutoTableModel.COL_DESCRICAO_PRODUTO).toString());
        		tfPreco.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), ProdutoTableModel.COL_PRECO_PRODUTO).toString());
        		
        		btExcluir.setEnabled(true);
        		btSalvar.setText("Atualizar");
        	}
        });


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produto");
        setResizable(false);

        jLabel1.setText("Código");

        jLabel2.setText("Descricao");

        jLabel3.setText("Preco");

        tfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoActionPerformed(evt);
            }
        });

        tfPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrecoActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");

        btExcluir.setText("Excluir");

        tbProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbProduto);
        
        JButton btLimpar = new JButton();
        btLimpar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ClearInputs();
        		btSalvar.setText("Salvar");
        		btExcluir.setEnabled(false);
        	}
        });
        btLimpar.setText("Limpar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap(21, Short.MAX_VALUE)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel1)
        								.addComponent(jLabel3))
        							.addGap(23))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel2)
        							.addPreferredGap(ComponentPlacement.UNRELATED)))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(tfPreco, 923, 923, 923)
        						.addComponent(tfCodigo, Alignment.TRAILING, 923, 923, 923)
        						.addComponent(tfDescricao, 923, 923, 923)))
        				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        					.addGap(187)
        					.addComponent(btLimpar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
        					.addGap(172)
        					.addComponent(btExcluir, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
        					.addComponent(btSalvar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        					.addGap(148)))
        			.addGap(56))
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 966, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(tfDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(24)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel3)
        				.addComponent(tfPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(36)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btLimpar)
        				.addComponent(btExcluir)
        				.addComponent(btSalvar))
        			.addGap(56)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(25, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>                        

    private void tfCodigoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void tfPrecoActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }        
    
    private void ClearInputs() {
    	tfCodigo.setText("");
		tfDescricao.setText("");
		tfPreco.setText("");
    }


    // Variables declaration - do not modify                     
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProduto;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfPreco;
}