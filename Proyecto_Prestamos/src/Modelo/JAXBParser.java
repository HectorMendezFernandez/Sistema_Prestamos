package Modelo;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileOutputStream;

public class JAXBParser {
    public void marshall(Object o, String filename){ //recibe un objeto y lo mete en xml
        try {
            //Creando el contexto JAXB
            JAXBContext jContext = JAXBContext.newInstance(o.getClass()); //ocupa una excepcion
            //Se crea el objeto para realizar el marshaller
            Marshaller marshallObj = jContext.createMarshaller();
            //se configura la propiedad para mostrar en el XML en el formato de salida
            marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallObj.marshal(o, new FileOutputStream(filename));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Object unmarshall(Object ref, String filename){ //leee el xml y me devuelve adentro del objeto
        Object o = null;
        try {
            //obteniendo el archivo xml para lectura
            File file = new File(filename);
            //creando el contexto JAXB
            JAXBContext JContext = JAXBContext.newInstance(ref.getClass());
            //creando el  objeto para el unmarshall
            Unmarshaller unmarshallerObj = JContext.createUnmarshaller();
            //llamando el metodo de unmarshall
            o = unmarshallerObj.unmarshal(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        return o;
    }
}