package com.darka11y.android.squareproject.screens.directorylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.darka11y.android.squareproject.databinding.DirectoryListFragmentBinding

/** This [Fragment] shows the status of the EmployeeDirectory web services transaction **/

class DirectoryListFragment : Fragment() {

    /** Lazy initialize [DirectoryListViewModel] **/
    private val viewModel: DirectoryListViewModel by lazy {
        ViewModelProvider(
            this,
            DirectoryListViewModelFactory()
        ).get(DirectoryListViewModel::class.java)
    }

    /** Inflates the layout with DataBinding, sets its lifecycle owner to [DirectoryListFragment]
     * to enable DataBinding and to observe LiveData. Additionally it sets up the RecylerView with an adapter. **/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Create Binding and Inflate Layout
        val binding = DirectoryListFragmentBinding.inflate(inflater)

        // Giving the binding access to the DirectoryListViewModel
        binding.employeeListViewModel = viewModel

        // Allows DataBinding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // RecyclerView Adapter
        val adapter = DirectoryListAdapter()

        // Bind the adapter
        binding.employeeListView.adapter = adapter

        // Observe the List Data
        viewModel.employeeList.observe(viewLifecycleOwner, {
            it?.let {
                adapter.data = it
            }
        })

        return binding.root
    }
}