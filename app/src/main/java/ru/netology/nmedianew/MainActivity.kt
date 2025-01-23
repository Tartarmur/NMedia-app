package ru.netology.nmedianew

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import ru.netology.nmedianew.databinding.ActivityMainBinding
import ru.netology.nmedianew.dto.Post

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            likes = 115,
            shares = 5098,
            views = 1299998,
            author = "Нетология. Университет интернет-профессий будущего",
            date_and_time_of_publication = "21 мая в 18:36",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            likeByMe = false,
        )

        //val avatar : ImageView = findViewById(R.id.avatar) - another variants
        //avatar.setImageResource(R.drawable.netology)
        binding.author.text = post.author
        binding.textOfThePublication.text = post.content
        binding.dateAndTimeOfPublication.text = post.date_and_time_of_publication
        binding.volumeOfLikes.text = formatCount(post.likes)
        binding.volumeOfShare.text = formatCount(post.shares)
        binding.volumeOfViews.text = formatCount(post.views)

        binding.likes.setOnClickListener {
            post.likeByMe = !post.likeByMe
            updateLike(binding, post)
        }

        binding.shares.setOnClickListener {
            updateShare(binding, post)
        }

        binding.views.setOnClickListener {
            updateViews(binding, post)
        }
    }


    private fun updateLike(binding: ActivityMainBinding, post: Post) {
        binding.likes.setImageResource(
            if (post.likeByMe) {
                R.drawable.baseline_favorite_border_24
            } else {
                R.drawable.baseline_favorite_24
            }
        )
        if (post.likeByMe) post.likes-- else post.likes++
        binding.volumeOfLikes.text = formatCount(post.likes)
    }


    private fun updateShare(binding: ActivityMainBinding, post: Post) {
        post.shares++
        binding.volumeOfShare.text = formatCount(post.shares)
    }

    private fun updateViews(binding: ActivityMainBinding, post: Post) {
        post.views++
        binding.volumeOfViews.text = formatCount(post.views)
    }

    private fun formatCount(count: Long): String {
        var stringReturn: String = ""
        var prCount: Long = 0
        if (count < 1000) {
            stringReturn = count.toString()
            return stringReturn
        } else if (count >= 1000 && count < 10_000) {
            prCount = (count / 100)
            stringReturn = (prCount / 10.0).toString() + "K"
            return stringReturn
        } else if (count >= 10_000 && count < 1_000_000) {
            stringReturn = (count / 1000).toString() + "K"
            return stringReturn
        } else if (count >= 1_000_000) {
            prCount = (count / 100_000)
            stringReturn = (prCount / 10.0).toString() + "M"
            return stringReturn
        }
        return stringReturn
    }
}

