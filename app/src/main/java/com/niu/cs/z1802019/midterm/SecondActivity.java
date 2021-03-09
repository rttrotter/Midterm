package com.niu.cs.z1802019.midterm;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
public class SecondActivity extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //variables
        final Button calculate = (Button) findViewById(R.id.calcButton);
        final Button backButton = (Button) findViewById(R.id.returnButton);
        TextView title = findViewById(R.id.titleActivityTwo);
        TextView u1 = findViewById(R.id.unit1);
        TextView u2 = findViewById(R.id.unit2);
        EditText input = findViewById(R.id.inputActivitytwo);
        TextView output = findViewById(R.id.outputActivityTwo);
        Intent intent = getIntent();
        DecimalFormat form = new DecimalFormat("#.###");//setting output pattern
        int choice = intent.getIntExtra("USER_CHOICE",-1); // pull the choice from main activity

        //initialize our text upon load in
        if(choice == 1)//feet to meters
        {
            title.setText(getString(R.string.conversion_one_name));
            u1.setText("Feet");
            u2.setText("meters");
        }
        else if(choice == 2)// inches to centimeters
        {
            title.setText(getString(R.string.conversion_two_name));
            u1.setText("inches");
            u2.setText("centimeters");
        }
        else if(choice == 3) // pounds to grams
        {
            title.setText(getString(R.string.conversion_three_name));
            u1.setText("pounds");
            u2.setText("grams");
        }
        else//return to activity main if there's a problem with selection
        {
            finish();
        }
        
        //on button press we set our output text to 3 significant digits
        calculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                output.setText(form.format(calculate(choice,Double.parseDouble(input.getText().toString()))));
            }
        });
        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

    }
    /**************************************
     * calculate
     * inputs: int algorithm, double user value
     * output: double output
     * This function uses the algorithm chooses and
     * does the proper conversion calculation
     * then returns the output as an double
     *
     *************************************/

    double calculate(int type, double input)
    {
        double value = 0;
        if(type == 1)
        {
            value = input/3;
        }
        else if(type == 2)
        {
            value = input * 2.54;
        }
        else
        {
            value = input * 453.592;
        }
        return value;
    }
}
