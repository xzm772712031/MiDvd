
public class DVDSet {
	private String name;
	private int id;
	private String state;
	private String date;
	private int count;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public DVDSet() {
		super();
	}

	public DVDSet(String name, int id, String state, String date, int count) {
		super();
		this.name = name;
		this.id = id;
		this.state = state;
		this.date = date;
		this.count = count;

	}

}
