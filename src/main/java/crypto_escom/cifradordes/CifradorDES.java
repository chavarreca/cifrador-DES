package crypto_escom.cifradordes;

import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CifradorDES extends javax.swing.JFrame {

    String nombreArchivo = "";
    byte[] imagen;
    
    public CifradorDES() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jrb_grupo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        abrirArchivo = new javax.swing.JButton();
        cifrar = new javax.swing.JButton();
        jrb_ECB = new javax.swing.JRadioButton();
        jrb_CBC = new javax.swing.JRadioButton();
        jrb_CFB = new javax.swing.JRadioButton();
        jrb_OFB = new javax.swing.JRadioButton();
        decifrar = new javax.swing.JButton();
        txt_salida = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        llaveEntrada = new javax.swing.JTextField();
        ivEntrada = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cifrador DES");

        jLabel2.setText("Seleccione su archivo: ");

        abrirArchivo.setText("Abrir Archivo");
        abrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirArchivoActionPerformed(evt);
            }
        });

        cifrar.setText("Cifrar");
        cifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cifrarActionPerformed(evt);
            }
        });

        jrb_ECB.setText("ECB");

        jrb_CBC.setText("CBC");
        jrb_CBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_CBCActionPerformed(evt);
            }
        });

        jrb_CFB.setText("CFB");

        jrb_OFB.setText("OFB");

        decifrar.setText("Decifrar");
        decifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decifrarActionPerformed(evt);
            }
        });

        txt_salida.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Llave:");

        jLabel4.setText("IV:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(34, 34, 34)
                                .addComponent(abrirArchivo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(llaveEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(ivEntrada)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jrb_ECB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jrb_CBC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jrb_CFB)
                                        .addGap(18, 18, 18)
                                        .addComponent(jrb_OFB))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_salida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cifrar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                            .addComponent(decifrar)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(abrirArchivo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(llaveEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ivEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_ECB)
                    .addComponent(jrb_CBC)
                    .addComponent(jrb_CFB)
                    .addComponent(jrb_OFB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cifrar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(decifrar))
                .addGap(18, 18, 18)
                .addComponent(txt_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArchivoActionPerformed
        try{
            JFileChooser archivo = new JFileChooser();
            archivo.showOpenDialog(this);
            nombreArchivo = archivo.getSelectedFile().getName().substring(0,archivo.getSelectedFile().getName().length()-4);
            imagen = cargarImagen.obtenImagen(archivo.getSelectedFile().toPath().toString());
            txt_salida.setText("Archivo Seleccionado: " + nombreArchivo);
        }
        catch(IOException ina){
            System.out.println(ina);
        }
    }//GEN-LAST:event_abrirArchivoActionPerformed

    private void jrb_CBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_CBCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_CBCActionPerformed

    private void cifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cifrarActionPerformed
        if(llaveEntrada.getText().isEmpty() || ivEntrada.getText().isEmpty() || imagen.length == 0)
            JOptionPane.showMessageDialog(null,"Rellene todos los campos");
        else
            try{
               DES des = new DES(modo());
               des.cifrar(llaveEntrada.getText(), ivEntrada.getText(), imagen, nombreArchivo);
               txt_salida.setText("Cifrado Exitoso en modo " + modo() + " ^w^");
               String key = llaveEntrada.getText();
                String iv = ivEntrada.getText();
                System.out.println("Llave: " + key + "\niv: " + iv);
            }
            catch(Exception ina){
                txt_salida.setText("Ha ocurrido un error :c");
                System.out.println(ina);
            }
    }//GEN-LAST:event_cifrarActionPerformed

    private void decifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decifrarActionPerformed
        if(llaveEntrada.getText().isEmpty() || ivEntrada.getText().isEmpty() || imagen.length == 0)
            JOptionPane.showMessageDialog(null,"Rellene todos los campos");
        else
            try{
               DES des = new DES(modo());
               des.decifrar(llaveEntrada.getText(), ivEntrada.getText(), imagen, nombreArchivo);
               txt_salida.setText("Decfrado Exitoso en modo " + modo() + " ^w^");
            }
            catch(Exception ina){
                txt_salida.setText("Ha ocurrido un error :c");
                System.out.println(ina);
                String key = llaveEntrada.getText();
                String iv = ivEntrada.getText();
                System.out.println("Llave: " + key + "\niv: " + iv + "\nimagen" +imagen.toString());
            }
    }//GEN-LAST:event_decifrarActionPerformed
    
    public String modo(){
        jrb_grupo.add(jrb_ECB);
        jrb_grupo.add(jrb_CBC);
        jrb_grupo.add(jrb_CFB);
        jrb_grupo.add(jrb_OFB);
        
        String modo = "";
        
        if(jrb_ECB.isSelected()){
            modo = "ECB";
        }
        else if(jrb_CBC.isSelected()){
            modo = "CBC";
        }
        else if(jrb_CFB.isSelected()){
            modo = "CFB";
        }
        else if(jrb_OFB.isSelected()){
            modo = "OFB";
        }
        else {
            txt_salida.setText("Seleccione un modo");
        }
        
        return modo;
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CifradorDES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirArchivo;
    private javax.swing.JButton cifrar;
    private javax.swing.JButton decifrar;
    private javax.swing.JTextField ivEntrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jrb_CBC;
    private javax.swing.JRadioButton jrb_CFB;
    private javax.swing.JRadioButton jrb_ECB;
    private javax.swing.JRadioButton jrb_OFB;
    private javax.swing.ButtonGroup jrb_grupo;
    private javax.swing.JTextField llaveEntrada;
    private javax.swing.JLabel txt_salida;
    // End of variables declaration//GEN-END:variables
}
