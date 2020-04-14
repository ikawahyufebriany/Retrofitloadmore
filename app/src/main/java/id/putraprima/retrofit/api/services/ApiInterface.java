package id.putraprima.retrofit.api.services;


import java.util.List;

import id.putraprima.retrofit.api.models.AppVersion;
import id.putraprima.retrofit.api.models.Data;
import id.putraprima.retrofit.api.models.EditPassReq;
import id.putraprima.retrofit.api.models.EditPassRess;
import id.putraprima.retrofit.api.models.EditProfileReq;
import id.putraprima.retrofit.api.models.EditProfileRes;
import id.putraprima.retrofit.api.models.Envelope;
import id.putraprima.retrofit.api.models.LoginRequest;
import id.putraprima.retrofit.api.models.LoginResponse;
import id.putraprima.retrofit.api.models.Profile;
import id.putraprima.retrofit.api.models.Recipe;
import id.putraprima.retrofit.api.models.RegisterRequest;
import id.putraprima.retrofit.api.models.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface{
    @GET("/")
    Call<AppVersion> getAppVersion();

    @POST("/api/auth/login")
    Call<LoginResponse> loginRequest(@Body LoginRequest loginRequest);

    @POST("/api/auth/register")
    Call<RegisterResponse> tryRegister(@Body RegisterRequest registerReq);

    @GET("/api/auth/me")
    Call<Data<Profile>> showProfile(@Header("Authorization") String token);

    @PATCH("/api/account/profile")
    Call<EditProfileRes> editProfile(@Header("Authorization") String token,@Body EditProfileReq req);

    @PATCH("/api/account/password")
    Call<EditPassRess> editPassword(@Header("Authorization") String token,@Body EditPassReq req);

    @GET("/api/recipe/")
    Call<Envelope<List<Recipe>>> getDataRecipe(@Query("page") int load);
}
