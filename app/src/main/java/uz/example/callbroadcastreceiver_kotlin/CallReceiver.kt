package uz.example.callbroadcastreceiver_kotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.widget.Toast

class CallReceiver:BroadcastReceiver() {
    var phoneNumber: String? = null
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent!!.getStringExtra(TelephonyManager.EXTRA_STATE) == TelephonyManager.EXTRA_STATE_OFFHOOK) {
            Toast.makeText(context, "Kotlin Phone call is stared...", Toast.LENGTH_LONG).show()
        } else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE) == TelephonyManager.EXTRA_STATE_IDLE) {
            Toast.makeText(context, "Kotlin Phone call is ended...", Toast.LENGTH_LONG).show()
        } else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE) == TelephonyManager.EXTRA_STATE_RINGING) {
            phoneNumber = intent.extras!!.getString("incoming_number")
            if (phoneNumber != null) {
                Toast.makeText(context, "Kotlin Incoming Call...$phoneNumber", Toast.LENGTH_LONG).show()
            }
        }
    }
}