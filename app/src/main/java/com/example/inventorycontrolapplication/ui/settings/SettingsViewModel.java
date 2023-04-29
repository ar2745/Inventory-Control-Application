package com.example.inventorycontrolapplication.ui.settings;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.example.inventorycontrolapplication.data.InventoryDataSource;

public class SettingsViewModel extends ViewModel {

    private InventoryDataSource dataSource;

    public SettingsViewModel() {

    }

    // Initialize the Data Source  Provider
    public void InitializeDataProvider(Context context) {
        dataSource = new InventoryDataSource(context);
    }

}
