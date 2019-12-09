package com.coreelements.ce.widw;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.InterstitialAd;

public class Start extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {

    private InterstitialAd mInterstitialAd;

    ImageView iv;
    TextView starttv, anleitungtv, quittv, ttvv;

    SharedPreferences easterPref, winnerScorePref, winnerPref, highscorePref;
    SharedPreferences.Editor easterPrefEditor, winnerScorePrefEditor, winnerPrefEditor, highscorePrefEditor;

    int eastercount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_start);

        easterPref = this.getSharedPreferences("EASTEREGG", MODE_PRIVATE);
        easterPrefEditor = easterPref.edit();

        iv = (ImageView)findViewById(R.id.imageView);
        iv.setOnClickListener(this);

        ttvv = (TextView)findViewById(R.id.textView4);

        starttv = (TextView)findViewById(R.id.startTextView);
        starttv.setOnTouchListener(this);

        anleitungtv = (TextView)findViewById(R.id.anleitungTextView);
        anleitungtv.setOnTouchListener(this);

        quittv = (TextView)findViewById(R.id.quitTextView);
        quittv.setOnTouchListener(this);

        eastercount = easterPref.getInt("icon", 0);

        winnerPref = this.getSharedPreferences("WINNER", MODE_PRIVATE);
        winnerPrefEditor = winnerPref.edit();

        winnerScorePref = this.getSharedPreferences("WINNERSCORE", MODE_PRIVATE);
        winnerScorePrefEditor = winnerScorePref.edit();

        highscorePref = this.getSharedPreferences("HIGHSCORE", MODE_PRIVATE);
        highscorePrefEditor = highscorePref.edit();

        if (winnerPref.getString("winner", "").length() > 0) {
            ttvv.setText(getString(R.string.lastwinner) + " " + winnerPref.getString("winner", ""));
            if (highscorePref.getInt("highscore", 0) > 0){
                ttvv.setText(ttvv.getText() + "  ||  Highscore: " + highscorePref.getInt("highscore", 0));
            }
        }

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

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                switch (v.getId()) {
                    case R.id.startTextView:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            starttv.setTextColor(getColor(R.color.grey_dark));
                        }
                        //container.removeAllViews();
                        //btn.setClickable(true);
                        //btn.setVisibility(View.VISIBLE);
                        return true;
                    case R.id.anleitungTextView:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            anleitungtv.setTextColor(getColor(R.color.grey_dark));
                        }
                        //startActivity(new Intent(getApplicationContext(), Anleitung_Activity.class));
                        //finish();
                        return true;
                    case R.id.quitTextView:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            quittv.setTextColor(getColor(R.color.grey_dark));
                        }
                        //showDialog(0);
                        return true;
                }
                return true;

            case MotionEvent.ACTION_UP:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    starttv.setTextColor(getColor(R.color.black));
                    anleitungtv.setTextColor(getColor(R.color.black));
                    quittv.setTextColor(getColor(R.color.black));
                }
                switch (v.getId()) {
                    case R.id.startTextView:
                        startActivity(new Intent(getApplicationContext(), LayoutMainActivity.class));
                        finish();
                        return true;
                    case R.id.anleitungTextView:
                        startActivity(new Intent(getApplicationContext(), Anleitung_Activity.class));
                        finish();
                        return true;
                    case R.id.quitTextView:
                        showDialog(1);
                        return true;
                }

                return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageView){
            if (eastercount >= 9){
                Toast.makeText(this.getApplicationContext(), R.string.easteregg, Toast.LENGTH_SHORT).show();
            } else {
                eastercount++;
            }
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        easterPrefEditor.putInt("icon", eastercount);
        easterPrefEditor.commit();
    }

    @Override
    public void onBackPressed() {
        showDialog(1);
    }

    @Override
    protected Dialog onCreateDialog (int id) {
        //switch (id) {
        //case 0:
        if (id == 1){
            AlertDialog.Builder mainbuilder = new AlertDialog.Builder(this);
            mainbuilder.setMessage(R.string.wanna_quit);
            mainbuilder.setCancelable(true);

            mainbuilder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
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
}
