package fr.unice.polytech.polynews.tutoriel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.unice.polytech.polynews.R;

/**
 * Created by chronos on 01/05/16.
 */
public class FirstNewsCustomAdapter extends ArrayAdapter<News> {

    public FirstNewsCustomAdapter(Context context, List<News> resource) {
        super(context, -1, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_first_news, null);
        }

        News news = getItem(position);

        ImageView image = (ImageView) convertView.findViewById(R.id.news_image);
        //image.setImageResource(R.drawable.icon);
        DownloadPictures task = new DownloadPictures(image, getContext());
        task.execute(news.getMedia_path());

        TextView title = (TextView) convertView.findViewById(R.id.news_title);
        title.setText(news.getTitle());

        TextView date = (TextView) convertView.findViewById(R.id.news_date);
        date.setText(news.getDate());

        TextView category = (TextView) convertView.findViewById(R.id.news_category);
        category.setText(news.getCategoryString());


        return convertView;
    }


}