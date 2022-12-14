package com.d121201055.taskreminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.d121201055.taskreminder.model.Task
import com.d121201055.taskreminder.databinding.ActivityAddBinding
import com.d121201055.taskreminder.viewmodel.TaskViewModel
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddBinding
    private lateinit var KategoriTugas:ArrayAdapter<CharSequence>
    private lateinit var taskViewModel: TaskViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        taskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]
        KategoriTugas = ArrayAdapter.createFromResource(this, R.array.Kategori_Tugas,android.R.layout.simple_list_item_1)
        binding.dropdownKategoriTugas.setAdapter(KategoriTugas)

        binding.btnAdd.setOnClickListener {
            val judul = binding.judulTugas.text.toString()
            val isi = binding.deskripsiTugas.text.toString()
            val kategori = binding.dropdownKategoriTugas.text.toString()

            if(kategori.isEmpty()){
                Toast.makeText(this,"Kategori belum dipilih",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(judul.isEmpty()){
                binding.judulTugas.error = "Judul Wajib di isi"
                binding.judulTugas.requestFocus()
                return@setOnClickListener
            }

            if(isi.isEmpty()){
                binding.deskripsiTugas.error = "Deskripsi Wajib di isi"
                binding.deskripsiTugas.requestFocus()
                return@setOnClickListener
            }

            lifecycleScope.launch {
                val task = Task(0, judul,isi,kategori, "Belum Selesai")
                taskViewModel.addTask(task)
                finish()
            }
        }

        binding.btnBack.setOnClickListener {
            finish()
        }


    }
}