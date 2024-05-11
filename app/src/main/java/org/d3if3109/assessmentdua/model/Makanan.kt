package org.d3if3109.assessmentdua.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "makanan")
data class Makanan(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val harga: String,
    val jenis: String,
    var selectedOption: String = ""
)