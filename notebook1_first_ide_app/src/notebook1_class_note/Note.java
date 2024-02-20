package notebook1_class_note;

import java.util.Date;

public class Note implements Comparable<Note> {
	private String content;
	private Date creationDate;

	public Note(String content) {
		this.content = content;
		this.creationDate = new Date();
	}

	public String getContent() {
		return content;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Note{" + "content='" + content + '\'' + ", creationDate=" + creationDate + '}';
	}

	@Override
	public int compareTo(Note otherNote) {
		return this.creationDate.compareTo(otherNote.creationDate);
	}
}
