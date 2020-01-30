package com.iitbbs.esummit;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;
    private String string;

    public Adapter(String string,List<Model> models, Context context) {
        this.models = models;
        this.context = context;
        this.string = string;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        final View view = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView;
        TextView title, desc;

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);
        TextView textView = view.findViewById(R.id.title_toy);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        textView.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(context, MainActivity.class);
                //intent.putExtra("param", models.get(position).getTitle());
                //context.startActivity(intent);
                //Toast.makeText(context, models.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                if (position == 0){
                    android.app.FragmentManager fragmentManager = ((Activity)context).getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.fragment, new competitions_frag());
                    ft.addToBackStack("COMPETITIONS");
                    ft.commit();
                }else if(position == 2){
                    //guest talks
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.e-summit-iitbbs.com/"));
                    Intent choser = Intent.createChooser(intent,"Choose Your Browser");
                    context.startActivity(choser);
                }else if(position == 1){
                    //workshop
                    android.app.FragmentManager fragmentManager = ((Activity)context).getFragmentManager();
                    FragmentTransaction  ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.fragment,new workshop());
                    ft.addToBackStack("WORKSHOPS");
                    ft.commit();
                }else if(position == 3){
                    //investors drive
                    android.app.FragmentManager fragmentManager = ((Activity)context).getFragmentManager();
                    FragmentTransaction  ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.fragment,new drive());
                    ft.addToBackStack("INVESTORS DRIVE");
                    ft.commit();
                }else if(position == 4){
                    android.app.FragmentManager fragmentManager = ((Activity)context).getFragmentManager();
                    FragmentTransaction  ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.fragment,new competitions_frag());
                    ft.addToBackStack("INNOVATION EXPO");
                    ft.commit();
                    // innovation expo
                }else if(position == 5){
                    //internship fair
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.e-summit-iitbbs.com/pages/internship_fair.php"));
                    Intent choser = Intent.createChooser(intent,"Choose Your Browser");
                    context.startActivity(choser);
                }

                // finish();
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
