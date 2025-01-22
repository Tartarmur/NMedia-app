package ru.netology.nmedianew.dto

data class Post (
    val id: Long = 1,
    var likes: Long = 999,
    var shares: Long = 999,
    var views: Long = 999,
    val author: String = "",
    val date_and_time_of_publication: String = "",
    val content: String = "",
    var likeByMe: Boolean,
)
