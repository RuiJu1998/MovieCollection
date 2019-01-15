import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String type;
	private String performers;
	private String releaseYear;
	private String rating;
	private String review;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPerformers() {
		return performers;
	}

	public void setPerformers(String performers) {
		this.performers = performers;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	public FormEvent(Object source, String name, String type, String performers, String releaseYear, String rating, String review) {
		super(source);
		this.name = name;
		this.type = type;
		this.performers = performers;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.review = review;
	}

}
