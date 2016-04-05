package fr.unice.polytech.polynews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Antoine on 05/04/2016.
 */
public class DownloadPictures extends AsyncTask<String, Void, Bitmap> {

    ImageView imageView;
    Context context;

    public DownloadPictures(ImageView imageView, Context context) {
        super();
        this.imageView = imageView;
        this.context = context;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        return downloadPicture(params[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        this.imageView.setImageBitmap(bitmap);
    }

    private Bitmap downloadPicture(String fileURL) {
        InputStream input;
        HttpURLConnection urlConnection;
        Bitmap picture;
        try {
            URL url = new URL(fileURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            if (urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                Log.e(DownloadPictures.class.toString(), "Server returned HTTP " + urlConnection.getResponseCode()
                        + " " + urlConnection.getResponseMessage());
            }

            input = new BufferedInputStream(urlConnection.getInputStream());
            picture = BitmapFactory.decodeStream(input);
            if (null != picture)
                return picture;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
