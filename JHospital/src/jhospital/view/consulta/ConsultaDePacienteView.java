/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConsultaDePacienteView.java
 *
 * Created on 21/01/2014, 10:15:45
 */
package jhospital.view.consulta;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import jhospital.controller.PacienteController;
import jhospital.model.Paciente;
import jhospital.view.cadastro.CadastroDePacienteView;


public class ConsultaDePacienteView extends javax.swing.JPanel {

    private JTabbedPane tabbedPane;
    
    public ConsultaDePacienteView(JTabbedPane tabbedPane1) {
        this.tabbedPane = tabbedPane1;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        menuItemApagar = new javax.swing.JMenuItem();
        menuItemEditar = new javax.swing.JMenuItem();
        labelConsultaDePaciente = new javax.swing.JLabel();
        SeparatorSuperior = new javax.swing.JSeparator();
        labelNome = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        textFieldEmail = new javax.swing.JTextField();
        buttonConsultar = new javax.swing.JButton();
        buttonFechar = new javax.swing.JButton();
        ScrollPaneResultados = new javax.swing.JScrollPane();
        tableResultados = new javax.swing.JTable();

        menuItemApagar.setText("Apagar");
        menuItemApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemApagarActionPerformed(evt);
            }
        });
        popupMenu.add(menuItemApagar);

        menuItemEditar.setText("Editar");
        menuItemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEditarActionPerformed(evt);
            }
        });
        popupMenu.add(menuItemEditar);

        labelConsultaDePaciente.setText("Consulta de Paciente");

        labelNome.setText("Nome:");

        labelEmail.setText("Email:");

        buttonConsultar.setText("Consultar");
        buttonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConsultarActionPerformed(evt);
            }
        });

        buttonFechar.setText("Fechar");
        buttonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFecharActionPerformed(evt);
            }
        });

        tableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Endereço", "Email", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableResultadosMouseClicked(evt);
            }
        });
        ScrollPaneResultados.setViewportView(tableResultados);
        tableResultados.getColumnModel().getColumn(0).setMinWidth(0);
        tableResultados.getColumnModel().getColumn(0).setPreferredWidth(0);
        tableResultados.getColumnModel().getColumn(0).setMaxWidth(0);
        tableResultados.getColumnModel().getColumn(1).setResizable(false);
        tableResultados.getColumnModel().getColumn(2).setResizable(false);
        tableResultados.getColumnModel().getColumn(3).setResizable(false);
        tableResultados.getColumnModel().getColumn(4).setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ScrollPaneResultados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(labelEmail)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(buttonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SeparatorSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                        .addComponent(labelConsultaDePaciente)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelNome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmail)
                    .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonFechar)
                    .addComponent(buttonConsultar))
                .addGap(18, 18, 18)
                .addComponent(ScrollPaneResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(labelConsultaDePaciente)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(SeparatorSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelNome)
                        .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(329, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void buttonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsultarActionPerformed
        PacienteController pc = new PacienteController();
        try {
            List<Paciente> listaDePacientes = pc.buscar(
                    textFieldNome.getText(), textFieldEmail.getText());
            DefaultTableModel model = 
                    (DefaultTableModel) tableResultados.getModel();
            for (int i = model.getRowCount() - 1; i >= 0; i--){
                model.removeRow(i);
            }
            if (listaDePacientes != null) {
                for (int i = 0; i < listaDePacientes.size(); i++) {
                    Paciente paciente = listaDePacientes.get(i);
                    String[] p = new String[] {
                        String.valueOf(paciente.getId()),
                        paciente.getNome(),
                        paciente.getEndereco(),
                        paciente.getEmail(),
                        paciente.getTelefone(),
                        String.valueOf(paciente.getNumerodoquarto())};
                    model.insertRow(i, p);
                    }
                }
                tableResultados.setModel(model);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Não foi possível consultar os pacientes!\n\n"
                    + e.getLocalizedMessage());
            }
    }//GEN-LAST:event_buttonConsultarActionPerformed

    private void buttonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFecharActionPerformed
        tabbedPane.remove(this);
        tabbedPane.validate();
        tabbedPane.repaint();
    }//GEN-LAST:event_buttonFecharActionPerformed

    private void tableResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableResultadosMouseClicked
        try {
            if (evt.getButton() == MouseEvent.BUTTON3) {
                Point p = evt.getPoint();
                int row = tableResultados.rowAtPoint(p);
                if (row >= 0 && row < tableResultados.getRowCount()) {
                    tableResultados
                            .setRowSelectionInterval(row, row);
                    popupMenu.show(evt.getComponent(),
                            evt.getX(), evt.getY());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Não foi possível abrir o popup!\n\n"
                    + e.getLocalizedMessage());
        }
    }//GEN-LAST:event_tableResultadosMouseClicked

    private void menuItemApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemApagarActionPerformed
        try {
            int row = tableResultados.getSelectedRow();
            PacienteController pc = new PacienteController();
            DefaultTableModel model = (DefaultTableModel) tableResultados
                    .getModel();
            if (JOptionPane.showConfirmDialog(this,
                    "Deseja mesmo apagar o paciente " 
                    + model.getValueAt(row, 1).toString(),
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION) ==
                    JOptionPane.YES_OPTION) {
                pc.excluir(Integer.parseInt(model.
                        getValueAt(row, 0).toString()));
                ((DefaultTableModel) tableResultados
                        .getModel()).removeRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Não foi possível apagar o paciente!\n\n"
                    + e.getLocalizedMessage());
        }
    }//GEN-LAST:event_menuItemApagarActionPerformed

    private void menuItemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEditarActionPerformed
        try {
            int row = tableResultados.getSelectedRow();
            DefaultTableModel model = 
                    (DefaultTableModel) tableResultados.getModel();
            CadastroDePacienteView cadastroDePacienteView;
            cadastroDePacienteView = new CadastroDePacienteView(
                    tabbedPane, Integer.parseInt(
                    model.getValueAt(row, 0).toString()));
            tabbedPane.add("Edição de paciente",
                    cadastroDePacienteView);
            tabbedPane.setSelectedComponent(cadastroDePacienteView);
            tabbedPane.revalidate();
            tabbedPane.repaint();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Não é possível editar o paciente!\n\n"
                    + ex.getLocalizedMessage());
        }
    }//GEN-LAST:event_menuItemEditarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPaneResultados;
    private javax.swing.JSeparator SeparatorSuperior;
    private javax.swing.JButton buttonConsultar;
    private javax.swing.JButton buttonFechar;
    private javax.swing.JLabel labelConsultaDePaciente;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNome;
    private javax.swing.JMenuItem menuItemApagar;
    private javax.swing.JMenuItem menuItemEditar;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JTable tableResultados;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldNome;
    // End of variables declaration//GEN-END:variables
}
