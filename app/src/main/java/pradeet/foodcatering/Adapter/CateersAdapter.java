package pradeet.foodcatering.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.jar.Attributes;
import java.util.zip.Inflater;

import pradeet.foodcatering.CateersSepc;
import pradeet.foodcatering.R;

/**
 * Created by pradeet on 24/7/15.
 */
public class CateersAdapter extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList<CateersSepc> CateersData;
    Context context;

    public CateersAdapter(Context context, ArrayList<CateersSepc> CateersData){
        this.context = context;
        this.CateersData = CateersData;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return CateersData.size();
    }

    @Override
    public Object getItem(int position) {
        return CateersData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        if (convertView == null){
            convertView = inflater.inflate(R.layout.cateers_row, parent, false);
            holder.Name = (TextView) convertView.findViewById(R.id.CateerName);
            holder.Rate = (TextView) convertView.findViewById(R.id.CateerRate);
            holder.Spec = (TextView) convertView.findViewById(R.id.CateerSpecial);
            holder.Rating = (TextView) convertView.findViewById(R.id.CateerRating);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        CateersSepc present = CateersData.get(position);
        holder.Name.setText(present.Name);
        holder.Rating.setText(present.Rating);
        holder.Spec.setText(present.Spec);
        holder.Rate.setText(context.getResources().getString(R.string.Rupee) + " " + present.Rate + "Per Plate");

        return convertView;
    }

    private class Holder {
        TextView Name;
        TextView Spec;
        TextView Rate;
        TextView Rating;
    }
}