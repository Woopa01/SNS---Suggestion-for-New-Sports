package dsm2017.com.sns.retrofit

import dsm2017.com.sns.retrofit.Model.EmailCodeModel
import dsm2017.com.sns.retrofit.Model.SportsLikeModel
import dsm2017.com.sns.retrofit.Model.UserDataModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface API {

    @POST("/signup")
    @FormUrlEncoded
    fun SignupRequest(@FieldMap map : HashMap<String, String>) : Call<ResponseBody>

    @POST("/signin")
    @FormUrlEncoded
    fun SigninRequest(@FieldMap map : HashMap<String, String>) : Call<UserDataModel>

    @POST("/check/email")
    @FormUrlEncoded
    fun EmailCodeRequest(@FieldMap map : HashMap<String, String>) : Call<EmailCodeModel>

    @POST("/show/list/sports")
    @FormUrlEncoded
    fun ShowMainRequest(@FieldMap map: HashMap<String, String>) : Call<SportsLikeModel>


}