package com.example.healtec_meddy

class SplashScreen : AppCompatActivity() {

    private val SPLASHTIMEOUT:Long = 5000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this,Onboarding1::class.java))
            finish()

        })

        supportActionBar?.hide()


    }
}