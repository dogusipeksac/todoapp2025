package com.base.testing.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoDao {
    /*
    Neden suspend Kullanırız?
    UI'nin Donmaması: Bu fonksiyonlar, UI thread'i üzerinde bloklama yapmadan çalışabilmek için suspend kullanır.
    Eğer suspend kullanmazsak, bu işlemler UI'yi engeller ve uygulamanın donmasına sebep olabilir.
    Asenkron İşlem Yapma: Veritabanı işlemleri zaman alabilir ve bu işlemleri başka bir iş parçacığında yaparak ana iş parçacığını serbest bırakabiliriz.
    suspend anahtar kelimesi, arka planda çalışan asenkron fonksiyonlar yazmamıza olanak tanır.
     */

    @Query("SELECT * from todos")
    suspend fun getTodos(): List<TodoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: TodoEntity)

    @Delete
    suspend fun deleteTodo(todo: TodoEntity)

}