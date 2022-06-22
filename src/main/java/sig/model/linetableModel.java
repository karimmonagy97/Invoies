/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sig.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dell
 */
public class linetableModel extends AbstractTableModel{
private ArrayList<InvoiceLine>Lines;
private String[] col={"Num","Product","Price","count","Total"};
    @Override
    public int getRowCount() {
       return Lines.size();
    }

    @Override
    public int getColumnCount() {
       return col.length;
    }
    @Override
     public String getColumnName(int column) {
         return col[column];
     }
    public linetableModel(ArrayList<InvoiceLine> Lines) {
        this.Lines = Lines;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine Line=Lines.get(rowIndex);
        switch(columnIndex){
        case 0:return Line.getNum();
        case 1:return Line.getProduct();
        case 2:return Line.getPrice();
        case 3:return Line.getCount();
        case 4:return Line.getTotproduct();
        default:return" ";
    }
    }
    
}
