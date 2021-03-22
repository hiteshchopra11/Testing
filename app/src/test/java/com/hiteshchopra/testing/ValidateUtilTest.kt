package com.hiteshchopra.testing

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class ValidateUtilTest {

    @Test
    fun `empty username returns false`() {
        val result = ValidateUtil.validateRegistration(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = ValidateUtil.validateRegistration(
            "Philipp",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists returns false`() {
        val result = ValidateUtil.validateRegistration(
            "Carl",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `incorrectly confirmed password returns false`() {
        val result = ValidateUtil.validateRegistration(
            "Philipp",
            "123456",
            "abcdefg"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = ValidateUtil.validateRegistration(
            "Philipp",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `less than 2 digit password returns false`() {
        val result = ValidateUtil.validateRegistration(
            "Philipp",
            "abcdefg5",
            "abcdefg5"
        )
        assertThat(result).isFalse()
    }
}