package learncode.example.com.learncode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import learncode.example.com.learncode.Adapters.QuestionAdapter;
import learncode.example.com.learncode.DataModelClass.Questions;
import learncode.example.com.learncode.Network_Operations.APIClient;
import learncode.example.com.learncode.Network_Operations.APIInterface;
import learncode.example.com.learncode.Utils.AppDebug;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    APIInterface apiInterface;
    RecyclerView recyclerView;
    QuestionAdapter mAdapter;
    Questions questions_datas;
    TextView txt_nodatafound;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        *
        * Method for intialize all the view id from corresponding layout
        *
        * *
        */


        InitializeView();
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null

        toolbar.setTitle("Data Structures");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        /*
        *
        *
        *
        *
        *
        *
        * */

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());





        /*
        *
        * Getting the apiinterface from APIInterface class
        *
        * */
        apiInterface = APIClient.getClient().create(APIInterface.class);


        /**
         GET List Of Questions from Server
         **/
        Call<Questions> call = apiInterface.getQuestions();

        call.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {


                if (response != null) {

                    AppDebug.d("RESPONCE FROM SERVER :", ">>>>>>>>>" + response.body());
                    questions_datas = response.body();
                    mAdapter = new QuestionAdapter(getApplicationContext(), questions_datas);
                    recyclerView.setAdapter(mAdapter);
                } else {

                }


            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {
                AppDebug.e("RESPONCE FROM SERVER :", ">>>>>>>>>" + t);

            }


        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);

    }

    private void InitializeView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        txt_nodatafound = (TextView) findViewById(R.id.txt_nodatafound);
    }

}
