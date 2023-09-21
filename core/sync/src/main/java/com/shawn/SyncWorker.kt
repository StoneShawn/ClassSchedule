package com.shawn

import android.content.Context
import androidx.tracing.traceAsync
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkerParameters
import com.shawn.data.repository.CourseRepository
import com.shawn.data.util.Synchronizer
import com.shawn.sync.SyncConstraints
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext

class SyncWorker (
    private val appContext: Context,
    workerParams: WorkerParameters,
    private val courseRepository: CourseRepository,
    private val ioDispatcher: CoroutineDispatcher,
) : CoroutineWorker(appContext, workerParams), Synchronizer {

    override suspend fun doWork(): Result = withContext(ioDispatcher) {
        traceAsync("Sync", 0) {
            // First sync the repositories in parallel
            val syncedSuccessfully = awaitAll(
                async { courseRepository.sync() },
            ).all { it }

            if (syncedSuccessfully) Result.success()
            else Result.retry()
        }
    }

    companion object {
        /**
         * Expedited one time work to sync data on app startup
         */
        fun startUpSyncWork() = OneTimeWorkRequestBuilder<SyncWorker>()
            .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            .setConstraints(SyncConstraints)
            .setInputData(SyncWorker::class.delegatedData())
            .build()
    }
}
