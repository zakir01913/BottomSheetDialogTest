package com.zakir.bottomsheetdialogtest

enum class ActionItem(val textRes: Int, val iconRes: Int) {
    EMAIL(R.string.email, R.drawable.ic_email_black),
    SMS(R.string.sms, R.drawable.ic_message_black),
    OTHER(R.string.other, R.drawable.icon_more_horiz_black)
}