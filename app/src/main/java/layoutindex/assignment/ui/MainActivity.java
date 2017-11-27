package layoutindex.assignment.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import layoutindex.assignment.Api.RestApi;
import layoutindex.assignment.BaseApplication;
import layoutindex.assignment.R;
import layoutindex.assignment.model.BaseResponse;
import layoutindex.assignment.model.DataItem;
import layoutindex.assignment.ui.adapter.MovieAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rec_movies_list)
    RecyclerView mRecMoviesList;

    @BindView(R.id.txt_search_movie)
    EditText mSearchMovie;

    @Inject
    Retrofit retrofit;
    private MovieAdapter adapter;
    private static List<DataItem> moviesList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ((BaseApplication) getApplication()).getNetworkComponent().inject(this);

        Call<BaseResponse> posts = retrofit.create(RestApi.class).getPosts();

        //Enque the call
        posts.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                //Set the response to the textview
                adapter = new MovieAdapter(MainActivity.this, response.body().getData());
                moviesList.addAll(response.body().getData());
                adapter.setMoviesList(response.body().getData());
                mRecMoviesList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                mRecMoviesList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                //Set the error to the textview
            }
        });

        initSearch();


    }

    private void initSearch() {
        mSearchMovie.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {

                filter(cs.toString()); //need better filtering
                //adapter.getFilter().filter(cs.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

        });
    }

    void filter(String searchText) {
        if (!searchText.equalsIgnoreCase("")) {

            List<DataItem> filteredList = new ArrayList();
            for (DataItem movie : moviesList) {

                if (movie.getMovieName().toLowerCase().contains(searchText.toLowerCase())) {
                    filteredList.add(movie);
                }
            }
            //update recyclerview
            adapter.setMoviesList(filteredList);
        }
    }
}
