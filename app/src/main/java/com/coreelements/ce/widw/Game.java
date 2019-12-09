package com.coreelements.ce.widw;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.InterstitialAd;

public class Game extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private InterstitialAd mInterstitialAd;

    ImageButton btnY, sbtn;
    ImageButton btnN;
    TextView aufgabentv, playertv, scoretv, roundtv;
    ListView lv;
    RadioButton rbtnl, rbtnm, rbtns;
    String gamemode;
    int countUL, countUM, countUS, countDL, countDM, countDS, countPL, countPM, countPS, countZL, countZM, countZS, countSL, countSM, countSS, countCL, countCM, countCS, countFL, countFM, countFS;

    int i = 1;
    int count = 1;
    int round = 1;
    int adCount = 0;

    SharedPreferences sPref, sPrefCount, playerSizePref, winnerPref, winnerScorePref, highscorePref, categoryPref;
    SharedPreferences.Editor sPrefEditor, sPrefEditorCount, playerSizePrefEditor, winnerPrefEditor, winnerScorePrefEditor, highscorePrefEditor, categoryPrefEditor;

    List<String> listPlayers = new ArrayList<String>();
    ArrayAdapter<String> adapterPlayers;

    List<String> listUL = new ArrayList<String>();
    ArrayAdapter<String> adapterUL;
    List<String> listUM = new ArrayList<String>();
    ArrayAdapter<String> adapterUM;
    List<String> listUS = new ArrayList<String>();
    ArrayAdapter<String> adapterUS;

    List<String> listDL = new ArrayList<String>();
    ArrayAdapter<String> adapterDL;
    List<String> listDM = new ArrayList<String>();
    ArrayAdapter<String> adapterDM;
    List<String> listDS = new ArrayList<String>();
    ArrayAdapter<String> adapterDS;

    List<String> listPL = new ArrayList<String>();
    ArrayAdapter<String> adapterPL;
    List<String> listPM = new ArrayList<String>();
    ArrayAdapter<String> adapterPM;
    List<String> listPS = new ArrayList<String>();
    ArrayAdapter<String> adapterPS;

    List<String> listZL = new ArrayList<String>();
    ArrayAdapter<String> adapterZL;
    List<String> listZM = new ArrayList<String>();
    ArrayAdapter<String> adapterZM;
    List<String> listZS = new ArrayList<String>();
    ArrayAdapter<String> adapterZS;

    List<String> listSL = new ArrayList<String>();
    ArrayAdapter<String> adapterSL;
    List<String> listSM = new ArrayList<String>();
    ArrayAdapter<String> adapterSM;
    List<String> listSS = new ArrayList<String>();
    ArrayAdapter<String> adapterSS;

    List<String> listCL = new ArrayList<String>();
    ArrayAdapter<String> adapterCL;
    List<String> listCM = new ArrayList<String>();
    ArrayAdapter<String> adapterCM;
    List<String> listCS = new ArrayList<String>();
    ArrayAdapter<String> adapterCS;

    List<String> listFL = new ArrayList<String>();
    ArrayAdapter<String> adapterFL;
    List<String> listFM = new ArrayList<String>();
    ArrayAdapter<String> adapterFM;
    List<String> listFS = new ArrayList<String>();
    ArrayAdapter<String> adapterFS;

    List<String> listAufgaben = new ArrayList<String>();
    ArrayAdapter<String> adapterAufgaben;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_game);

        AdView adViewUP = (AdView)findViewById(R.id.adViewUP);
        AdRequest adRequestUP = new AdRequest.Builder().build();
        adViewUP.loadAd(adRequestUP);

        adapterPlayers = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listPlayers);
        adapterAufgaben = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listAufgaben);

        adapterUL = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listUL);
        adapterUM = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listUM);
        adapterUS = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listUS);

        adapterDL = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listDL);
        adapterDM = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listDM);
        adapterDS = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listDS);

        adapterPL = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listPL);
        adapterPM = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listPM);
        adapterPS = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listPS);

        adapterZL = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listZL);
        adapterZM = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listZM);
        adapterZS = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listZS);

        adapterSL = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listSL);
        adapterSM = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listSM);
        adapterSS = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listSS);

        adapterCL = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listCL);
        adapterCM = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listCM);
        adapterCS = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listCS);

        adapterFL = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listFL);
        adapterFM = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listFM);
        adapterFS = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listFS);

        btnY = (ImageButton) findViewById(R.id.buttonY);
        btnY.setOnClickListener(this);
        btnY.setOnTouchListener(this);

        btnN = (ImageButton) findViewById(R.id.buttonN);
        btnN.setOnClickListener(this);
        btnN.setOnTouchListener(this);

        sbtn = (ImageButton) findViewById(R.id.skipButton);
        sbtn.setOnClickListener(this);
        sbtn.setOnTouchListener(this);

        rbtnl = (RadioButton) findViewById(R.id.leichtRadioButton);
        rbtnl.setOnClickListener(this);

        rbtnm = (RadioButton) findViewById(R.id.mittelRadioButton);
        rbtnm.setOnClickListener(this);

        rbtns = (RadioButton) findViewById(R.id.schwerRadioButton);
        rbtns.setOnClickListener(this);

        lv = (ListView) findViewById(R.id.listView2);

        aufgabentv = (TextView) findViewById(R.id.aufgabenTextView);

        playertv = (TextView) findViewById(R.id.playerTextView);

        scoretv = (TextView) findViewById(R.id.scoreTextView);

        roundtv = (TextView) findViewById(R.id.roundTextView);
        roundtv.setText(getString(R.string.runde) + " " + round);

        sPref = this.getSharedPreferences("PLAYERS", MODE_PRIVATE);
        sPrefEditor = sPref.edit();

        sPrefCount = this.getSharedPreferences("COUNT", MODE_PRIVATE);
        sPrefEditorCount = sPrefCount.edit();

        playerSizePref = this.getSharedPreferences("SIZE", MODE_PRIVATE);
        playerSizePrefEditor = playerSizePref.edit();

        winnerPref = this.getSharedPreferences("WINNER", MODE_PRIVATE);
        winnerPrefEditor = winnerPref.edit();

        winnerScorePref = this.getSharedPreferences("WINNERSCORE", MODE_PRIVATE);
        winnerScorePrefEditor = winnerScorePref.edit();

        highscorePref = this.getSharedPreferences("HIGHSCORE", MODE_PRIVATE);
        highscorePrefEditor = highscorePref.edit();

        categoryPref = this.getSharedPreferences("CATEGORY", MODE_PRIVATE);
        categoryPrefEditor = categoryPref.edit();

        rbtnl.setChecked(true);
        rbtnm.setChecked(false);
        rbtns.setChecked(false);
        gamemode = "leicht";

        getReady();
        addAufgaben();
        setNewExercise();

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle("Achtung");
        alertDialog.setMessage(getString(R.string.safety_first));
        alertDialog.setPositiveButton(getString(R.string.got_it), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), getString(R.string.have_fun), Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();

        showIntersitialAD();

    }

    private void showIntersitialAD() {

        MobileAds.initialize(this, "ca-app-pub-1814335808278709~5325464272");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1814335808278709/7901431125");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
            }
        });
    }

    public void addAufgaben(){
        addUL();
        addUM();
        addUS();

        addDL();
        addDM();
        addDS();

        addPL();
        addPM();
        addPS();

        addZL();
        addZM();
        addZS();

        addSL();
        addSM();
        addSS();

        addCL();
        addCM();
        addCS();

        addFL();
        addFM();
        addFS();

    }

    public void getReady(){
        playertv.setText(sPref.getString("" + i, ""));
        scoretv.setText("" + sPrefCount.getInt("" + i, 0));
    }

    public void addPlayers(){
        int count2 = 1;
        listPlayers.clear();
        while (count2 <= playerSizePref.getInt("playersize", 0)){
            listPlayers.add(sPref.getString("" + count2, "") + " (" + sPrefCount.getInt("" + count2, 0) + "P)");
            count2++;
        }
        lv.setAdapter(adapterPlayers);

    }

    public void disableRadioButtons(){
        rbtnl.setClickable(false);
        rbtnm.setClickable(false);
        rbtns.setClickable(false);
    }

    public void enableRadioButtons(){
        rbtnl.setClickable(true);
        rbtnm.setClickable(true);
        rbtns.setClickable(true);
    }

    @Override
    public void onClick(View v) {
        boolean skip = false;
        boolean skipfail = false;

        if (v.getId() == R.id.leichtRadioButton){
            //if (rbtnl.isChecked() == false) {
                rbtnl.setChecked(true);
                rbtnm.setChecked(false);
                rbtns.setChecked(false);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btnY.setBackground(getDrawable(R.drawable.widw_ybtn25));
                }
                gamemode = "leicht";
                setNewExercise();
                disableRadioButtons();
            //}
        } else if (v.getId() == R.id.mittelRadioButton){
            //if (rbtnm.isChecked() == false) {
                rbtnl.setChecked(false);
                rbtnm.setChecked(true);
                rbtns.setChecked(false);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btnY.setBackground(getDrawable(R.drawable.widwybtn));
                }
                gamemode = "mittel";
                setNewExercise();
                disableRadioButtons();
            //}
        } else if (v.getId() == R.id.schwerRadioButton) {
            //if (rbtns.isChecked() == false) {
                rbtnl.setChecked(false);
                rbtnm.setChecked(false);
                rbtns.setChecked(true);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btnY.setBackground(getDrawable(R.drawable.widw_ybtn100));
                }
                gamemode = "schwer";
                setNewExercise();
                disableRadioButtons();
            //}
        } else







        if (v.getId() == R.id.buttonY){
            if (gamemode.contains("leicht")) {
                sPrefEditorCount.putInt("" + i, sPrefCount.getInt("" + i, 0) + 25);
                sPrefEditorCount.commit();
            } else if (gamemode.contains("mittel")) {
                sPrefEditorCount.putInt("" + i, sPrefCount.getInt("" + i, 0) + 50);
                sPrefEditorCount.commit();
            } else if (gamemode.contains("schwer")){
                sPrefEditorCount.putInt("" + i, sPrefCount.getInt("" + i, 0) + 100);
                sPrefEditorCount.commit();
            }
            enableRadioButtons();
            nextTurn(skipfail, skip);
        } else if (v.getId() == R.id.buttonN){
            sPrefEditorCount.putInt("" + i, sPrefCount.getInt("" + i, 0) - 200);
            sPrefEditorCount.commit();
            enableRadioButtons();
            nextTurn(skipfail, skip);
        } else if (v.getId() == R.id.skipButton){
            if (sPrefCount.getInt("" + i, 0) >= 200) {
                sPrefEditorCount.putInt("" + i, sPrefCount.getInt("" + i, 0) - 200);
                sPrefEditorCount.commit();
                skip = true;
                setNewExercise();
                disableRadioButtons();

            } else {
                Toast.makeText(getApplicationContext(), getString(R.string.zu_wenig_punkte), Toast.LENGTH_SHORT).show();
                skipfail = true;
            }
            nextTurn(skipfail, skip);
        }

    }

    public void nextTurn(boolean skipfail, boolean skip){
        if (skipfail == false) {

            if (skip == false) {
                i++;
                count++;


                if (count > playerSizePref.getInt("playersize", 0)) {
                    i = 1;
                    count = 1;
                    round++;
                    adCount++;
                    roundtv.setText(getString(R.string.runde) + " " + round);
                    playertv.setText(sPref.getString("" + i, ""));

                    if (adCount >= 3) {
                        showIntersitialAD();
                        adCount = 0;
                    }
                } else {
                    playertv.setText(sPref.getString("" + i, ""));
                }
                setNewExercise();

            }
            addPlayers();
            scoretv.setText("" + sPrefCount.getInt("" + i, 0) + "P");
        }
    }

    public void setNewExercise(){
        if (categoryPref.getString("category", "").contains("Überall")) {
            if (gamemode.contains("leicht")) {
                if (listUL.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addUL();
                }
                int random = (int) (Math.random() * countUL);
                String item = listUL.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countUL--;
                listUL.remove(item);
            } else if (gamemode.contains("mittel")) {
                if (listUM.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addUM();
                }
                int random = (int) (Math.random() * countUM);
                String item = listUM.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countUM--;
                listUM.remove(item);
            } else if (gamemode.contains("schwer")) {
                if (listUS.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addUS();
                }
                int random = (int) (Math.random() * countUS);
                String item = listUS.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countUS--;
                listUS.remove(item);
            }
        } else if (categoryPref.getString("category", "").contains("Party")){
            if (gamemode.contains("leicht")) {
                if (listPL.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addPL();
                }
                int random = (int) (Math.random() * countPL);
                String item = listPL.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countPL--;
                listPL.remove(item);
            } else if (gamemode.contains("mittel")) {
                if (listPM.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addPM();
                }
                int random = (int) (Math.random() * countPM);
                String item = listPM.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countPM--;
                listPM.remove(item);
            } else if (gamemode.contains("schwer")) {
                if (listPS.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addPS();
                }
                int random = (int) (Math.random() * countPS);
                String item = listPS.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countPS--;
                listPS.remove(item);
            }
        } else if (categoryPref.getString("category", "").contains("Draußen")){
            if (gamemode.contains("leicht")) {
                if (listDL.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addDL();
                }
                int random = (int) (Math.random() * countDL);
                String item = listDL.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countDL--;
                listDL.remove(item);
            } else if (gamemode.contains("mittel")) {
                if (listDM.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addDM();
                }
                int random = (int) (Math.random() * countDM);
                String item = listDM.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countDM--;
                listDM.remove(item);
            } else if (gamemode.contains("schwer")) {
                if (listDS.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addDS();
                }
                int random = (int) (Math.random() * countDS);
                String item = listDS.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countDS--;
                listDS.remove(item);
            }
        } else if (categoryPref.getString("category", "").contains("Party")){
            if (gamemode.contains("leicht")) {
                if (listPL.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addPL();
                }
                int random = (int) (Math.random() * countPL);
                String item = listPL.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countPL--;
                listPL.remove(item);
            } else if (gamemode.contains("mittel")) {
                if (listPM.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addPM();
                }
                int random = (int) (Math.random() * countPM);
                String item = listPM.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countPM--;
                listPM.remove(item);
            } else if (gamemode.contains("schwer")) {
                if (listPS.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addPS();
                }
                int random = (int) (Math.random() * countPS);
                String item = listPS.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countPS--;
                listPS.remove(item);
            }
        } else if (categoryPref.getString("category", "").contains("Zuhause")){
            if (gamemode.contains("leicht")) {
                if (listZL.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addZL();
                }
                int random = (int) (Math.random() * countZL);
                String item = listZL.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countZL--;
                listZL.remove(item);
            } else if (gamemode.contains("mittel")) {
                if (listZM.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addZM();
                }
                int random = (int) (Math.random() * countZM);
                String item = listZM.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countZM--;
                listZM.remove(item);
            } else if (gamemode.contains("schwer")) {
                if (listZS.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addZS();
                }
                int random = (int) (Math.random() * countZS);
                String item = listZS.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countZS--;
                listZS.remove(item);
            }
        } else if (categoryPref.getString("category", "").contains("Schule")){
            if (gamemode.contains("leicht")) {
                if (listSL.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addSL();
                }
                int random = (int) (Math.random() * countSL);
                String item = listSL.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countSL--;
                listSL.remove(item);
            } else if (gamemode.contains("mittel")) {
                if (listSM.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addSM();
                }
                int random = (int) (Math.random() * countSM);
                String item = listSM.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countSM--;
                listSM.remove(item);
            } else if (gamemode.contains("schwer")) {
                if (listSS.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addSS();
                }
                int random = (int) (Math.random() * countSS);
                String item = listSS.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countSS--;
                listSS.remove(item);
            }
        } else if (categoryPref.getString("category", "").contains("Stadt")){
            if (gamemode.contains("leicht")) {
                if (listCL.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addCL();
                }
                int random = (int) (Math.random() * countCL);
                String item = listCL.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countCL--;
                listCL.remove(item);
            } else if (gamemode.contains("mittel")) {
                if (listCM.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addCM();
                }
                int random = (int) (Math.random() * countCM);
                String item = listCM.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countCM--;
                listCM.remove(item);
            } else if (gamemode.contains("schwer")) {
                if (listCS.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addCS();
                }
                int random = (int) (Math.random() * countCS);
                String item = listCS.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countCS--;
                listCS.remove(item);
            }
        } else if (categoryPref.getString("category", "").contains("Freund")){
            if (gamemode.contains("leicht")) {
                if (listFL.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addFL();
                }
                int random = (int) (Math.random() * countFL);
                String item = listFL.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countFL--;
                listFL.remove(item);
            } else if (gamemode.contains("mittel")) {
                if (listFM.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addFM();
                }
                int random = (int) (Math.random() * countFM);
                String item = listFM.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countFM--;
                listFM.remove(item);
            } else if (gamemode.contains("schwer")) {
                if (listFS.isEmpty()) {
                    //addAufgaben();
                    emptyToast();
                    addFS();
                }
                int random = (int) (Math.random() * countFS);
                String item = listFS.get(random);
                aufgabentv.setText(getString(R.string.widw) + item);
                countFS--;
                listFS.remove(item);
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                switch (v.getId()) {
                    case R.id.buttonY:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (gamemode.contains("leicht")){
                                btnY.setBackground(getDrawable(R.drawable.widw_ybtn_light25));
                            } else if (gamemode.contains("mittel")) {
                                btnY.setBackground(getDrawable(R.drawable.widwybtnlight));
                            } else if (gamemode.contains("schwer")){
                                btnY.setBackground(getDrawable(R.drawable.widw_ybtn_light100));
                            }
                        }
                        onClick(btnY);
                        return true;
                    case R.id.buttonN:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            btnN.setBackground(getDrawable(R.drawable.widwnbtnlight));
                        }
                        onClick(btnN);
                        return true;
                    case R.id.skipButton:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            sbtn.setBackground(getDrawable(R.drawable.widwskipbtnlight));
                        }
                        onClick(sbtn);
                        return true;

                }
                return true;

            case MotionEvent.ACTION_UP:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (gamemode.contains("leicht")){
                        btnY.setBackground(getDrawable(R.drawable.widw_ybtn25));
                    } else if (gamemode.contains("mittel")) {
                        btnY.setBackground(getDrawable(R.drawable.widwybtn));
                    } else if (gamemode.contains("schwer")){
                        btnY.setBackground(getDrawable(R.drawable.widw_ybtn100));
                    }
                    btnN.setBackground(getDrawable(R.drawable.widwnbtn));
                    sbtn.setBackground(getDrawable(R.drawable.widwskipbtn));
                }

                return true;
        }

        return false;
    }

    //DRAUßEN

    public void addDL(){

        listDL.add(getString(R.string.ul1));
        listDL.add(getString(R.string.ul2));
        listDL.add(getString(R.string.ul3));
        listDL.add(getString(R.string.ul4));
        listDL.add(getString(R.string.ul5));
        listDL.add(getString(R.string.ul6));
        listDL.add(getString(R.string.ul7));
        listDL.add(getString(R.string.ul8));
        listDL.add(getString(R.string.ul9));
        listDL.add(getString(R.string.ul10));
        listDL.add(getString(R.string.ul11));
        listDL.add(getString(R.string.ul12));
        listDL.add(getString(R.string.ul13));
        listDL.add(getString(R.string.ul14));
        listDL.add(getString(R.string.ul15));
        listDL.add(getString(R.string.ul16));
        listDL.add(getString(R.string.ul17));
        listDL.add(getString(R.string.ul18));
        listDL.add(getString(R.string.ul19));
        listDL.add(getString(R.string.ul20));
        listDL.add(getString(R.string.ul21));
        listDL.add(getString(R.string.ul22));
        listDL.add(getString(R.string.ul23));
        listDL.add(getString(R.string.ul24));
        listDL.add(getString(R.string.ul25));
        listDL.add(getString(R.string.ul26));
        listDL.add(getString(R.string.ul27));
        listDL.add(getString(R.string.ul28));
        listDL.add(getString(R.string.ul29));

        listDL.add(getString(R.string.dl1));
        listDL.add(getString(R.string.dl2));
        listDL.add(getString(R.string.dl3));


        countDL = listDL.size();
    }

    public void addDM(){

        listDM.add(getString(R.string.um1));
        listDM.add(getString(R.string.um2));
        listDM.add(getString(R.string.um3));
        listDM.add(getString(R.string.um4));
        listDM.add(getString(R.string.um5));
        listDM.add(getString(R.string.um6));
        listDM.add(getString(R.string.um7));
        listDM.add(getString(R.string.um8));
        listDM.add(getString(R.string.um9));
        listDM.add(getString(R.string.um10));
        listDM.add(getString(R.string.um11));
        listDM.add(getString(R.string.um12));
        listDM.add(getString(R.string.um13));
        listDM.add(getString(R.string.um14));
        listDM.add(getString(R.string.um15));
        listDM.add(getString(R.string.um16));
        listDM.add(getString(R.string.um17));
        listDM.add(getString(R.string.um18));
        listDM.add(getString(R.string.um19));
        listDM.add(getString(R.string.um20));
        listDM.add(getString(R.string.um21));
        listDM.add(getString(R.string.um22));
        listDM.add(getString(R.string.um23));
        listDM.add(getString(R.string.um24));
        listDM.add(getString(R.string.um25));
        listDM.add(getString(R.string.um26));
        listDM.add(getString(R.string.um27));
        listDM.add(getString(R.string.um28));
        listDM.add(getString(R.string.um29));
        listDM.add(getString(R.string.um30));

        listDM.add(getString(R.string.dm1));
        listDM.add(getString(R.string.dm2));
        listDM.add(getString(R.string.dm3));
        listDM.add(getString(R.string.dm4));
        listDM.add(getString(R.string.dm5));
        listDM.add(getString(R.string.dm6));

        countDM = listDM.size();
    }

    public void addDS(){

        listDS.add(getString(R.string.us1));
        listDS.add(getString(R.string.us2));
        listDS.add(getString(R.string.us3));
        listDS.add(getString(R.string.us4));
        listDS.add(getString(R.string.us5));
        listDS.add(getString(R.string.us6));
        listDS.add(getString(R.string.us7));
        listDS.add(getString(R.string.us8));
        listDS.add(getString(R.string.us9));
        listDS.add(getString(R.string.us10));

        listDS.add(getString(R.string.ds1));
        listDS.add(getString(R.string.ds2));
        listDS.add(getString(R.string.ds3));

        countDS = listDS.size();
    }

    //PARTY

    public void addPL(){

        listPL.add(getString(R.string.ul1));
        listPL.add(getString(R.string.ul2));
        listPL.add(getString(R.string.ul3));
        listPL.add(getString(R.string.ul4));
        listPL.add(getString(R.string.ul5));
        listPL.add(getString(R.string.ul6));
        listPL.add(getString(R.string.ul7));
        listPL.add(getString(R.string.ul8));
        listPL.add(getString(R.string.ul9));
        listPL.add(getString(R.string.ul10));
        listPL.add(getString(R.string.ul11));
        listPL.add(getString(R.string.ul12));
        listPL.add(getString(R.string.ul13));
        listPL.add(getString(R.string.ul14));
        listPL.add(getString(R.string.ul15));
        listPL.add(getString(R.string.ul16));
        listPL.add(getString(R.string.ul17));
        listPL.add(getString(R.string.ul18));
        listPL.add(getString(R.string.ul19));
        listPL.add(getString(R.string.ul20));
        listPL.add(getString(R.string.ul21));
        listPL.add(getString(R.string.ul22));
        listPL.add(getString(R.string.ul23));
        listPL.add(getString(R.string.ul24));
        listPL.add(getString(R.string.ul25));
        listPL.add(getString(R.string.ul26));
        listPL.add(getString(R.string.ul27));
        listPL.add(getString(R.string.ul28));
        listPL.add(getString(R.string.ul29));

        listPL.add(getString(R.string.pl1));
        listPL.add(getString(R.string.pl2));
        listPL.add(getString(R.string.pl3));
        listPL.add(getString(R.string.pl4));
        listPL.add(getString(R.string.pl5));
        listPL.add(getString(R.string.pl6));
        listPL.add(getString(R.string.pl7));
        listPL.add(getString(R.string.pl8));
        listPL.add(getString(R.string.pl9));
        listPL.add(getString(R.string.pl10));
        listPL.add(getString(R.string.pl11));
        listPL.add(getString(R.string.pl12));
        listPL.add(getString(R.string.pl13));
        listPL.add(getString(R.string.pl14));
        listPL.add(getString(R.string.pl15));
        listPL.add(getString(R.string.pl16));
        listPL.add(getString(R.string.pl17));
        listPL.add(getString(R.string.pl18));
        listPL.add(getString(R.string.pl19));
        listPL.add(getString(R.string.pl20));
        listPL.add(getString(R.string.pl21));
        listPL.add(getString(R.string.pl22));
        listPL.add(getString(R.string.pl23));
        listPL.add(getString(R.string.pl24));
        listPL.add(getString(R.string.pl25));
        listPL.add(getString(R.string.pl26));
        listPL.add(getString(R.string.pl27));
        listPL.add(getString(R.string.pl28));
        listPL.add(getString(R.string.pl29));
        listPL.add(getString(R.string.pl30));

        countPL = listPL.size();
    }

    public void addPM(){

        listPM.add(getString(R.string.um1));
        listPM.add(getString(R.string.um2));
        listPM.add(getString(R.string.um3));
        listPM.add(getString(R.string.um4));
        listPM.add(getString(R.string.um5));
        listPM.add(getString(R.string.um6));
        listPM.add(getString(R.string.um7));
        listPM.add(getString(R.string.um8));
        listPM.add(getString(R.string.um9));
        listPM.add(getString(R.string.um10));
        listPM.add(getString(R.string.um11));
        listPM.add(getString(R.string.um12));
        listPM.add(getString(R.string.um13));
        listPM.add(getString(R.string.um14));
        listPM.add(getString(R.string.um15));
        listPM.add(getString(R.string.um16));
        listPM.add(getString(R.string.um17));
        listPM.add(getString(R.string.um18));
        listPM.add(getString(R.string.um19));
        listPM.add(getString(R.string.um20));
        listPM.add(getString(R.string.um21));
        listPM.add(getString(R.string.um22));
        listPM.add(getString(R.string.um23));
        listPM.add(getString(R.string.um24));
        listPM.add(getString(R.string.um25));
        listPM.add(getString(R.string.um26));
        listPM.add(getString(R.string.um27));
        listPM.add(getString(R.string.um28));
        listPM.add(getString(R.string.um29));
        listPM.add(getString(R.string.um30));

        listPM.add(getString(R.string.pm1));
        listPM.add(getString(R.string.pm2));
        listPM.add(getString(R.string.pm3));
        listPM.add(getString(R.string.pm4));
        listPM.add(getString(R.string.pm5));
        listPM.add(getString(R.string.pm6));
        listPM.add(getString(R.string.pm7));
        listPM.add(getString(R.string.pm8));
        listPM.add(getString(R.string.pm9));
        listPM.add(getString(R.string.pm10));
        listPM.add(getString(R.string.pm11));
        listPM.add(getString(R.string.pm12));
        listPM.add(getString(R.string.pm13));
        listPM.add(getString(R.string.pm14));
        listPM.add(getString(R.string.pm15));
        listPM.add(getString(R.string.pm16));
        listPM.add(getString(R.string.pm17));
        listPM.add(getString(R.string.pm18));
        listPM.add(getString(R.string.pm19));
        listPM.add(getString(R.string.pm20));
        listPM.add(getString(R.string.pm21));
        listPM.add(getString(R.string.pm22));
        listPM.add(getString(R.string.pm23));
        listPM.add(getString(R.string.pm24));
        listPM.add(getString(R.string.pm25));
        listPM.add(getString(R.string.pm26));
        listPM.add(getString(R.string.pm27));
        listPM.add(getString(R.string.pm28));
        listPM.add(getString(R.string.pm29));
        listPM.add(getString(R.string.pm30));

        countPM = listPM.size();
    }

    public void addPS(){

        listPS.add(getString(R.string.us1));
        listPS.add(getString(R.string.us2));
        listPS.add(getString(R.string.us3));
        listPS.add(getString(R.string.us4));
        listPS.add(getString(R.string.us5));
        listPS.add(getString(R.string.us6));
        listPS.add(getString(R.string.us7));
        listPS.add(getString(R.string.us8));
        listPS.add(getString(R.string.us9));
        listPS.add(getString(R.string.us10));

        listPS.add(getString(R.string.ps1));
        listPS.add(getString(R.string.ps2));
        listPS.add(getString(R.string.ps3));
        listPS.add(getString(R.string.ps4));
        listPS.add(getString(R.string.ps5));
        listPS.add(getString(R.string.ps6));
        listPS.add(getString(R.string.ps7));
        listPS.add(getString(R.string.ps8));
        listPS.add(getString(R.string.ps9));
        listPS.add(getString(R.string.ps10));
        listPS.add(getString(R.string.ps11));
        listPS.add(getString(R.string.ps12));
        listPS.add(getString(R.string.ps13));
        listPS.add(getString(R.string.ps14));
        listPS.add(getString(R.string.ps15));
        listPS.add(getString(R.string.ps16));
        listPS.add(getString(R.string.ps17));
        listPS.add(getString(R.string.ps18));
        listPS.add(getString(R.string.ps19));
        listPS.add(getString(R.string.ps20));

        countPS = listPS.size();
    }

    //ZUHAUSE

    public void addZL(){

        listZL.add(getString(R.string.ul1));
        listZL.add(getString(R.string.ul2));
        listZL.add(getString(R.string.ul3));
        listZL.add(getString(R.string.ul4));
        listZL.add(getString(R.string.ul5));
        listZL.add(getString(R.string.ul6));
        listZL.add(getString(R.string.ul7));
        listZL.add(getString(R.string.ul8));
        listZL.add(getString(R.string.ul9));
        listZL.add(getString(R.string.ul10));
        listZL.add(getString(R.string.ul11));
        listZL.add(getString(R.string.ul12));
        listZL.add(getString(R.string.ul13));
        listZL.add(getString(R.string.ul14));
        listZL.add(getString(R.string.ul15));
        listZL.add(getString(R.string.ul16));
        listZL.add(getString(R.string.ul17));
        listZL.add(getString(R.string.ul18));
        listZL.add(getString(R.string.ul19));
        listZL.add(getString(R.string.ul20));
        listZL.add(getString(R.string.ul21));
        listZL.add(getString(R.string.ul22));
        listZL.add(getString(R.string.ul23));
        listZL.add(getString(R.string.ul24));
        listZL.add(getString(R.string.ul25));
        listZL.add(getString(R.string.ul26));
        listZL.add(getString(R.string.ul27));
        listZL.add(getString(R.string.ul28));
        listZL.add(getString(R.string.ul29));

        listZL.add(getString(R.string.zl1));

        countZL = listZL.size();
    }

    public void addZM(){

        listZM.add(getString(R.string.um1));
        listZM.add(getString(R.string.um2));
        listZM.add(getString(R.string.um3));
        listZM.add(getString(R.string.um4));
        listZM.add(getString(R.string.um5));
        listZM.add(getString(R.string.um6));
        listZM.add(getString(R.string.um7));
        listZM.add(getString(R.string.um8));
        listZM.add(getString(R.string.um9));
        listZM.add(getString(R.string.um10));
        listZM.add(getString(R.string.um11));
        listZM.add(getString(R.string.um12));
        listZM.add(getString(R.string.um13));
        listZM.add(getString(R.string.um14));
        listZM.add(getString(R.string.um15));
        listZM.add(getString(R.string.um16));
        listZM.add(getString(R.string.um17));
        listZM.add(getString(R.string.um18));
        listZM.add(getString(R.string.um19));
        listZM.add(getString(R.string.um20));
        listZM.add(getString(R.string.um21));
        listZM.add(getString(R.string.um22));
        listZM.add(getString(R.string.um23));
        listZM.add(getString(R.string.um24));
        listZM.add(getString(R.string.um25));
        listZM.add(getString(R.string.um26));
        listZM.add(getString(R.string.um27));
        listZM.add(getString(R.string.um28));
        listZM.add(getString(R.string.um29));
        listZM.add(getString(R.string.um30));

        listZM.add(getString(R.string.zm1));
        listZM.add(getString(R.string.zm2));
        listZM.add(getString(R.string.zm3));

        countZM = listZM.size();
    }

    public void addZS(){

        listZS.add(getString(R.string.us1));
        listZS.add(getString(R.string.us2));
        listZS.add(getString(R.string.us3));
        listZS.add(getString(R.string.us4));
        listZS.add(getString(R.string.us5));
        listZS.add(getString(R.string.us6));
        listZS.add(getString(R.string.us7));
        listZS.add(getString(R.string.us8));
        listZS.add(getString(R.string.us9));
        listZS.add(getString(R.string.us10));

        //listZS.add(getString(R.string.zs1));

        countZS = listZS.size();
    }

    //SCHULE

    public void addSL(){

        listSL.add(getString(R.string.ul1));
        listSL.add(getString(R.string.ul2));
        listSL.add(getString(R.string.ul3));
        listSL.add(getString(R.string.ul4));
        listSL.add(getString(R.string.ul5));
        listSL.add(getString(R.string.ul6));
        listSL.add(getString(R.string.ul7));
        listSL.add(getString(R.string.ul8));
        listSL.add(getString(R.string.ul9));
        listSL.add(getString(R.string.ul10));
        listSL.add(getString(R.string.ul11));
        listSL.add(getString(R.string.ul12));
        listSL.add(getString(R.string.ul13));
        listSL.add(getString(R.string.ul14));
        listSL.add(getString(R.string.ul15));
        listSL.add(getString(R.string.ul16));
        listSL.add(getString(R.string.ul17));
        listSL.add(getString(R.string.ul18));
        listSL.add(getString(R.string.ul19));
        listSL.add(getString(R.string.ul20));
        listSL.add(getString(R.string.ul21));
        listSL.add(getString(R.string.ul22));
        listSL.add(getString(R.string.ul23));
        listSL.add(getString(R.string.ul24));
        listSL.add(getString(R.string.ul25));
        listSL.add(getString(R.string.ul26));
        listSL.add(getString(R.string.ul27));
        listSL.add(getString(R.string.ul28));
        listSL.add(getString(R.string.ul29));

        listSL.add(getString(R.string.sl1));
        listSL.add(getString(R.string.sl2));
        listSL.add(getString(R.string.sl3));
        listSL.add(getString(R.string.sl4));
        listSL.add(getString(R.string.sl5));
        listSL.add(getString(R.string.sl6));
        listSL.add(getString(R.string.sl7));
        listSL.add(getString(R.string.sl8));
        listSL.add(getString(R.string.sl9));
        listSL.add(getString(R.string.sl10));
        listSL.add(getString(R.string.sl11));
        listSL.add(getString(R.string.sl12));
        listSL.add(getString(R.string.sl13));
        listSL.add(getString(R.string.sl14));
        listSL.add(getString(R.string.sl15));
        listSL.add(getString(R.string.sl16));
        listSL.add(getString(R.string.sl17));
        listSL.add(getString(R.string.sl18));
        listSL.add(getString(R.string.sl19));
        listSL.add(getString(R.string.sl20));
        listSL.add(getString(R.string.sl21));
        listSL.add(getString(R.string.sl22));
        listSL.add(getString(R.string.sl23));
        listSL.add(getString(R.string.sl24));
        listSL.add(getString(R.string.sl25));
        listSL.add(getString(R.string.sl26));
        listSL.add(getString(R.string.sl27));
        listSL.add(getString(R.string.sl28));
        listSL.add(getString(R.string.sl29));
        listSL.add(getString(R.string.sl30));
        listSL.add(getString(R.string.sl31));
        listSL.add(getString(R.string.sl32));
        listSL.add(getString(R.string.sl33));
        listSL.add(getString(R.string.sl34));
        listSL.add(getString(R.string.sl35));

        countSL = listSL.size();
    }

    public void addSM(){

        listSM.add(getString(R.string.um1));
        listSM.add(getString(R.string.um2));
        listSM.add(getString(R.string.um3));
        listSM.add(getString(R.string.um4));
        listSM.add(getString(R.string.um5));
        listSM.add(getString(R.string.um6));
        listSM.add(getString(R.string.um7));
        listSM.add(getString(R.string.um8));
        listSM.add(getString(R.string.um9));
        listSM.add(getString(R.string.um10));
        listSM.add(getString(R.string.um11));
        listSM.add(getString(R.string.um12));
        listSM.add(getString(R.string.um13));
        listSM.add(getString(R.string.um14));
        listSM.add(getString(R.string.um15));
        listSM.add(getString(R.string.um16));
        listSM.add(getString(R.string.um17));
        listSM.add(getString(R.string.um18));
        listSM.add(getString(R.string.um19));
        listSM.add(getString(R.string.um20));
        listSM.add(getString(R.string.um21));
        listSM.add(getString(R.string.um22));
        listSM.add(getString(R.string.um23));
        listSM.add(getString(R.string.um24));
        listSM.add(getString(R.string.um25));
        listSM.add(getString(R.string.um26));
        listSM.add(getString(R.string.um27));
        listSM.add(getString(R.string.um28));
        listSM.add(getString(R.string.um29));
        listSM.add(getString(R.string.um30));

        listSM.add(getString(R.string.sm1));
        listSM.add(getString(R.string.sm2));
        listSM.add(getString(R.string.sm3));
        listSM.add(getString(R.string.sm4));
        listSM.add(getString(R.string.sm5));
        listSM.add(getString(R.string.sm6));
        listSM.add(getString(R.string.sm7));
        listSM.add(getString(R.string.sm8));
        listSM.add(getString(R.string.sm9));
        listSM.add(getString(R.string.sm10));
        listSM.add(getString(R.string.sm11));
        listSM.add(getString(R.string.sm12));
        listSM.add(getString(R.string.sm13));
        listSM.add(getString(R.string.sm14));
        listSM.add(getString(R.string.sm15));
        listSM.add(getString(R.string.sm16));
        listSM.add(getString(R.string.sm17));
        listSM.add(getString(R.string.sm18));
        listSM.add(getString(R.string.sm19));
        listSM.add(getString(R.string.sm20));
        listSM.add(getString(R.string.sm21));
        listSM.add(getString(R.string.sm22));
        listSM.add(getString(R.string.sm23));
        listSM.add(getString(R.string.sm24));
        listSM.add(getString(R.string.sm25));
        listSM.add(getString(R.string.sm26));
        listSM.add(getString(R.string.sm27));
        listSM.add(getString(R.string.sm28));
        listSM.add(getString(R.string.sm29));
        listSM.add(getString(R.string.sm30));

        countSM = listSM.size();
    }

    public void addSS(){

        listSS.add(getString(R.string.us1));
        listSS.add(getString(R.string.us2));
        listSS.add(getString(R.string.us3));
        listSS.add(getString(R.string.us4));
        listSS.add(getString(R.string.us5));
        listSS.add(getString(R.string.us6));
        listSS.add(getString(R.string.us7));
        listSS.add(getString(R.string.us8));
        listSS.add(getString(R.string.us9));
        listSS.add(getString(R.string.us10));

        listSS.add(getString(R.string.ss1));
        listSS.add(getString(R.string.ss2));
        listSS.add(getString(R.string.ss3));
        listSS.add(getString(R.string.ss4));
        listSS.add(getString(R.string.ss5));
        listSS.add(getString(R.string.ss6));
        listSS.add(getString(R.string.ss7));
        listSS.add(getString(R.string.ss8));
        listSS.add(getString(R.string.ss9));
        listSS.add(getString(R.string.ss10));
        listSS.add(getString(R.string.ss11));
        listSS.add(getString(R.string.ss12));
        listSS.add(getString(R.string.ss13));
        listSS.add(getString(R.string.ss14));
        listSS.add(getString(R.string.ss15));
        listSS.add(getString(R.string.ss16));
        listSS.add(getString(R.string.ss17));
        listSS.add(getString(R.string.ss18));
        listSS.add(getString(R.string.ss19));
        listSS.add(getString(R.string.ss20));

        countSS = listSS.size();
    }

    //CITY

    public void addCL(){

        listCL.add(getString(R.string.ul1));
        listCL.add(getString(R.string.ul2));
        listCL.add(getString(R.string.ul3));
        listCL.add(getString(R.string.ul4));
        listCL.add(getString(R.string.ul5));
        listCL.add(getString(R.string.ul6));
        listCL.add(getString(R.string.ul7));
        listCL.add(getString(R.string.ul8));
        listCL.add(getString(R.string.ul9));
        listCL.add(getString(R.string.ul10));
        listCL.add(getString(R.string.ul11));
        listCL.add(getString(R.string.ul12));
        listCL.add(getString(R.string.ul13));
        listCL.add(getString(R.string.ul14));
        listCL.add(getString(R.string.ul15));
        listCL.add(getString(R.string.ul16));
        listCL.add(getString(R.string.ul17));
        listCL.add(getString(R.string.ul18));
        listCL.add(getString(R.string.ul19));
        listCL.add(getString(R.string.ul20));
        listCL.add(getString(R.string.ul21));
        listCL.add(getString(R.string.ul22));
        listCL.add(getString(R.string.ul23));
        listCL.add(getString(R.string.ul24));
        listCL.add(getString(R.string.ul25));
        listCL.add(getString(R.string.ul26));
        listCL.add(getString(R.string.ul27));
        listCL.add(getString(R.string.ul28));
        listCL.add(getString(R.string.ul29));

        listCL.add(getString(R.string.cl1));
        listCL.add(getString(R.string.cl2));
        listCL.add(getString(R.string.cl3));
        listCL.add(getString(R.string.cl4));
        listCL.add(getString(R.string.cl5));
        listCL.add(getString(R.string.cl6));
        listCL.add(getString(R.string.cl7));
        listCL.add(getString(R.string.cl8));
        listCL.add(getString(R.string.cl9));
        listCL.add(getString(R.string.cl10));
        listCL.add(getString(R.string.cl11));
        listCL.add(getString(R.string.cl12));
        listCL.add(getString(R.string.cl13));
        listCL.add(getString(R.string.cl14));
        listCL.add(getString(R.string.cl15));
        listCL.add(getString(R.string.cl16));
        listCL.add(getString(R.string.cl17));
        listCL.add(getString(R.string.cl18));
        listCL.add(getString(R.string.cl19));
        listCL.add(getString(R.string.cl20));
        listCL.add(getString(R.string.cl21));
        listCL.add(getString(R.string.cl22));
        listCL.add(getString(R.string.cl23));
        listCL.add(getString(R.string.cl24));
        listCL.add(getString(R.string.cl25));
        listCL.add(getString(R.string.cl26));
        listCL.add(getString(R.string.cl27));
        listCL.add(getString(R.string.cl28));
        listCL.add(getString(R.string.cl29));
        listCL.add(getString(R.string.cl30));
        listCL.add(getString(R.string.cl31));
        listCL.add(getString(R.string.cl32));

        countCL = listCL.size();
    }

    public void addCM(){

        listCM.add(getString(R.string.um1));
        listCM.add(getString(R.string.um2));
        listCM.add(getString(R.string.um3));
        listCM.add(getString(R.string.um4));
        listCM.add(getString(R.string.um5));
        listCM.add(getString(R.string.um6));
        listCM.add(getString(R.string.um7));
        listCM.add(getString(R.string.um8));
        listCM.add(getString(R.string.um9));
        listCM.add(getString(R.string.um10));
        listCM.add(getString(R.string.um11));
        listCM.add(getString(R.string.um12));
        listCM.add(getString(R.string.um13));
        listCM.add(getString(R.string.um14));
        listCM.add(getString(R.string.um15));
        listCM.add(getString(R.string.um16));
        listCM.add(getString(R.string.um17));
        listCM.add(getString(R.string.um18));
        listCM.add(getString(R.string.um19));
        listCM.add(getString(R.string.um20));
        listCM.add(getString(R.string.um21));
        listCM.add(getString(R.string.um22));
        listCM.add(getString(R.string.um23));
        listCM.add(getString(R.string.um24));
        listCM.add(getString(R.string.um25));
        listCM.add(getString(R.string.um26));
        listCM.add(getString(R.string.um27));
        listCM.add(getString(R.string.um28));
        listCM.add(getString(R.string.um29));
        listCM.add(getString(R.string.um30));

        listCM.add(getString(R.string.cm1));
        listCM.add(getString(R.string.cm2));
        listCM.add(getString(R.string.cm3));
        listCM.add(getString(R.string.cm4));
        listCM.add(getString(R.string.cm5));
        listCM.add(getString(R.string.cm6));
        listCM.add(getString(R.string.cm7));
        listCM.add(getString(R.string.cm8));
        listCM.add(getString(R.string.cm9));
        listCM.add(getString(R.string.cm10));
        listCM.add(getString(R.string.cm11));
        listCM.add(getString(R.string.cm12));
        listCM.add(getString(R.string.cm13));
        listCM.add(getString(R.string.cm14));
        listCM.add(getString(R.string.cm15));
        listCM.add(getString(R.string.cm16));
        listCM.add(getString(R.string.cm17));
        listCM.add(getString(R.string.cm18));
        listCM.add(getString(R.string.cm19));
        listCM.add(getString(R.string.cm20));
        listCM.add(getString(R.string.cm21));
        listCM.add(getString(R.string.cm22));
        listCM.add(getString(R.string.cm23));
        listCM.add(getString(R.string.cm24));
        listCM.add(getString(R.string.cm25));
        listCM.add(getString(R.string.cm26));
        listCM.add(getString(R.string.cm27));
        listCM.add(getString(R.string.cm28));
        listCM.add(getString(R.string.cm29));
        listCM.add(getString(R.string.cm30));
        listCM.add(getString(R.string.cm31));
        listCM.add(getString(R.string.cm32));

        countCM = listCM.size();
    }

    public void addCS(){

        listCS.add(getString(R.string.us1));
        listCS.add(getString(R.string.us2));
        listCS.add(getString(R.string.us3));
        listCS.add(getString(R.string.us4));
        listCS.add(getString(R.string.us5));
        listCS.add(getString(R.string.us6));
        listCS.add(getString(R.string.us7));
        listCS.add(getString(R.string.us8));
        listCS.add(getString(R.string.us9));
        listCS.add(getString(R.string.us10));

        listCS.add(getString(R.string.cs1));
        listCS.add(getString(R.string.cs2));
        listCS.add(getString(R.string.cs3));
        listCS.add(getString(R.string.cs4));
        listCS.add(getString(R.string.cs5));
        listCS.add(getString(R.string.cs6));
        listCS.add(getString(R.string.cs7));
        listCS.add(getString(R.string.cs8));
        listCS.add(getString(R.string.cs9));
        listCS.add(getString(R.string.cs10));
        listCS.add(getString(R.string.cs11));
        listCS.add(getString(R.string.cs12));
        listCS.add(getString(R.string.cs13));
        listCS.add(getString(R.string.cs14));
        listCS.add(getString(R.string.cs15));
        listCS.add(getString(R.string.cs16));
        listCS.add(getString(R.string.cs17));
        listCS.add(getString(R.string.cs18));
        listCS.add(getString(R.string.cs19));
        listCS.add(getString(R.string.cs20));

        countCS = listCS.size();
    }

    //BEI EINEM FREUND

    public void addFL(){

        listFL.add(getString(R.string.ul1));
        listFL.add(getString(R.string.ul2));
        listFL.add(getString(R.string.ul3));
        listFL.add(getString(R.string.ul4));
        listFL.add(getString(R.string.ul5));
        listFL.add(getString(R.string.ul6));
        listFL.add(getString(R.string.ul7));
        listFL.add(getString(R.string.ul8));
        listFL.add(getString(R.string.ul9));
        listFL.add(getString(R.string.ul10));
        listFL.add(getString(R.string.ul11));
        listFL.add(getString(R.string.ul12));
        listFL.add(getString(R.string.ul13));
        listFL.add(getString(R.string.ul14));
        listFL.add(getString(R.string.ul15));
        listFL.add(getString(R.string.ul16));
        listFL.add(getString(R.string.ul17));
        listFL.add(getString(R.string.ul18));
        listFL.add(getString(R.string.ul19));
        listFL.add(getString(R.string.ul20));
        listFL.add(getString(R.string.ul21));
        listFL.add(getString(R.string.ul22));
        listFL.add(getString(R.string.ul23));
        listFL.add(getString(R.string.ul24));
        listFL.add(getString(R.string.ul25));
        listFL.add(getString(R.string.ul26));
        listFL.add(getString(R.string.ul27));
        listFL.add(getString(R.string.ul28));
        listFL.add(getString(R.string.ul29));

        listFL.add(getString(R.string.fl1));

        countFL = listFL.size();
    }

    public void addFM(){

        listFM.add(getString(R.string.um1));
        listFM.add(getString(R.string.um2));
        listFM.add(getString(R.string.um3));
        listFM.add(getString(R.string.um4));
        listFM.add(getString(R.string.um5));
        listFM.add(getString(R.string.um6));
        listFM.add(getString(R.string.um7));
        listFM.add(getString(R.string.um8));
        listFM.add(getString(R.string.um9));
        listFM.add(getString(R.string.um10));
        listFM.add(getString(R.string.um11));
        listFM.add(getString(R.string.um12));
        listFM.add(getString(R.string.um13));
        listFM.add(getString(R.string.um14));

        listFM.add(getString(R.string.fm1));

        countFM = listFM.size();
    }

    public void addFS(){

        listFS.add(getString(R.string.us1));
        listFS.add(getString(R.string.us2));
        listFS.add(getString(R.string.us3));
        listFS.add(getString(R.string.us4));
        listFS.add(getString(R.string.us5));
        listFS.add(getString(R.string.us6));
        listFS.add(getString(R.string.us7));
        listFS.add(getString(R.string.us8));
        listFS.add(getString(R.string.us9));
        listFS.add(getString(R.string.us10));

        listFS.add(getString(R.string.fs1));

        countFS = listFS.size();
    }

    public void addUL(){
        listUL.add(getString(R.string.ul1));
        listUL.add(getString(R.string.ul2));
        listUL.add(getString(R.string.ul3));
        listUL.add(getString(R.string.ul4));
        listUL.add(getString(R.string.ul5));
        listUL.add(getString(R.string.ul6));
        listUL.add(getString(R.string.ul7));
        listUL.add(getString(R.string.ul8));
        listUL.add(getString(R.string.ul9));
        listUL.add(getString(R.string.ul10));
        listUL.add(getString(R.string.ul11));
        listUL.add(getString(R.string.ul12));
        listUL.add(getString(R.string.ul13));
        listUL.add(getString(R.string.ul14));
        listUL.add(getString(R.string.ul15));
        listUL.add(getString(R.string.ul16));
        listUL.add(getString(R.string.ul17));
        listUL.add(getString(R.string.ul18));
        listUL.add(getString(R.string.ul19));
        listUL.add(getString(R.string.ul20));
        listUL.add(getString(R.string.ul21));
        listUL.add(getString(R.string.ul22));
        listUL.add(getString(R.string.ul23));
        listUL.add(getString(R.string.ul24));
        listUL.add(getString(R.string.ul25));
        listUL.add(getString(R.string.ul26));
        listUL.add(getString(R.string.ul27));
        listUL.add(getString(R.string.ul28));
        listUL.add(getString(R.string.ul29));


        countUL = listUL.size();
    }

    public void addUM(){
        listUM.add(getString(R.string.um1));
        listUM.add(getString(R.string.um2));
        listUM.add(getString(R.string.um3));
        listUM.add(getString(R.string.um4));
        listUM.add(getString(R.string.um5));
        listUM.add(getString(R.string.um6));
        listUM.add(getString(R.string.um7));
        listUM.add(getString(R.string.um8));
        listUM.add(getString(R.string.um9));
        listUM.add(getString(R.string.um10));
        listUM.add(getString(R.string.um11));
        listUM.add(getString(R.string.um12));
        listUM.add(getString(R.string.um13));
        listUM.add(getString(R.string.um14));

        listUM.add(getString(R.string.um15));
        listUM.add(getString(R.string.um16));
        listUM.add(getString(R.string.um17));
        listUM.add(getString(R.string.um18));
        listUM.add(getString(R.string.um19));
        listUM.add(getString(R.string.um20));
        listUM.add(getString(R.string.um21));
        listUM.add(getString(R.string.um22));
        listUM.add(getString(R.string.um23));
        listUM.add(getString(R.string.um24));
        listUM.add(getString(R.string.um25));
        listUM.add(getString(R.string.um26));
        listUM.add(getString(R.string.um27));
        listUM.add(getString(R.string.um28));
        listUM.add(getString(R.string.um29));
        listUM.add(getString(R.string.um30));

        countUM = listUM.size();
    }

    public void addUS(){
        listUS.add(getString(R.string.us1));
        listUS.add(getString(R.string.us2));
        listUS.add(getString(R.string.us3));
        listUS.add(getString(R.string.us4));
        listUS.add(getString(R.string.us5));
        listUS.add(getString(R.string.us6));
        listUS.add(getString(R.string.us7));
        listUS.add(getString(R.string.us8));
        listUS.add(getString(R.string.us9));
        listUS.add(getString(R.string.us10));

        countUS = listUS.size();
    }

    public void onBackPressed(){
        showDialog(1);
    }

    @Override
    protected Dialog onCreateDialog (int id) {
        //switch (id) {
        //case 0:
        if (id == 1){
            AlertDialog.Builder mainbuilder = new AlertDialog.Builder(this);
            mainbuilder.setMessage(R.string.wanna_main);
            mainbuilder.setCancelable(true);

            mainbuilder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(getApplicationContext(), Start.class));
                    finish();
                }
            });

            mainbuilder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });

            AlertDialog maindialog = mainbuilder.create();
            maindialog.show();
        }

        //}
        return super.onCreateDialog(id);
    }

    public void onPause(){
        winnerScorePrefEditor.putInt("score", 0);
        winnerScorePrefEditor.commit();
        super.onPause();
        int wincount = 1;
        while (wincount <= playerSizePref.getInt("playersize", 0)){
            if (sPrefCount.getInt("" + wincount, 0) > winnerScorePref.getInt("score",0)){
                winnerScorePrefEditor.putInt("score", sPrefCount.getInt("" + wincount, 0));
                winnerScorePrefEditor.commit();

                winnerPrefEditor.putString("winner", sPref.getString("" + wincount, ""));
                winnerPrefEditor.commit();

                if (sPrefCount.getInt("" + wincount, 0) > highscorePref.getInt("highscore",0)){
                    highscorePrefEditor.putInt("highscore", sPrefCount.getInt(""+wincount, 0));
                    highscorePrefEditor.commit();
                }
            }

            wincount++;
        }



    }

    public void emptyToast(){
        Toast.makeText(getApplicationContext(), getString(R.string.full_house), Toast.LENGTH_SHORT).show();
    }
}
