package androiddev1631292.champlain.radioplayer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androiddev1631292.champlain.radioplayer.DB.DBSQLiteManager;
import androiddev1631292.champlain.radioplayer.Models.AddedSong;
import androiddev1631292.champlain.radioplayer.Models.Song;

import static android.content.Context.MODE_PRIVATE;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView ArtisName;
        public TextView SongName;
        public TextView AlbumName;
        public TextView YearSong;
        public TextView Id;
        public View AddButton;
        public View ViewButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(final View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            ArtisName = itemView.findViewById(R.id.TxtArtistName);
            SongName = itemView.findViewById(R.id.TxtSongName);
            AlbumName = itemView.findViewById(R.id.TxtAlbum);
            YearSong = itemView.findViewById(R.id.TxtYear);
            Id = itemView.findViewById(R.id.TxtID);
            AddButton = (Button) itemView.findViewById(R.id.BtnAdd);
            ViewButton = (Button) itemView.findViewById(R.id.BtnView);

            AddButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SharedPreferences prefs = context.getSharedPreferences("Radio", MODE_PRIVATE);
                    String t = prefs.getString("Username", "Error");

                    int id = mSongs.get(getLayoutPosition()).getID();

                    AddedSong newSong = new AddedSong(id, t);

                    manager.addSong(newSong);

                    Toast.makeText(context, "Song Added!", Toast.LENGTH_LONG).show();

                }
            });

            ViewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int id = mSongs.get(getLayoutPosition()).getID();

                    Intent i = new Intent(context, ItemActivity.class);

                    i.putExtra("ID", id);

                    context.startActivity(i);
                }
            });

        }
    }

    // Store a member variable for the contacts
    private List<Song> mSongs;
    Context context;
    DBSQLiteManager manager;

    // Pass in the contact array into the constructor
    public SongAdapter(List<Song> songs, Context context, DBSQLiteManager manager) {
        mSongs = songs;
        this.context = context;
        this.manager = manager;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View songView = inflater.inflate(R.layout.activity_master_list_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(songView);

        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(SongAdapter.ViewHolder viewHolder, int position)
    {
        // Get the data model based on position
        Song song = mSongs.get(position);

        // Set item views based on your views and data model
        TextView textViewArtist = viewHolder.ArtisName;
        textViewArtist.setText(song.getArtist());

        TextView textViewSg = viewHolder.SongName;
        textViewSg.setText(song.getName());

        TextView textViewId = viewHolder.Id;
        textViewId.setText(song.getID().toString());

        TextView textViewAl = viewHolder.AlbumName;
        textViewAl.setText(song.getAlbum());

        TextView textViewYr = viewHolder.YearSong;
        textViewYr.setText(song.getYear());


    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount()
    {
        return mSongs.size();
    }
}

