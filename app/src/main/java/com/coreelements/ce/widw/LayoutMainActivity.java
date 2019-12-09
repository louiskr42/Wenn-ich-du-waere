package com.coreelements.ce.widw;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LayoutMainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, View.OnKeyListener {

    Button btn, btn2, deletebtn;
    EditText et;
    ListView lv;
    Spinner sp;

    int i = 1;
    int b = 1;

    SharedPreferences sPref, sPrefCount, playerSizePref, categoryPref;
    SharedPreferences.Editor sPrefEditor, sPrefEditorCount, playerSizePrefEditor, categoryPrefEditor;

    List<String> listPlayers = new ArrayList<String>();
    ArrayAdapter<String> adapterPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        adapterPlayers = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listPlayers);

        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);

        deletebtn = (Button)findViewById(R.id.deleteButton);
        deletebtn.setOnClickListener(this);

        btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(this);

        sp = (Spinner)findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);
        fillSpinner();

        et = (EditText)findViewById(R.id.editText);
        et.setOnKeyListener(this);

        sPref = this.getSharedPreferences("PLAYERS", MODE_PRIVATE);
        sPrefEditor = sPref.edit();

        sPrefCount = this.getSharedPreferences("COUNT", MODE_PRIVATE);
        sPrefEditorCount = sPrefCount.edit();

        playerSizePref = this.getSharedPreferences("SIZE", MODE_PRIVATE);
        playerSizePrefEditor = playerSizePref.edit();

        categoryPref = this.getSharedPreferences("CATEGORY", MODE_PRIVATE);
        categoryPrefEditor = categoryPref.edit();
    }

    public void fillSpinner(){
        List<String> listCategory = new ArrayList<String>();
        ArrayAdapter<CharSequence> adapterCategory;
        adapterCategory = ArrayAdapter.createFromResource(this, R.array.places, android.R.layout.simple_spinner_item);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapterCategory);
    }

    //@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        categoryPrefEditor.putString("category", item);
        categoryPrefEditor.commit();
        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + categoryPref.getString("category", ""), Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onClick(View v) {
        String eingabe = et.getText().toString().replace("a", "A").replace("b", "B").replace("c", "C").replace("d", "D")
                .replace("e", "E").replace("f", "F").replace("g", "G").replace("h", "H").replace("i", "I").replace("j", "J")
                .replace("k", "K").replace("l", "L").replace("m", "M").replace("n", "N").replace("o", "O").replace("p", "P")
                .replace("q", "Q").replace("r", "R").replace("s", "S").replace("t", "T").replace("u", "U").replace("v", "V")
                .replace("w", "W").replace("x", "X").replace("y", "Y").replace("z", "Z").replace(" ", "");
        if (v.getId() == R.id.button) {
            if (eingabe.length() > 0) {

                lv = (ListView) findViewById(R.id.listView);
                lv.setAdapter(adapterPlayers);

                sPrefEditor.putString("" + i, eingabe);
                sPrefEditor.commit();

                sPrefEditorCount.putInt("" + i, 0);
                sPrefEditorCount.commit();

                listPlayers.add(sPref.getString("" + i, ""));
                et.setText("");
                playerSizePrefEditor.putInt("playersize", listPlayers.size());
                playerSizePrefEditor.commit();
                i++;
                b++;

            } else {
                Toast.makeText(getApplicationContext(), getString(R.string.enter_name), Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.deleteButton){
            lv = (ListView) findViewById(R.id.listView);
            lv.setAdapter(adapterPlayers);

            i = 1;
            b = 1;

            listPlayers.clear();
            et.setText("");
            playerSizePrefEditor.putInt("playersize", listPlayers.size());
            playerSizePrefEditor.commit();


        } else {
            if (listPlayers.size() > 1) {
                startActivity(new Intent(this.getApplicationContext(), Game.class));
                finish();
            } else if (listPlayers.size() == 1){
                showDialog(1);
            } else {
                Toast.makeText(getApplicationContext(), getString(R.string.enter_name), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(this.getApplicationContext(), Start.class));
        finish();
    }

    @Override
    protected Dialog onCreateDialog (int id) {
        //switch (id) {
        //case 0:
        if (id == 1){
            AlertDialog.Builder mainbuilder = new AlertDialog.Builder(this);
            mainbuilder.setMessage(R.string.play_lonly);
            mainbuilder.setCancelable(true);

            mainbuilder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(getApplicationContext(), Game.class));
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

    @Override
    public void onPause() {
        super.onPause();

        //categoryPrefEditor.put("category", sp.getSelectedItem());
        sp.getSelectedItem();
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        String eingabe = et.getText().toString();
        eingabe.toUpperCase();

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_ENTER:
                    onClick(btn);
                    return true;
                default:
                    break;
            }

        }
        return false;
    }
}
