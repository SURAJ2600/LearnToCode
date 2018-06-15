package learncode.example.com.learncode.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import learncode.example.com.learncode.DataModelClass.Question;
import learncode.example.com.learncode.DataModelClass.Questions;
import learncode.example.com.learncode.Question_AnswersActivity;
import learncode.example.com.learncode.R;

/**
 * Created by vadivel on 14/6/18.
 */


public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.MyViewHolder> {
    Questions mQuestion_data;
    private Context mContexts;


    public QuestionAdapter(Context mContext, Questions mQuestion_data) {
        this.mContexts = mContext;
        this.mQuestion_data = mQuestion_data;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.question_lititem_layout;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttach = false;
        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttach);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        if (position % 2 == 1) {
            holder.main_layout.setBackgroundColor(ContextCompat.getColor(mContexts, R.color.colorLightPrimary));
        } else {
            holder.main_layout.setBackgroundColor(ContextCompat.getColor(mContexts, R.color.colorWhite));


        }

        Question mQuestion_object = mQuestion_data.getQuestions().get(position);

        holder.Question_title.setText(position+1+") " + mQuestion_object.getQuestion());


    }

    @Override
    public int getItemCount() {
        return mQuestion_data.getQuestions().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView Question_title;
        public ImageView img_rightarrow;
        public LinearLayout main_layout;

        public MyViewHolder(View itemView) {
            super(itemView);

            Question_title = itemView.findViewById(R.id.txt_questions);
            img_rightarrow = itemView.findViewById(R.id.img_rightarrow);

            main_layout = itemView.findViewById(R.id.main_layout);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    /*
                    *
                    * Passing the clicked postion value to Question_AnswerActivity
                    *
                    *
                    * */

                    int Clickedpostion = getAdapterPosition();
                    Intent intent = new Intent(mContexts, Question_AnswersActivity.class);
                    intent.putExtra("Question", "" + mQuestion_data.getQuestions().get(Clickedpostion).getQuestion());
                    intent.putExtra("Answer", "" + mQuestion_data.getQuestions().get(Clickedpostion).getAnswer());
                    intent.putExtra("Postion", "" + Clickedpostion);

                    mContexts.startActivity(intent);


                }
            });
        }
    }


}
