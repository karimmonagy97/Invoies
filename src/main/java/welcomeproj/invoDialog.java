/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package welcomeproj;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author dell
 */
public class invoDialog extends JDialog {
    private JTextField cusName;
    private JTextField invDate;
    private JLabel customerName;
    private JLabel invDateL;
    private JButton buttonOk;
    private JButton buttonCancel;
    public invoDialog(NewJFrame Frame){
        customerName=new JLabel("Customer Name");
        cusName=new JTextField(20);
        invDateL=new JLabel("Date is");
        //SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        //Date d=new Date();
        //invDate.setText(s.format(d));
        invDate=new JTextField(20);
        buttonOk=new JButton("OK");
        buttonCancel=new JButton("Cancel");
        
        buttonOk.setActionCommand("createOK");
        buttonCancel.setActionCommand("createcancel");
        
        buttonOk.addActionListener(Frame.getL());
        buttonCancel.addActionListener(Frame.getL());
        
        setLayout(new GridLayout(4,2));
        
        add(invDateL);
        add(invDate);
        add(customerName);
        add(cusName);
        add(buttonOk);
        add(buttonCancel);
        
        pack();
        
    }

    public JTextField getCusName() {
        return cusName;
    }

    public JTextField getInvDate() {
        return invDate;
    }
    public void putdate(){
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date();
        invDate.setText(s.format(d));
    }
}
