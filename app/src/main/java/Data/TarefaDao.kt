package Data

import androidx.room.*


@Dao
interface TarefaDao {
    @Query("SELECT * FROM Tarefa")
    fun getAllTarefas(): List<Tarefa>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createOrUpdateTarefas(tarefa: Tarefa)

    @Query("SELECT * FROM Tarefa WHERE text LIKE :query")
    fun searchTarefas(query: String): List<Tarefa>?

    @Query("SELECT * FROM Tarefa WHERE id = :tarefaId")
    fun getCardByTarefaId(tarefaId: Int): Tarefa
}