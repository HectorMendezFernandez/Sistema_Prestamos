package Modelo;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.pow;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Prestamos") //etiqueta general para cuando se le haga el marshall a este objeto
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PrestamoModelo
{
    private List<Prestamo> listaPres;

    public PrestamoModelo() {
        listaPres = new ArrayList<>();
    }

    public void asignarDatosPrestamo(double m, double in, int p, Cliente c) //agregar a la lista
    {
        Prestamo prestamo = new Prestamo();
        prestamo.setMonto(m);
        prestamo.setInteres(in);
        prestamo.setPlazo(p);
        prestamo.setCliente(c);
        double cuota = (prestamo.getSaldo() * prestamo.getInteres()) / (1 - (pow((1 + prestamo.getInteres()), -prestamo.getPlazo())));
        prestamo.setCuota(cuota);
        listaPres.add(prestamo);
    }
    public void addPrestamo(Prestamo obj){
        listaPres.add(obj);
    }

    public void listarPrestamos()//imprimir lista
    {
        for(Prestamo prestamo : listaPres )
        {
           prestamo.toStringPres();

        }
    }

    @XmlElement(name = "prestamo")
    public List<Prestamo> getListaPres() {
    return listaPres;
}

    public Prestamo retornarPrestamo(String id){
        for(Prestamo pre : listaPres)
        {
            if(id.equals(pre.getId()) == true){
                return pre;
            }
        }
        return null;
    }

    public boolean buscarPrestamo(String id) {
        for (Prestamo pre : listaPres) {
            if (id.equals(pre.getId()) == true) {
                return true;
            }
        }
        return false;
    }

    public void prestamosCliente(Cliente cli, List<Prestamo> prestamoList){
        for (Prestamo pre : listaPres) {
            if (cli.getCedula().equals(pre.getCliente().getCedula()) == true) {
               // System.out.println("Entro");
                prestamoList.add(pre);
            }
        }
    }
}
