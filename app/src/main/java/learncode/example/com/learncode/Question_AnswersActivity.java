package learncode.example.com.learncode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class Question_AnswersActivity extends AppCompatActivity {

    private TextView txt_question;

    private TextView txt_answer;

    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__answers);


        InitializeView();
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null


        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent=  getIntent();


        if(intent.getExtras() != null)
        {

            String mQuestion_valuefromintent=intent.getStringExtra("Question");
            String mAnswer_valuefromintent=intent.getStringExtra("Answer");
            Integer mIndex=Integer.parseInt(intent.getStringExtra("Postion"))+1;


            txt_question.setText(mIndex+") "+mQuestion_valuefromintent);
            txt_answer.setText("Answer : \n"+mAnswer_valuefromintent);



        }
    }

    private void InitializeView() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txt_question=findViewById(R.id.txt_question);
        txt_answer=findViewById(R.id.txt_answer);
    }


    /*
    *
    *
    *
    *
    * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);

    }


}
