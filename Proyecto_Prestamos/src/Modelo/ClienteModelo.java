package Modelo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "clientes") //etiqueta general para cuando se le haga el marshall a este objeto
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ClienteModelo
{
    private List<Cliente> listaC;

    public ClienteModelo() {
       listaC = new ArrayList<>();
    }

    public void asignaDatosCliente(String id, String n, String p, String c, String d)
    {
        Cliente cli = new Cliente();
        cli.setCedula(id);
        cli.setNombre(n);
        cli.setProvincia(p);
        cli.setCanton(c);
        cli.setDistrito(d);
        listaC.add(cli);
    }
    public void addCliente(Cliente obj){
        listaC.add(obj);
    }

    public void listarClientes()
    {
        for(Cliente cli : listaC)
        {
            System.out.println(cli.toString());

        }
    }

    public boolean buscarClienteBool(String id)
    {
        for(Cliente cli : listaC)
        {
            if(id.equals(cli.getCedula()) == true){
                return true;
            }
        }
        return false;
    }

    public Cliente buscarClienteID(String id)
    {
       for(Cliente cli : listaC)
        {
            if(id.equals(cli.getCedula()) == true){
                return cli;
            }
        }
       return null;
    }
    @XmlElement(name = "cliente")
    public List<Cliente> getListaC() {
        return listaC;
    }
}
