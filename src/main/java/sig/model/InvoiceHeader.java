/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sig.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sound.sampled.Line;

/**
 *
 * @author dell
 */
public class InvoiceHeader {
    private int num;
    private String Name;
    private String Date;
    private ArrayList<InvoiceLine > Line;
    //private double totalinvoprice;

    public InvoiceHeader(int num, String Date,String Name) {
        this.num = num;
        this.Name = Name;
        this.Date = Date;
    }

    public ArrayList<InvoiceLine> getLine() {
        if(Line==null){
            Line=new ArrayList<>();
        }
        return Line;
    }


    public int getNum() {
        return num;
    }

    public String getName() {
        return Name;
    }

    public String getDate() {
        return Date;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "InoviceHeader{" + "num=" + num + ", Name=" + Name + ", Date=" + Date + '}';
    }

    public double getTotalinvoprice() {
        double totalinvoprice=0;
      for(int i=0;i<this.getLine().size();i++){
          totalinvoprice+=Line.get(i).getTotproduct();
          System.out.println("magmoo3");
        }
        return totalinvoprice;
    }

    public String getAsci(){
        System.out.println("i was here");
        return num+","+Name+","+Date;
        
    }
}
