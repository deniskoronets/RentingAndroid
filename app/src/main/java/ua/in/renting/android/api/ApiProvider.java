package ua.in.renting.android.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ua.in.renting.android.BuildConfig;
import ua.in.renting.android.api.model.ApiResponse;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 03/01/17
 */
public class ApiProvider {

    public static Api getApi() {
        return new Retrofit.Builder().baseUrl(BuildConfig.SERVER_URL)
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(Level.BODY))
                        .build())
                .addConverterFactory(JacksonConverterFactory.create())
                .build().create(Api.class);
    }

    public interface Api {
        @POST(Method.LOGIN)
        Call<ApiResponse> login(@Query(Key.USERNAME) String username,
                                @Query(Key.PASSWORD) String password);
    }

    public interface Key {
        String USERNAME = "username";
        String PASSWORD = "password";
    }

    public interface Method {
        String LOGIN = "user-login";
    }
}