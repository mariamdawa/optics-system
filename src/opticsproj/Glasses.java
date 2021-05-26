/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opticsproj;

/**
 *
 * @author bloodymary
 */
public class Glasses {
     private String code, brand, color, name;
    private double price;
    private int number;

    public Glasses(String code, String brand, String color, String name, double price, int number) {
        this.code = code;
        this.brand = brand;
        this.color = color;
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Glasses(String code, String brand, double price, int number) {
        this.code = code;
        this.brand = brand;
        this.price = price;
        this.number = number;
    }

    

    public String getCode() {
        return code;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
}
