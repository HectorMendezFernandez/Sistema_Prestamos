package Modelo;

import javax.swing.table.AbstractTableModel;
import java.util.Date;
import java.util.List;

public class JTable_Pagos extends AbstractTableModel {

    private List<Pago> filas;
    private String columnas[] = {"#Cuota", "Interes", "Monto", "Amortizacion", "Fecha"};

    public JTable_Pagos(List<Pago> filas) {
        this.filas = filas;
    }

    @Override
    public int getRowCount() {
        return filas.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public List<Pago> getFilas() {
        return filas;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pago pago = filas.get(rowIndex); //almaceno el empleado que se encuentra en la fila
        switch (columnIndex) {
            case 0:
                return pago.getNumeroCuota(); //retorno el id de la persona
            case 1:
                return pago.getMontoInteres(); //retorno el nombre de la persona
            case 2:
                return pago.getMontoPagar(); //retorno el salario de la persona
            case 3:
                return pago.getAmortizacion();
            case 4: {
                Object fecha = new Date();
                return fecha;
            }
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int col){
        return columnas[col]; //obtiene el nombre de las columnas  de una posicion especifica
    }
}
