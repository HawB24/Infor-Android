package com.example.infor;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // khai bao bien giao dien
    EditText edtName, edtNumber, edtMore;
    Button btnSubmit;
    RadioGroup idGroup;
    CheckBox checkFilm, checkBook, checkSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // anh xa id bien giao dien
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        edtMore = findViewById(R.id.edtMore);
        btnSubmit = findViewById(R.id.btnSubmit);
        idGroup = findViewById(R.id.idGroup);
        checkBook = findViewById(R.id.checkBook);
        checkFilm = findViewById(R.id.checkFilm);
        checkSport = findViewById(R.id.checkSport);
        // xu li Click
        btnSubmit.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             //Lay thong tin ho ten
                                             String name = edtName.getText().toString();
                                             if (name.length() < 3) {
                                                 Toast.makeText(MainActivity.this, "Please Input least 3 words", Toast.LENGTH_SHORT).show();
                                                 edtName.requestFocus();
                                                 edtName.selectAll();
                                                 return;
                                             }
                                             //Lay thong tin sdt
                                             String number = edtNumber.getText().toString();
                                             if (number.length() != 9) {
                                                 Toast.makeText(MainActivity.this, "Please Input 9 number", Toast.LENGTH_SHORT).show();
                                                 edtNumber.requestFocus();
                                                 edtNumber.selectAll();
                                                 return;
                                             }
                                             //Lay thong tin bang cap
                                             int idSelect = idGroup.getCheckedRadioButtonId();
                                             RadioButton radioSelect = findViewById(idSelect);
                                             String bangcap = radioSelect.getText().toString();
                                             //Lay thong tin so thich
                                             String sothich = "";
                                             if (checkBook.isChecked()) {
                                                 sothich += checkBook.getText().toString() + "-";
                                             }
                                             if (checkFilm.isChecked()) {
                                                 sothich += checkFilm.getText().toString() + "-";
                                             }
                                             if (checkSport.isChecked()) {
                                                 sothich += checkSport.getText().toString();
                                             }
                                             //Lay thong tin bo sung
                                             String bosung = edtMore.getText().toString();
                                             String tonghop = name + "\n" + number + "\n" + bangcap + "\n" + sothich + "\n";
                                             tonghop += "--------- Thong tin bo sung -------------\n";
                                             tonghop += bosung + "\n";
                                             tonghop += "-----------------------------------------------------";
                                             // Create Dialog
                                             AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                                             mydialog.setTitle("Thong Tin Ca Nhan");
                                             mydialog.setMessage(tonghop);
                                             mydialog.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                                                 @Override
                                                 public void onClick(DialogInterface dialog, int which) {
                                                     dialog.cancel();
                                                 }
                                             });
                                             mydialog.create().show();
                                         }
                                     }
        );
    }
}