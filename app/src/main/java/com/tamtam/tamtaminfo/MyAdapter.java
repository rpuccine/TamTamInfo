package com.tamtam.tamtaminfo;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private News[] mDataset;
    private static IClickListener mItemListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView categView;
        public TextView dateView;
        public TextView titleView;
        public ImageView imgView;

        public ViewHolder(View v) {
            super(v);
            categView = (TextView) v.findViewById(R.id.recCateg);
            dateView = (TextView) v.findViewById(R.id.recDate);
            titleView = (TextView) v.findViewById(R.id.recTitle);
            imgView = (ImageView) v.findViewById(R.id.recImg);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = this.getLayoutPosition();
            mItemListener.recyclerViewClicked(v, position);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(News[] myDataset, IClickListener itemListener) {
        mDataset = myDataset;
        mItemListener = itemListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.categView.setText(mDataset[position].catName);
        holder.dateView.setText(getDateString(position));
        holder.titleView.setText(mDataset[position].title);
        //holder.imgView.setImageResource(R.drawable.pixel);
        holder.imgView.setImageBitmap(mDataset[position].imgBit);
        holder.categView.setBackgroundColor(mDataset[position].catColor);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    private String getDateString(int position) {
        String ret = "Publié le "
                + mDataset[position].date.get(Calendar.DAY_OF_MONTH) + " "
                + mDataset[position].date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE) + " "
                + mDataset[position].date.get(Calendar.YEAR) + " par Tam Tam";
        return (ret);
    }

}
