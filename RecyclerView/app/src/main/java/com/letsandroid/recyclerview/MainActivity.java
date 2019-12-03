package com.letsandroid.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int START_FROM = 1970;
    private final int COUNT = 100;

    private String[] listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListAdapter adapter = new ListAdapter();
        adapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, listItems[position], Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView list = findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayout.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.list_item_divider, null));
        list.addItemDecoration(dividerItemDecoration);

        listItems = new String[COUNT];
        for (int i = START_FROM; i < START_FROM + COUNT; i++) {
            listItems[i - START_FROM] = String.valueOf(i);
        }
        adapter.setItems(listItems);
        adapter.notifyDataSetChanged();
    }
}
