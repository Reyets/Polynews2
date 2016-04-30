package fr.unice.polytech.polynews.association;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


import fr.unice.polytech.polynews.R;
import fr.unice.polytech.polynews.tutoriel.DownloadPictures;


public class AssoCustomAdapter extends ArrayAdapter<Assos> {

    public AssoCustomAdapter(Context context, List<Assos> resource) {
        super(context, -1, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_asso_element, null);
        }

        Assos assos = getItem(position);

        ImageView image = (ImageView) convertView.findViewById(R.id.asso_image);
        DownloadPictures task = new DownloadPictures(image, getContext());
        task.execute(assos.getImage());


        TextView name = (TextView) convertView.findViewById(R.id.nom_asso);
        name.setText(assos.getName());

        TextView date = (TextView) convertView.findViewById(R.id.descri);
        date.setText(assos.getDescription());


        return convertView;
    }


}
