package fr.unice.polytech.polynews;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class NewsCustomAdapter extends ArrayAdapter<News> {

    public NewsCustomAdapter(Context context, List<News> resource) {
        super(context, -1, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_news_element, null);
        }

        News news = getItem(position);

        ImageView image = (ImageView) convertView.findViewById(R.id.news_image);
        image.setImageResource(R.drawable.icon);

        TextView title = (TextView) convertView.findViewById(R.id.news_title);
        title.setText(news.getTitle());

        TextView date = (TextView) convertView.findViewById(R.id.news_date);
        date.setText(news.getDate());

        //TextView category = (TextView) convertView.findViewById(R.id.news_category);
        //category.setText(news.getCategory());

        return convertView;
    }


}
