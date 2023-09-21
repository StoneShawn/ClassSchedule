package com.shawn.data.util


//interface Synchronizer {
//    /**
//     * Syntactic sugar to call [Syncable.syncWith] while omitting the synchronizer argument
//     */
//    suspend fun Syncable.sync() = this@sync.syncWith(this@Synchronizer)
//}

interface Synchronizer {
    suspend fun Syncable.sync() = this@sync.syncWith()
}
interface Syncable{
    suspend fun syncWith(): Boolean
}