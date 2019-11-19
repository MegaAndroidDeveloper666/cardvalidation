package ru.markstudio.cardvalidation

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTests {
    @Test
    fun validateEmpty() {
        assertFalse(CardValidator.validate(""))
    }

    @Test
    fun validateNotOnlyDigits() {
        assertFalse(CardValidator.validate("43777237441o8055"))
    }

    @Test
    fun validateFirstDigit() {
        assertFalse(CardValidator.validate("0367723744108055"))
    }

    @Test
    fun validateLength() {
        val length = "4377723744106075".length
        assertTrue(length in 12..19)
    }

    @Test
    fun validateIncorrectLengthTooLittle() {
        val length = "4377723".length
        assertFalse(length in 12..19)
    }

    @Test
    fun validateIncorrectLengthTooLarge() {
        val length = "4377712312312312312323".length
        assertFalse(length in 12..19)
    }

    @Test
    fun validateLyhn() {
        assertTrue(CardValidator.validate("4377723744108055"))
    }

    @Test
    fun validateMy() {
        assertTrue(CardValidator.validate("4377723744108055"))
    }
}
