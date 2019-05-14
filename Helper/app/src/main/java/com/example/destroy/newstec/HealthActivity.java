package com.example.destroy.newstec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.destroy.helper.R;

public class HealthActivity extends AppCompatActivity {
    private Spinner dvsn;
    private Spinner regin;
    ArrayAdapter<CharSequence>division;
    ArrayAdapter<CharSequence>regionselect;

    private Toolbar toolbar;
    private LinearLayout hlayout;
    private WebView hWebView;
    private WebSettings hwebSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        toolbar=(Toolbar)findViewById(R.id.doctorhelp);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hospital");


        dvsn=(Spinner)findViewById(R.id.division);
        regin=(Spinner)findViewById(R.id.hospital);

       hWebView=findViewById(R.id.healthinfo);
       hlayout=(LinearLayout)findViewById(R.id.website);

        division=ArrayAdapter.createFromResource(this,
                R.array.all_division_select,android.R.layout.simple_spinner_item);
        division.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dvsn.setAdapter(division);


        dvsn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String string=parent.getItemAtPosition(position).toString();
                if (string.equals("Dhaka")){
                    regionselect=ArrayAdapter.createFromResource(HealthActivity.this,
                            R.array.dhaka_division,android.R.layout.simple_spinner_item);
                    regionselect.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    regin.setAdapter(regionselect);

                    regin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String dhakareg=parent.getItemAtPosition(position).toString();

                            if (dhakareg.equals("Square Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                               hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://www.squarehospital.com/");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                          else  if (dhakareg.equals("Apollo Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://www.apollodhaka.com/");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                          else  if (dhakareg.equals("Labaid Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://labaidgroup.com/specialized/doctor");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                         else   if (dhakareg.equals("IbnSina Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://www.ibnsinatrust.com/find_a_doctor.php");
                                hWebView.setWebViewClient(new WebViewClient());


                            }
                          else  if (dhakareg.equals("Popular Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("https://www.populardiagnostic.com/");
                                hWebView.setWebViewClient(new WebViewClient());


                            }
                           else if (dhakareg.equals("Samorita Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://mhsamorita.edu.bd/");
                                hWebView.setWebViewClient(new WebViewClient());


                            }
                          else  if (dhakareg.equals("United Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://www.uhlbd.com/");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                          else  if (dhakareg.equals("Green Life")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("https://gmch-bd.net/");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                           else if (dhakareg.equals("Holy family")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://hfhdelhi.org/contact.html");
                                hWebView.setWebViewClient(new WebViewClient());

                            }


                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

              else  if (string.equals("Rajshahi")){
                    regionselect=ArrayAdapter.createFromResource(HealthActivity.this,
                            R.array.rajshahi_division,android.R.layout.simple_spinner_item);
                    regionselect.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    regin.setAdapter(regionselect);


                    regin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String dhakareg=parent.getItemAtPosition(position).toString();

                            if (dhakareg.equals("Apollo Information Centre")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://blog.emedicalpoint.com/hospitals-in-bangladesh/apollo-hospitals-information-center-bangladesh/");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                            else  if (dhakareg.equals("IslamiBank Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://www.ibfbd.org/institute/hospitals/islami-bank-medical-college-hospital-rajshahi");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                            else  if (dhakareg.equals("Dolphin Clinic")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://www.dolphinclinic.co.nz/");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                            else   if (dhakareg.equals("popular diagnostic")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://www.populardiagnostic.com/single_branch.php?id_sent=14");
                                hWebView.setWebViewClient(new WebViewClient());

                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
               else if (string.equals("Khulna")){
                    regionselect=ArrayAdapter.createFromResource(HealthActivity.this,
                            R.array.khulna_division,android.R.layout.simple_spinner_item);
                    regionselect.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    regin.setAdapter(regionselect);



                    regin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String dhakareg=parent.getItemAtPosition(position).toString();

                            if (dhakareg.equals("Basundhara Diagnostic")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("https://www.nirvor.com/healthcare/medical-provider/basundhara-diagnostic-center-1852");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                            else  if (dhakareg.equals("City Nursing Home")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("https://www.justdial.com/Indore/City-Nursing-Home-Pvt-Ltd-Rajmohalla-Jawahar-Road/0731P731STDK002970_BZDET");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                            else  if (dhakareg.equals("Fair Health Clinic")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("https://findoutadoctor.blogspot.com/2016/08/best-hospital-clinic-in-barisal.html");
                                hWebView.setWebViewClient(new WebViewClient());

                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
               else if (string.equals("Chittagong")){
                    regionselect=ArrayAdapter.createFromResource(HealthActivity.this,
                            R.array.chittagong_division,android.R.layout.simple_spinner_item);
                    regionselect.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    regin.setAdapter(regionselect);


                    regin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String dhakareg=parent.getItemAtPosition(position).toString();

                            if (dhakareg.equals("Chattagram Metropoliton Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://www.emedicalpoint.com/doclist.php?org=Chittagong%20Metropolitan%20Hospital%20Pvt.%20Ltd");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                            else  if (dhakareg.equals("National Hospital Chittagong")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://nationalhospitalctg.com/");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                            else  if (dhakareg.equals("Lions General Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("https://www.justdial.com/Mehsana/Lions-General-Hospital-Near-Doctor-House/9999P2762-2762-100105121310-K7S5_BZDET");
                                hWebView.setWebViewClient(new WebViewClient());

                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                }
              else  if (string.equals("Sylhet")){
                    regionselect=ArrayAdapter.createFromResource(HealthActivity.this,
                            R.array.sylhet_division,android.R.layout.simple_spinner_item);
                    regionselect.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    regin.setAdapter(regionselect);


                    regin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String dhakareg=parent.getItemAtPosition(position).toString();

                            if (dhakareg.equals("Al-Banna General Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://sylhetdirectory.com/burhan-uddin-hospital/");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                            else  if (dhakareg.equals("Burhan Uddin Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://sylhetdirectory.com/burhan-uddin-hospital/");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                            else  if (dhakareg.equals("Modern General Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://sylhetdirectory.com/modern-general-hospital/");
                                hWebView.setWebViewClient(new WebViewClient());

                            }


                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
               else if (string.equals("Barisal")){
                    regionselect=ArrayAdapter.createFromResource(HealthActivity.this,
                            R.array.barishal_division,android.R.layout.simple_spinner_item);
                    regionselect.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    regin.setAdapter(regionselect);

                    regin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String dhakareg=parent.getItemAtPosition(position).toString();

                            if (dhakareg.equals("Ambia Memorial Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://www.emedicalpoint.com/doclist.php?org=Ambia%20Memorial%20Hospital");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                            else  if (dhakareg.equals("Eden Nursing Home")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://www.emedicalpoint.com/search_medical.php?speciality=Clinic+and+Nursing+Home&city=Barisal");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                            else  if (dhakareg.equals("Globe Diagnostic Lab")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("https://www.nirvor.com/healthcare/medical-provider/globe-diagnostic-lab-901");
                                hWebView.setWebViewClient(new WebViewClient());

                            }else  if (dhakareg.equals("Islam Poly Clinic")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://www.sondhan.com/listing/islam-poly-clinic.html");
                                hWebView.setWebViewClient(new WebViewClient());

                            }


                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
               else if (string.equals("Rangpur")){
                    regionselect=ArrayAdapter.createFromResource(HealthActivity.this,
                            R.array.rangpur_division,android.R.layout.simple_spinner_item);
                    regionselect.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    regin.setAdapter(regionselect);

                    regin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String dhakareg=parent.getItemAtPosition(position).toString();

                            if (dhakareg.equals("Good Health Hospital")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("https://www.justdial.com/Guwahati/Dr-Good-Health-Hospital-(Good-Health-Hospital)-Assam-Sachivalaya/9999PX361-X361-150728150300-M7K7_BZDET");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                            else  if (dhakareg.equals("Desh Clinic and Nursing Home")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://facilityregistry.dghs.gov.bd/org_profile.php?org_code=10022939");
                                hWebView.setWebViewClient(new WebViewClient());

                            }
                            else  if (dhakareg.equals("New Rangpur Clinic")){

                                hlayout.setVisibility(View.VISIBLE);
                                hwebSettings = hWebView.getSettings();
                                hwebSettings.setJavaScriptEnabled(true);
                                hWebView.loadUrl("http://www.emedicalpoint.com/doclist.php?org=New%20Rangpur%20Clinic");
                                hWebView.setWebViewClient(new WebViewClient());

                            }


                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        if(hWebView.canGoBack()) {
            hWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
