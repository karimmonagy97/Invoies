/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sig.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import static java.util.Date.parse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DateFormatter;
import sig.model.InvoiceHeader;
import sig.model.InvoiceLine;
import sig.model.InvotableModel;
import sig.model.linetableModel;
import welcomeproj.NewJFrame;
import welcomeproj.invoDialog;
import welcomeproj.lineDialog;
/**
 *
 * @author dell
 */
public class ActionHandler implements ActionListener , ListSelectionListener{
    private NewJFrame Frame;
    private invoDialog invoDialog;
    private lineDialog lineDialog;
    public ActionHandler(NewJFrame Frame) {
        this.Frame=Frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            System.out.println("I Heared");
            switch (e.getActionCommand()){
                case"Delete line":
                    deleteLine();
                    break;
                case"New line":
                    newLine();
                    break;
                case"Delete inovice":
                    deleteInov();
                    break;
                case"New inovice":
                    newInov();
                    break;
                case"Load File":
                    loadFile();
                    break;
                case"Save File":
                    saveFile();
                    break;
                case"createOK":
                    createOK();
                    break;
                case"createcancel":
                    createcancel();
                    break;
                case"LineOK":
                    LineOK();
                    break;
                case"LineCancel":
                    LineCancel();
                    break;
                    
                    
                    
                    
                    
            }
    }

    @SuppressWarnings("null")
    private void loadFile() {
         JFileChooser fc=new JFileChooser();
         try {
         int res=fc.showOpenDialog(Frame);
         if(res==JFileChooser.APPROVE_OPTION){
                 File headf=fc.getSelectedFile();
                 Path headp=Paths.get(headf.getAbsolutePath());
                 List<String>headerL=Files.readAllLines(headp);
                 System.out.println("read the file");
                 
                 ArrayList <InvoiceHeader>Invoices=new ArrayList<>();
                 for(int i=0;i<headerL.size();i++){
                     String[]parts=headerL.get(i).split(",");
                     int invnum=Integer.parseInt(parts[0]);
                     String invdate=parts[1];
                     String invcustomer=parts[2];
                    
                     InvoiceHeader Invoice=new InvoiceHeader(invnum,invdate,invcustomer);
                     Invoices.add(Invoice);
                     System.out.println("check");
                 }
                 
                  res=fc.showOpenDialog(Frame);
                  if(res==JFileChooser.APPROVE_OPTION){
                     File Linef=fc.getSelectedFile();
                     Path Linep=Paths.get(Linef.getAbsolutePath());
                    
                     List<String>Linel=Files.readAllLines(Linep);
                     System.out.println("CheckLines");
                     
                     
                     for(int i=0;i<Linel.size();i++){
                         String[]Lparts=Linel.get(i).split(",");
                         int invonum =Integer.parseInt(Lparts[0]);
                         String Product=Lparts[1];
                         double price=Double.parseDouble(Lparts[2]);
                         int count=Integer.parseInt(Lparts[3]);
                         InvoiceHeader Invo=null;
                         for(int j=0;j<Invoices.size();j++){
                             if(Invoices.get(j).getNum()==invonum){
                                 Invo=Invoices.get(j);
                                  break;
                             }
                             
                               
                         }
                     
                         InvoiceLine Line=new InvoiceLine(invonum,Product,price,count,Invo);
                         Invo.getLine().add(Line);
                     }
                     System.out.println("Hello");
                  } 
                  Frame.setInvoices(Invoices);
                  InvotableModel InvoTableModel=new InvotableModel(Invoices);
                  Frame.setInvoTableModel(InvoTableModel);
                  Frame.getInvoicetable().setModel(InvoTableModel);
                  Frame.getInvoTableModel().fireTableDataChanged();
         }
         }catch (IOException ex) {
                 ex.printStackTrace();
             }
         
            
        
        }            
    private void saveFile() {
        ArrayList<InvoiceHeader>invoice=Frame.getInvoices();
        String Headersvc="";
        String Linescv="";
        for(int i=0;i<invoice.size();i++){
            String headersvc=invoice.get(i).getAsci();
            Headersvc+=headersvc;
            Headersvc+="\n";
            System.out.println("Love");
        }
        for(int i=0;i<invoice.size();i++){
            for(int j=0;j<invoice.get(i).getLine().size();j++){
                 Linescv+=invoice.get(i).getLine().get(j).getAsci();
                 Linescv+="\n";
            }
           
        }
        
         JFileChooser fc=new JFileChooser();
         try {
         int res=fc.showOpenDialog(Frame);
         if(res==JFileChooser.APPROVE_OPTION){
             File headf=fc.getSelectedFile();
             FileWriter fw=new FileWriter(headf);
             fw.write(Headersvc);
             fw.flush();
             fw.close();
             res=fc.showOpenDialog(Frame);
             if(res==JFileChooser.APPROVE_OPTION){
                File linef=fc.getSelectedFile();
                FileWriter fwl=new FileWriter(linef);
                fwl.write(Linescv);
                fwl.flush();
                fwl.close();
                  
              }
         }
         }catch(Exception e) {
             
         }
    }

    private void newInov() {
        invoDialog=new invoDialog(Frame);
        invoDialog.setVisible(true);
        
    }

    private void deleteInov() {
         int selectedr=Frame.getInvoicetable().getSelectedRow();
        if(selectedr!=-1){
            Frame.getInvoices().remove(selectedr);
            Frame.getInvoTableModel().fireTableDataChanged();
        }
    }

    private void newLine() {
        lineDialog=new lineDialog(Frame);
        lineDialog.setVisible(true);
    }

    private void deleteLine() {
        int selectedinv=Frame.getInvoicetable().getSelectedRow();
        int selectedline=Frame.getItemtable().getSelectedRow();
        if(selectedinv!=-1 && selectedline!=-1){
            InvoiceHeader InvT=Frame.getInvoices().get(selectedinv);
            InvT.getLine().remove(selectedline);
            linetableModel linetableModel=new linetableModel(InvT.getLine());
            Frame.getItemtable().setModel(linetableModel);
            linetableModel.fireTableDataChanged();
            Frame.getInvoTableModel().fireTableDataChanged();
            
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int Target=Frame.getInvoicetable().getSelectedRow();
       System.out.println("Selected row:"+Target);
       if(Target!=-1){
        InvoiceHeader InvT=Frame.getInvoices().get(Target);
        Frame.getDate().setText(InvT.getDate());
        Frame.getCustomer().setText(InvT.getName());
        Frame.getTotalinov().setText(""+InvT.getTotalinvoprice());
        Frame.getNumber().setText(""+InvT.getNum());
        linetableModel Lines=new linetableModel(InvT.getLine());
        Frame.getItemtable().setModel(Lines);
        Lines.fireTableDataChanged();
    }
    }

    private void createOK() {
        //invoDialog.putdate();
        String Date=invoDialog.getInvDate().getText();
        String Name=invoDialog.getCusName().getText();
        System.out.println("HII");
        int num=Frame.getnextnum()+1;
        System.out.println(num);
        InvoiceHeader Invoice=new InvoiceHeader(num,Date,Name);
        Frame.getInvoices().add(Invoice);
        Frame.getInvoTableModel().fireTableDataChanged();
        invoDialog.setVisible(false);
        invoDialog.dispose();
        invoDialog=null;
        
    }

    private void createcancel() {
        invoDialog.setVisible(false);
        invoDialog.dispose();
        invoDialog=null;
    }

    private void LineOK() {
        String product=lineDialog.getProductName().getText();
        //String numberst=lineDialog.getNumber().getText();
        //int number=Integer.parseInt(numberst);
        String countst=lineDialog.getCountT().getText();
        int count=Integer.parseInt(countst);
        String pricest=lineDialog.getPriceT().getText();
        int price=Integer.parseInt(pricest);
        if(Frame.getInvoicetable().getSelectedRow()!=-1){
            InvoiceHeader Invoice=Frame.getInvoices().get(Frame.getInvoicetable().getSelectedRow());
            InvoiceLine Line=new InvoiceLine(Invoice.getNum(),product,price,count,Invoice);
            Invoice.getLine().add(Line);
            linetableModel linetableModel=(linetableModel)Frame.getItemtable().getModel();
            linetableModel.fireTableDataChanged();
            Frame.getInvoTableModel().fireTableDataChanged();
        }
        invoDialog.setVisible(false);
        invoDialog.dispose();
        invoDialog=null;
        
    }

    private void LineCancel() {
        lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog=null;
    }
    
}
