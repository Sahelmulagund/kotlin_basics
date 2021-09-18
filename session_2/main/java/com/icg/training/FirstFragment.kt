package com.icg.training

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.icg.training.adapter.AndroidInfoAdapter
import com.icg.training.databinding.FragmentFirstBinding
import com.icg.training.model.InfoModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {


    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var itemList:MutableList<InfoModel> = mutableListOf(
      InfoModel(androidVersion = 4.1,androidName = "Jelly Bean", androidFirstLetter = "J",
               androidSdk = 16, androidDesc = "Isolated services, Memory Management... ",releaseDate = "October 2012"),

        InfoModel(androidVersion = 4.4,androidName = "KitKat", androidFirstLetter = "K",
            androidSdk = 19, androidDesc = "Update your target API level... ", releaseDate = "December 2013"),
        InfoModel(androidVersion = 5.0,androidName = "Lollipop", androidFirstLetter = "L",
            androidSdk = 21, androidDesc = "Multiple SIM card support... ",releaseDate = "March 2015")

    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).supportActionBar?.title = "RecyclerView"
        _binding = FragmentFirstBinding.inflate(inflater, container, false)


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerAndroidVersions.setHasFixedSize(true)
        val lm = LinearLayoutManager(context)
        lm.orientation = RecyclerView.VERTICAL
        binding.recyclerAndroidVersions.layoutManager = lm
        val adapter = AndroidInfoAdapter(requireContext(),itemList)
        binding.recyclerAndroidVersions.adapter = adapter


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}