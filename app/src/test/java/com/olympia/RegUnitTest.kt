package com.olympia

import com.olympia.model.repositories.UsersRepository
import org.junit.Assert
import org.junit.Test

class RegUnitTest {
    var r = UsersRepository()
    @Test
    fun addition_isCorrect() {
        Assert.assertEquals(/* expected = */ 1, /* actual = */ r.writeNewUser(
            "Daniil",
            "qwer",
            "man",
            "22.02.2002",
            "da@gmail.ru"
        ))
    }
}