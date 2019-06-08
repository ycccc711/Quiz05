package sg.edu.rp.c346.quiz05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button plus,minus,submit;
    CheckBox one,round;
    TextView pax;
    int paxNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = findViewById(R.id.cbOne);
        round = findViewById(R.id.cbRound);

        plus = findViewById(R.id.btnPlus);
        minus = findViewById(R.id.btnMinus);
        submit = findViewById(R.id.btnSubmit);

        pax = findViewById(R.id.tvPax);
        paxNum = Integer.parseInt(pax.getText().toString());

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(paxNum > 0){
                    Toast.makeText(MainActivity.this, "No. of pax should not be negative", Toast.LENGTH_SHORT).show();
                    paxNum -- ;
                    pax.setText(String.valueOf(paxNum)+"");
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paxNum++;
                pax.setText(String.valueOf(paxNum)+"");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pax.getText().toString().equals("0")) {
                    Toast.makeText(MainActivity.this, "No zero value can be entered", Toast.LENGTH_LONG).show();
                    //submit.setEnabled(false);
                }
                //check - only one selection
                else if(one.isChecked() == true && round.isChecked() == true){
                    Toast.makeText(MainActivity.this, "Invalid ticket type selected", Toast.LENGTH_SHORT).show();
                }
                else if(one.isChecked() == false && round.isChecked() == false){
                    Toast.makeText(MainActivity.this, "Invalid ticket type selected", Toast.LENGTH_SHORT).show();
                }else{
                   Intent intent = new Intent(MainActivity.this,Main2Activity.class);

                    if (one.isChecked()){
                        intent.putExtra("type", "One way");
                    } else {
                        intent.putExtra("type", "round");
                    }
                    intent.putExtra("pax", pax.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}
