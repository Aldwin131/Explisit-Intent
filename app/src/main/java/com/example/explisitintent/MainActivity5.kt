package com.example.explisitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity5 : AppCompatActivity() {

    companion object {
        const val SelectedItem = "extra_selected_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val _rgItems = findViewById<RadioGroup>(R.id.rgItems)
        val _btnConfirm = findViewById<Button>(R.id.btnConfirm)

        _btnConfirm.setOnClickListener {
            val selectedRadioButtonId = _rgItems.checkedRadioButtonId

            if (selectedRadioButtonId != -1) {
                val _selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val selectedItem = _selectedRadioButton.text.toString()

                val resultIntent = Intent().apply {
                    putExtra(SelectedItem, selectedItem)
                }
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}