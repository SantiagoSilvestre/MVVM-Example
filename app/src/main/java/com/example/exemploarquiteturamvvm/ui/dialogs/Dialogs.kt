package com.example.exemploarquiteturamvvm.ui.dialogs

import android.content.Context
import com.example.exemploarquiteturamvvm.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder


/**
 * Class to show dialogs
 */
object Dialogs {

    fun showErrorDialogWithRetry(
        context: Context,
        retryFunction: () -> Unit,
        closeFunction: () -> Unit
    ) {
        MaterialAlertDialogBuilder(context)
            .setTitle(context.resources.getString(R.string.error_title))
            .setMessage(context.resources.getString(R.string.error_message_retry))
            .setPositiveButton(context.resources.getString(R.string.retry)) { _, _ ->
                retryFunction()
            }.setNegativeButton(context.resources.getString(R.string.close)) { _, _ ->
                closeFunction()
            }.show()

    }


    fun shoSimpleErrorDialog(context: Context, message: String?) {

    }

    private fun showSimpleInfoDialog(context: Context, title: String, message: String) {
        MaterialAlertDialogBuilder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(context.resources.getString(R.string.ok)) { _, _ ->
                // Respond to positive button press,nothing to do here
            }
            .show()
    }

}