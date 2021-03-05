package com.example.gcserevisionapp.ui.english

import com.example.gcserevisionapp.R
import android.content.Context
import android.os.Build
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter for the [RecyclerView] in [EnglishFragment].
 */
private val TAG = "TopicAdapter"

class EnglishAdapter : RecyclerView.Adapter<EnglishAdapter.SubtopicViewHolder>() {
    private val list = listOf(
        "Analysis of Acts",
        "Characters",
        "Context and Themes",
        "Shakespeare's Techniques",
        "Exam Practice"
    )

    class SubtopicViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById(R.id.button_item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubtopicViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        layout.accessibilityDelegate = Accessibility
        return SubtopicViewHolder(layout)
    }

    override fun onBindViewHolder(holder: SubtopicViewHolder, position: Int) {
        val item = list[position]

        holder.button.text = item

        holder.button.setOnClickListener {
            val letter = holder.button.text
            Log.d(TAG, "Clicked $letter")

            holder.view.findNavController().navigate(R.id.nav_home)
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
