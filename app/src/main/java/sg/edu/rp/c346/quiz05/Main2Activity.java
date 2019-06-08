package sg.edu.rp.c346.quiz05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        summary =findViewById(R.id.tvSummary);

        //get value
        Intent intentValue = getIntent();

        int pax = Integer.parseInt(intentValue.getStringExtra("pax"));
        String type = intentValue.getStringExtra("type");

        if (type.equals("round")){
            int ttl = pax * 2 * 100;
            summary.setText("You have selected Round Trip\nYour air tickets costs $" + ttl);
        } else {
            int ttl = pax * 100;
            summary.setText("You have selected One Way Trip\nYour air tickets costs $" + ttl);
        }
    }
}
