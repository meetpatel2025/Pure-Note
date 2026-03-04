package com.training.purenote.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.training.purenote.MainActivity
import com.training.purenote.R
import com.training.purenote.adapter.NoteAdapter
import com.training.purenote.databinding.FragmentHomeBinding
import com.training.purenote.model.Note
import com.training.purenote.viewmodel.NoteViewModel
import androidx.appcompat.widget.SearchView



class HomeFragment : Fragment(R.layout.fragment_home), SearchView.OnQueryTextListener{

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var notesViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel = (activity as MainActivity).noteViewModel

        setUpRecyclerView()
        binding.addButton.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_homeFragment_to_newNoteFragment
            )
        }
    }
    private fun setUpRecyclerView() {
        noteAdapter = NoteAdapter()

        noteAdapter.onItemClick = { note ->
            val action = HomeFragmentDirections.actionHomeFragmentToUpdateNoteFragment(note)
            requireView().findNavController().navigate(action)
        }

        binding.notesList.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = noteAdapter
        }

        notesViewModel.getAllNotes().observe(viewLifecycleOwner) {
            Log.d("HOME_DEBUG", "Notes size: ${it.size}")
            noteAdapter.differ.submitList(it)
        }

        activity?.let {
            notesViewModel.getAllNotes().observe(viewLifecycleOwner, { note ->
                noteAdapter.differ.submitList(note)
                updateUI(note)
            })
        }
    }


    private fun updateUI(note: List<Note>?) {
        if (note != null && note.isNotEmpty()) {
            binding.notesList.visibility = View.VISIBLE
            binding.noteCard.visibility = View.GONE
        } else {
            binding.notesList.visibility = View.GONE
            binding.noteCard.visibility = View.VISIBLE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        menu.clear()
        inflater.inflate(R.menu.home_menu, menu)

        val menuSearch = menu.findItem(R.id.menu_search).actionView as SearchView
        menuSearch.isSubmitButtonEnabled = false
        menuSearch.setOnQueryTextListener(this)
    }

    override fun onQueryTextChange(newText: String?): Boolean {
//        searchNote(query)
        return false
    }

    private fun searchNote(query: String?) {
        val searchQuery = "%$query"

        notesViewModel.searchNote(searchQuery).observe(
            this,
            { list -> noteAdapter.differ.submitList(list) }
        )
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            searchNote(query)
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
