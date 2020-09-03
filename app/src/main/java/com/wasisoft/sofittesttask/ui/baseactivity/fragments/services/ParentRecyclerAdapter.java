package com.wasisoft.sofittesttask.ui.baseactivity.fragments.services;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wasisoft.sofittesttask.R;
import com.wasisoft.sofittesttask.model.GovernmentServiceChild;
import com.wasisoft.sofittesttask.model.GovernmentServiceParent;

import java.util.List;

public class ParentRecyclerAdapter extends RecyclerView.Adapter<ParentRecyclerAdapter.MyViewHolder> {
    private List<GovernmentServiceParent> parentList;

    public ParentRecyclerAdapter(List<GovernmentServiceParent> parentList) {
        this.parentList = parentList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(parentList.get(position).getSingleServiceChildList());
    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerViewParent;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerViewParent = itemView.findViewById(R.id.recycler_view);
            recyclerViewParent.setHasFixedSize(true);
            recyclerViewParent.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                @Override
                public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                    int action = e.getAction();
                    if (action == MotionEvent.ACTION_MOVE) {
                        rv.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return false;
                }

                @Override
                public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

                }

                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                }
            });
        }

        void onBind(List<GovernmentServiceChild> childList) {
            recyclerViewParent.setAdapter(new ChildRecyclerAdapter(childList));
        }
    }
}
