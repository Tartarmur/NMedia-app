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
            likes = 111324,
            shares = 7735,
            views = 1222301,
            author = "Нетология. Университет интернет-профессий будущего",
            date_and_time_of_publication = "21 мая в 18:36",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            likeByMe = false,
        )

        //val avatar : ImageView = findViewById(R.id.avatar)
        //avatar.setImageResource(R.drawable.netology)
        binding.author.text = post.author
        binding.textOfThePublication.text = post.content
        binding.dateAndTimeOfPublication.text = post.date_and_time_of_publication
        binding.volumeOfLikes.text = post.likes.toString()
        binding.volumeOfShare.text = post.shares.toString()
        binding.volumeOfViews.text = post.views.toString()
        writeEndingLikes(binding, post)
        writeEndingShares(binding, post)
        writeEndingViews(binding, post)

        binding.likes.setOnClickListener {
            post.likeByMe = !post.likeByMe
            updateLike(binding, post)
            writeEndingLikes(binding, post)
        }

        binding.shares.setOnClickListener {
            updateShare(binding,post)
            writeEndingShares(binding, post)
        }

        binding.views.setOnClickListener {
            updateViews(binding, post)
            writeEndingViews(binding, post)
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
            binding.volumeOfLikes.text = post.likes.toString()
        }


    private fun updateShare(binding: ActivityMainBinding, post: Post) {
        post.shares++
        binding.volumeOfShare.text = post.shares.toString()
    }

    private fun updateViews(binding: ActivityMainBinding, post: Post) {
        post.views++
        binding.volumeOfViews.text = post.views.toString()
    }

    private fun writeEndingLikes (binding: ActivityMainBinding, post: Post) {
        if (post.likes >=1000 && post.likes < 10_000) {
            binding.volumeOfLikes.text = (post.likes / 1000.0).toString() + "K"
        } else if (post.likes >=10_000 && post.likes < 1_000_000) {
         binding.volumeOfLikes.text = (post.likes / 1000).toString() + "K"
       } else if (post.likes >=1_000_000) {
            binding.volumeOfLikes.text = (post.likes / 1_000_000).toString() + "M"
        }

        }

    private fun writeEndingShares (binding: ActivityMainBinding, post: Post) {
        if (post.shares >=1000 && post.shares < 10000) {
            binding.volumeOfShare.text = (post.shares/1000.0).toString() + "K"
        } else if (post.shares >=10000 && post.shares < 1000000) {
            binding.volumeOfShare.text = (post.shares / 1000).toString() + "K"
        } else if (post.shares >=1000000) {
            binding.volumeOfShare.text = (post.shares / 1000000).toString() + "M"
        }

    }

    private fun writeEndingViews (binding: ActivityMainBinding, post: Post) {
        if (post.views >=1000 && post.views <10000) {
            binding.volumeOfViews.text = (post.views / 1000.0).toString() + "K"
        } else if (post.views >=10000 && post.views < 1000000) {
            binding.volumeOfViews.text = (post.views / 1000).toString() + "K"
        } else if (post.views >=1000000) {
            binding.volumeOfViews.text = (post.views / 1000000).toString() + "M"
        }

    }
        }

