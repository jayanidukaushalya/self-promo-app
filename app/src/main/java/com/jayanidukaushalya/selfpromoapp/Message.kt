package com.jayanidukaushalya.selfpromoapp

import java.io.Serializable

data class Message(
    val contactName: String,
    val contactNumber: String,
    val displayName: String,
    val includeJunior: Boolean,
    val jobTitle: String?,
    val immediateStart: Boolean,
    val startDate: String?
): Serializable {
    fun getFullDescription() = if (includeJunior) "a junior $jobTitle" else "a senior $jobTitle"
    fun getAvailability() = if (immediateStart) "immediately" else "from $startDate"
}