package com.example.tablayout.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.tablayout.R
import com.example.tablayout.adapter.FirstAdapter
import com.example.tablayout.databinding.FragmentFisrtBinding
import com.example.tablayout.model.CharacterModel
import com.example.tablayout.ontemclick.OnItemClickListener
import com.example.tablayout.repository.CharacterRepository


class FisrtFragment : Fragment(), OnItemClickListener {

    private var binding: FragmentFisrtBinding? = null
    private var repository = CharacterRepository()
    private var adapterFirst = FirstAdapter(this)
    private lateinit var displayList: ArrayList<CharacterModel>
    private lateinit var arrayList: ArrayList<CharacterModel>
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFisrtBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val myAdapter = FirstAdapter(displayList)
//        //layoutManager = GridLayoutManager(this.context,2)
//        recyclerView.layoutManager = layoutManager
//        recyclerView.adapter = myAdapter
//        setHasOptionsMenu(true)
        initialze()
    }

    private fun initialze() {
        binding?.recyclerFirst?.adapter = adapterFirst
        adapterFirst.setData(repository.getListOfCelebrities())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        val menuItem = menu.findItem(R.id.actionSearch)
//        val searchView = menuItem.actionView as SearchView
        binding?.searchView?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                displayList.clear()
                displayList.addAll(arrayList)
                recyclerView.adapter!!.notifyDataSetChanged()
            }

        })


        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(model: CharacterModel) {
        Toast.makeText(requireContext(), "anime", Toast.LENGTH_SHORT).show()
    }
}


