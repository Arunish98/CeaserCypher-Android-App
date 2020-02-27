package com.example.crypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.SeekBar

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    var length : Int = 0
    var key : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val encrypter : String = inputRuleText.text.toString()
        length = encrypter.length
        val message : String = inputText.text.toString()
        var message1 : String = ""

        for(i in message.indices){

            var value = encrypter.indexOf(message[i])

            if(value != -1){
                message1 = message1.plus(encrypter[(value+key)%(encrypter.length)])
            }
            else{
                message1 = message1.plus(message[i])
            }

        }

        OutputText.text = message1
        slider.setOnSeekBarChangeListener(this)

    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

        key = (length) * (progress/100)
        inputRuleNumber.text = progress.toString()

    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
