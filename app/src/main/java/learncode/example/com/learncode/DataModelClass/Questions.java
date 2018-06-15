package learncode.example.com.learncode.DataModelClass;

/**
 * Created by vadivel on 14/6/18.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Questions {

    @SerializedName("questions")
    @Expose
    private List<Question> questions = null;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}