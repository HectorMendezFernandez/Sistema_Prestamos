package vista;

import Modelo.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class VistaPrestamos extends JFrame{

    JPanel panelSuperior = new JPanel();
    JPanel panelInferior = new JPanel();
    JTable jTableprestamos, jTableCuotas; //tablas que mostraran los prestamos y los pagos de cadaa prestamo
    JButton btnPago, btnPrestamo, btnRegreso, btnPagoAutomatico, btnReporteCli, btnReportePres;
    JTextField jTextFMonto, numeroCuota, jTextFIdPre, jTextFPlazo, jTextFInteres, jTextFPago;
    JLabel jLabelPrestamoCliente, jLabelMonto,jLabelInteres,jLabelidPre, jLabelPlazo, jLabelMontoPago;
    JLabel jLabelIDPersona, jLabelNombrePersona, jLabelProvinciaPersona, jLabelCantonPersona,  jLabelDistritoPersona, jLabelDatosPersona;
    JLabel jLabelIDPrestamo, jLabelMontoPrestamo, jLabelCuotaPrestamo, jLabelPlazoPrestamo,  jLabelInteresPrestamo, jLabelEstadoPrestamo, jLabelDatosPrestamo;

    public VistaPrestamos(){

        setVisible(false);

        setTitle("Prestamos clientes");

        setBounds(100, 25, 950, 730);

        setDefaultCloseOperation(0);

       // setResizable(false);

        this.instantiateComponents();
        this.addComponents();
        this.actionCommands();
    }

    public void instantiateComponents(){
        String t = "      ";
        btnPago = new JButton("Agregar Pago");
        jTableprestamos = new JTable();
        jTableCuotas = new JTable();

        jLabelPrestamoCliente = new JLabel("Prestamos del cliente");
        jLabelidPre = new JLabel(t+"ID");
        jLabelInteres =new JLabel(t+"Interes");
        jLabelMonto = new JLabel("Monto");
        jLabelPlazo = new JLabel(t+"Plazo");
        jLabelMontoPago = new JLabel("Monto de cuota");

        Font font1 = new Font("Arial",Font.PLAIN,9);
        jLabelDatosPersona = new JLabel("-DATOS DEL CLIENTE-");
        jLabelDatosPersona.setFont(new Font("Arial",Font.BOLD,10));
        jLabelIDPersona = new JLabel("ID persona");
        jLabelIDPersona.setFont(font1);
        jLabelNombrePersona =new JLabel("Nombre persona");
        jLabelNombrePersona.setFont(font1);
        jLabelProvinciaPersona = new JLabel("Pronvincia Persona");
        jLabelProvinciaPersona.setFont(font1);
        jLabelDistritoPersona = new JLabel("Distrito Persona");
        jLabelDistritoPersona.setFont(font1);
        jLabelCantonPersona = new JLabel("Canton Persona");
        jLabelCantonPersona.setFont(font1);

        jLabelDatosPrestamo = new JLabel("-DATOS DEL PRESTAMO");
        jLabelDatosPrestamo.setFont(new Font("Arial",Font.BOLD,10));
        jLabelIDPrestamo = new JLabel();
        jLabelIDPrestamo.setFont(font1);
        jLabelMontoPrestamo= new JLabel();
        jLabelMontoPrestamo.setFont(font1);
        jLabelCuotaPrestamo= new JLabel();
        jLabelCuotaPrestamo.setFont(font1);
        jLabelPlazoPrestamo= new JLabel();
        jLabelPlazoPrestamo.setFont(font1);
        jLabelInteresPrestamo= new JLabel();
        jLabelInteresPrestamo.setFont(font1);
        jLabelEstadoPrestamo= new JLabel();
        jLabelEstadoPrestamo.setFont(font1);

        jTextFMonto = new JTextField(8);
        numeroCuota= new JTextField(8);
        jTextFIdPre= new JTextField(8);
        jTextFPlazo= new JTextField(8);
        jTextFInteres = new JTextField(8);
        jTextFPago = new JTextField(8);

        btnPrestamo = new JButton("add prestamo");
        btnPrestamo.setPreferredSize(new Dimension(100,30));
        btnPrestamo.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED));

        btnPago =new JButton("add nuevo pago");
        btnRegreso = new JButton();
        btnRegreso.setPreferredSize(new Dimension(45,30));
        btnRegreso.setIcon(new ImageIcon("src/imagenes/regreso.png"));
        btnRegreso.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED));

        btnPagoAutomatico = new JButton("Pago automatico");
    }

    public void addComponents(){
        this.getContentPane().setLayout(new GridLayout(2,0));
        JPanel norte = new JPanel(new BorderLayout());
        JPanel sur = new JPanel(new BorderLayout());
        //Agregamos en la parte superior
        JPanel subNorte = new JPanel(new BorderLayout());
        JPanel subsubNorte= new JPanel();
        JPanel tituloSuperior = new JPanel();
        tituloSuperior.setBackground(new Color(38, 236, 18, 176));
        //agregando panel que tendra la info de personas
        JPanel infoPer = new JPanel(new GridLayout(7,1));
        JPanel blanco = new JPanel();
        blanco.setBackground(Color.white);
        infoPer.add(jLabelDatosPersona);
        infoPer.add(jLabelNombrePersona);
        infoPer.add(jLabelIDPersona);
        infoPer.add(jLabelProvinciaPersona);
        infoPer.add(jLabelCantonPersona);
        infoPer.add(jLabelDistritoPersona);
        infoPer.add(blanco);

        infoPer.setBackground(new Color(133, 255, 59, 255));
        //
        tituloSuperior.add(new JLabel("Prestamos del cliente"));

        subsubNorte.add(jLabelMonto,BorderLayout.CENTER);
        subsubNorte.add(jTextFMonto,BorderLayout.CENTER);

        subsubNorte.add(jLabelInteres,BorderLayout.CENTER);
        subsubNorte.add(jTextFInteres,BorderLayout.CENTER);

        subsubNorte.add(jLabelPlazo,BorderLayout.CENTER);
        subsubNorte.add(jTextFPlazo,BorderLayout.CENTER);

        subsubNorte.add(jLabelidPre,BorderLayout.CENTER);
        subsubNorte.add(jTextFIdPre,BorderLayout.CENTER);

        JPanel panelBotonPr =new JPanel();
        panelBotonPr.add(btnPrestamo);
        subNorte.add(panelBotonPr, BorderLayout.EAST);
        subNorte.add(tituloSuperior, BorderLayout.NORTH);
        subNorte.add(subsubNorte,BorderLayout.CENTER);
        JPanel panelBotonRegr =new JPanel();
        panelBotonRegr.add(btnRegreso);
        subNorte.add(panelBotonRegr,BorderLayout.WEST);

        norte.add(subNorte, BorderLayout.NORTH);
        norte.add(panelSuperior,BorderLayout.CENTER);
        norte.add(infoPer, BorderLayout.WEST);

        //agregamos a la parte inferior
        JPanel tituloInferior = new JPanel();
        tituloInferior.setBackground(new Color(38, 236, 18, 176));
        JPanel subsubSur= new JPanel();
        tituloInferior.add(new JLabel("Cuotas del prestamo seleccionado"));
        JPanel subSur = new JPanel(new BorderLayout());

        JPanel infoPres= new JPanel(new GridLayout(8,1));
        JPanel blanco2 = new JPanel();
        blanco2.setBackground(Color.white);
        infoPres.setBackground(new Color(133, 255, 59, 255));
        infoPres.add(jLabelDatosPrestamo);
        infoPres.add(jLabelIDPrestamo);
        infoPres.add(jLabelMontoPrestamo);
        infoPres.add(jLabelInteresPrestamo);
        infoPres.add(jLabelCuotaPrestamo);
        infoPres.add(jLabelPlazoPrestamo);
        infoPres.add(jLabelEstadoPrestamo);
        infoPres.add(blanco2);

        subsubSur.add(jLabelMontoPago);
        subsubSur.add(jTextFPago);
        subsubSur.add(btnPago);
       // subsubSur.add(btnPago);
        subSur.add(btnPagoAutomatico, BorderLayout.EAST);
        subSur.add(subsubSur, BorderLayout.CENTER);
        subSur.add(tituloInferior, BorderLayout.NORTH);
      //  subSur

        sur.add(subSur, BorderLayout.NORTH);
        sur.add(panelInferior,BorderLayout.CENTER);
        sur.add(infoPres,BorderLayout.WEST);

        //agregamos al panel principal
        this.getContentPane().add(norte);
        this.getContentPane().add(sur);
    }


    public void agregarTablaPrestamos(JScrollPane sp){ //este metodo me quita la tabla actual y coloca la nueva en el scrollPanel
        if(panelSuperior.getComponentCount() > 0){
            panelSuperior.remove(0); //remuevo all lo que hay en el panel(en este caso la tabla)
        }
        panelSuperior.add(sp); //agrego el scrollPane al panelCentral
        panelSuperior.validate(); //le pido al JPanel que se vuelva a validar para que se repinte nuevamente
    }

    public void agregarTablaCuotas(JScrollPane sp){ //este metodo me quita la tabla actual y coloca la nueva en el scrollPanel
        if(panelInferior.getComponentCount() > 0){
            panelInferior.remove(0); //remuevo all lo que hay en el panel(en este caso la tabla)
        }
        panelInferior.add(sp); //agrego el scrollPane al panelCentral
        panelInferior.validate(); //le pido al JPanel que se vuelva a validar para que se repinte nuevamente
    }

    public void actionCommands(){
        btnPrestamo.setActionCommand("4");
        btnPago.setActionCommand("5");
        btnRegreso.setActionCommand("6");
        btnPagoAutomatico.setActionCommand("7");
    }

    public void addListeners(ActionListener ac){
        btnRegreso.addActionListener(ac);
        btnPago.addActionListener(ac);
        btnPrestamo.addActionListener(ac);
        btnPagoAutomatico.addActionListener(ac);
    }
    public void addMouseListeners(MouseListener ml){
        jTableprestamos.addMouseListener(ml);
    }
    public void setjTableprestamos(JTable jTableprestamos) {
        this.jTableprestamos = jTableprestamos;
    }

    public void setjTableCuotas(JTable jTableCuotas) {
        this.jTableCuotas = jTableCuotas;
    }

    public void setBtnPago(JButton btnPago) {
        this.btnPago = btnPago;
    }

    public void setjTextFMonto(JTextField jTextFMonto) {
        this.jTextFMonto = jTextFMonto;
    }

    public void setNumeroCuota(JTextField numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public JTable getjTableprestamos() {
        return jTableprestamos;
    }

    public JTable getjTableCuotas() {
        return jTableCuotas;
    }

    public JButton getBtnPago() {
        return btnPago;
    }

    public JTextField getjTextFMonto() {
        return jTextFMonto;
    }

    public JTextField getNumeroCuota() {
        return numeroCuota;
    }

    public JButton getBtnPrestamo() {
        return btnPrestamo;
    }

    public JTextField getjTextFIdPre() {
        return jTextFIdPre;
    }

    public JTextField getjTextFPlazo() {
        return jTextFPlazo;
    }

    public JTextField getjTextFInteres() {
        return jTextFInteres;
    }

    public JTextField getjTextFPago() {
        return jTextFPago;
    }

    public JLabel getjLabelIDPersona() {
        return jLabelIDPersona;
    }

    public JLabel getjLabelNombrePersona() {
        return jLabelNombrePersona;
    }

    public JLabel getjLabelProvinciaPersona() {
        return jLabelProvinciaPersona;
    }

    public JLabel getjLabelCantonPersona() {
        return jLabelCantonPersona;
    }

    public JLabel getjLabelDistritoPersona() {
        return jLabelDistritoPersona;
    }

    public JLabel getjLabelIDPrestamo() {
        return jLabelIDPrestamo;
    }

    public JLabel getjLabelMontoPrestamo() {
        return jLabelMontoPrestamo;
    }

    public JLabel getjLabelCuotaPrestamo() {
        return jLabelCuotaPrestamo;
    }

    public JLabel getjLabelPlazoPrestamo() {
        return jLabelPlazoPrestamo;
    }

    public JLabel getjLabelInteresPrestamo() {
        return jLabelInteresPrestamo;
    }

    public JLabel getjLabelEstadoPrestamo() {
        return jLabelEstadoPrestamo;
    }
}
