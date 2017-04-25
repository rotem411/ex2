package com.rotemarbiv.ex2;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private String inputTextString = "";
//    private KeyListener listen;
    private EditText inputText;
    private FloatingActionButton button;
//    private RecyclerView theList;
//    private MyAdapter adapter;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public ArrayList<String> myDataset = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = (EditText) findViewById(R.id.inputText);
        button = (FloatingActionButton) findViewById(R.id.Button);
        mRecyclerView = (RecyclerView) findViewById(R.id.outputText);


//          listen = inputText.getKeyListener();

//        inputText.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (event.getAction() == KeyEvent.ACTION_DOWN) {
//                    switch (keyCode) {
//                        case KeyEvent.KEYCODE_DPAD_CENTER:
//                        case KeyEvent.KEYCODE_ENTER:
//                            addText(v);
//                            return true;
//                        default:
//                            break;
//                    }
//                }
//                return false;
//            }
//        });
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        button.setOnKeyListener(new View.OnKeyListener(){

        });
    }
    public void addText(View view){

        Calendar cldr = Calendar.getInstance();
        EditText textFromInput = (EditText)findViewById(R.id.inputText);
        inputTextString = cldr.get(Calendar.HOUR) + ":" + cldr.get(Calendar.MINUTE) +":  "+ textFromInput.getText().toString() ;
        myDataset.add(inputTextString);

//        myDataset.setText("");
//        textFromInput = (EditText)findViewById(R.id.outputText);
//        textFromInput.setText(inputTextString);
        inputText.setKeyListener(listen);

    }
}


