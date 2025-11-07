package com.unilifeai

import java.util.*

object AiPredictor {

    /**
     * Suggests the next activity based on the current time and timetable.
     * This is a simple rule-based implementation.
     */
    fun suggestNextActivity(timetable: List<TimetableEntry>): String {
        val nextClass = GreetingHelper.getNextClassReminder(timetable)
        if (nextClass != "No more classes today!") {
            return "Prepare for your next class: $nextClass"
        }

        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return when (hour) {
            in 8..11 -> "Time for a study session."
            in 13..15 -> "Consider going for a walk or exercising."
            in 18..20 -> "How about reviewing today's notes?"
            else -> "It's a good time to relax or plan your shopping."
        }
    }

    /**
     * Predicts frequently bought items based on purchase history.
     * This is a simple simulation that returns the most frequent items.
     */
    fun predictFrequentItems(shoppingHistory: List<ShoppingItem>): List<String> {
        if (shoppingHistory.isEmpty()) return emptyList()

        return shoppingHistory
            .groupBy { it.name }
            .mapValues { it.value.size }
            .toList()
            .sortedByDescending { (_, count) -> count }
            .take(3)
            .map { it.first }
    }
}
