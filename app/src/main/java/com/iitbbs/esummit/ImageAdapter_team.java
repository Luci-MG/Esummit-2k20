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
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter_team extends RecyclerView.Adapter<ImageAdapter_team.ImageViewHolder_team>{
    private Context mContext;
    private List<Upload> mUploads;


    public ImageAdapter_team(Context context, List<Upload> uploads){
        mContext = context;
        mUploads = uploads;
    }

    @NonNull
    @Override
    public ImageViewHolder_team onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_item_team, parent, false);
        return new ImageAdapter_team.ImageViewHolder_team(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder_team holder, int position) {
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

    public class ImageViewHolder_team extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;

        public ImageViewHolder_team(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view_name_team);
            imageView = itemView.findViewById(R.id.image_view_upload_team);
            textView1 = itemView.findViewById(R.id.text_view_name_descp_team);
            textView2 = itemView.findViewById(R.id.text_view_name_pos_team);
        }
    }
}
