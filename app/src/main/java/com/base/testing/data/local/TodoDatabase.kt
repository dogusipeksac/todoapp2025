package com.base.testing.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/*
Neden abstract Kullanılır?
RoomDatabase Sınıfının Soyut Olması: RoomDatabase sınıfı, Room veritabanı işlemlerini yöneten temel sınıftır.
Bu sınıfın işlevsel olması için soyut bir sınıf olarak tanımlanması gereklidir, çünkü veritabanı ile etkileşime giren DAO'lar (Data Access Object)
gibi fonksiyonlar, uygulamanın farklı yerlerinden erişilecek ve genellikle birden çok DAO içerebilir.
Room, bu soyut sınıfı genişleterek, veritabanı işlemleri için gereken fonksiyonları otomatik olarak implemente eder.

DAO'yu Tanımlama: todoDao() fonksiyonu, veritabanı işlemlerine erişim sağlayan DAO'yu (Data Access Object) döndüren bir fonksiyondur.
Bu fonksiyon soyut olduğundan, Room veritabanı sınıfının içinde, hangi DAO sınıfının kullanılacağını belirtir. Soyut fonksiyon,
Room tarafından otomatik olarak implement edilir.

Veritabanı Yapısının Modülerliği: abstract kullanarak, veritabanı sınıfınızı daha esnek hale getirirsiniz.
Bu sınıf, uygulamanızda farklı veri tablolarına sahip olabilir ve Room, her bir DAO'yu sağlayabilmek için bu soyut sınıfı kullanır.
 */
@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}