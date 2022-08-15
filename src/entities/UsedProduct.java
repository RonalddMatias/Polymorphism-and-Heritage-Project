package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
    
    //Classe que não pode ser herdade
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

    private Date manufactureDate;

    public UsedProduct(){

    }

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
    
    @Override
    public String priceTag(){
        return getName() 
        + " $ " 
        + String.format("%.2f", getPrice()) //Usa o getPrice() porque isso é uma método de outra classe.
        + "(Manufacture date: "
        + sdf.format(manufactureDate) //Datas tem que ser impressas dessa forma, se não vai sair com um formato diferente.
        +")";
    }

}
