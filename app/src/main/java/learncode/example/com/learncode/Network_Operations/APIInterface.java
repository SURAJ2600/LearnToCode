package learncode.example.com.learncode.Network_Operations;

import learncode.example.com.learncode.DataModelClass.Questions;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vadivel on 14/6/18.
 */

public interface APIInterface {

    @GET("api/android/datastructure.json")
    Call<Questions> getQuestions();
}
