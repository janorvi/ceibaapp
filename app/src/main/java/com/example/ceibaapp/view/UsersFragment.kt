package com.example.ceibaapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.ceibaapp.R
import com.example.ceibaapp.model.User
import com.example.ceibaapp.viewmodel.UserFragmentViewModel
import com.example.ceibaapp.viewmodel.UserFragmentViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UsersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UsersFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var userViewModel: UserFragmentViewModel? = null
    private var userList: List<User>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_users, container, false)
        var userFragmentViewModelFactory: UserFragmentViewModelFactory? = activity?.let {
            UserFragmentViewModelFactory.createFactory(it)
        }
        userViewModel = ViewModelProviders.of(this,userFragmentViewModelFactory).get(UserFragmentViewModel::class.java)
        userViewModel?.getAllUsersFromDatabase()
        userViewModel?.userList?.observe(viewLifecycleOwner) {
            if(it.isEmpty()){
                MainActivity.sourceType = "Service"
                userViewModel?.getAllUsersFromService()
            }else {
                when(MainActivity.sourceType){
                    "Service" -> {
                        for(user in it){
                            userViewModel?.insert(user)
                        }
                        MainActivity.sourceType = "Database"
                        userViewModel?.getAllUsersFromDatabase()
                    }
                    "Database" -> {
                        userList = it
                    }
                }
            }
        }
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UsersFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UsersFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}