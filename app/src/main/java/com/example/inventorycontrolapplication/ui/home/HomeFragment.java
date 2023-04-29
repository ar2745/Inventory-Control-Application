package com.example.inventorycontrolapplication.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.inventorycontrolapplication.R;
import com.example.inventorycontrolapplication.data.RecycleDataAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import java.io.IOException;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecycleDataAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Set View Variables
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.InitializeDataProvider(getContext());
        View root = inflater.inflate(R.layout.inventory_home, container, false);

        // Events
        FloatingActionButton fab = root.findViewById(R.id.edit_data);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.add_data);
            }
        });

        // set up the RecyclerView
        RecyclerView recyclerView = root.findViewById(R.id.data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        try {
            adapter = new RecycleDataAdapter(getContext(), homeViewModel.GetRecords());
        } catch (IOException e) {
            Snackbar.make(root, "Failed to load grid", Snackbar.LENGTH_LONG)
                    .setActionTextColor(Color.RED)
                    .show();
        }
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return root;
    }
}