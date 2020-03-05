package com.example.crypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.SeekBar
import androidx.core.widget.addTextChangedListener
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var encrypter = ceaserText.text.toString()
        var length = encrypter.length
        var text1 = Text1.text.toString()
        var step = 0

        fun encode(message : String,key : Int) : String{

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
            return message1
        }





        Text1.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable) {
            }

            override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
                text1 = Text1.text.toString()
                Text2.text = encode(text1,step)
            }

        })


        ceaserText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable) {
            }

            override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
                length = p0.length
                encrypter = ceaserText.text.toString()
                Text2.text = encode(text1,step)

            }
        })


        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
               // val step = (i/100)*length
                inputRuleNumber.text = "${length*i/100}"
                step = length*i/100
                Text2.text = encode(text1,step)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
            }
        })




    }
}
