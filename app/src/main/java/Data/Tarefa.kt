package Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tarefa(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var text: String,
    var description: String,
    var check: Boolean)