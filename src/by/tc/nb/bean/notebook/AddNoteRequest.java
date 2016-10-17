package by.tc.nb.bean.notebook;

import by.tc.nb.bean.Request;

public class AddNoteRequest extends Request {
	private int userID;
	private String note;
	private String date;

	public AddNoteRequest() {
	}

	public AddNoteRequest(int userID, String note, String date) {
		this.userID = userID;
		this.note = note;
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserId(int userID) {
		this.userID = userID;
	}
}
