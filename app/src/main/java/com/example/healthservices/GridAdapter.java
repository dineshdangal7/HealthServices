package com.example.healthservices;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<GridItem> items;

    public GridAdapter(Context context, ArrayList<GridItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        }

        final GridItem item = items.get(position);

        ImageView imageView = convertView.findViewById(R.id.itemImage);
        TextView textView = convertView.findViewById(R.id.itemText);

        imageView.setImageResource(item.getImageResource());
        textView.setText(item.getItemName());

        // Set an OnClickListener for the convertView (view item)
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                // Get the destination class from the clicked item and start the activity
                Class<?> destinationClass = item.getDestinationClass();
                if (destinationClass != null) {
                    Intent intent = new Intent(context, destinationClass);
                    context.startActivity(intent);
                }
            }
        });

        return convertView;
    }


}
