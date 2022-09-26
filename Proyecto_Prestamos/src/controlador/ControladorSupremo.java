package controlador;

import Modelo.*;
import com.itextpdf.io.IOException;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;



/*
btnBuscar--->("1");
btnGuardar--->("2");
btnPrestamo--->("3");
btnRealzarPrestamo--->("4")
btnRealizarPago--->("5")
btnRegresoPrincipal--->("6");
*/
public class ControladorSupremo {

    ControladorClientes controlClientes;
    ControladorPrestamos controlPrestamos;

    public ControladorSupremo() throws java.io.IOException {
        controlClientes = new ControladorClientes();
        controlClientes.vistaCliente.addListeners(new ListenersAction());
        controlPrestamos =new ControladorPrestamos();
        controlPrestamos.vistaPres.addListeners(new ListenersAction());
        //agregarDatosDefaultS();
        controlClientes.leeClientes();
        controlPrestamos.leePrestamos();
    }

    public void agregarDatosDefaultS(){
        PagoModelo list1 = new PagoModelo();
        Cliente cli1 = new Cliente("123", "Hector1", "Alajuela", "Alajuela", "Carrizal");
      //  Prestamo prestamo1 = new Prestamo("1234", 1500, 0.05, 4, cli1, list1);

        //agregandole pagos por default
     //   prestamo1.agregarPago(423);
      //  prestamo1.agregarPago(423);
       // prestamo1.agregarPago(423);


        PagoModelo list2 = new PagoModelo();
        Cliente cli2 = new Cliente("3210", "Hector2", "Limon", "Pococí", "Guapiles");
       // Prestamo prestamo2 = new Prestamo("321", 6000, 0.10, 6, cli2, list2);

        //agregando prestamos
        //controlPrestamos.listaPres.addPrestamo(prestamo2);
       // controlPrestamos.listaPres.addPrestamo(prestamo1);

        //agregando a los clientes
        controlClientes.listaCliente.addCliente(cli1);
        controlClientes.listaCliente.addCliente(cli2);

        controlPrestamos.escribePrestamos();
        controlClientes.escribeClientes();
    }


    public void generarregistroClientes() throws IOException, java.io.IOException {
        String n = "Lista de Clientes";
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfWriter writer = new PdfWriter("Registro_de_Clientes.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());//pdf, PageSize.A4.rotate());
        document.setMargins(50, 50, 50, 50);

        document.add(new Paragraph(""));
        document.add(new Paragraph(n).setFont(font).setBold().setFontSize(20f));
        document.add(new Paragraph(""));
        document.add(new Paragraph(""));

        Table table = new Table(5);
        Cell c = new Cell();
        Color bkg = ColorConstants.LIGHT_GRAY;
        Color frg= ColorConstants.BLUE;

        c= new Cell(); c.add(new Paragraph("Nombre")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);
        c= new Cell(); c.add(new Paragraph("Cedula")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);
        c= new Cell(); c.add(new Paragraph("Provincia")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);
        c= new Cell(); c.add(new Paragraph("Canton")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);
        c= new Cell(); c.add(new Paragraph("Distrito")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);

        for(Cliente cli : controlClientes.listaCliente.getListaC())
        {
            {
                //System.out.println(cli.toString());

                table.addHeaderCell(cli.getNombre()+"");
                table.addHeaderCell(cli.getCedula()+"");
                table.addHeaderCell(cli.getProvincia()+"");
                table.addHeaderCell(cli.getCanton()+"");
                table.addHeaderCell(cli.getDistrito()+"");

            }
        }
        document.add(table);
        document.close();
    }

    public void generarRegistrodePagosXPrest() throws IOException, java.io.IOException {

        String n = "Lista de Pagos de un Prestamo";
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfWriter writer = new PdfWriter("Registro_de_pagos.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(50, 50, 50, 50);
        document.add(new Paragraph(n).setFont(font).setBold().setFontSize(20f));
        document.add(new Paragraph(""));
        document.add(new Paragraph(""));
        for(Prestamo prestamo : controlPrestamos.listaPres.getListaPres())
        {
            {

                document.add(new Paragraph("Prestamo id: "+prestamo.getId()).setBold());
                document.add(new Paragraph("Cliente id: "+prestamo.getCliente().getCedula()).setBold());
                document.add(new Paragraph("Nombre del(a) cliente: "+prestamo.getCliente().getNombre()).setBold());
            }
            for(Pago pago : prestamo.getPagoList().getPagoList())
            {
                Table table = new Table(5);
                Cell c = new Cell();
                Color bkg = ColorConstants.LIGHT_GRAY;
                Color frg= ColorConstants.BLUE;
                c= new Cell(); c.add(new Paragraph("Fecha")).setBackgroundColor(bkg).setFontColor(frg);
                table.addHeaderCell(c);
                c= new Cell(); c.add(new Paragraph("Monto a pagar")).setBackgroundColor(bkg).setFontColor(frg);
                table.addHeaderCell(c);
                c= new Cell(); c.add(new Paragraph("Monto destinado al interes")).setBackgroundColor(bkg).setFontColor(frg);
                table.addHeaderCell(c);
                c= new Cell(); c.add(new Paragraph("Monto destinado a la Amortizacion")).setBackgroundColor(bkg).setFontColor(frg);
                table.addHeaderCell(c);
                c= new Cell(); c.add(new Paragraph("Numero de cuota")).setBackgroundColor(bkg).setFontColor(frg);
                table.addHeaderCell(c);
                table.addHeaderCell(String.valueOf(pago.getFechaPago()));
                table.addHeaderCell(String.valueOf(Math.round(pago.getMontoPagar())));
                table.addHeaderCell(String.valueOf(Math.round(pago.getMontoInteres())));
                table.addHeaderCell(String.valueOf(Math.round(pago.getAmortizacion())));
                table.addHeaderCell(String.valueOf(pago.getNumeroCuota()));
                document.add(table);
            }
            document.add(new Paragraph(""));
            document.add(new Paragraph(""));
            document.add(new Paragraph(""));
        }
        document.close();
    }


    private class ListenersAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int valor =Integer.parseInt(e.getActionCommand());
            switch (valor){
                case 1:{
                    String id =(String) controlClientes.vistaCliente.getjTextFId().getText();
                    try{
                        Cliente cli;
                        if(id.isEmpty()){
                            throw new RuntimeException("ERROR, no se puede buscar una persona\n si el espacio de id esta vacio");
                        }
                        if(controlClientes.listaCliente.buscarClienteBool(id) == false){
                            throw new RuntimeException("RROR, el cliente que se quiere buscar\n NO existe en el registro bancario");
                        }
                        cli =controlClientes.listaCliente.buscarClienteID(id);
                        controlClientes.agregarComboBoxXML(cli.getProvincia()+".xml");
                        controlClientes.vistaCliente.getjTextFNombre().setText(cli.getNombre());
                        controlClientes.vistaCliente.getjTextFProvincia().setText(cli.getProvincia());
                        controlClientes.vistaCliente.colocarCantonComboBox(cli.getCanton());
                        controlClientes.vistaCliente.colocarDistritoComboBox(cli.getDistrito());
                    }catch (RuntimeException re){
                        JOptionPane.showMessageDialog(null,re.getMessage());
                    }
                    break;
                }//Boton de buscar cliente
                case 2:{
                    Cliente cliente = null;
                    String nombre = controlClientes.vistaCliente.getjTextFNombre().getText();
                    String id = controlClientes.vistaCliente.getjTextFId().getText();
                    String provincia = controlClientes.vistaCliente.getjTextFProvincia().getText();
                    String canton = (String)controlClientes.vistaCliente.getjComboCanton().getSelectedItem();
                    String distrito= (String)controlClientes.vistaCliente.getjComboDistrito().getSelectedItem();
                    try{
                        if(nombre.isBlank() || id.isEmpty() || provincia.isEmpty() || provincia.isEmpty()){ //verifica que ningun espacio este en blanco
                            throw new RuntimeException("ERROR, no se puede agregar \nsi hay un campo de texto vacio");
                        }
                        if(controlClientes.listaCliente.buscarClienteBool(id) == true){
                            throw new RuntimeException("ERROR, Ya existe un cliente\n en el registro con el id ingresado");
                        }
                        cliente = new Cliente(id,nombre,provincia,canton,distrito);
                        controlClientes.listaCliente.addCliente(cliente); //agrega un nuevo cliente

                        controlClientes.listaCliente.listarClientes();
                        JOptionPane.showMessageDialog(null, "Se ingreso el cliente al sistema");

                        controlClientes.escribeClientes();

                    }catch (RuntimeException rt) {
                        JOptionPane.showMessageDialog(null, rt.getMessage());
                    }
                    break;
                }//Boton de agregar cliente
                case 3:{
                    List<Prestamo> list = new ArrayList<>();
                    String id = controlClientes.vistaCliente.getjTextFId().getText();
                    try {
                        if(controlClientes.listaCliente.buscarClienteBool(id) == false){
                            throw new RuntimeException("Debe de ingresar el id de un cliente que se enceuntre\n en el registro para ver y realizarle prestamos");
                        }
                        if(id.isEmpty()){
                            throw new RuntimeException("Debe de ingresar el id de un cliente que se enceuntre\n en el registro para ver y realizarle prestamos");
                        }
                        controlClientes.cli = controlClientes.listaCliente.buscarClienteID(id);
                        controlPrestamos.listaPres.prestamosCliente(controlClientes.cli,list); //obtengo la lista de prestamos de ese cliente
                        controlPrestamos.actualizarTablaPrestamos(list); //agregamos los clientes a la tabla
                        controlClientes.vistaCliente.setVisible(false);
                        controlPrestamos.vistaPres.setVisible(true);
                        //agregamos los datos del usuario a los labels para que se muestre
                        controlPrestamos.vistaPres.getjLabelNombrePersona().setText("-Nombre: " +controlClientes.cli.getNombre());
                        controlPrestamos.vistaPres.getjLabelIDPersona().setText("-ID:" + controlClientes.cli.getCedula());
                        controlPrestamos.vistaPres.getjLabelProvinciaPersona().setText( "-Provincia: " +controlClientes.cli.getProvincia());
                        controlPrestamos.vistaPres.getjLabelCantonPersona().setText("-Canton: " + controlClientes.cli.getCanton());
                        controlPrestamos.vistaPres.getjLabelDistritoPersona().setText("-Distrito: " + controlClientes.cli.getDistrito());
                    }catch (RuntimeException tr){
                        JOptionPane.showMessageDialog(null,tr.getMessage());
                    }
                    break;
                }//Boton de abrir ventna de prestamos
                case 4: {
                    Prestamo prest = null;
                    PagoModelo listaPago = new PagoModelo();
                    String idPrestamo =(String) controlPrestamos.vistaPres.getjTextFIdPre().getText();
                    String montoPrestamo =(String) controlPrestamos.vistaPres.getjTextFMonto().getText();
                    String interes = (String)controlPrestamos.vistaPres.getjTextFInteres().getText();
                    String plazo =(String) controlPrestamos.vistaPres.getjTextFPlazo().getText();

                    Cliente cli = controlClientes.cli;
                    try{
                        if(idPrestamo.isBlank() || montoPrestamo.isBlank() || interes.isBlank() || plazo.isBlank()){ //verifica que ningun espacio este en blanco
                            throw new RuntimeException("ERROR, no se puede agregar un prestamo al cliente \nsi hay un campo de texto vacio");
                        }
                        double montoPres = Double.parseDouble(montoPrestamo);
                        double interesPres = Double.parseDouble(interes);
                        int plazoPres = Integer.parseInt(plazo);
                        if(controlPrestamos.listaPres.buscarPrestamo(idPrestamo)){
                            throw new RuntimeException("ERROR, el id ingresado ya es existente en otro prestamo\nporfavor digite uno distinto");
                        }
                        if(montoPres == 0 || montoPres<0){
                            throw new RuntimeException("ERROR, el monto ingresado no es valido\n prueba con valores mayores a 500");
                        }
                        if(montoPres < 500){
                            throw new RuntimeException("ERROR, el monto minimo de un prestamo es de 500");
                        }
                        if(interesPres > 0.9 || interesPres <=0){
                            throw new RuntimeException("ERROR, interes debe de ser menor a 1 y mayor igual a 0\n ejm: 0.9, 0.0, 0.05");
                        }
                        if(plazoPres<0){
                            throw new RuntimeException("ERROR, el plazo debe de ser mayor o igual a 1");
                        }
                        //creo el prestamo y lo agrego a la lista
                        prest = new Prestamo(idPrestamo,montoPres,interesPres,plazoPres,cli,listaPago);
                        controlPrestamos.listaPres.addPrestamo(prest);
                        JOptionPane.showMessageDialog(null, "Se realizo un nuevo prestamo con exito");
                        controlPrestamos.actualizarTablaPrestamos(controlPrestamos.listaPres.getListaPres());
                        //creo la lista de prestamos del cliente nuevamente para cargarla al jTable
                        List<Prestamo> list = new ArrayList<>();
                        controlPrestamos.listaPres.prestamosCliente(cli,list); //obtengo la lista de prestamos de ese cliente
                        controlPrestamos.actualizarTablaPrestamos(list);

                        controlPrestamos.escribePrestamos(); //guarda en xml

                    }catch (RuntimeException rt) {
                        JOptionPane.showMessageDialog(null, rt.getMessage());
                    }
                    break;}//boton para agregar un nuevo prestamo
                case 5: {
                    List<Prestamo> list = new ArrayList<>();
                    String pag = (String)controlPrestamos.vistaPres.getjTextFPago().getText();
                    try {
                        if(pag.isEmpty()){
                            throw new RuntimeException("Debe de colocar un monto a pagar en la casilla");
                        }
                        double pago = Double.parseDouble(pag);
                        controlPrestamos.prestamo.agregarPago(pago);
                       controlPrestamos.actualizarTablaPagos(controlPrestamos.prestamo.getPagoList().getPagoList());
                       controlPrestamos.listaPres.prestamosCliente(controlClientes.cli,list);
                       controlPrestamos.actualizarTablaPrestamos(list);

                       controlPrestamos.escribePrestamos();

                    }catch (RuntimeException rt){
                        JOptionPane.showMessageDialog(null,rt.getMessage());
                    }
                    break;
                }//Boton de realizar pago a prestamo
                case 6: {
                    List<Prestamo> list = new ArrayList<>();
                    PagoModelo listP  = new PagoModelo();
                    controlPrestamos.vistaPres.setVisible(false);
                    controlClientes.vistaCliente.setVisible(true);
                    controlPrestamos.actualizarTablaPagos(listP.getPagoList());
                   // controlPrestamos.actualizarTablaPrestamos(list);
                    break;
                }//boton para regrear a la ventana principal
                case 7:{
                    List<Prestamo> list = new ArrayList<>();
                    controlPrestamos.prestamo.realizaPagoAutomatico();
                    controlPrestamos.actualizarTablaPagos(controlPrestamos.prestamo.getPagoList().getPagoList());
                    controlPrestamos.listaPres.prestamosCliente(controlClientes.cli,list);
                    controlPrestamos.actualizarTablaPrestamos(list);
                    controlPrestamos.escribePrestamos();
                    break;
                } //pago automatico
                case 8:{ //genera reporte de clientes pdf
                    try {
                        generarregistroClientes();
                    } catch (java.io.IOException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Se ha generado un reporte\n de los clientes en pdf");
                    break;
                }
                case 9:{ //genera reporte de clientes pdf
                    try {
                        generarRegistrodePagosXPrest();
                    } catch (java.io.IOException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Se ha generado un reporte\n de los prestamos en pdf");
                    break;
                }
                default:{break;}
            }
        }
    }
}
