package Data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CardRepository(private val tarefaDao: TarefaDao) {
    suspend fun getAllTarefas(): List<Tarefa>? = withContext(Dispatchers.IO) { tarefaDao.getAllTarefas() }
    suspend fun createOrUpdateTarefas(tarefa: Tarefa) = withContext(Dispatchers.IO) { tarefaDao.createOrUpdateTarefas(tarefa) }
    suspend fun getCardByTarefaId(tarefaId: Int) = withContext(Dispatchers.IO) { tarefaDao.getCardByTarefaId(tarefaId) }
    fun searchTarefas(query: String): List<Tarefa>? {
        return tarefaDao.searchTarefas(query)
    }
}