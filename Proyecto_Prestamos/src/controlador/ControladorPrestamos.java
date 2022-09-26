package controlador;

import Modelo.*;
import com.itextpdf.io.IOException;
import vista.VistaPrestamos;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ControladorPrestamos {
    Prestamo prestamo;
    VistaPrestamos vistaPres;
    PrestamoModelo listaPres;

   public ControladorPrestamos(){
        vistaPres = new VistaPrestamos();
        listaPres = new PrestamoModelo();
        prestamo = null;
        vistaPres.actionCommands();
        vistaPres.addMouseListeners(new ListenerTabla(vistaPres.getjTableprestamos()));
    }

    public void escribePrestamos()
    {
        JAXBParser parser = new JAXBParser();
        parser.marshall(listaPres,"prestamos.xml");
    }

    public void leePrestamos() throws IOException
    {
        JAXBParser parser = new JAXBParser();
        listaPres = (PrestamoModelo) parser.unmarshall(listaPres, "prestamos.xml");
    }


    public void agregarDatosDefault(){
        PagoModelo list1 = new PagoModelo();
        Cliente cli1 = new Cliente("321", "Hector1", "Alajuela", "Alajuela", "Carrizal");
        Prestamo prestamo1 = new Prestamo("543", 1500, 0.05, 4, cli1, list1);

        //agregandole pagos por default
        prestamo1.agregarPago(423);
        prestamo1.agregarPago(423);
        prestamo1.agregarPago(423);


        PagoModelo list2 = new PagoModelo();
        Cliente cli2 = new Cliente("3215", "Hector2", "Limon", "Pococí", "Guapiles");
        Prestamo prestamo2 = new Prestamo("3212", 6000, 0.10, 6, cli2, list2);

        listaPres.addPrestamo(prestamo2);
        listaPres.addPrestamo(prestamo1);

        JTable tabla = new JTable();
        tabla.setModel(new JTable_Prestamos(listaPres.getListaPres()));
       agregarListenerTabla(tabla);
        vistaPres.setjTableprestamos(tabla); //se agrego

        JScrollPane pn1 = new JScrollPane(tabla);
        vistaPres.agregarTablaPrestamos(pn1);
    }

    public void agregarListenerTabla(JTable tabla){
       tabla.addMouseListener(new ListenerTabla(tabla));
    }

    public void actualizarTablaPagos(List<Pago> list){
        JTable tabla = new JTable();
        tabla.setModel(new JTable_Pagos(list));
        //tabla.addMouseListener(new ListenerTable(tabla));
        vistaPres.setjTableCuotas(tabla); //se agrego
        JScrollPane pn1 = new JScrollPane(tabla);
        vistaPres.agregarTablaCuotas(pn1);
    }

    public void actualizarTablaPrestamos(List<Prestamo> list){
        JTable tabla = new JTable();
        tabla.setModel(new JTable_Prestamos(list));
        tabla.addMouseListener(new ListenerTabla(tabla));
        vistaPres.setjTableprestamos(tabla); //se agrego

        JScrollPane pn1 = new JScrollPane(tabla);
        vistaPres.agregarTablaPrestamos(pn1);
    }

    private class ListenerTabla extends MouseAdapter{
        JTable tabla;
        public ListenerTabla(JTable tabla){ //constructor
            this.tabla = tabla;
        }
        @Override
        public void mouseClicked(MouseEvent e) { //listener
            super.mouseClicked(e);
            int fila = tabla.getSelectedRow();
            String idprestamo = (String)tabla.getValueAt(fila,0);
            prestamo = listaPres.retornarPrestamo(idprestamo);
            actualizarTablaPagos(prestamo.getPagoList().getPagoList());
            vistaPres.getjLabelIDPrestamo().setText("-ID: "+prestamo.getId());
            vistaPres.getjLabelCuotaPrestamo().setText("-Cuota: "+prestamo.getCuota());
            vistaPres.getjLabelMontoPrestamo().setText("-Monto: "+prestamo.getMonto());
            vistaPres.getjLabelInteresPrestamo().setText("-Interes: "+prestamo.getInteres());
            vistaPres.getjLabelPlazoPrestamo().setText("-Plazo: "+prestamo.getPlazo()+" meses");
            vistaPres.getjLabelEstadoPrestamo().setText("-Estado: "+prestamo.getEstadoPago());
        }
    }

}
