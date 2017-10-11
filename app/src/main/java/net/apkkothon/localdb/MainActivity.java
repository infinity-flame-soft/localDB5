package net.apkkothon.localdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName,etProfession;
    private Button btAdd,btShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=(EditText)findViewById(R.id.et_name);
        etProfession=(EditText)findViewById(R.id.et_prof);
        btAdd=(Button)findViewById(R.id.bt_add);
        btShow=(Button)findViewById(R.id.bt_show);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=etName.getText().toString();
                String prof=etProfession.getText().toString();

                Model model=new Model(name,prof);

                MyDBFunctions myDBFunctions=new MyDBFunctions(MainActivity.this);

                myDBFunctions.addToTable(model);

                Toast.makeText(MainActivity.this,"Data Added Successfully ",Toast.LENGTH_SHORT).show();

            }
        });

        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ShowActivity.class));
            }
        });


    }
}
