package digiwizards.sih.com.tollpay;

/**
 * Created by singhania for default search adapter on 28/3/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import digiwizards.sih.com.tollpay.model.CityModel;

public class ListSearchAdapter extends RecyclerView.Adapter<ListSearchAdapter.ViewHolder> {

    private Context context;
    private SearchListHandler searchListHandler;
    private List<CityModel> listCity;
    private boolean isCity;
    private View resultView;
   /* SearchActivityStudent searchActivityStudent;
    List<AutoCompleteSchoolModel> autoCompleteSchoolModels;
    List<AutoCompleteCourseModel> autoCompleteCourseModels;*/

    public ListSearchAdapter(Context context, List<CityModel> listCity, SearchListHandler searchListHandler) {
        this.listCity = listCity;
        isCity = true;
        this.searchListHandler = searchListHandler;
        this.context = context;
    }
/*
    public ListSearchAdapter(Context context, List<AutoCompleteCourseModel> autoCompleteCourseModels, boolean mock, SearchActivityStudent searchActivityStudent) {
        this.autoCompleteCourseModels = autoCompleteCourseModels;
        isSchool = false;
        this.searchActivityStudent = searchActivityStudent;
        this.context = context;
    }*/

    @Override
    public ListSearchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemLayoutView;
            itemLayoutView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_search_item, parent, false);

       return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(ListSearchAdapter.ViewHolder holder, int position) {
        holder.cityModel=listCity.get(position);


    }

    @Override
    public long getItemId(int position) {
        if (isCity)
            return listCity.get(position).getId();
        else
            return 0;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView username, summary;
        private CityModel cityModel;

        private ViewHolder(View itemView) {
            super(itemView);

            resultView = itemView;
           /* username = (TextView) itemView.findViewById(R.id.userName);
            summary = (TextView) itemView.findViewById(R.id.summary);*/
        }
    }

}
