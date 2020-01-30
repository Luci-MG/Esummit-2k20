package com.iitbbs.esummit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class adapterupdates extends RecyclerView.Adapter<adapterupdates.ImageViewHolder_adapterupdates> {

    private Context mContext;
    private List<Upload> mUploads;

    public adapterupdates(Context context, List<Upload> uploads){
        mContext = context;
        mUploads = uploads;
    }

    @NonNull
    @Override
    public ImageViewHolder_adapterupdates onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.updateitem, parent, false);
        return new adapterupdates.ImageViewHolder_adapterupdates(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder_adapterupdates holder, int position) {
        Upload uploadcurrent = mUploads.get(position);
        holder.textView.setText(uploadcurrent.getName());
        holder.textView1.setText(uploadcurrent.getDescp());
        holder.textView2.setText(uploadcurrent.getPos());
        //Picasso.get().load(uploadcurrent.getImageUrl()).placeholder(R.drawable.ic_swap_vertical_circle_black_24dp).fit()
        //        .centerCrop().into(holder.imageView);

        Glide.with(mContext)
                .load(uploadcurrent.getImageUrl()).fitCenter().centerCrop()
                .placeholder(R.drawable.newloading)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder_adapterupdates extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;

        public ImageViewHolder_adapterupdates(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.update_headig);
            imageView = itemView.findViewById(R.id.update_img);
            textView1 = itemView.findViewById(R.id.description_update);
            textView2 = itemView.findViewById(R.id.date_update);
        }
    }

}
