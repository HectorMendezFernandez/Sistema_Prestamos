package vista;

import Modelo.RoundedBorder;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

public class VistaClientes extends JFrame { //ventana principal donde se agregaran y busc

    //atributos
    Image imagen;

    JLabel jLabelNombre,  jLabelId, jLabelProvincia, jLabelCanton, jLabelDistrito, jLabelImagen;
    JTextField jTextFProvincia, jTextFNombre, jTextFId;
    JComboBox jComboCanton, jComboDistrito;
    JButton btnBuscar, btnGuardar, btnPrestamo, btnReporteCli, btnReportePres;

    public VistaClientes(){

        setVisible(true);

        setTitle("Ventana Clientes");

        setBounds(100, 25, 950, 730);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        try {
            imagen = ImageIO.read(new File("src/imagenes/Provincias (2).png")); //recibe un objeto de tipo File (es necesario colocar un try)
        }
        catch(IOException e) {
            System.out.println("La imagen no se encuentra");
        }

        this.addBackground();
        this.instantiateComponents();
        this.addComponents();
        this.addCommits();
    }

    public void addCommits(){
        btnBuscar.setActionCommand("1");
        btnGuardar.setActionCommand("2");
        btnPrestamo.setActionCommand("3");
        btnReporteCli.setActionCommand("8");
        btnReportePres.setActionCommand("9");
    }

    public void addBackground(){
        try{
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("src/imagenes/FondoBanco2.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        }catch (IOException ex){
            JOptionPane.showMessageDialog(this,ex.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    void formatoPanel(){ //establece el formato del panel y verifica la existencia de la imagen
        this.getContentPane().setLayout(null);
    }

    void addComponents(){
       this.formatoPanel();
       //Colocamos la imagen en el panel
        jLabelImagen.setBounds(30,250,400,400);
        this.add(jLabelImagen);
        //Colocamos los labels
        jLabelNombre.setBounds(30, 20, 100, 25);
        this.add(jLabelNombre);
        jLabelId.setBounds(30,100,50,20);
        this.add(jLabelId);
        jLabelProvincia.setBounds(460,250,90,25);
        this.add(jLabelProvincia);
        jLabelCanton.setBounds(460, 400,100,25);
        this.add(jLabelCanton);
        jLabelDistrito.setBounds(460,550,100,25);
        this.add(jLabelDistrito);

        //Colocamos los JtextField
        jTextFNombre.setBounds(30,50,200,23);
        this.add(jTextFNombre);
        jTextFId.setBounds(30,130,200,23);
        this.add(jTextFId);
        jTextFProvincia.setBounds(550, 250,120,25);
        this.add(jTextFProvincia);

        //Colocamos los comboBox
        jComboCanton.setBounds(545,400,125,25);
        this.add(jComboCanton);
        jComboDistrito.setBounds(545,550,120,25);
        this.add(jComboDistrito);

        //Colocamos el boton
        btnBuscar.setBounds(300,45,135,35);
        //btnBuscar.setBorder(new RoundedBorder(30));
        this.add(btnBuscar);
        btnGuardar.setBounds(300,120,135,35);
        this.add(btnGuardar);
        btnPrestamo.setBounds(760, 30, 120,125);
        this.add(btnPrestamo);

        btnReporteCli.setBounds(760, 175, 150, 30);
        this.add(btnReporteCli);

        btnReportePres.setBounds(760, 215, 150, 30);
        this.add(btnReportePres);
    }

    void instantiateComponents(){ //Me instanciaa los componentes
        Font font = new Font("Rockwell",Font.BOLD,16);
        Font text = new Font("Rockwell",Font.BOLD,10);
        Color col = new Color(35, 34, 34);

        jLabelImagen = new JLabel(new ImageIcon(imagen));
        jLabelImagen.setBorder(new RoundedBorder(1));
        jLabelNombre = new JLabel("Nombre");
        jLabelNombre.setFont(font);
        jLabelId= new JLabel("ID");
        jLabelId .setFont(font);
        jLabelProvincia= new JLabel("Provincia:");
        jLabelProvincia.setFont(font);
        jLabelCanton= new JLabel("Canton:");
        jLabelCanton.setFont(font);
        jLabelDistrito= new JLabel("Distrito:");
        jLabelDistrito.setFont(font);

        jTextFProvincia = new JTextField(50);
        jTextFProvincia.setEnabled(false);
        jTextFProvincia.setForeground(Color.red);
        jTextFProvincia.setBackground(col);
        jTextFProvincia.setToolTipText("Provincia de residencia");

        jTextFNombre = new JTextField(50);
        jTextFNombre.setToolTipText("Ingresar nombre de la persona");

        jTextFId = new JTextField(30);
        jTextFId.setToolTipText("Ingresar ID de la persona");

        jComboCanton = new JComboBox();
        jComboDistrito = new JComboBox();


        btnBuscar = new JButton();
        btnBuscar.setBorder(new RoundedBorder(26));
        btnBuscar.setText("search");
        btnBuscar.setIcon(new ImageIcon("src/imagenes/buscar (1).png"));
        btnBuscar.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnBuscar.setVerticalTextPosition(SwingConstants.CENTER);
        btnBuscar.setToolTipText("Boton para buscar cliente");

        btnGuardar = new JButton();
        btnGuardar.setBorder(new RoundedBorder(26));
        btnGuardar.setText("save");
        btnGuardar.setIcon(new ImageIcon("src/imagenes/guardar-el-archivo (3).png"));
        btnGuardar.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnGuardar.setVerticalTextPosition(SwingConstants.CENTER);
        btnGuardar.setToolTipText("Boton para registrar nuevo cliente");

        btnPrestamo =new JButton();
        btnPrestamo.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED));
        btnPrestamo.setText("Prestamo");
        btnPrestamo.setIcon(new ImageIcon("src/imagenes/prestamo-a-valor (1).png"));
        btnPrestamo.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPrestamo.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnPrestamo.setToolTipText("Boton para realizar y ver prestamos del cliente");

        btnReporteCli = new JButton("generar pdf clientes");
        btnReporteCli.setToolTipText("Generara un archivo pdf de los clientes");
        btnReporteCli.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED));

        btnReportePres = new JButton("generar pdf prestamos");
        btnReportePres.setToolTipText("Generara un archivo pdf de los prestamos");
        btnReportePres.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    public void addListeners(ActionListener ac){
        btnBuscar.addActionListener(ac);
        btnPrestamo.addActionListener(ac);
        btnGuardar.addActionListener(ac);
        btnReporteCli.addActionListener(ac);
        btnReportePres.addActionListener(ac);
    }

    public void addMouseMotionListeners(MouseMotionListener mtl){
        jLabelImagen.addMouseMotionListener(mtl);
    }
    public void addMouseListeners(MouseListener ml){
        jLabelImagen.addMouseListener(ml);
    }

    public JTextField getjTextFProvincia() {
        return jTextFProvincia;
    }

    public JTextField getjTextFNombre() {
        return jTextFNombre;
    }

    public JTextField getjTextFId() {
        return jTextFId;
    }

    public JLabel getjLabelImagen() {
        return jLabelImagen;
    }

    public JComboBox getjComboCanton() {
        return jComboCanton;
    }

    public JComboBox getjComboDistrito() {
        return jComboDistrito;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnPrestamo() {
        return btnPrestamo;
    }

    public void setjTextFProvincia(JTextField jTextFProvincia) {
        this.jTextFProvincia = jTextFProvincia;
    }

    public void setjTextFNombre(JTextField jTextFNombre) {
        this.jTextFNombre = jTextFNombre;
    }

    public void setjTextFId(JTextField jTextFId) {
        this.jTextFId = jTextFId;
    }

    public void setjComboCanton(JComboBox jComboCanton) {
        this.jComboCanton = jComboCanton;
    }

    public void setjComboDistrito(JComboBox jComboDistrito) {
        this.jComboDistrito = jComboDistrito;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public void setBtnPrestamo(JButton btnPrestamo) {
        this.btnPrestamo = btnPrestamo;
    }

    public void colocarDistritoComboBox(String distrito){
        int index =0;
        for(int i = 0; i< jComboDistrito.getItemCount();i++){
            if(distrito.equals((String)jComboDistrito.getItemAt(i)) == true){
                jComboDistrito.setSelectedIndex(i);
            }
        }
    }

    public void colocarCantonComboBox(String canton){
        int index =0;
        for(int i = 0; i< jComboCanton.getItemCount();i++){
            if(canton.equals((String)jComboCanton.getItemAt(i)) == true){
                jComboCanton.setSelectedIndex(i);
            }
        }
    }
}
