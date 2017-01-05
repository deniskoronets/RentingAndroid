package ua.in.renting.android;

import android.app.Application;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 03/01/17
 */
public class App extends Application {

    // TODO: 03/01/17 for api testing only

    @Override
    public void onCreate() {
        super.onCreate();

//        final ApiContract.Api api = ApiContract.getApi();
//        final Call<ApiResponse> login = api.login("kkxmshu", "temp");
//        login.enqueue(new Callback<ApiResponse>() {
//            @Override
//            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
//                String value = response.headers().get("Set-Cookie");
//                String token = Utils.extractBetween(SharedStrings.EQUALS, SharedStrings.SEMICOLON, value);
//                toLog("token = " + token);
//                toLog(response.body().getMessage());
//            }
//
//            @Override
//            public void onFailure(Call<ApiResponse> call, Throwable t) {
//                toLog(t.getMessage());
//            }
//        });
    }
}