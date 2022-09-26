package Modelo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "Pagos") //etiqueta general para cuando se le haga el marshall a este objeto
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PagoModelo
{
    List<Pago> pagoList;

    public PagoModelo() {
        pagoList = new ArrayList<>();
    }

    public void asignarDatosPago(Pago obj)
    {
        pagoList.add(obj);
    }

    public int numeroPagos(){
       return pagoList.size();
    }

    public void imprimir(){
        if(pagoList.size()==0){
            System.out.println("No hay pagos aun\n");
        }else {
            for (Pago pago : pagoList) {
                System.out.println("Pago=");
                pago.toStringPago(); System.out.println();
            }
        }
    }

    @XmlElement(name = "pago")
    public List<Pago> getPagoList() {
        return pagoList;
    }
}