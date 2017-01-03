package ua.in.renting.android;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.in.renting.android.api.ApiContract;
import ua.in.renting.android.api.model.ApiResponse;
import ua.in.renting.android.utility.SharedStrings;
import ua.in.renting.android.utility.Utils;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 03/01/17
 */
public class App extends Application {

    // TODO: 03/01/17 for api testing only

    @Override
    public void onCreate() {
        super.onCreate();

        final ApiContract.Api api = ApiContract.getApi();
        final Call<ApiResponse> login = api.login("kkxmshu", "temp");
        login.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                String value = response.headers().get("Set-Cookie");
                String token = Utils.extractBetween(SharedStrings.EQUALS, SharedStrings.SEMICOLON, value);
                toLog("token = " + token);
                toLog(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                toLog(t.getMessage());
            }
        });
    }

    private static void toLog(String message) {
        if (!TextUtils.isEmpty(message)) {
            Log.d(App.class.getSimpleName(), message);
        }
    }
}