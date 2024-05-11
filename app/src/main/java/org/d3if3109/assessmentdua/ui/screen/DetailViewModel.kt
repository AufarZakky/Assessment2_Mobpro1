package org.d3if3109.assessmentdua.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3109.assessmentdua.database.MakananDao
import org.d3if3109.assessmentdua.model.Makanan

class DetailViewModel(private val dao: MakananDao) : ViewModel() {

    fun insert(nama: String, harga: String, jenis: String) {
        val makanan = Makanan(
            nama = nama,
            harga = harga,
            jenis = jenis,
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(makanan)
        }
    }
    suspend fun getMakanan(id: Long): Makanan? {
        return dao.getMakananById(id)
    }
    fun update(id: Long, nama: String, harga: String, jenis: String) {
        val makanan = Makanan(
            id = id,
            nama = nama,
            harga = harga,
            jenis = jenis,
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(makanan)
        }
    }
    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}