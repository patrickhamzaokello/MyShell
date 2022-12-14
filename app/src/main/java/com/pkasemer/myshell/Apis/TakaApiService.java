package com.pkasemer.myshell.Apis;

import com.pkasemer.myshell.Models.FileResponse;
import com.pkasemer.myshell.Models.HomeFeed;
import com.pkasemer.myshell.Models.PickupResponse;
import com.pkasemer.myshell.Models.RequestPickupModel;
import com.pkasemer.myshell.Models.UserOrders;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


public interface TakaApiService {


    //    get all infrastructure
//    http://localhost:8080/projects/TakaMap/mobile/api/v1/infrastructure/read.php?page=1
//    @GET("read.php")
//    Call<HomeFeed> getAllInfrastructure(
//            @Query("page") int pageIndex
//    );

    @GET("near_me.php")
    Call<HomeFeed> getAllInfrastructure(
            @Query("page") int pageIndex
    );

    //post Address
    @POST("request_pickup.php")
    @Headers("Cache-Control: no-cache")
    Call<PickupResponse> postCreatePickupRequest(
            @Body RequestPickupModel requestPickupModel
    );


    //fetch past orders
    @GET("orders/userOrders.php")
    Call<UserOrders> getUserOrders(
            @Query("customerId") int customerID,
            @Query("page") int pageIndex
    );

    @Multipart
    @POST("report_case.php")
    Call<FileResponse> postReport(
            @Part("userID") RequestBody userID,
            @Part("title") RequestBody title,
            @Part("description") RequestBody description,
            @Part MultipartBody.Part file
    );


}