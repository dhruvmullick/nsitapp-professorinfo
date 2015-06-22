package com.nsit.dhruvmullick.professorinfo;

/**
 * Created by dhruvmullick on 09/07/14.
 */
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class ImageTextListViewActivity extends Activity implements
        OnItemClickListener {

    public static final String[] titles = new String[] { "ECE",
            "COE", "ICE", "MPAE", "IT", "BT","PCME"};

    public static final String[] full = new String[] {
            "Division Of Electronics & Communication Engg",
            "Division Of Computer Engg", "Division Of Instrumentation & Control Engg",
            "Division Of Manufacturing Processes & Automation Engg", "Division Of Information Technology","Division Of Bio-Technology","School Of Applied Sciences"
    };

//    public static final Integer[] images = { R.drawable.picece,
  //          R.drawable.piccoe, R.drawable.picice, R.drawable.picmpae,R.drawable.picit,R.drawable.picbt,R.drawable.picpcme };

    ListView listView;
    List<RowItem> rowItems;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem(titles[i].toUpperCase(), full[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.list);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                R.layout.list_item, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Intent myIntent = new Intent(view.getContext(),ProfList.class);
        myIntent.putExtra("dept", position);
        startActivity(myIntent);

    }
}