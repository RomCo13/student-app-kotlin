package com.example.studentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, windowInsets ->
            val systemBarInsets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBarInsets.left, systemBarInsets.top, systemBarInsets.right, systemBarInsets.bottom)
            windowInsets
        }

        val consentCheckBox: CheckBox = findViewById(R.id.add_student_activity_checked_button)
        val confirmButton: Button = findViewById(R.id.add_student_activity_save_button)
        val backButton: Button = findViewById(R.id.add_student_activity_cancel_button)
        val studentNameEditText: EditText = findViewById(R.id.add_student_activity_name_edit_text)
        val studentIdEditText: EditText = findViewById(R.id.add_student_activity_id_edit_text)
        val studentPhoneEditText: EditText = findViewById(R.id.add_student_activity_phone_edit_text)
        val studentAddressEditText: EditText = findViewById(R.id.add_student_activity_address_edit_text)
        val statusTextView: TextView = findViewById(R.id.add_student_activity_save_message_text_view)

        backButton.setOnClickListener{
            finish()
        }

        confirmButton.setOnClickListener {
            val studentName = studentNameEditText.text.toString()
            val studentId = studentIdEditText.text.toString()
            val studentPhone = studentPhoneEditText.text.toString()
            val studentAddress = studentAddressEditText.text.toString()
            val consentStatus = if (consentCheckBox.isChecked) "Checked" else "Unchecked"

            statusTextView.text = "Name: $studentName, ID: $studentId, Phone: $studentPhone, Address: $studentAddress, Status: $consentStatus saved!"
        }
    }
}
