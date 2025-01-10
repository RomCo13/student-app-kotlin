package com.example.studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_details)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val checkboxStatus: CheckBox = findViewById(R.id.student_details_activity_checked_button)
        val editTextName: EditText = findViewById(R.id.student_details_activity_name_edit_text)
        val editTextId: EditText = findViewById(R.id.student_details_activity_id_edit_text)
        val editTextPhone: EditText = findViewById(R.id.student_details_activity_phone_edit_text)
        val editTextAddress: EditText = findViewById(R.id.student_details_activity_address_edit_text)
        val buttonEdit: Button = findViewById(R.id.student_details_activity_edit_button)

        val studentName = intent.getStringExtra("studentName")
        val studentId = intent.getStringExtra("studentId")
        val studentPhone = intent.getStringExtra("studentPhone")
        val studentAddress = intent.getStringExtra("studentAddress")
        val studentChecked = intent.getBooleanExtra("isChecked", false)

        studentName?.let { editTextName.setText(it) }
        studentId?.let { editTextId.setText(it) }
        studentPhone?.let { editTextPhone.setText(it) }
        studentAddress?.let { editTextAddress.setText(it) }
        checkboxStatus.isChecked = studentChecked

        buttonEdit.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java).apply {
                putExtra("studentName", studentName)
                putExtra("studentId", studentId)
                putExtra("studentPhone", studentPhone)
                putExtra("studentAddress", studentAddress)
                putExtra("isChecked", studentChecked)
            }
            startActivity(intent)
        }
    }
}