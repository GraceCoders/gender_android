package com.gender.gendercomfortable.controller.services


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gender.gendercomfortable.controller.repository.APIClient
import com.gender.gendercomfortable.controller.repository.APIInterface
import com.gender.gendercomfortable.controller.utills.Constants
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File


object APIRepository {
    private var apiInterface: APIInterface = APIClient.retrofit(Constants.BASE_URL_API)

    //get categories

}





