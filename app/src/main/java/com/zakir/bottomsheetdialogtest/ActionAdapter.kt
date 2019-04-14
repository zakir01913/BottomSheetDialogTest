package com.zakir.bottomsheetdialogtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.action_item.view.*


class ActionAdapter(
    private val actionItems: List<ActionItem>
): RecyclerView.Adapter<ActionAdapter.InviteFriendViewHolder>() {

    var inviteFriendItemClickListener: InviteFriendItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InviteFriendViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.action_item, parent,false)
        return InviteFriendViewHolder(view)
    }

    override fun getItemCount(): Int {
        return actionItems.count()
    }

    override fun onBindViewHolder(holder: InviteFriendViewHolder, position: Int) {
        val inviteFriendActionItem = actionItems[position]
        holder.setItem(inviteFriendActionItem)
        holder.itemView.setOnClickListener{
            inviteFriendItemClickListener?.onItemClick(inviteFriendActionItem)
        }
    }

    class InviteFriendViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun setItem(actionItem: ActionItem) {
            itemView.actionName.setText(actionItem.textRes)
            itemView.actionIcon.setImageResource(actionItem.iconRes)
        }
    }

    interface InviteFriendItemClickListener {
        fun onItemClick(actionItem: ActionItem)
    }
}