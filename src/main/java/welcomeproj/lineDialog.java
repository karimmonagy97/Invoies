/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package welcomeproj;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author dell
 */
public class lineDialog extends JDialog {
    private JLabel number;
    private JTextField numberT;
    private JLabel Product;
    private JTextField ProductName;
    private JLabel count;
    private JTextField countT;
    private JLabel Price;
    private JTextField PriceT;
    private JLabel Total;
    private JLabel TotalT;
    private JButton buttonOK;
    private JButton buttonCancel;
    
    public lineDialog(NewJFrame Frame){
        number =new JLabel("Enter the number of invoice");
        numberT=new JTextField(20);
        Product=new JLabel("Enter the product");
        ProductName=new JTextField(20);
        count=new JLabel("Enter the count");
        countT=new JTextField(20);
        Price=new JLabel("Enter the price");
        PriceT=new JTextField(20);
        //Total=new JLabel("The total is");
      //  int Count=Integer.parseInt(countT.getText());
        //int price=Integer.parseInt(PriceT.getText());
        //int totalPrice=price*Count;
        //String theTotal=Integer.toString(totalPrice);
        //TotalT.setText(theTotal);
        buttonOK=new JButton ("OK");
        buttonCancel= new JButton("Cancel");
        
        buttonOK.addActionListener(Frame.getL());
        buttonCancel.addActionListener(Frame.getL());
        
        buttonOK.setActionCommand("LineOK");
        buttonCancel.setActionCommand("LineCancel");
        
        setLayout(new GridLayout(7,3));
        add(number);
        add(numberT);
        add(Product);
        add(ProductName);
        add(count);
        add(countT);
        add(Price);
        add(PriceT);
        //add(Total);
        //add(TotalT);
        add(buttonOK);
        add(buttonCancel);
        pack();
    }

    public JLabel getNumber() {
        return number;
    }

    public JTextField getProductName() {
        return ProductName;
    }

    public JTextField getCountT() {
        return countT;
    }

    public JTextField getPriceT() {
        return PriceT;
    }
    
    
    
}
