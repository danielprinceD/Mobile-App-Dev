package com.example.studentdatabase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentdatabase.DB.Student
import com.example.studentdatabase.DB.StudentDAO
import com.example.studentdatabase.DB.StudentDatabase
import java.util.Locale
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    private lateinit var nameField: EditText
    private lateinit var emailField: EditText
    private lateinit var saveBtn: Button
    private lateinit var clearBtn: Button
    private lateinit var viewModel: StudentViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : StudentRVAdapter
    private lateinit var selectedOne : Student
    private var isSelected : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            nameField = findViewById(R.id.name)
            emailField = findViewById(R.id.editTextText2)
            saveBtn = findViewById(R.id.btnSave)
            clearBtn = findViewById(R.id.btnClear)
            var dao = StudentDatabase.getInstance(application).getStudentDao()
            var factory = StudentVMFactory(dao)
            viewModel = ViewModelProvider(this, factory).get(StudentViewModel::class.java)
            saveBtn.setOnClickListener {
                if(!isSelected) saveFunction()
                else updateFunction()
            }
            nameField.requestFocus()
            recyclerView = findViewById(R.id.recyclerView)
            initRecyclerView()
            clearBtn.setOnClickListener {
                if(!isSelected) clearFunction()
                else deleteFunction()
            }
        }catch(ex : Exception){
            Toast.makeText(this , "${ex.message}" , Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StudentRVAdapter{
            clickEvent(it)
        }
        recyclerView.adapter = adapter
        displayList()
    }

    private fun clickEvent(student : Student){
        nameField.setText(student.name)
        emailField.setText(student.email)
        selectedOne = student
        isSelected = true
        saveBtn.text = "Update"
        clearBtn.text = "Delete"
    }

    private fun displayList(){
        viewModel.students.observe(this){
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }
    }

    private fun checkEmail() : Boolean{
        val email : String = emailField.text.toString()
            return Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
            ).matcher(email).matches()
    }

    private fun saveFunction() {
        if(!nameField.text.toString().isNullOrEmpty() && !emailField.text.toString().isNullOrEmpty() && checkEmail()) {
            viewModel.insertData(
                Student(
                    0,
                    nameField.text.toString(),
                    emailField.text.toString().toLowerCase()
                )
            )
            clearFunction()
        }else
        {
            Toast.makeText(this,"Enter Valid Detail" , Toast.LENGTH_SHORT).show()
        }


    }

    private fun updateFunction(){
        if(nameField.text.toString().isNotEmpty() && emailField.text.toString().isNotEmpty() && checkEmail()) {
        viewModel.updateData(
            Student(
                selectedOne.id,
                nameField.text.toString(),
                emailField.text.toString()
            )
        )
            clearFunction()
            isSelected = false
            saveBtn.text = "Save"
            clearBtn.text = "Clear"
        }
        else
        {
            Toast.makeText(this,"Enter Valid Detail" , Toast.LENGTH_SHORT).show()
        }


    }
    private fun deleteFunction(){
        viewModel.deleteData(
            Student(
                selectedOne.id,
                nameField.text.toString(),
                emailField.text.toString()
            )
        )
        clearFunction()
        isSelected = false
        saveBtn.text = "Save"
        clearBtn.text = "Clear"
    }
    private fun clearFunction() {
        nameField.setText("")
        emailField.setText("")
        nameField.requestFocus()
    }

}