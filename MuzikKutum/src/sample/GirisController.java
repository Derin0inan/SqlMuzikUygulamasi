package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class GirisController implements Initializable {

    @FXML
    private TextField email_kullanici;

    @FXML
    private PasswordField giris_sifreKullanici;

    @FXML
    private Button girisyapButon;

    @FXML
    private Button iptal_kullanici;

    @FXML
    private TextField email_admin;

    @FXML
    private PasswordField sifre_admin;

    @FXML
    private Button girisbuton_admin;

    @FXML
    private Button iptal_admin;

    @FXML
    private TextField AdSoyad_Kayit;

    @FXML
    private Button Kayit_Buton;

    @FXML
    private PasswordField sifre_Kayit;
    @FXML
    private PasswordField sifreTekrar_Kayit;

    @FXML
    private Button Kapat_Buton;

    @FXML
    private TextField abonelik_Tur;

    @FXML
    private TextField email_Kayit;

    @FXML
    private TextField Ulke_kayit;

    @FXML
    private Label asd;

    @FXML
    private Label adminasd;

    @FXML
    private ImageView solResim;

    @FXML
    private Label sifretekrarlabel;

    @FXML
    private Label kayitlabel;


    public void iptalKullaniciOnAction(ActionEvent event) {
        Stage stage = (Stage) iptal_kullanici.getScene().getWindow();
        stage.close();
    }

    public void iptalAdminOnAction(ActionEvent event) {
        Stage stage = (Stage) iptal_admin.getScene().getWindow();
        stage.close();
    }


    public void iptalKayitOnAction(ActionEvent event) {
        Stage stage = (Stage) Kapat_Buton.getScene().getWindow();
        stage.close();
    }
    public void girisbutonadminOnAction(ActionEvent event) {

        if (email_admin.getText().isBlank() == false && sifre_admin.getText().isBlank() == false) {
            adminGirisKontrol();

        } else {
        }

    }
    public void girisyapButonOnAction(ActionEvent event) {

        if (email_kullanici.getText().isBlank() == false && giris_sifreKullanici.getText().isBlank() == false) {
            GirisKontrol();

        } else {
            asd.setText("E-mail ve Sifre Girin.");
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File solDosya = new File("src/resim/anaekran.jpg");
        Image solFoto = new Image(solDosya.toURI().toString());
        solResim.setImage(solFoto);
    }

    public void GirisKontrol() {
        VeriTabaniBaglantisi bag = new VeriTabaniBaglantisi();
        Connection veritabanibaglan = bag.getConnection();
        String girisDogrula = "SELECT count(1) FROM kullanici WHERE e_mailkullanici = '" + email_kullanici.getText() + "'AND sifre= '" + giris_sifreKullanici.getText() + "'";

        try {
            Statement statement = veritabanibaglan.createStatement();

            ResultSet rs = statement.executeQuery(girisDogrula);

            while (rs.next()) {
                if (rs.getInt(1) == 1) {
                    asd.setText("Basarili Giris");
                } else {
                    asd.setText("Hatali Giris");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


    public void anaEkrana(){
        try{
            Stage anaekran= new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("AdminKontrol.fxml"));
            anaekran.initStyle(StageStyle.UNDECORATED);
            anaekran.setScene(new Scene(root, 620, 500));
            anaekran.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    public void adminGirisKontrol() {
        VeriTabaniBaglantisi adbag = new VeriTabaniBaglantisi();
        Connection veritabanibag = adbag.getConnection();
        String girisDogrul = "SELECT count(1) FROM admin WHERE admin_mail = '" + email_admin.getText() + "'AND admin_sifre= '" + sifre_admin.getText() + "'";

        try {
            Statement statement = veritabanibag.createStatement();

            ResultSet rs = statement.executeQuery(girisDogrul);

            while (rs.next()) {
                if (rs.getInt(1) == 1) {
                    adminasd.setText("Basarili Giris");
                    anaEkrana();

                } else {
                    adminasd.setText("Hatali Giris");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void kayitOlButonOnAction(ActionEvent event){
        if(sifre_Kayit.getText().equals(sifreTekrar_Kayit.getText())){
            kayitOlma();
            sifretekrarlabel.setText("");
        }else{
            sifretekrarlabel.setText("Sifreler eslesmiyor.");

        }
    }

    public void kayitOlma(){
        VeriTabaniBaglantisi baglan = new VeriTabaniBaglantisi();

        Connection baglanDB = baglan.getConnection();

        String adsoyad = AdSoyad_Kayit.getText();
        String email = email_Kayit.getText();
        String sifre = sifre_Kayit.getText();
        String ulke = Ulke_kayit.getText();
        String aboneTur = abonelik_Tur.getText();

        String girisKisim = "INSERT INTO kullanici(kullanici_ad, e_mailkullanici, sifre, abonelik_tur, ulke) VALUES ('";
        String degerKisim = adsoyad + "','"+ email + "','"+sifre+ "','"+aboneTur+"','" + ulke+ "')";

        String kayitSon = girisKisim+degerKisim;

        try {
            Statement statement = baglanDB.createStatement();
            statement.executeUpdate(kayitSon);
            kayitlabel.setText("Basari ile kayit olundu.");


        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }

}