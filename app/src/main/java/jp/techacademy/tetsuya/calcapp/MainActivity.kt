package jp.techacademy.tetsuya.calcapp

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import jp.techacademy.tetsuya.calcapp.databinding.ActivityMainBinding
import android.content.Intent


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //追加１　ボタン押せるようにする
        binding.button1.setOnClickListener(this)//足し算
        binding.button2.setOnClickListener(this)//引き算
        binding.button3.setOnClickListener(this)//割り算
        binding.button4.setOnClickListener(this)//掛け算
    }

    override fun onClick(v: View) {

        //editText内に何もない時、returnすればいけるのでは？　→いけた
        if (binding.editText1.text.toString() == "" || binding.editText2.text.toString() == "") {
            return
        } else {


        //追加１　まず、editTextを数値に変換する
        val x: Double = binding.editText1.text.toString().toDouble()
        val y: Double = binding.editText2.text.toString().toDouble()
        //画面遷移できるようにする
        val intent = Intent(this, ResultActivity::class.java)
//        intent.putExtra("VALUE1", x)
//        intent.putExtra("VALUE2", y)


            //画面遷移する前に計算して、遷移した画面にその数値渡せば簡単なのでは？　→いけたわ
            when (v.id) {
                R.id.button1 -> {
                    var z = x + y
                    intent.putExtra("VALUE", z.toFloat())
                }
                R.id.button2 -> {
                    val z = x - y
                    intent.putExtra("VALUE", z.toFloat())
                }
                R.id.button3 -> {
                    val z = x / y
                    intent.putExtra("VALUE", z.toFloat())
                }
                R.id.button4 -> {
                    val z = x * y
                    intent.putExtra("VALUE", z.toFloat())
                }
            }
            startActivity(intent)
        }
    }


}
