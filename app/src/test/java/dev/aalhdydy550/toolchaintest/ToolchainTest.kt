package dev.aalhdydy550.toolchaintest

import dev.aalhdydy550.toolchaintest.data.Note
import dev.aalhdydy550.toolchaintest.ui.toolchainGreeting
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ToolchainTest {
    @Test
    fun greetingNamesTheUpgradeStack() {
        val greeting = toolchainGreeting()
        assertTrue(greeting.contains("AGP 9.1"))
        assertTrue(greeting.contains("Gradle 9"))
        assertTrue(greeting.contains("SDK 37"))
    }

    @Test
    fun noteDefaultsToUnsavedId() {
        assertEquals(0L, Note(text = "hello").id)
        assertEquals("hello", Note(text = "hello").text)
    }
}
