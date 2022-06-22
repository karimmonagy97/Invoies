/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sig.model;

/**
 *
 * @author dell
 */
public class InvoiceLine {
    private int num;
    private String Product;
    private int count;
    private double Price;
    private double totproduct;

    public InvoiceLine(int num, String Product, double Price, int count, InvoiceHeader invo) {
        this.num = num;
        this.Product = Product;
        this.count = count;
        this.Price = Price;
        this.invo = invo;
    }
    private InvoiceHeader invo;

    public InvoiceLine(int num, String Product, int count) {
        this.num = num;
        this.Product = Product;
        this.count = count;
    }

    public InvoiceLine(int num, String Product, int count, InvoiceHeader invo) {
        this.num = num;
        this.Product = Product;
        this.count = count;
        this.invo = invo;
    }

    @Override
    public String toString() {
        return "InoviceLine{" + "num=" + num + ", Product=" + Product + ", count=" + count + ", invo=" + invo + '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String Product) {
        this.Product = Product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public InvoiceHeader getInvo() {
        return invo;
    }

    public void setInvo(InvoiceHeader invo) {
        this.invo = invo;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getTotproduct() {
        totproduct=count*Price;
        System.out.println("mgamee3");
        return totproduct;
    }
     public String getAsci(){
        return num+","+Product+","+Price+","+count;
    }
    
}
