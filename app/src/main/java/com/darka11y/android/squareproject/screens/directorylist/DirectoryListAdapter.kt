package com.darka11y.android.squareproject.screens.directorylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.darka11y.android.squareproject.databinding.EmployeeListItemViewBinding
import com.darka11y.android.squareproject.network.Employee

class DirectoryListAdapter : RecyclerView.Adapter<DirectoryListAdapter.EmployeeListViewHolder>() {
    /** List of [Employee] return from the Api **/
    var data = listOf<Employee>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /** Create new [RecyclerView] item vies (invoked by layout manager) **/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeListViewHolder {
        return EmployeeListViewHolder(EmployeeListItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /** Replaces the contents of a view (invoked by the layout manager) **/

    override fun onBindViewHolder(holder: EmployeeListViewHolder, position: Int) {
        val currentEmployee = data.elementAt(position)
        holder.bind(currentEmployee)
    }

    /** Get the number of items in the data **/
    override fun getItemCount() = data.size

    /** The [EmployeeListViewHolder] constructor that takes the binding variable form the associated
     * EmployeeListItemView, which then gives access to the full [Employee] information. **/

    class EmployeeListViewHolder(private var binding: EmployeeListItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(employee: Employee) {
            binding.employee = employee
            binding.executePendingBindings()
        }
    }
}