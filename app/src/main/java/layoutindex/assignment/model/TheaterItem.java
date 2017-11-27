package layoutindex.assignment.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

public class TheaterItem{

	@SerializedName("image")
	private String image;

	@SerializedName("cinema_name")
	private String cinemaName;

	@SerializedName("name")
	private String name;

	@SerializedName("cinema_address")
	private String cinemaAddress;

	@SerializedName("url_key")
	private String urlKey;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setCinemaName(String cinemaName){
		this.cinemaName = cinemaName;
	}

	public String getCinemaName(){
		return cinemaName;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCinemaAddress(String cinemaAddress){
		this.cinemaAddress = cinemaAddress;
	}

	public String getCinemaAddress(){
		return cinemaAddress;
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
			"TheaterItem{" + 
			"image = '" + image + '\'' + 
			",cinema_name = '" + cinemaName + '\'' + 
			",name = '" + name + '\'' + 
			",cinema_address = '" + cinemaAddress + '\'' + 
			",url_key = '" + urlKey + '\'' + 
			"}";
		}
}