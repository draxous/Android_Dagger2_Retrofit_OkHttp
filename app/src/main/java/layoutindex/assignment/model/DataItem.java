package layoutindex.assignment.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("end_date")
	private String endDate;

	@SerializedName("trailer")
	private String trailer;

	@SerializedName("date_release")
	private String dateRelease;

	@SerializedName("booking_start_date")
	private String bookingStartDate;

	@SerializedName("imdb_rate")
	private String imdbRate;

	@SerializedName("theater")
	private List<TheaterItem> theater;

	@SerializedName("genre")
	private String genre;

	@SerializedName("movie_content")
	private String movieContent;

	@SerializedName("movie_name")
	private String movieName;

	@SerializedName("portrait_image")
	private String portraitImage;

	@SerializedName("movie_id")
	private String movieId;

	@SerializedName("url_key")
	private String urlKey;

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setTrailer(String trailer){
		this.trailer = trailer;
	}

	public String getTrailer(){
		return trailer;
	}

	public void setDateRelease(String dateRelease){
		this.dateRelease = dateRelease;
	}

	public String getDateRelease(){
		return dateRelease;
	}

	public void setBookingStartDate(String bookingStartDate){
		this.bookingStartDate = bookingStartDate;
	}

	public String getBookingStartDate(){
		return bookingStartDate;
	}

	public void setImdbRate(String imdbRate){
		this.imdbRate = imdbRate;
	}

	public String getImdbRate(){
		return imdbRate;
	}

	public void setTheater(List<TheaterItem> theater){
		this.theater = theater;
	}

	public List<TheaterItem> getTheater(){
		return theater;
	}

	public void setGenre(String genre){
		this.genre = genre;
	}

	public String getGenre(){
		return genre;
	}

	public void setMovieContent(String movieContent){
		this.movieContent = movieContent;
	}

	public String getMovieContent(){
		return movieContent;
	}

	public void setMovieName(String movieName){
		this.movieName = movieName;
	}

	public String getMovieName(){
		return movieName;
	}

	public void setPortraitImage(String portraitImage){
		this.portraitImage = portraitImage;
	}

	public String getPortraitImage(){
		return portraitImage;
	}

	public void setMovieId(String movieId){
		this.movieId = movieId;
	}

	public String getMovieId(){
		return movieId;
	}

	public void setUrlKey(String urlKey){
		this.urlKey = urlKey;
	}

	public String getUrlKey(){
		return urlKey;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"end_date = '" + endDate + '\'' + 
			",trailer = '" + trailer + '\'' + 
			",date_release = '" + dateRelease + '\'' + 
			",booking_start_date = '" + bookingStartDate + '\'' + 
			",imdb_rate = '" + imdbRate + '\'' + 
			",theater = '" + theater + '\'' + 
			",genre = '" + genre + '\'' + 
			",movie_content = '" + movieContent + '\'' + 
			",movie_name = '" + movieName + '\'' + 
			",portrait_image = '" + portraitImage + '\'' + 
			",movie_id = '" + movieId + '\'' + 
			",url_key = '" + urlKey + '\'' + 
			"}";
		}
}