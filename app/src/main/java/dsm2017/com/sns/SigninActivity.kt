package dsm2017.com.sns

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import dsm2017.com.sns.R.id.*
import dsm2017.com.sns.retrofit.Connect
import dsm2017.com.sns.retrofit.Model.UserDataModel
import kotlinx.android.synthetic.main.activity_signin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        signin_main_button.setOnClickListener {
           // SignInRequest(signin_id.text.toString(),signin_password.text.toString())
            val intent = Intent(SigninActivity@this,MainActivity::class.java)
            startActivity(intent)
        }

        signin_signup_button.setOnClickListener {
            val intent = Intent(SigninActivity@this,SignupActivity::class.java)
            startActivity(intent)
        }


    }

    fun SignInRequest(user_id : String, user_password : String) {
        val map = hashMapOf<String,String>("user_id" to user_id, "user_password" to user_password)

        Connect.api.SigninRequest(map)
                .enqueue(object : retrofit2.Callback<UserDataModel>{
                    override fun onResponse(call: Call<UserDataModel>?, response: Response<UserDataModel>?) {
                        var userDataModel = response!!.body()
                        var username : String = ""
                        var usertoken : String = ""
                        for(item in userDataModel!!.user){
                             username = userDataModel!!.UserDatas().user_name
                             usertoken = userDataModel!!.UserDatas().user_token
                        }
                        Toast.makeText(baseContext, username, Toast.LENGTH_SHORT).show()

                    }

                    override fun onFailure(call: Call<UserDataModel>?, t: Throwable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
    }
}

