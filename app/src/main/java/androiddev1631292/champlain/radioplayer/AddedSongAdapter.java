package androiddev1631292.champlain.radioplayer;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androiddev1631292.champlain.radioplayer.DB.DBSQLiteManager;
import androiddev1631292.champlain.radioplayer.Models.AddedSong;
import androiddev1631292.champlain.radioplayer.Models.Song;

import static android.content.Context.MODE_PRIVATE;


public class AddedSongAdapter extends RecyclerView.Adapter<AddedSongAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView ArtistName2;
        public TextView SongName2;
        public TextView AlbumName2;
        public TextView GenreName2;
        public TextView YearSong2;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            ArtistName2 = itemView.findViewById(R.id.TxtArtistName2);
            SongName2 = itemView.findViewById(R.id.TxtSongName2);
            AlbumName2 = itemView.findViewById(R.id.TxtAlbum2);
            GenreName2 = itemView.findViewById(R.id.TxtGenre2);
            YearSong2 = itemView.findViewById(R.id.TxtYear2);
        }
    }

    // Store a member variable for the contacts
    private List<Song> mSongs;
    Context context;
    DBSQLiteManager manager;


    // Pass in the contact array into the constructor
    public AddedSongAdapter(List<Song> songs) {
        mSongs = songs;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public AddedSongAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View songView = inflater.inflate(R.layout.playlist_item, parent, false);

        // Return a new holder instance
        AddedSongAdapter.ViewHolder viewHolder = new AddedSongAdapter.ViewHolder(songView);

        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(AddedSongAdapter.ViewHolder viewHolder, int position)
    {
        // Get the data model based on position
        Song song = mSongs.get(position);

        // Set item views based on your views and data model
        TextView textViewArtist = viewHolder.ArtistName2;
        textViewArtist.setText(song.getArtist());

        TextView textViewSg = viewHolder.SongName2;
        textViewSg.setText(song.getName());

        TextView textViewAl = viewHolder.AlbumName2;
        textViewAl.setText(song.getAlbum());

        TextView textViewGn = viewHolder.GenreName2;
        textViewGn.setText(song.getGenre());

        TextView textViewYr = viewHolder.YearSong2;
        textViewYr.setText(song.getYear());


    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount()
    {
        return mSongs.size();
    }
}
