package com.example.simpletodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>{

    public interface OnClickListener{
        void onItemClicked(int position);
    }

    public interface OnLongCLickListener {
        void onItemLongCLicked(int position);
    }

    List<String> items;
    OnLongCLickListener longClickListener;
    OnClickListener clickListener;

    public ItemsAdapter(List<String> items, OnLongCLickListener longClickListener, OnClickListener clickListener){
        this.items = items;
        for(String item : items){
            System.out.println(item);
        }
        this.longClickListener = longClickListener;
        this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //use layout Inflator to inflate the view
        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
        //wrap it inside a View Holder and return it
        return new ViewHolder(todoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Grab the item at the position
        String item = items.get(position);
        //Bind the item into the specified view holder
        holder.bind(item);
    }

    // Tells the RV how many items are there
    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(android.R.id.text1);
        }

        // Update the view inside of the view holder with this data
        public void bind(String item) {
            tvItem.setText(item);
            tvItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClicked(getAdapterPosition());
                }
            });
            tvItem.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v){
                    //Notify the listener which position was long pressed
                    longClickListener.onItemLongCLicked(getAdapterPosition());
                    return true;
                }
            });
        }
    }
}
