package com.icg.training

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.icg.training.adapter.ListviewAdapter
import com.icg.training.databinding.FragmentSecondBinding
import com.icg.training.model.InfoModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

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

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ListviewAdapter(requireContext(), itemList)
      binding.listAndroidVersions.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}