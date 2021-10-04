package com.example.basicuicomponent

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import android.widget.TextView
import com.example.basicuicomponent.databinding.ActivityMainBinding
import android.widget.ArrayAdapter


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private var txtview: TextView?=null
    private var edtview: EditText?=null
    private var autocompletetextview:AutoCompleteTextView?=null
    private var multiautocompletetextv:MultiAutoCompleteTextView?=null
    var courseNames = arrayOf("Android Developer Course", "iOS Developer Course",
        "Java Developer Course")
    var myAdapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        txtview=findViewById(R.id.txtValue)
        edtview=findViewById(R.id.edtValue)
        autocompletetextview=findViewById(R.id.autoCompleteTextView)
        multiautocompletetextv=findViewById(R.id.multiAutoCompleteTextView)

        txtview?.text="Awesome"
        txtview?.setBackgroundColor(Color.BLUE)

        txtview?.setOnClickListener(this@MainActivity)
        edtview?.setOnClickListener(this@MainActivity)

        myAdapter= ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,courseNames)
        autocompletetextview?.setAdapter(myAdapter)
        multiautocompletetextv?.setAdapter(myAdapter)
        multiautocompletetextv?.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.txtValue->{
                txtview?.setTextColor(Color.RED)
            }
            R.id.edtValue->{
                txtview?.text=edtview?.text
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}