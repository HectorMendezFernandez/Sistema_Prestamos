package controlador;

import Modelo.Cliente;
import Modelo.ClienteModelo;
import Modelo.JAXBParser;
import com.itextpdf.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import vista.VistaClientes;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.event.*;
import java.io.File;

public class ControladorClientes {
    int provincia;
    Cliente cli;
    VistaClientes vistaCliente;
    ClienteModelo listaCliente;

    public  ControladorClientes(){
        cli = null;
        listaCliente = new ClienteModelo();
        vistaCliente = new VistaClientes();
        vistaCliente.addMouseMotionListeners(new ListenerMapa());
        vistaCliente.addMouseListeners(new MouseListenerMapa());
    }

    public void escribeClientes()
    {
        JAXBParser parser = new JAXBParser();
        parser.marshall(listaCliente, "clientes.xml");
    }

    public void leeClientes() throws IOException
    {
        JAXBParser parser = new JAXBParser();
        listaCliente = (ClienteModelo) parser.unmarshall(listaCliente, "clientes.xml");
    }

    public void agregarComboBoxXML(String file){ //me agregaa los distritos y cantones
        vistaCliente.getjComboCanton().removeAllItems();
        vistaCliente.getjComboDistrito().removeAllItems();
        try{
            File archivoXML =new File("C:\\Users\\luda2\\Desktop\\Universidad Hector\\Ciclo 2 (level 2)\\Programacion 3\\Proyectos Programacion\\Proyecto_Prestamos\\src\\XML_CostaRica\\"+file);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document documentoXML = builder.parse(archivoXML);
            documentoXML.getDocumentElement().normalize();
            //obtener los elementos a partir del nombre de una etiqueta (agrega en este caso todos los nodos cantones
            NodeList cantones = documentoXML.getElementsByTagName("cantones");
            for(int i = 0 ; i<cantones.getLength(); i++ ){
                Node provincia = cantones.item(i);
                if(provincia.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) provincia;
                    //Me devuelve el nombre de la provincia o canton
                    String canton= (String)element.getElementsByTagName("nombre").item(0).getTextContent();
                    vistaCliente.getjComboCanton().addItem(canton); //agrega el canton al combo box
                }
            }
            NodeList distritos = documentoXML.getElementsByTagName("distritos");
            for(int i = 0 ; i<distritos.getLength(); i++ ){
                Node distrito = distritos.item(i);
                if(distrito.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) distrito;
                    //Me devuelve el nombre de la provincia o canton
                    String distri= (String)elemento.getElementsByTagName("nombre").item(0).getTextContent();
                     vistaCliente.getjComboDistrito().addItem(distri); //agrega el canton al combo box
                }
            }
        }catch (Exception e){
            System.out.println("error");
        }
       }

       private class ListenerMapa implements MouseMotionListener{

           @Override
           public void mouseDragged(MouseEvent e) {

           }

           @Override
           public void mouseMoved(MouseEvent e) {
              int X=(int)e.getPoint().getX();
              int Y=(int)e.getPoint().getY();
              // coordenadas = "X:"+X+" Y: "+Y;
               //System.out.println(coordenadas);
              // coorde.setText(coordenadas);
               //Heredia
               if( (X==209 && Y >= 59 && Y <= 158) || (X==241 && Y <= 158 && Y >= 59) || (Y==158 && X >= 206 && X <= 241) || (Y==59 && X >=208 && X <= 241)) {
                   provincia = 1;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaHeredia(1).png"));
               }
               //Alajuela
               if( (X==207 && Y >= 59 && Y <= 168) || (X==149 && Y <= 163 && Y >= 59) || (Y==59 && X >= 149 && X <= 207) || (Y==163 && X >=149 && X <= 207)) {
                   provincia = 2;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaAlajuela(1).png"));
               }
               //Alajuela Zona 2
               if( (X==82 && Y >= 23 && Y <= 56) || (X==202 && Y <= 56 && Y >= 23) || (Y==22 && X >= 82 && X <= 202) || (Y==56 && X >=82 && X <= 202)) {
                   provincia = 2;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaAlajuela(1).png"));
               }
               //Alajuela 4
               if( (X==110 && Y >= 24 && Y <= 58) || (X==148 && Y <= 58 && Y >= 24) || (Y==24 && X >= 110 && X <= 148) || (Y==58 && X >=110 && X <= 148)) {
                   provincia = 2;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaAlajuela(1).png"));
               }
               //Alajuela 5
               if( (X==136 && Y >= 59 && Y <= 120) || (X==148 && Y <= 120 && Y >= 59) || (Y==59 && X >= 136 && X <= 148) || (Y==120 && X >=136 && X <= 148)) {
                   provincia = 2;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaAlajuela(1).png"));
               }
               ////Cartago 14
               if( (X==242 && Y >= 139 && Y <= 196) || (X==296 && Y <= 196 && Y >= 159) || (Y==159 && X >= 242 && X <= 296) || (Y==196 && X >= 242 && X <= 296)) {
                   provincia = 3;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaCartago (1).png"));
               }
               //Limon 13
               if( (X==245 && Y >= 64 && Y <= 57) || (X==298 && Y <= 157 && Y >= 64) || (Y==64 && X >= 245 && X <= 298) || (Y==157 && X >=245  && X <= 298)) {
                   provincia = 7;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaLimon(1).png"));
               }
               //Limon 11
               if( (X==300 && Y >= 157 && Y <= 250) || (X==362 && Y <= 250 && Y >= 157) || (Y==157 && X >= 362 && X <= 300) || (Y==250 && X >=362  && X <= 300)) {
                   provincia = 7;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaLimon(1).png"));
               }
               //Limon 12
               if( (X==363 && Y >= 192 && Y <= 215) || (X==394 && Y <= 215 && Y >= 192) || (Y==192 && X >= 363 && X <= 394) || (Y==215 && X >=363  && X <= 394)) {
                   provincia = 7;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaLimon(1).png"));
               }
               //Guanacaste 19
               if( (X==54 && Y >= 60 && Y <= 172) || (X==80 && Y <= 172 && Y >= 60) || (Y==60 && X >= 54 && X <= 80) || (Y==172 && X >=54  && X <= 80)) {
                   provincia = 6;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaGuanacaste (1).png"));
               }
               //Guanacaste 18
               if( (X==81 && Y >= 68 && Y <= 111) || (X==130 && Y <= 111 && Y >= 68) || (Y==68 && X >= 81 && X <= 130) || (Y==111 && X >=81  && X <= 130)) {
                   provincia = 6;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaGuanacaste (1).png"));
               }
               //Guanacaste 20
               if( (X==53 && Y >= 11 && Y <= 174) || (X==6 && Y <= 174 && Y >= 11) || (Y==11 && X >= 6 && X <= 53) || (Y==174 && X >=6  && X <= 53)) {
                   provincia = 6;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaGuanacaste (1).png"));
               }
               //Puntarenas 7
               if( (X==81 && Y >= 156 && Y <= 196) || (X==119 && Y <= 196 && Y >= 156) || (Y==156 && X >= 81 && X <= 119) || (Y==196 && X >=81  && X <= 119)) {
                   provincia = 5;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaPuntarenas_ (1).png"));
               }
               //Puntarenas 8
               if( (X==182 && Y >=201 && Y <= 216) || (X==209 && Y <= 216 && Y >= 201) || (Y==201 && X >= 182 && X <= 209) || (Y==216 && X >=182  && X <= 209)) {
                   provincia = 5;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaPuntarenas_ (1).png"));
               }
               //Puntarenas 6
               if( (X==131 && Y >=122 && Y <= 157) || (X==148 && Y <= 157 && Y >= 122) || (Y==122 && X >= 131 && X <= 148) || (Y==157 && X >=131  && X <= 148)) {
                   provincia = 5;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaPuntarenas_ (1).png"));
               }
               //Puntarenas 10
               if( (X==247 && Y >=252 && Y <= 347) || (X==370 && Y <= 347 && Y >= 252) || (Y==252 && X >= 247 && X <= 370) || (Y==347 && X >=247  && X <= 370)) {
                   provincia = 5;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaPuntarenas_ (1).png"));
               }
               //San Jose 15
               if( (X==250 && Y >=218 && Y <= 251) || (X==282 && Y <= 251 && Y >= 218) || (Y==218 && X >= 250 && X <= 282) || (Y==251 && X >=250  && X <= 282)) {
                   provincia = 4;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaSanJose(1).png"));
               }
               //San Jose 17
               if( (X==224 && Y >=147 && Y <= 228) || (X==249 && Y <= 228 && Y >= 147) || (Y==147 && X >= 224 && X <= 249) || (Y==228 && X >=224  && X <= 249)) {
                   provincia = 4;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaSanJose(1).png"));
               }
               //San Jose 16
               if( (X==162 && Y >=171 && Y <= 200) || (X==218 && Y <= 200 && Y >= 171) || (Y==171 && X >= 162 && X <= 218) || (Y==200 && X >= 162  && X <= 218)) {
                   provincia = 4;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaSanJose(1).png"));
               }
               //Puntarenas 9
               if( (X==208 && Y >=228 && Y <= 239) || (X==229 && Y <= 239 && Y >= 228) || (Y==228 && X >= 208 && X <= 229) || (Y==239 && X >= 208  && X <= 229)) {
                   provincia = 5;
                   vistaCliente.getjLabelImagen().setIcon(new ImageIcon("src/imagenes/ProvinciaPuntarenas_ (1).png"));
               }
           }
       }

       private class MouseListenerMapa extends MouseAdapter{
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               switch (provincia){
                   case 1:System.out.println("Entro");vistaCliente.getjTextFProvincia().setText("Heredia"); agregarComboBoxXML("Heredia.xml"); break;
                   case 2:vistaCliente.getjTextFProvincia().setText("Alajuela"); agregarComboBoxXML("Alajuela.xml");break;
                   case 3:vistaCliente.getjTextFProvincia().setText("Cartago"); agregarComboBoxXML("Cartago.xml");break;
                   case 4:vistaCliente.getjTextFProvincia().setText("San Jose"); agregarComboBoxXML("SanJose.xml");break;
                   case 5:vistaCliente.getjTextFProvincia().setText("Puntarenas"); agregarComboBoxXML("Puntarenas.xml");break;
                   case 6:vistaCliente.getjTextFProvincia().setText("Guanacaste"); agregarComboBoxXML("Guanacaste.xml");break;
                   case 7:vistaCliente.getjTextFProvincia().setText("Limon"); agregarComboBoxXML("Limon.xml");break;
                   default:break;
               }
           }
       }
}


