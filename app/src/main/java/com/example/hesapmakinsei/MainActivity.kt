package com.example.hesapmakinsei

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnSayiTık(view: View){
        if(yeniOperator){
            sayıGöster.setText(" ")
        }
        yeniOperator=false
        var btnSeç = view as Button
        var btnTikDeğer : String = sayıGöster.text.toString()
        when(btnSeç.id){
            btn0.id->{
            btnTikDeğer+="0"
           }
            btn1.id->{
                btnTikDeğer+="1"
            }
            btn2.id->{
                btnTikDeğer+="2"
            }
            btn3.id->{
                btnTikDeğer+="3"
            }
            btn4.id->{
                btnTikDeğer+="4"
            }
            btn5.id->{
                btnTikDeğer+="5"
            }
            btn6.id->{
                btnTikDeğer+="6"
            }
            btn7.id->{
                btnTikDeğer+="7"
            }
            btn8.id->{
                btnTikDeğer+="8"
            }
            btn9.id->{
                btnTikDeğer+="9"
            }
            btnArtıEksi.id->{
                btnTikDeğer="-"+btnTikDeğer
            }
        }
        sayıGöster.setText(btnTikDeğer)
    }

    var operator="*"
    var eskiSayi=""
    var yeniOperator=true
    fun btnOpTik(view: View){
        var btnSeç = view as Button
        when(btnSeç.id){
            btnBölme.id->{
            operator="/"
            }
            btnÇarpım.id->{
                operator="*"
            }
            btnÇıkarma.id->{
                operator="-"
            }
            btnTopla.id->{
                operator="+"
            }
        }
        eskiSayi=sayıGöster.text.toString()
        yeniOperator= true
    }

    fun btnEşittirTik(view: View){
        var yeniSayı=sayıGöster.text.toString()
        var sonuçSayisi:Double?=null
        when(operator){
            "/"->{
                sonuçSayisi=eskiSayi.toDouble()/yeniSayı.toDouble()
            }
            "*"->{
                sonuçSayisi=eskiSayi.toDouble()*yeniSayı.toDouble()
            }
            "-"->{
                sonuçSayisi=eskiSayi.toDouble()-yeniSayı.toDouble()
            }
            "+"->{
                sonuçSayisi=eskiSayi.toDouble()+yeniSayı.toDouble()
            }
        }
        sayıGöster.setText(sonuçSayisi.toString())
        yeniOperator=true
    }

    fun btnSilTik(view: View){
      sayıGöster.setText("0")
        yeniOperator=true
    }

    fun btnYüzdeTik(view: View){
        var sayi:Double = sayıGöster.text.toString().toDouble()/100
        sayıGöster.setText(sayi.toString())
        yeniOperator=true

    }

    fun btnNoktaTik(view: View){
       val editable: Editable = sayıGöster.text
        editable.append(".")

    }
}