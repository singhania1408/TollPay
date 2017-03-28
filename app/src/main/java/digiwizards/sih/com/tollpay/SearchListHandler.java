package digiwizards.sih.com.tollpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class SearchListHandler extends AppCompatActivity {

    RecyclerView recyclerView;
    ListSearchAdapter listSearchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__list__handler);


        recyclerView=(RecyclerView) findViewById(R.id.recycler_view_search);

        recyclerView.setAdapter(listSearchAdapter);

    }


    public void setUpRecyclerView(RecyclerView recyclerView) {

    }


}
