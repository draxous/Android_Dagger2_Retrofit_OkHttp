package layoutindex.assignment.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import layoutindex.assignment.R;
import layoutindex.assignment.model.BaseResponse;
import layoutindex.assignment.model.DataItem;
import layoutindex.assignment.model.TheaterItem;
import layoutindex.assignment.util.MovieFilter;

/**
 * Created by rasslk on 11/15/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>  {


    private final Context mContext;
    private MovieFilter filter;
    private List<DataItem> moviesList;

    public MovieAdapter(Context context, List<DataItem> movies) {

        mContext = context;
        moviesList = new ArrayList<>();
        filter = new MovieFilter(movies, this);
    }

    public void setMoviesList(List<DataItem> movies) {
        if (moviesList == null) {
            moviesList = new ArrayList<DataItem>();
        } else {
            moviesList.clear();
            moviesList = movies;
        }

        notifyDataSetChanged();
    }


    public List<DataItem> getMoviesList() {
        return moviesList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.movie_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Glide.with(mContext)
                .load(moviesList.get(position).getPortraitImage())
                .into(holder.mMovieBanner);

        holder.mMovieName.setText(moviesList.get(position).getMovieName());
        holder.mMovieRatings.setRating(Float.parseFloat(moviesList.get(position).getImdbRate()) / 2);

        setTheaters(holder.mTheaters, moviesList.get(position).getTheater());

        Date curDate = new Date();
        Date bookingStartDate = null;
        Date endDate = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatMonth = new SimpleDateFormat("MMM dd");

        try {
            bookingStartDate = format.parse(moviesList.get(position).getBookingStartDate());
            endDate = format.parse(moviesList.get(position).getEndDate());


            if (curDate.after(bookingStartDate) && endDate.after(curDate)) {
                holder.mBookingDate.setVisibility(View.GONE);
                holder.mBook.setVisibility(View.VISIBLE);
                holder.mMore.setVisibility(View.VISIBLE);
            } else {
                holder.mBookingDate.setVisibility(View.VISIBLE);
                holder.mBook.setVisibility(View.GONE);
                holder.mMore.setVisibility(View.VISIBLE);
                holder.mBookingDate.setText(formatMonth.format(bookingStartDate));
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    private void setTheaters(LinearLayout mTheaters, List<TheaterItem> theatersList) {

        if (mTheaters != null) {
            if(mTheaters.getChildCount()>0){
                mTheaters.removeAllViews();
            }
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            for (TheaterItem theater : theatersList) {

                Button theaterView = new Button(mContext);
                theaterView.setText(theater.getCinemaName());
                theaterView.setBackgroundColor(mContext.getResources().getColor(R.color.colorTheater));
                theaterView.setPadding((int) mContext.getResources().getDimension(R.dimen.padding_normal), (int) mContext.getResources().getDimension(R.dimen.padding_normal), (int) mContext.getResources().getDimension(R.dimen.padding_normal), (int) mContext.getResources().getDimension(R.dimen.padding_normal));
                theaterView.setTextColor(mContext.getResources().getColor(android.R.color.white));
                theaterView.setLayoutParams(param);
                mTheaters.addView(theaterView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;

        @BindView(R.id.img_banner)
        ImageView mMovieBanner;
        @BindView(R.id.movie_name)
        TextView mMovieName;
        @BindView(R.id.rate_movie)
        AppCompatRatingBar mMovieRatings;
        @BindView(R.id.ll_theaters)
        LinearLayout mTheaters;
        @BindView(R.id.btn_booking_date)
        Button mBookingDate;
        @BindView(R.id.btn_book)
        Button mBook;
        @BindView(R.id.btn_more)
        Button mMore;


        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            ButterKnife.bind(this, mView);
        }
    }
}
