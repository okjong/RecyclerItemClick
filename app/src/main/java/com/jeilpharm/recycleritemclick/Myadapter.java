package com.jeilpharm.recycleritemclick;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.VH> {

    public interface OnItemClickListener{
        void onItemclick(int pos);
    }
    private OnItemClickListener onItemClickListener=null;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener=listener;

    }

    ArrayList<Item> items;
    Context context;

    public Myadapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);

        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Item item=items.get(position);

        holder.name.setText(item.Name);
        holder.age.setText(item.Age);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView name;
        TextView age;

        public VH(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tv_name);
            age=itemView.findViewById(R.id.tv_age);

            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    if (position!=RecyclerView.NO_POSITION){
                        if (onItemClickListener!=null){
                            onItemClickListener.onItemclick(position);
                        }
                    }
                }
            });
        }
    }
}







































