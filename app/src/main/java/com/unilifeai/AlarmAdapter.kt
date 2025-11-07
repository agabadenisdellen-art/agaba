package com.unilifeai

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.switchmaterial.SwitchMaterial

class AlarmAdapter(
    private val alarms: List<Alarm>,
    private val onToggle: (Alarm) -> Unit
) : RecyclerView.Adapter<AlarmAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val timeTextView: TextView = view.findViewById(R.id.textViewAlarmTime)
        val labelTextView: TextView = view.findViewById(R.id.textViewAlarmLabel)
        val enabledSwitch: SwitchMaterial = view.findViewById(R.id.switchAlarmEnabled)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alarm, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alarm = alarms[position]
        holder.timeTextView.text = alarm.time
        holder.labelTextView.text = alarm.label
        holder.enabledSwitch.isChecked = alarm.isEnabled
        holder.enabledSwitch.setOnCheckedChangeListener { _, isChecked ->
            onToggle(alarm.copy(isEnabled = isChecked))
        }
    }

    override fun getItemCount() = alarms.size
}
