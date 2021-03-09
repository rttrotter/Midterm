package com.niu.cs.z1802019.midterm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity
{
    public int choice = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button go = (Button) findViewById(R.id.button);
        RadioGroup uInput = (RadioGroup) findViewById(R.id.radioGroup);//user selection for mode
        go.setOnClickListener(new View.OnClickListener()
        {
            @Override
           public void onClick(View v)
           {
               if(choice != -1)
                sendMessage(v); // custom method to launch our next activity
           }

        });
        uInput.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if(checkedId == R.id.radioButton)
                {
                    choice = 1;
                }
                else if(checkedId == R.id.radioButton2)
                {
                    choice = 2;
                }
                else if(checkedId == R.id.radioButton3)
                {
                    choice = 3;
                }
            }
        });
    }
    /****************************************
     * sendMessage
     * input View v
     * output: none
     * This will launch our second activity
     * with the user choice selected and pass
     * it as an extra
     *
     ****************************************/
    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("USER_CHOICE",choice);
        startActivity(intent);

    }
}