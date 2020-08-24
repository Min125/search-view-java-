package coder.mtk.newappjava.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import coder.mtk.newappjava.api.ApiService;
import coder.mtk.newappjava.model.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {

    MutableLiveData<News> result = new MutableLiveData<>();
    MutableLiveData<Boolean> loadError = new MutableLiveData<>();
    MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public MutableLiveData<News> getResult() {
        return result;
    }

    public MutableLiveData<Boolean> getLoadError() {
        return loadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void loadResult (){
        loading.setValue(true);
        String apiKey = "8f4b1cee839b43ab80645baee4a33881";

        Call<News> newsCall = ApiService.getNews("us","Technology",apiKey);
        newsCall.enqueue(
                new Callback<News>() {
                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        Log.d("responseresult>>",response.body().toString());
                        if (response.isSuccessful() && response.body()!= null){
                            loading.setValue(false);
                            result.setValue(response.body());

                        }
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {
                        loading.setValue(false);
                        loadError.setValue(true);
                        Log.d("Response>>>>",t.toString());
                    }
                }
        );
    }

}
