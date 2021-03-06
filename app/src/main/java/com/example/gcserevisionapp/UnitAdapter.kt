package com.example.gcserevisionapp

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.reflect.TypeToken

private val TAG = "TopicAdapter"

class UnitAdapter(
    private val map: Map<String, Map<String, Int>>,
    context: Context
) : RecyclerView.Adapter<UnitAdapter.UnitViewHolder>() {
    val type = map.javaClass
    private val list = map.keys.toList()

    class UnitViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById(R.id.button_item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        layout.accessibilityDelegate = Accessibility
        return UnitViewHolder(layout)
    }

    override fun onBindViewHolder(holder: UnitViewHolder, position: Int) {
        val item = list[position]

        holder.button.text = item

        holder.button.setOnClickListener {
            val key = holder.button.text
                PrefConfig.Writer.writeMapInPref(holder.button.context, map[key]!!)
                holder.view.findNavController().navigate(R.id.nav_subtopics)
        }
    }

    companion object Accessibility : View.AccessibilityDelegate() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onInitializeAccessibilityNodeInfo(host: View?, info: AccessibilityNodeInfo?) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            val customString = host?.context?.getString(R.string.look_up_subtopics)
            val customClick = AccessibilityNodeInfo.AccessibilityAction(
                AccessibilityNodeInfo.ACTION_CLICK,
                customString
            )
            info?.addAction(customClick)
        }
    }
}
