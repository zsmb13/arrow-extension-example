package co.zsmb.example

import arrow.extension
import co.zsmb.example.user.eq.eq
import co.zsmb.example.user.eq.neqv

interface Eq<F> {
    fun F.eqv(b: F): Boolean
    fun F.neqv(b: F): Boolean = !eqv(b)
}

data class User(val id: Int) {
    companion object
}

@extension
interface UserEq : Eq<User> {
    override fun User.eqv(b: User): Boolean = id == b.id
}

fun main() {

    val user1 = User(1)
    val user2 = User(2)

    user1.neqv(user2)
    //user1.eqv(user2 // eqv extension doesn't exist

    // this works, but isn't pretty
    User.eq().run {
        println(user1.eqv(user2))
    }

}
