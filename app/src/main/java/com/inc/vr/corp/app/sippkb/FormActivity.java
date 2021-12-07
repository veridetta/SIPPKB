package com.inc.vr.corp.app.sippkb;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.gkemon.XMLtoPDF.PdfGenerator;
import com.gkemon.XMLtoPDF.PdfGeneratorListener;
import com.gkemon.XMLtoPDF.model.FailureResponse;
import com.gkemon.XMLtoPDF.model.SuccessResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FormActivity extends AppCompatActivity {
    CardView home, submit, pindah;
    File form_1,form_2,form_3;
    Spinner enam_1, enam_2, delapan_1, delapan_2,sembilan,sepuluh_1,sepuluh_2, duabelas,tigabelas,adua,aempat,alima_1, alima_2,
            alima_3,alima_4, aenam, asembilan_1, asembilan_2, asebelas_1, asebelas_2, asebelas_3, asebelas_4
            , asepuluh,limabelas;
    EditText tiga;
    String[] enam, delapans, sembilans, sepuluh, duabelass,tigabelass,yatidak,aenams,asepuluhs,limabelass;
    ArrayAdapter<String> enam_1Adapter, enam_2Adapter, delapanAdapter, sembilanAdapter,sepuluh_1Adapter,sepuluh_2Adapter
            , duabelasAdapter, tigabelasAdapter,aduaAdapter,aempatAdapter,aenamAdapter, asepuluhAdapter,limabelasAdapter;
    boolean connected = false;
    ArrayList<Uri> files = new ArrayList<Uri>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        tiga = findViewById(R.id.tiga);
        home = findViewById(R.id.btn_home);

        submit = findViewById(R.id.submit);
        String date = new SimpleDateFormat("dd-M-yyy", Locale.getDefault()).format(new Date());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle("Konfirmasi Selesai")
                        .setMessage("Pastikan internet telah terhubung")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                                    //we are connected to a network
                                    connected = true;
                                } else{
                                    connected = false;
                                }
                                if(connected){
                                    String nama_file = tiga.getText()+"-"+date;
                                    String nama_folder ="DataKB";
                                    Toast.makeText(FormActivity.this, "Terhubung", Toast.LENGTH_SHORT).show();
                                    //LinearLayout formsatu = findViewById(R.id.form_satu);
                                    //LinearLayout formdua = findViewById(R.id.form_dua);
                                    //LinearLayout formtiga = findViewById(R.id.form_tiga);
                                    //setPDF(formsatu,nama_file+"1","KB");
                                    //setPDF(formdua,nama_file+"2","KB");
                                    //setPDF(formtiga,nama_file+"3","KB");
                                    //files.add(Uri.fromFile(form_1));
                                    //files.add(Uri.fromFile(form_2));
                                    //files.add(Uri.fromFile(form_3));
                                    //-------------------------------
                                    EditText satu_1, satu_2, satu_3, satu_4, dua, empat_1, empat_2, lima_1, lima_2;
                                    //----------------------
                                    satu_1 = findViewById(R.id.satu_1);
                                    satu_2 = findViewById(R.id.satu_2);
                                    satu_3 = findViewById(R.id.satu_3);
                                    satu_4 = findViewById(R.id.satu_4);
                                    String kode_faskes = satu_1.getText().toString()+"-"+satu_2.getText().toString()+"-"+satu_3.getText().toString()+"-"+satu_4.getText().toString();
                                    //-----------------------
                                    dua = findViewById(R.id.dua);
                                    String nip = dua.getText().toString();
                                    //-----------------------
                                    String nama_p = tiga.getText().toString();
                                    //------------------------------
                                    empat_1 = findViewById(R.id.empat_1);
                                    empat_2 = findViewById(R.id.empat_2);
                                    String tgl = empat_1.getText().toString();
                                    String umur = empat_2.getText().toString();
                                    //---------------------
                                    lima_1 = findViewById(R.id.lima_1);
                                    lima_2 = findViewById(R.id.lima_2);
                                    String nama_su = lima_1.getText().toString();
                                    String nama_is = lima_2.getText().toString();
                                    //---------------------
                                    Spinner enam_1, enam_2;
                                    enam_1 = findViewById(R.id.enam_1);
                                    enam_2 = findViewById(R.id.enam_2);
                                    String p_su = enam_1.getSelectedItem().toString();
                                    String p_is = enam_2.getSelectedItem().toString();
                                    //-----------------------
                                    EditText tujuh;
                                    tujuh = findViewById(R.id.tujuh);
                                    String alamat = tujuh.getText().toString();
                                    //----------------------
                                    Spinner delapan_1, delapan_2;
                                    delapan_1 = findViewById(R.id.delapan_1);
                                    delapan_2 = findViewById(R.id.delapan_2);
                                    String pe_su = delapan_1.getSelectedItem().toString();
                                    String pe_is = delapan_2.getSelectedItem().toString();
                                    //----------------------
                                    Spinner sembilan = findViewById(R.id.sembilan);
                                    String asu = sembilan.getSelectedItem().toString();
                                    //---------------
                                    Spinner sepuluh_1, sepuluh_2;
                                    sepuluh_1 = findViewById(R.id.sepuluh_1);
                                    sepuluh_2 = findViewById(R.id.sepuluh_2);
                                    String h_l = sepuluh_1.getSelectedItem().toString();
                                    String h_p = sepuluh_2.getSelectedItem().toString();
                                    //---------------
                                    EditText sebelas_1 = findViewById(R.id.sebelas_1);
                                    EditText sebelas_2 = findViewById(R.id.sebelas_2);
                                    String hi_t =  sebelas_1.getText().toString();
                                    String hi_b = sebelas_2.getText().toString();
                                    //--------------------
                                    Spinner duabelas = findViewById(R.id.duabelas);
                                    String status = duabelas.getSelectedItem().toString();
                                    //------------------
                                    Spinner tigabelas = findViewById(R.id.tigabelas);
                                    String akhir = tigabelas.getSelectedItem().toString();
                                    //----------------
                                    EditText asatu_1 = findViewById(R.id.Asatu_1);
                                    EditText asatu_2 = findViewById(R.id.Asatu_2);
                                    EditText asatu_3 = findViewById(R.id.Asatu_3);
                                    String haid = asatu_1.getText().toString()+"-"+asatu_2.getText().toString()+"-"+asatu_3.getText().toString();
                                    //--------------
                                    Spinner adua = findViewById(R.id.Adua);
                                    String duga = adua.getSelectedItem().toString();
                                    //----------------
                                    EditText atiga_1 = findViewById(R.id.Atiga_1);
                                    String gra = atiga_1.getText().toString();
                                    EditText atiga_2 = findViewById(R.id.Atiga_2);
                                    String par = atiga_2.getText().toString();
                                    EditText atiga_3 = findViewById(R.id.Atiga_3);
                                    String abor = atiga_3.getText().toString();
                                    //------------------
                                    Spinner aempat = findViewById(R.id.Aempat);
                                    String susu = aempat.getSelectedItem().toString();
                                    //----------------
                                    Spinner alima_1 = findViewById(R.id.Alima_1);
                                    String kuning = alima_1.getSelectedItem().toString();
                                    Spinner alima_2 = findViewById(R.id.Alima_2);
                                    String darah = alima_2.getSelectedItem().toString();
                                    Spinner alima_3 = findViewById(R.id.Alima_3);
                                    String putih = alima_3.getSelectedItem().toString();
                                    Spinner alima_4 = findViewById(R.id.Alima_4);
                                    String tumor_1 = alima_4.getSelectedItem().toString();
                                    //----------------
                                    Spinner aenam = findViewById(R.id.Aenam);
                                    String umum = aenam.getSelectedItem().toString();
                                    //---------
                                    EditText atujuh = findViewById(R.id.Atujuh);
                                    String berat = atujuh.getText().toString();
                                    //---------------
                                    EditText adelapan = findViewById(R.id.Adelapan);
                                    String tek = adelapan.getText().toString();
                                    //------------
                                    Spinner asembilan_1 = findViewById(R.id.Asembilan_1);
                                    String radang = asembilan_1.getSelectedItem().toString();
                                    Spinner asembilan_2 = findViewById(R.id.Asembilan_2);
                                    String tumor = asembilan_2.getSelectedItem().toString();
                                    //--------------
                                    Spinner asepuluh = findViewById(R.id.Asepuluh);
                                    String posisi = asepuluh.getSelectedItem().toString();
                                    //------------------
                                    Spinner asebelas_1 = findViewById(R.id.Asebelas_1);
                                    String diab = asebelas_1.getSelectedItem().toString();
                                    Spinner asebelas_2 = findViewById(R.id.Asebelas_2);
                                    String beku = asebelas_2.getSelectedItem().toString();
                                    Spinner asebelas_3 = findViewById(R.id.Asebelas_3);
                                    String orc = asebelas_3.getSelectedItem().toString();
                                    Spinner asebelas_4 = findViewById(R.id.Asebelas_4);
                                    String tumor2 = asebelas_4.getSelectedItem().toString();
                                    //---------------
                                    CheckBox aduabelas_1,aduabelas_2,aduabelas_3,aduabelas_4,aduabelas_5,
                                            aduabelas_6,aduabelas_7,aduabelas_8,aduabelas_9,aduabelas_10;
                                    String boleh = "";
                                    aduabelas_1 = findViewById(R.id.Aduabelas_1);
                                    if(aduabelas_1.isChecked()){
                                        boleh += ", "+aduabelas_1.getText().toString();
                                    }
                                    aduabelas_2 = findViewById(R.id.Aduabelas_2);
                                    if(aduabelas_2.isChecked()){
                                        boleh += ", "+aduabelas_2.getText().toString();
                                    }
                                    aduabelas_3 = findViewById(R.id.Aduabelas_3);
                                    if(aduabelas_3.isChecked()){
                                        boleh += ", "+aduabelas_3.getText().toString();
                                    }
                                    aduabelas_4 = findViewById(R.id.Aduabelas_4);
                                    if(aduabelas_4.isChecked()){
                                        boleh += ", "+aduabelas_4.getText().toString();
                                    }
                                    aduabelas_5 = findViewById(R.id.Aduabelas_5);
                                    if(aduabelas_5.isChecked()){
                                        boleh += ", "+aduabelas_5.getText().toString();
                                    }
                                    aduabelas_6 = findViewById(R.id.Aduabelas_6);
                                    if(aduabelas_6.isChecked()){
                                        boleh += ", "+aduabelas_6.getText().toString();
                                    }
                                    aduabelas_7 = findViewById(R.id.Aduabelas_7);
                                    if(aduabelas_7.isChecked()){
                                        boleh += ", "+aduabelas_7.getText().toString();
                                    }
                                    aduabelas_8 = findViewById(R.id.Aduabelas_8);
                                    if(aduabelas_8.isChecked()){
                                        boleh += ", "+aduabelas_8.getText().toString();
                                    }
                                    aduabelas_9 = findViewById(R.id.Aduabelas_9);
                                    if(aduabelas_9.isChecked()){
                                        boleh += ", "+aduabelas_9.getText().toString();
                                    }
                                    aduabelas_10 = findViewById(R.id.Aduabelas_10);
                                    if(aduabelas_10.isChecked()){
                                        boleh += ", "+aduabelas_10.getText().toString();
                                    }
                                    //------------------
                                    Spinner limabelas = findViewById(R.id.limabelas);
                                    String pilih = limabelas.getSelectedItem().toString();
                                    //------------
                                    EditText enambelas_1 = findViewById(R.id.enambelas_1);
                                    EditText enambelas_2 = findViewById(R.id.enambelas_2);
                                    EditText enambelas_3 = findViewById(R.id.enambelas_3);
                                    String layani = enambelas_1.getText().toString()+"-"+enambelas_2.getText().toString()+"-"+enambelas_3.getText().toString();
                                    ///------------------
                                    EditText tujuhbelas_1 = findViewById(R.id.tujuhbelas_1);
                                    EditText tujuhbelas_2 = findViewById(R.id.tujuhbelas_2);
                                    EditText tujuhbelas_3 = findViewById(R.id.tujuhbelas_3);
                                    String ulang = tujuhbelas_1.getText().toString()+"-"+tujuhbelas_2.getText().toString()+"-"+tujuhbelas_3.getText().toString();
                                    ///------------------
                                    EditText delapanbelas_1 = findViewById(R.id.delapanbelas_1);
                                    EditText delapanbelas_2 = findViewById(R.id.delapanbelas_2);
                                    EditText delapanbelas_3 = findViewById(R.id.delapanbelas_3);
                                    String cabut = delapanbelas_1.getText().toString()+"-"+delapanbelas_2.getText().toString()+"-"+delapanbelas_3.getText().toString();
                                    //----------------
                                    EditText sembilanbelas = findViewById(R.id.sembilanbelas);
                                    String bidan = sembilanbelas.getText().toString();
                                    sendEmail("Data KB "+tiga.getText(),"Berikut lampiran file",
                                            html(kode_faskes,nip,nama_p,tgl,umur,nama_su,nama_is,p_su,p_is,alamat,pe_su,pe_is,
                                                    asu,h_l,h_p,hi_t,hi_b,status,akhir,haid,duga,gra,par, abor,susu,kuning,darah,
                                                    putih,tumor_1,umum,berat,tek,radang,tumor,posisi,diab,beku,orc,tumor2,boleh,
                                                    pilih,layani, ulang,cabut,bidan));
                                }else{
                                    Toast.makeText(FormActivity.this, "Tidak ada koneksi internet, jawaban kamu belum terkirim", Toast.LENGTH_SHORT).show();
                                }
                            }})
                        .setNegativeButton(android.R.string.no, null).show();

            }
        });
        pindah = findViewById(R.id.pindah);
        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(FormActivity.this, ResultActivity.class);
                intent.putExtra("nama",tiga.getText());
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(FormActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        enam = new String[]{"Tidak Tamat SD/MI","Tamat SD/MI", "Tamat SLTP/MTSN", "TAMAT SLTA/SMA","Tamat PT","Tidak Sekolah"};
        enam_1 = findViewById(R.id.enam_1);
        enam_1Adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, enam);
        enam_1.setAdapter(enam_1Adapter);
        enam_2 = findViewById(R.id.enam_2);
        enam_2Adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, enam);
        enam_2.setAdapter(enam_2Adapter);
        delapans = new String[]{"Petani","Nelayan","Pedagang","PNS/TNI/POLRI","Pegawai Swasta","Wiraswasta","Pensiunan",
                "Pekerja Lepas","Lainnya","Tidak Bekerja"};
        delapan_1 = findViewById(R.id.delapan_1);
        delapanAdapter  = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, delapans);
        delapan_1.setAdapter(delapanAdapter);
        delapan_2 = findViewById(R.id.delapan_2);
        delapan_2.setAdapter(delapanAdapter);
        sembilans = new String[]{"BJS Kesehatan","Lainnya","Tidak"};
        sembilan = findViewById(R.id.sembilan);
        sembilanAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,sembilans);
        sembilan.setAdapter(sembilanAdapter);
        sepuluh = new String[]{"0","1","2","3","4","5","6","7","8","9","10"};
        sepuluh_1 = findViewById(R.id.sepuluh_1);
        sepuluh_1Adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sepuluh);
        sepuluh_1.setAdapter(sepuluh_1Adapter);
        sepuluh_2 = findViewById(R.id.sepuluh_2);
        sepuluh_2Adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sepuluh);
        sepuluh_2.setAdapter(sepuluh_2Adapter);
        duabelass   = new String[]{"Baru Pertama Kali","Pernah pakai alat KB berhenti sesudah bersalin/keguguran",
                "Pernah pakai alat KB","Sedang ber-KB"};
        duabelas = findViewById(R.id.duabelas);
        duabelasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,duabelass);
        duabelas.setAdapter(duabelasAdapter);
        tigabelass   = new String[]{"Suntikan 1 Bulanan","Suntikan 3 Bulanan","Pil","Kondom","Implan 1 Batang","Implan 2 Batang",
                "IUD CuT 380A","IUD Lain-lain","Tubektomi","Vasektomi"};
        tigabelas = findViewById(R.id.tigabelas);
        tigabelasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,tigabelass);
        tigabelas.setAdapter(tigabelasAdapter);
        yatidak   = new String[]{"Ya","Tidak"};
        adua = findViewById(R.id.Adua);
        aduaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,yatidak);
        adua.setAdapter(aduaAdapter);
        aempat = findViewById(R.id.Aempat);
        aempatAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,yatidak);
        aempat.setAdapter(aempatAdapter);
        alima_1 = findViewById(R.id.Alima_1);
        alima_1.setAdapter(aempatAdapter);
        alima_2 = findViewById(R.id.Alima_2);
        alima_2.setAdapter(aempatAdapter);
        alima_3 = findViewById(R.id.Alima_3);
        alima_3.setAdapter(aempatAdapter);
        alima_4 = findViewById(R.id.Alima_4);
        alima_4.setAdapter(aempatAdapter);
        aenams   = new String[]{"Baik","Sedang","Kurang"};
        aenam = findViewById(R.id.Aenam);
        aenamAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,aenams);
        aenam.setAdapter(aenamAdapter);
        asembilan_1 = findViewById(R.id.Asembilan_1);
        asembilan_1.setAdapter(aempatAdapter);
        asembilan_2 = findViewById(R.id.Asembilan_2);
        asembilan_2.setAdapter(aempatAdapter);
        asebelas_1 = findViewById(R.id.Asebelas_1);
        asebelas_1.setAdapter(aempatAdapter);
        asebelas_2 = findViewById(R.id.Asebelas_2);
        asebelas_2.setAdapter(aempatAdapter);
        asebelas_3 = findViewById(R.id.Asebelas_3);
        asebelas_3.setAdapter(aempatAdapter);
        asebelas_4 = findViewById(R.id.Asebelas_4);
        asebelas_4.setAdapter(aempatAdapter);
        asepuluhs   = new String[]{"Retroflexi", "Antefleksi"};
        asepuluh = findViewById(R.id.Asepuluh);
        asepuluhAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,asepuluhs);
        asepuluh.setAdapter(asepuluhAdapter);
        limabelass   = new String[]{"Suntikan 1 Bulanan", "Sunitkan 3 Bulanan","Pil", "Kondom",
        "Implan 1 Batang","Implan 2 Batang","IUD CuT 380A","IUD Lain-lain","Tubektomi","Vasektomi"};
        limabelas = findViewById(R.id.limabelas);
        limabelasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,limabelass);
        limabelas.setAdapter(limabelasAdapter);

    }
    public void setPDF(LinearLayout view, String nama_file,String nama_folder){
        AlertDialog ad = new AlertDialog.Builder(this).create();
        //final File[] file = new File[1];
        PdfGenerator.getBuilder()
                .setContext(FormActivity.this)
                .fromViewSource()
                .fromView(view)
                .setFileName(nama_file)
                .setFolderName(nama_folder)
                .openPDFafterGeneration(false)
                .build(new PdfGeneratorListener() {
                    @Override
                    public void onFailure(FailureResponse failureResponse) {
                        super.onFailure(failureResponse);
                    }

                    @Override
                    public void showLog(String log) {
                        super.showLog(log);
                    }

                    @Override
                    public void onStartPDFGeneration() {
                        /*When PDF generation begins to start*/
                        ad.setMessage(" Sedang memproses data ..");
                        ad.show();
                    }

                    @Override
                    public void onFinishPDFGeneration() {
                        /*When PDF generation is finished*/

                    }

                    @Override
                    public void onSuccess(SuccessResponse response) {
                        super.onSuccess(response);
                        ad.hide();
                        finish();
                        PackageManager m = getPackageManager();
                        String s = getPackageName();
                        try {
                            PackageInfo p = m.getPackageInfo(s, 0);
                            s = p.applicationInfo.dataDir;
                        } catch (PackageManager.NameNotFoundException e) {
                            Log.w("yourtag", "Error Package name not found ", e);
                        }
                        //file[0] = response.getFile();
                        files.add(Uri.fromFile(response.getFile()));
                        // File from = new File("file:///"+s+"/"+nama_folder+"/"+nama_file+".pdf");
                        //sendEmail("Data KB "+tiga.getText(),"Berikut lampiran file",response.getFile());
                    }
                });
        //return file[0];
    }
    protected void sendEmail(String subject, String isi, /*ArrayList<Uri> file*/ String ht) {
        Log.i("Send email", "");
        //String[] TO = {"veridetta@gmail.com "};
        String[] TO = {"uptdpakecamatanmundu@gmail.com "};
        String[] CC = {"akhyarputraprasetyoo@gmail.com"};
        //Log.d("EMAIL", "sendEmail: "+file);
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/html");
        //emailIntent.setType("application/pdf");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        //emailIntent.putExtra(Intent.EXTRA_TEXT, isi);
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml(ht));
       // emailIntent.putExtra(Intent.EXTRA_STREAM, file);
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(FormActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
    public String html(String kode_faskes, String nip, String nama_p, String tgl, String umur,
                       String nama_su, String nama_is, String p_su, String p_is, String alamat,
                       String pe_su, String pe_is, String asu,  String hi_l,
                       String hi_p, String hi_t, String hi_b, String status, String akhir,
                       String haid, String duga, String gra, String par, String abor,
                       String susu, String kuning, String darah, String putih, String tumor_1, String umum, String berat, String tek,
                       String radang, String tumor, String posisi, String diab, String beku,
                       String orc, String tumor2, String boleh, String pilih, String layani,
                       String ulang, String cabut, String bidan){
        String hh;
        hh ="<p>I. Kode faskes KB Jaringan/Jejaring : "+ kode_faskes +"</p> \n"+
        "<p>II. Nomor Induk Kependudukan : "+ nip +"</p> \n"+
                "<p>III. Nama Peserta KB : "+ nama_p +"</p> \n"+
                "<p>IV. Tgl Lahir/ Umur Istri : "+ tgl +"/"+umur+"</p> \n"+
                "<p>V. Nama Suami/Istri : </p> \n"+
                "<p>Suami : "+ nama_su +"</p> \n"+
                "<p>Istri : "+ nama_is +"</p> \n\n"+
                "<p>VI. Pendidikan Suami dan Istri\n"+
                "<p>Suami : "+ p_su +"</p> \n"+
                "<p>Istri : "+ p_is +"</p> \n\n"+
                "<p>VII. Alamat Peserta KB : "+ alamat +"</p> \n"+
                "<p>VIII. Pekerjaan Suami dan Istri</p> \n"+
                "<p>Suami : "+ pe_su +"</p> \n"+
                "<p>Istri : "+ pe_is +"</p> \n\n"+
                "<p>IX. Penggunaan Asuransi : "+ asu +"</p> \n"+
                "<p>X. Jumlah Anak Hidup :  </p> \n"+
                "<p>Laki-laki : "+ hi_l +"</p> \n"+
                "<p>Perempuan : "+ hi_p +"</p> \n\n"+
                "<p>XI. Umur anak terakhir yang masih hidup : "+hi_t+" tahun "+hi_b+" bulan</p> \n"+
                "<p>XII. Status Peserta KB : "+ status +"</p> \n"+
                "<p>XIII. Alat/Obat/Cara KB Terakhir : "+ akhir +"</p> \n\n"+
                "<p>XIV. Penapisan (Skrining) untuk menentukan alat kontrasepsi yang dapat digunakan calon peserta KB</p> \n"+
                "<p>Petunjuk :</p> \n"+
                        "<p>Periksalah kedaan berikut ini dan hasilnya ditulis dengan angka atau tanda centang pada kotak yang tersedia</p> \n"+
                        "<p>Penapisan (Skrining) hanya boleh dilakukan oleh pelaksanaan yang telah dilatih dalam pelayanan KB</p> \n\n"+
                        "<p>Anamnese</p> \n"+
                        "<p>1. Haid terakhir tanggal : "+ haid +"</p> \n"+
                        "<p>2. Hamil/Diduga Hamil : "+ duga +"</p> \n"+
                        "<p>3. Jumlah GPA :</p> \n"+
                "<p>Gravida (Kehamilan) : "+ gra+"</p> \n"+
                "<p>Partus (Persalinan) : "+ par +"</p> \n"+
                "<p>Abortus (Keguguran) : "+ abor +"</p> \n"+
                "<p>Menyusui : "+ susu +"</p> \n\n"+
                "<p>Riwayat Penyakit sebelumnya :</p> \n"+
                "<p>a. Sakit kuning : "+ kuning +"</p> \n"+
                "<p>b. Pendarahan pervaginan yang tidak diketahui sebabnya : "+ darah +"</p> \n"+
                "<p>c. Keputihan yang lama : "+ putih +"</p> \n"+
                "<p>d. Tumor : "+tumor_1+"</p> \n"+
                "<p>- Payudara</p>  \n"+
                "<p>- Rahim </p> \n"+
                "<p>- Indung Telur </p> \n\n"+
                "<p>-----------------------------------------</p> \n"+
                "<p>- Bila semua jawaban TIDAk, dapat diberikan salah satu dari cara KB (kecuali IUD dan Tubektomi).</p> \n"+
                "<p>- Bila salah satu jawaban YA, rujuk ke dokter.</p> \n"+
                "<p>-----------------------------------------</p> \n\n"+
                "<p>Pemeriksaan</p> \n"+
                "<p>6. Keadaan Umum : "+ umum + "</p> \n"+
                "<p>7. Berat Badan : "+ berat+ "kg </p> \n"+
                "<p>8. Tekanan Darah : "+ tek+ "</p> \n"+
                "<p>9. Sebelum dilakukan pemasangan IUD atau Tubektomi dilakukan pemeriksaan dalam</p> \n"+
                "<p>a. Tanda-tanda radang : "+radang+ "</p> \n"+
                "<p>b. Tumor/keganasan ginekologi : "+ tumor+ "</p> \n\n"+
                "<p>-------------------------------------------</p> \n"+
                "<p>Bila semua jawaban TIDAK, pemasangan IUD atau tindakan Tubektomi dapat dilakukan. Bila salah satu jawaban YA, rujuk ke dokter</p> \n"+
                "<p>-------------------------------------------\n\n"+
                "<p>10. Posisi Rahim : "+posisi+ "</p> \n"+
                "<p>11. Pemeriksaan tambahan(khusus untuk calon Vasektomi dan Tubektomi)</p> \n"+
                "<p>a. Tanda-tanda diabetes : "+ diab+ "</p> \n"+
                "<p>b. Kelainan pembekuan darah : "+ beku+ "</p> \n"+
                "<p>c. Radang orchitis/epididymitis : "+orc+ "</p> \n"+
                "<p>d. Tumor/keganasan ginekologi : "+tumor2+ "</p> \n\n"+
                "<p>-------------------------------------------</p> \n"+
                "<p>Bila semua jawaban TIDAk, dapat dilakukan Vasektomi. Bila salah satu jawaban YA, maka rujuklah ke Faskes KB/Rumah Sakit yang lengkap.</p> \n"+
                "<p>-------------------------------------------</p> \n\n"+
                "<p>12. Alat/obat/cara kontrasepsi yang boleh dipergunakan : "+boleh+ "</p> \n\n"+
                "<p>XV. Alat/Obat/Cara Kontrasepsi yang dipilih : "+pilih+ "</p> \n"+
                "<p>XVI. Tanggal dilayani : "+layani+ "</p> \n"+
                "<p>XVII. Tanggal Kunjungan ulang : "+ ulang+ "</p> \n"+
                "<p>XVIII. Tanggal dicabut (Khsusu Implan/IUD) : "+cabut+ "</p> \n\n"+
                "<p>----------------------------------</p> \n"+
                "<p>XIX. Penanggungjawab Pelayanan KB</p> \n"+
                "<p>Dokter/Bidan/Perawat Kesehatan</p> /\n\n"+
                "<p>"+bidan+"</p>";
        return hh;
    }
}