package layoutindex.assignment.Api;

import layoutindex.assignment.model.BaseResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rasslk on 11/15/2017.
 */

public interface RestApi {

    @GET("android-test/movies.php")
    Call<BaseResponse> getPosts();

}
