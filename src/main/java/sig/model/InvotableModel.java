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
public class InvotableModel extends AbstractTableModel{
private ArrayList<InvoiceHeader>Invoice;
private String[]col={"num","Date","customer","Total"};
    @Override
    public int getRowCount() {
        return Invoice.size();
    }

    public InvotableModel(ArrayList<InvoiceHeader> Invoice) {
        this.Invoice = Invoice;
    }
    @Override
     public String getColumnName(int column) {
         return col[column];
     }

    @Override
    public int getColumnCount() {
        return col.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    InvoiceHeader Invo=Invoice.get(rowIndex);
    switch(columnIndex){
        case 0:return Invo.getNum();
        case 1:return Invo.getDate();
        case 2:return Invo.getName();
        case 3:return Invo.getTotalinvoprice();
        default:return" ";
    }
    }
    
    
}
