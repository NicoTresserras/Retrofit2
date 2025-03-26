package com.example.retrofit2

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2.RetrofitInstance.api
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var apodAdapter: ApodAdapter
    private val apodList = mutableListOf<ApodResponse>()
    val apiKey = "fGP4BDSuz5JY7MOcyxYIke9s0Nf5Ik5BaptfA1bT"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        apodAdapter = ApodAdapter(apodList)
        recyclerView.adapter = apodAdapter

        getApodData()
    }

    private fun getApodData() {
        Log.i("DiosMeSalve","Hola")
        CoroutineScope(Dispatchers.Main).launch {
                val response: Response<ApodResponse> = api.getApod(apiKey)
                Log.i("DiosMeSalve","Hola")
                if (response.isSuccessful) {
                    val apodResponse = response.body()
                    Log.d("APOD", "Response: $apodResponse")
                } else {
                    Log.e("APOD", "Error code: ${response.code()}")
                }
        }

    }
}
