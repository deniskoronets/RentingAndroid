package ua.in.renting.android.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ua.in.renting.android.BuildConfig;
import ua.in.renting.android.api.model.Advertisement;
import ua.in.renting.android.api.model.ApiResponse;
import ua.in.renting.android.api.model.Auth;
import ua.in.renting.android.api.model.User;

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
        @POST(Method.REGISTRATION)
        Call<ApiResponse> register(@Body User user);

        @POST(Method.LOGIN)
        Call<ApiResponse> login(@Body Auth auth);

        @GET(Method.USER)
        Call<ApiResponse<User>> getUser(@Query(Key.ID) long id);

        @GET(Method.USER_ME)
        Call<ApiResponse<User>> getUser();

        @POST(Method.USER_ME)
        Call<ApiResponse> setUser(@Body User user, @Body Auth auth);

        @GET(Method.ADS)
        Call<ApiResponse<Advertisement>> getAdvertisement(@Query(Key.ID) long id);

        @GET(Method.ADS_FILTER)
        Call<ApiResponse> getFilters();
    }

    public interface Key {
        String ID = "id";
        String USERNAME = "username";
        String PASSWORD = "password";
        String FIRST_NAME = "first_name";
        String LAST_NAME = "last_name";
        String EMAIL = "email";
        String CITY_ID = "city_id";
        String GROUP_TYPE = "group_type";
    }

    public interface Method {
        String LOGIN = "user-login";
        String REGISTRATION = "user-registration";

        String USER = "user";
        String USER_ME = "user-me";

        String ADS = "ads";
        String ADS_FILTER = "ads-filters";
        String ADS_PHOTO = "ads-photos";
        String ADS_MY = "ads-my";
        String ADS_STATUS = "ads-status";
        String ADS_SAVED = "ads-saved";

        String REGION = "regions";
        String CATEGORIES = "categories";
        String MAP = "map";

        String DIALOG = "dialogs";
        String NOTIFICATION = "notifications";
        String TRANSLATE = "translate";
    }
}