package com.example.sune.knotscrosses;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean didWin = false;
    boolean firstPlayer = true;
    Button btnTL;
    Button btnTM;
    Button btnTR;
    Button btnML;
    Button btnMM;
    Button btnMR;
    Button btnBL;
    Button btnBM;
    Button btnBR;
    TextView winnerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTL = (Button) findViewById(R.id.TL);
        btnTM = (Button) findViewById(R.id.TM);
        btnTR = (Button) findViewById(R.id.TR);
        btnML = (Button) findViewById(R.id.ML);
        btnMM = (Button) findViewById(R.id.MM);
        btnMR = (Button) findViewById(R.id.MR);
        btnBL = (Button) findViewById(R.id.BL);
        btnBM = (Button) findViewById(R.id.BM);
        btnBR = (Button) findViewById(R.id.BR);
        winnerLabel = (TextView) findViewById(R.id.winnerLabel);
        winnerLabel.setText("First Player");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

           }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void pushButton(View v) {
        if (!didWin) {

            if (v.getId() == btnTL.getId()) {
                updateButton(btnTL);
            }
            if (v.getId() == btnTM.getId()) {
                updateButton(btnTM);
            }
            if (v.getId() == btnTR.getId()) {
                updateButton(btnTR);
            }
            if (v.getId() == btnML.getId()) {
                updateButton(btnML);
            }
            if (v.getId() == btnMM.getId()) {
                updateButton(btnMM);
            }
            if (v.getId() == btnMR.getId()) {
                updateButton(btnMR);
            }
            if (v.getId() == btnBL.getId()) {
                updateButton(btnBL);
            }
            if (v.getId() == btnBM.getId()) {
                updateButton(btnBM);
            }
            if (v.getId() == btnBR.getId()) {
                updateButton(btnBR);
            }
        }
    }

    public void updateButton(Button btn) {
        if (btn.getText() == "") {
            if (firstPlayer) {
                btn.setText("X");
            } else {
                btn.setText("O");
            }
            firstPlayer = !firstPlayer;
        }
        didSomeoneWin();
    }

    public void didSomeoneWin() {
        //Rows
        if (btnTL.getText() == btnTM.getText() && btnTM.getText() == btnTR.getText() && btnTR.getText() !="") {
            didWin = true;
        }
        if (btnML.getText() == btnMM.getText() && btnMM.getText() == btnMR.getText() && btnMR.getText() !="") {
            didWin = true;
        }
        if (btnBL.getText() == btnBM.getText() && btnBM.getText() == btnBR.getText() && btnBR.getText() !="") {
            didWin = true;
        }
        //Coloums
        if (btnTL.getText() == btnML.getText() && btnML.getText() == btnBL.getText() && btnBL.getText() !="") {
            didWin = true;
        }
        if (btnTM.getText() == btnMM.getText() && btnMM.getText() == btnBM.getText() && btnBM.getText() !="") {
            didWin = true;
        }
        if (btnTR.getText() == btnMR.getText() && btnMR.getText() == btnBR.getText() && btnBR.getText() !="") {
            didWin = true;
        }
        //Diagonals
        if (btnTL.getText() == btnMM.getText() && btnMM.getText() == btnBR.getText() && btnBR.getText() !="") {
            didWin = true;
        }
        if (btnTR.getText() == btnMM.getText() && btnMM.getText() == btnBL.getText() && btnBL.getText() !="") {
            didWin = true;
        }

        if (didWin) {
            winnerLabel.setTextColor(Color.RED);
            if (firstPlayer) {
                winnerLabel.setText("Player 2 Wins");
            } else {
                winnerLabel.setText("Player 1 Wins");
            }
        } else {
            if(firstPlayer) {
                winnerLabel.setText("Player 2's Turn");
            } else {
                winnerLabel.setText("Player 1's Turn");
            }
        }
    }

    public void startAgain(View v) {
        btnTL.setText("");
        btnTM.setText("");
        btnTR.setText("");
        btnML.setText("");
        btnMM.setText("");
        btnMR.setText("");
        btnBL.setText("");
        btnBM.setText("");
        btnBR.setText("");
        winnerLabel.setText("Player 1's Turn");
        winnerLabel.setTextColor(Color.BLACK);
        firstPlayer = true;
        didWin = false;
    }


}
