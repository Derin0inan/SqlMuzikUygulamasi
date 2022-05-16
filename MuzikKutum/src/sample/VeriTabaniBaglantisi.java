package sample;
import java.sql.*;

public class VeriTabaniBaglantisi {
    public Connection veritabaniLink;
    public Connection getConnection(){
        String veritabani_Ad="muzikkutusu_db";
        String veritabaniKullanici="root";
        String veritabani_parola="1234";
        String url= "jdbc:mysql://localhost:3307/"+veritabani_Ad;
        try{


            Class.forName("com.mysql.cj.jdbc.Driver");
            veritabaniLink= DriverManager.getConnection(url,veritabaniKullanici,veritabani_parola);
            System.out.println("Baglandi");

        }catch (Exception e){
            System.out.printf("Baglanti Kötü");
            e.printStackTrace();
            e.getCause();

        }
        return veritabaniLink;
    }

}
