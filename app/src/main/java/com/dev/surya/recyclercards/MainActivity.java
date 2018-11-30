package com.dev.surya.recyclercards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<ExampleItem> exampleList;
    private Button buttonAdd, buttonDelete;
    private EditText editTextAdd, editTextDelete;


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find buttons
        buttonAdd = findViewById(R.id.buttonadd);
        buttonDelete = findViewById(R.id.buttondelete);
        //find edit text
        editTextAdd = findViewById(R.id.edittextadd);
        editTextDelete = findViewById(R.id.edittextdelete);

        buttonAdd.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);

        generateFakeData();
        recyclerViewConfig();
    }

    public void generateFakeData() {
        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.node, "Clicked at Studio"));
        exampleList.add(new ExampleItem(R.drawable.oner, "Clicked at Italy"));
        exampleList.add(new ExampleItem(R.drawable.twor, "Clicked at Rome"));
        exampleList.add(new ExampleItem(R.drawable.threer, "Clicked at USA"));
        exampleList.add(new ExampleItem(R.drawable.fourr, "Clicked at Greece"));
        exampleList.add(new ExampleItem(R.drawable.fiver, "Clicked at India"));
        exampleList.add(new ExampleItem(R.drawable.sixr, "Clicked at Canada"));
    }

    public void recyclerViewConfig(){
        //Config for recyclerView
        recyclerView = findViewById(R.id.recyclerView);
        //Performance improvement line - only the next line
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);}

    @Override
    public void onClick(View v) {
        int i = v.getId();
        String a = editTextAdd.getText().toString();
        String d = editTextDelete.getText().toString();

        if (TextUtils.isEmpty(a) && TextUtils.isEmpty(d)) {
            editTextAdd.setError("Empty User Input");
            editTextDelete.setError("Empty User Input");
        }
        else {
            switch (i) {
                case R.id.buttonadd:
                    addCard(Integer.parseInt(a));
                    editTextAdd.setText(null);
                    break;
                case R.id.buttondelete:
                    deleteCard(Integer.parseInt(d));
                    editTextAdd.setText(null);
                    break;
            }
        }
    }

    public void addCard(int position){
        exampleList.add(position, new ExampleItem(R.drawable.node, "New Card Added"));
        //notify data set change - important step
        //adapter.notifyDataSetChanged();
        // or use alternative
        adapter.notifyItemInserted(position);
    }

    public void deleteCard(int position){
        exampleList.remove(position);
        adapter.notifyItemRemoved(position);
    }

}
