package com.ewake.randommeme.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ewake.randommeme.databinding.FragmentMainPageBinding
import com.ewake.randommeme.presentation.model.MemeItemModel
import com.ewake.randommeme.presentation.ui.fragment.adapter.MainPageAdapter
import com.ewake.randommeme.presentation.viewmodel.MainPageViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@AndroidEntryPoint
class MainPageFragment : Fragment() {

    private val viewModel: MainPageViewModel by viewModels()

    private var _binding: FragmentMainPageBinding? = null
    private val binding: FragmentMainPageBinding
        get() = _binding!!

    private val viewPagerAdapter = MainPageAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.viewPager.adapter = viewPagerAdapter

        viewModel.apply {
            memeItemsLiveData.observe(viewLifecycleOwner, ::setItems)
            load()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setItems(list: List<MemeItemModel>) {
        viewPagerAdapter.items = list
    }
}