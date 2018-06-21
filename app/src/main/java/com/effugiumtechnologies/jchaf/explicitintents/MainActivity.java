package com.effugiumtechnologies.jchaf.explicitintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnActivity2, btnActivity3;
    TextView tvMessage;
    final int ACTIVITY3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        btnActivity2 = (Button) findViewById(R.id.btnActivtity2);
        btnActivity3 = (Button) findViewById(R.id.btnActivity3);
        final int ACTIVITY3 = 3;

        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();

                Intent intent = new Intent(MainActivity.this,
                        com.effugiumtechnologies.jchaf.explicitintents.Activity2.class);
                intent.putExtra("username", name);
                startActivity(intent);
            }
        });

        btnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        com.effugiumtechnologies.jchaf.explicitintents.Activity3.class);
                startActivityForResult(intent, ACTIVITY3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String surname;
        String name;

        if(requestCode == ACTIVITY3 && resultCode == RESULT_OK){
            surname = data.getStringExtra("surname");
            name = etName.getText().toString().trim();

            tvMessage.setText(name + " " + surname);
        } else if(resultCode ==  RESULT_CANCELED) {
            Toast.makeText(this, "The user did not enter anything!", Toast.LENGTH_SHORT).show();
        }
    }
}
