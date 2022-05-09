package com.example.ceibaapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ceibaapp.R
import com.example.ceibaapp.model.PostItem
import com.example.ceibaapp.viewmodel.PostFragmentViewModel
import com.example.ceibaapp.viewmodel.PostFragmentViewModelFactory
import com.example.ceibaapp.viewmodel.UserFragmentViewModel
import com.example.ceibaapp.viewmodel.UserFragmentViewModelFactory
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val USER_ID = "userId"
private const val NAME = "name"
/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PostsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var userId: String? = null
    private var name: String? = null
    private var postViewModel: PostFragmentViewModel? = null
    private var titleTextView: TextView? = null

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(userId: String, name: String) =
            PostsFragment().apply {
                arguments = Bundle().apply {
                    putString(USER_ID, userId)
                    putString(NAME, name)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userId = it.getString(USER_ID)
            name = it.getString(NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_posts, container, false)
        var postFragmentViewModelFactory: PostFragmentViewModelFactory? = activity?.let {
            PostFragmentViewModelFactory.createFactory(it)
        }
        var groupAdapter = GroupAdapter<GroupieViewHolder>()

        var recyclerView: RecyclerView? = null
        recyclerView = rootView.findViewById(R.id.posts_recycler_view)
        titleTextView = rootView.findViewById(R.id.posts_fragment_title_text_view)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        postViewModel = ViewModelProviders.of(this,postFragmentViewModelFactory).get(
            PostFragmentViewModel::class.java)
        if(name.isNullOrEmpty()){
            titleTextView?.text = "Todas las publicaciones"
            postViewModel?.getAllPostsFromService()
        }else{
            titleTextView?.text = "Publicaciones de " + name
            postViewModel?.getAllPostsByUserIdFromService(userId)
        }
        postViewModel?.postList?.observe(viewLifecycleOwner) {
            if(!it.isEmpty()){
                for(post in it){
                    groupAdapter.add(PostItem(post))
                }
                recyclerView.adapter = groupAdapter
            }
        }
        return rootView
    }
}