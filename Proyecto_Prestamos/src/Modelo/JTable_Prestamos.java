package Modelo;

import javax.swing.table.AbstractTableModel;
import java.util.List;


import javax.print.attribute.standard.NumberOfInterveningJobs;
import javax.swing.table.AbstractTableModel;
import javax.xml.transform.Templates;
import java.util.List;

public class JTable_Prestamos extends AbstractTableModel {

        private List<Prestamo> filas;
        private String columnas[] = {"ID", "Monto", "Intereses %", "Plazo", "Cuota", "Saldo", "Estado"};

        public JTable_Prestamos(List<Prestamo> filas) {
            this.filas = filas;
        }

        @Override
        public int getRowCount() {
            return filas.size();
        }

        @Override
        public int getColumnCount() {
            return 7;
        }

        public List<Prestamo> getFilas() {
            return filas;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Prestamo pres = filas.get(rowIndex); //almaceno el empleado que se encuentra en la fila
            switch (columnIndex) {
                case 0:
                    return pres.getId(); //retorno el id de la persona
                case 1:
                    return pres.getMonto(); //retorno el nombre de la persona
                case 2:
                    return pres.getInteres(); //retorno el salario de la persona
                case 3:
                    return pres.getPlazo();
                case 4:
                    return pres.getCuota();
                case 5:
                    return (int)pres.getSaldo();
                case 6:
                    return pres.getEstadoPago();
                default:
                    return null;
            }
        }

        @Override
        public String getColumnName(int col){
            return columnas[col]; //obtiene el nombre de las columnas  de una posicion especifica
        }

}
