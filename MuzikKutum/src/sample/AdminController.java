package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private TextField albumekle_adi;
    @FXML
    private TextField albumekle_sanatci;
    @FXML
    private TextField albumekle_sarki;
    @FXML
    private TextField albumekle_tur;
    @FXML
    private Button albumeklebuton;
    @FXML
    private Button sarkieklebuton;
    @FXML
    private Button sanatcieklebuton;
    @FXML
    private DatePicker sarkiekle_tarih;
    @FXML
    private DatePicker albumekle_tarih;
    @FXML
    private TextField sanatciekle_adi;
    @FXML
    private TextField sanatciekle_ulke;
    @FXML
    private TextField sarkiekle_adi;
    @FXML
    private TextField sarkiekle_sanatci;
    @FXML
    private TextField sarkiekle_tur;
    @FXML
    private TextField sarkiekle_album;
    @FXML
    private TextField sarkiekle_sure;
    @FXML
    private TextField albumguncelle_adi;
    @FXML
    private TextField albumguncelle_sanatci;
    @FXML
    private TextField albumguncelle_sarki;
    @FXML
    private TextField albumguncelle_tur;
    @FXML
    private Button albumguncellebuton;
    @FXML
    private Button sarkiguncellebuton;
    @FXML
    private Button sanatciguncellebuton;
    @FXML
    private DatePicker albumguncelle_tarih;
    @FXML
    private DatePicker sarkiguncelle_tarih;
    @FXML
    private TextField sanatciguncelle_adi;
    @FXML
    private TextField sanatciguncelle_ulke;
    @FXML
    private TextField sarkiguncelle_adi;
    @FXML
    private TextField sarkiguncelle_sanatci;
    @FXML
    private TextField sarkiguncelle_tur;
    @FXML
    private TextField sarkiguncelle_album;
    @FXML
    private TextField sarkiguncelle_sure;
    @FXML
    private TextField albumsil_adi;
    @FXML
    private TextField sarkisil_adi;
    @FXML
    private TextField sanatcisil_adi;
    @FXML
    private Button albumsilbuton;
    @FXML
    private Button sarkisilbuton;
    @FXML
    private Button sanatcisilbuton;

    @FXML
    private TextField sarkiguncelle_id;

    @FXML
    private TextField albumguncelle_id;
    @FXML
    private TextField sanatciguncelle_id;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void albumekleButonOnAction(ActionEvent event) {
         albumEkle();

    }

    public void sanatciekleButonOnAction(ActionEvent event){
        sanatciEkle();

    }

    public void sarkieklebutonOnAction(ActionEvent event){
        sarkiEkle();
    }

    public void albumsilbutonOnAction(ActionEvent event){
        albumSil();
    }
    public void albumEkle(){
        VeriTabaniBaglantisi baglan = new VeriTabaniBaglantisi();

        Connection baglanDB = baglan.getConnection();

        String albumadi = albumekle_adi.getText();
        String albumsanatci = albumekle_sanatci.getText();
        String albumsarki = albumekle_sarki.getText();
        String albumtur = albumekle_tur.getText();
        String albumtarih = albumekle_tarih.getValue().toString();

        String girisKisim = "INSERT INTO album(album_Ad, sanatci, sarki, tarih, tur) VALUES ('";
        String degerKisim = albumadi + "','"+ albumsanatci + "','"+albumsarki+ "','"+albumtarih+"','" + albumtur+ "')";

        String kayitSon = girisKisim+degerKisim;

        try {
            Statement statement = baglanDB.createStatement();
            statement.executeUpdate(kayitSon);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }

    public void sanatciEkle(){
        VeriTabaniBaglantisi baglan = new VeriTabaniBaglantisi();

        Connection baglanDB = baglan.getConnection();

        String sanatciAdi = sanatciekle_adi.getText();
        String ulke = sanatciekle_ulke.getText();

        String girisKisim = "INSERT INTO sanatci(sanatci_Ad,ulke) VALUES ('";
        String degerKisim = sanatciAdi + "','" + ulke + "')";

        String kayitSon = girisKisim+degerKisim;

        try {
            Statement statement = baglanDB.createStatement();
            statement.executeUpdate(kayitSon);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }

    public void albumGuncelleOnAction(ActionEvent event){
        albumGuncelle();
    }


    public void sarkiEkle(){
        VeriTabaniBaglantisi baglan = new VeriTabaniBaglantisi();

        Connection baglanDB = baglan.getConnection();

        String sarkiad = sarkiekle_adi.getText();
        String sanatciad = sarkiekle_sanatci.getText();
        String sarkitarih = sarkiekle_tarih.getValue().toString();
        String album = sarkiekle_album.getText();
        String tur = sarkiekle_tur.getText();
        String sure = sarkiekle_sure.getText();

        String girisKisim = "INSERT INTO sarki(sarki_Ad, sanatci_ad, sarki_tarih, album, tur,sure,dinlenmesayisi) VALUES ('";
        String degerKisim = sarkiad + "','"+ sanatciad + "','"+sarkitarih+ "','"+album+"','" + tur+ "','"+sure+"','"+"10')";

        String kayitSon = girisKisim+degerKisim;

        try {
            Statement statement = baglanDB.createStatement();
            statement.executeUpdate(kayitSon);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }


    public void albumSil(){
        VeriTabaniBaglantisi baglan = new VeriTabaniBaglantisi();

        Connection baglanDB = baglan.getConnection();

        String girisKisim = "delete from album where album_Ad = '"+albumsil_adi.getText()+"' and idalbum <> 0";


        try {
            Statement statement = baglanDB.createStatement();
            statement.executeUpdate(girisKisim);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }

    public void sanatcisilbutonOnAction(ActionEvent event){
        sanatciSil();
    }

    public void sarkisilbutonOnAction(ActionEvent event){
        sarkiSil();
    }

    public void sarkiSil(){
        VeriTabaniBaglantisi baglan = new VeriTabaniBaglantisi();

        Connection baglanDB = baglan.getConnection();

        String girisKisim = "    delete from sarki where sarki_Ad = '"+sarkisil_adi.getText()+"' and idsarki <> 0;\n";


        try {
            Statement statement = baglanDB.createStatement();
            statement.executeUpdate(girisKisim);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }


    public void sanatciSil(){
        VeriTabaniBaglantisi baglan = new VeriTabaniBaglantisi();

        Connection baglanDB = baglan.getConnection();

        String girisKisim = "    delete from sanatci where sanatci_Ad = '"+sanatcisil_adi.getText()+"' and idsanatci <> 0;\n";


        try {
            Statement statement = baglanDB.createStatement();
            statement.executeUpdate(girisKisim);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }

    public void albumGuncelle(){
        VeriTabaniBaglantisi baglan = new VeriTabaniBaglantisi();

        Connection baglanDB = baglan.getConnection();

        String girisKisim = "Update album set album_Ad = '"+albumguncelle_adi.getText()+"' ,sanatci = " +
                "'"+albumguncelle_sanatci.getText()+"' ,sarki = '"+ albumguncelle_sarki.getText()+"' ,tur = " +
                "'"+albumguncelle_tur.getText()+"' ,tarih = '"+albumguncelle_tarih.getValue().toString()+"' where idalbum ="+albumguncelle_id.getText();


        try {
            Statement statement = baglanDB.createStatement();
            statement.executeUpdate(girisKisim);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }


    public void sarkiguncellebutonOnAction(ActionEvent event){
        sarkiGuncelle();
    }


    public void sarkiGuncelle(){
        VeriTabaniBaglantisi baglan = new VeriTabaniBaglantisi();

        Connection baglanDB = baglan.getConnection();

        String girisKisim = "Update sarki set sarki_Ad = '"+sarkiguncelle_adi.getText()+"' ,sanatci_ad = " +
                "'"+sarkiguncelle_sanatci.getText()+"' ,sarki_tarih = '"+ sarkiguncelle_tarih.getValue().toString()+"' ,album = " +
                "'"+sarkiguncelle_album.getText()+"' ,tur = '"+sarkiguncelle_tur.getText()+"' ,sure = '"+ sarkiguncelle_sure.getText()+"' where idsarki ="+sarkiguncelle_id.getText();


        try {
            Statement statement = baglanDB.createStatement();
            statement.executeUpdate(girisKisim);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }


    public void sanatciguncellebutonOnAction(ActionEvent event){
        sanatciGuncelle();
    }

    public void sanatciGuncelle(){
        VeriTabaniBaglantisi baglan = new VeriTabaniBaglantisi();

        Connection baglanDB = baglan.getConnection();

        String girisKisim = "Update sanatci set sanatci_Ad = '"+sanatciguncelle_adi.getText()+ "' , ulke = '"+sanatciguncelle_ulke.getText() +"' where idsanatci ="+sanatciguncelle_id.getText();


        try {
            Statement statement = baglanDB.createStatement();
            statement.executeUpdate(girisKisim);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }

}
