package layoutindex.assignment.util;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import layoutindex.assignment.model.DataItem;
import layoutindex.assignment.ui.adapter.MovieAdapter;

/**
 * Created by rasslk on 11/16/2017.
 */

public class MovieFilter extends Filter {


    private final MovieAdapter adapter;
    private  List<DataItem> moviesList;
    private final ArrayList filteredMoviesList;

    public MovieFilter(List<DataItem> contactList, MovieAdapter adapter) {

        this.adapter = adapter;
        this.moviesList = contactList;
        this.filteredMoviesList = new ArrayList();
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results = new FilterResults();
        // We implement here the filter logic
        if (charSequence == null || charSequence.length() == 0) {
            // No filter implemented we return all the list
            results.values = moviesList;
            results.count = moviesList.size();
        }
        else {
            // We perform filtering operation
            List<DataItem> nPlanetList = new ArrayList<DataItem>();

            for (DataItem p : moviesList) {
                if (p.getMovieName().toUpperCase()
                        .startsWith(charSequence.toString().toUpperCase()))
                    nPlanetList.add(p);
            }

            results.values = nPlanetList;
            results.count = nPlanetList.size();
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

        // Now we have to inform the adapter about the new list filtered
        if (filterResults.count == 0) {
            //notifyDataSetInvalidated();
        }else {
            moviesList = (List<DataItem>) filterResults.values;
            adapter.notifyDataSetChanged();
        }
    }
}
