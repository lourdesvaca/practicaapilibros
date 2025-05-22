package com.example.practicaapilibros.ui.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaapilibros.R
import com.example.practicaapilibros.databinding.ActivityMainBinding
import com.example.practicaapilibros.models.Post
import com.example.practicaapilibros.ui.adapters.PostListAdapter
import com.example.practicaapilibros.ui.viewmodels.MainViewModel
import kotlin.getValue

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupRecyclerView()
        setupViewModelObservers()
        viewModel.loadPostList()
    }


    private fun setupRecyclerView() {
        val adapter = PostListAdapter(arrayListOf())
        binding.rvPostList.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(thiscom.example.practicaapilibros.ui.activities.MainActivity).apply {
                orientation = RecyclerView.VERTICAL
            }
            addItemDecoration(
                DividerItemDecoration(
                    thiscom.example.practicaapilibros.ui.activities.MainActivity,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
        adapter.setOnPostClickListener(this)
    }

    private fun setupViewModelObservers() {
        viewModel.postList.observe(this) {
            val adapter = binding.rvPostList.adapter as PostListAdapter
            adapter.setData(it)
        }
    }

    override fun onPostClick(post: Post) {
        val intent = PostDetailActivity.newIntent(this, post.id)
        startActivity(intent)
    }
}