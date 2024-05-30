package com.example.viewmodelscope.Model

class UserList {
    fun getList() : List<User>{
        return listOf(
            User("Name" , 1  , 20),
            User("Dog" , 2  , 30),
            User("Cat" , 3  , 25),
            User("Horse" , 4  , 22),
            User("Tiger" , 5  , 21)
        )
    }
}