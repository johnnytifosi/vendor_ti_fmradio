package com.ti.fmapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ti.fmapp.R;
import com.ti.fmapp.logic.PreSetRadio;

import java.util.ArrayList;


public class PreSetsAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<PreSetRadio> preSetRadios = null;

    @SuppressWarnings("unchecked")
    public PreSetsAdapter(Context context, ArrayList<PreSetRadio> preSetRadios) {
        this.preSetRadios = (ArrayList<PreSetRadio>) preSetRadios.clone();
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return preSetRadios.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        AlarmViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.preset_elem, null, false);
            holder = new AlarmViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.tv_station_name);
            holder.frequency = (TextView) convertView.findViewById(R.id.tv_station_frequency);
            convertView.setTag(holder);
        } else {
            holder = (AlarmViewHolder) convertView.getTag();
        }

        holder.name.setText(preSetRadios.get(position).getStationName());
        holder.frequency.setText(preSetRadios.get(position).getStationFrequency());

        return convertView;
    }

    class AlarmViewHolder {
        TextView name;
        TextView frequency;
    }

}
