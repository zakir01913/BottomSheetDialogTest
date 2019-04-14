package com.zakir.bottomsheetdialogtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet.view.*


class MainActivity : AppCompatActivity(), ActionAdapter.InviteFriendItemClickListener {

    lateinit var bottomSheetDialog: BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloWorldTextView.setOnClickListener {
            bottomSheetDialog.show()
        }

        val actionAdapter = ActionAdapter(ActionItem.values().toList())
        actionAdapter.inviteFriendItemClickListener = this
        val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
        view.actionRV.adapter = actionAdapter
        view.actionRV.layoutManager = LinearLayoutManager(this)
        view.actionRV.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
        bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(view)
    }

    override fun onItemClick(actionItem: ActionItem) {
        bottomSheetDialog.hide()
    }
}
