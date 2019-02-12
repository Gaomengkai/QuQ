package xyz.dalk.quq

//import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView


abstract class MainActivity : AppCompatActivity() {
    //Initialize
    internal var zhuang: Switch? = null
    internal var zhan: Switch? = null
    internal var qing: Switch? = null
    internal var zimo: Switch? = null
    internal var jia: Switch? = null
    internal var dian: Switch? = null
    internal var bao: Switch? = null
    internal var tong: Switch? = null
    internal var qi: Switch? = null
    internal var piao: Switch? = null
    internal var zd: Switch? = null
    private var wohule: CheckBox? = null
    internal var mine = 0
    internal var others = 0
    private var wodan: EditText? = null
    private var tadan: EditText? = null
    internal var score: TextView? = null
    private var dianpao = false
    internal var hu = false
    private var zdp = false
    private var z = false

    private var fcuk = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zhuang= findViewById(R.id.zhuang)
        zhan = findViewById(R.id.zhan)
        qing = findViewById(R.id.qing)
        zimo = findViewById(R.id.zimo)
        jia = findViewById(R.id.jia)
        piao = findViewById(R.id.piao)
        dian = findViewById(R.id.dian)
        bao = findViewById(R.id.bao)
        tong = findViewById(R.id.tong)
        qi = findViewById(R.id.qi)
        zd = findViewById(R.id.zd)
        wohule = findViewById(R.id.hu)
        wodan = findViewById(R.id.mine)
        tadan = findViewById(R.id.others)
        score = findViewById(R.id.score)
        run {
    zhuang!!.setOnCheckedChangeListener { buttonView, isChecked ->
        z = isChecked
        if (isChecked) zd!!.isChecked = false
        refresh()
    }
    zhan!!.setOnCheckedChangeListener { _, isChecked ->
        fcuk[1] = if (isChecked) 1 else 0
        refresh()
    }
    qing!!.setOnCheckedChangeListener { _, isChecked ->
        fcuk[2] = if (isChecked) 1 else 0
        refresh()
    }
    zimo!!.setOnCheckedChangeListener { buttonView, isChecked ->
        if (isChecked) {
            fcuk[3] = 1
            dian!!.isChecked = false
            tong!!.isChecked = false
        } else {
            bao!!.isChecked = false
            fcuk[3] = 0
        }
        refresh()
    }
    jia!!.setOnCheckedChangeListener { buttonView, isChecked ->
        if (isChecked) {
            qi!!.isChecked = false
            piao!!.isChecked = false
            fcuk[4] = 1
        } else {
            fcuk[4] = 0
        }
        refresh()
    }
    dian!!.setOnCheckedChangeListener { buttonView, isChecked ->
        if (isChecked) {
            dianpao = true
            zimo!!.isChecked = false
        } else {
            dianpao = false
        }
        refresh()
    }
    bao!!.setOnCheckedChangeListener { buttonView, isChecked ->
        if (isChecked) {
            tong!!.isChecked = false
            zimo!!.isChecked = true
            dian!!.isChecked = false
            fcuk[5] = 1
        } else {
            fcuk[5] = 0
        }
        refresh()
    }
    tong!!.setOnCheckedChangeListener { buttonView, isChecked ->
        if (isChecked) {
            bao!!.isChecked = false
            zimo!!.isChecked = false
            dianpao = false
            dian!!.isChecked = false
            fcuk[6] = 2
        } else {
            fcuk[6] = 0
        }
        refresh()
    }
    qi!!.setOnCheckedChangeListener { buttonView, isChecked ->
        if (isChecked) {
            piao!!.isChecked = false
            jia!!.isChecked = false
            fcuk[7] = 3
        } else {
            fcuk[7] = 0
        }
        refresh()
    }
    piao!!.setOnCheckedChangeListener { buttonView, isChecked ->
        if (isChecked) {
            qi!!.isChecked = false
            jia!!.isChecked = false
            fcuk[8] = 2
        } else {
            fcuk[8] = 0
        }
        refresh()
    }
    wohule!!.setOnCheckedChangeListener { buttonView, isChecked ->
        hu = isChecked
        refresh()
    }
    zd!!.setOnCheckedChangeListener { buttonView, isChecked ->
        if (isChecked) {
            zhuang!!.isChecked = false
            dian!!.isChecked = false
            dianpao = false
            zdp = true
        } else {
            zdp = false
        }
        refresh()
    }
    wodan!!.setOnEditorActionListener { v, _, _ ->
        val s = v.text.toString()
        mine = if (s != "") {
            Integer.parseInt(s)
        } else {
            0
        }
        refresh()
        false
    }
    tadan!!.setOnEditorActionListener { v, actionId, event ->
        val s = v.text.toString()
        others = if (s != "") {
            Integer.parseInt(s)
        } else {
            0
        }
        refresh()
        false
    }
}
    }

    private fun refresh() {
        var pw = 0
        for (i in 0..8) {
            pw += fcuk[i]
        }
        val base = Math.pow(2.0, pw.toDouble()).toInt()
        var scoreHere: Int
        if (hu) {
            scoreHere = if (zdp) {
                6 * base
            } else {
                if (dianpao) {
                    if (z)  8 * base
                    else 5 * base
                } else {
                    //前面自摸已经算过翻倍了，所以此处不乘自摸
                    if (z) 6 * base
                    else 4 * base
                }
            }
        } else {
            scoreHere = if (dianpao) {
                if (z) {
                    -4 * base
                } else {
                    -2 * base
                }
            } else {
                if (z) {
                    -2 * base
                } else {
                    -1 * base
                }
            }
        }
        scoreHere += 3 * mine
        scoreHere -= others
        val s = scoreHere.toString()
        score!!.text = s

    }
}
