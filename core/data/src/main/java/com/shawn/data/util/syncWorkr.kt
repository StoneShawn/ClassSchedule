//package com.shawn.data.util
//
//import android.content.Context
//import androidx.work.CoroutineWorker
//import androidx.work.WorkerParameters
//import kotlinx.coroutines.CoroutineDispatcher
//import kotlinx.coroutines.async
//import kotlinx.coroutines.awaitAll
//import kotlinx.coroutines.withContext
//
//class syncWorkr(
//    private val appContext: Context,
//    workerParams: WorkerParameters,
//    private val ioDispatcher: CoroutineDispatcher,
//) : CoroutineWorker
//    (appContext, workerParams), Synchronizer {
//    override suspend fun doWork(): Result = withContext(ioDispatcher) {
//        traceAsync("Sync", 0) {
//            // First sync the repositories in parallel
//            val syncedSuccessfully = awaitAll(
//                async { topicRepository.sync() },
//                async { authorsRepository.sync() },
//                async { newsRepository.sync() },
//            ).all { it }
//
//            if (syncedSuccessfully) Result.success()
//            else Result.retry()
//        }
//    }
//}