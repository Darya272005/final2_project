package notebook1_class_notebook;

import notebook1_class_note.Note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Notebook {
	private List<Note> notes;

	public Notebook() {
		this.notes = new ArrayList<>();
	}

	public void addNote(String content) {
		Note newNote = new Note(content);
		notes.add(newNote);
	}

	public void addNoteWithDate(String content, Date date) {
		Note newNote = new Note(content);
		newNote.setCreationDate(date);
		notes.add(newNote);
	}

	public void removeNoteByContent(String searchContent) {
		Iterator<Note> iterator = notes.iterator();
		while (iterator.hasNext()) {
			Note note = iterator.next();
			if (note.getContent().contains(searchContent)) {
				iterator.remove();
			}
		}
	}

	public void updateNoteByContent(String searchContent, String newContent) {
		for (Note note : notes) {
			if (note.getContent().contains(searchContent)) {
				note.setContent(newContent);
			}
		}
	}

	public List<Note> searchNotesByContent(String searchContent) {
		List<Note> result = new ArrayList<>();
		for (Note note : notes) {
			if (note.getContent().contains(searchContent)) {
				result.add(note);
			}
		}
		return result;
	}

	public List<Note> searchNotesByDate(Date searchDate) {
		List<Note> result = new ArrayList<>();
		for (Note note : notes) {
			if (note.getCreationDate().equals(searchDate)) {
				result.add(note);
			}
		}
		return result;
	}

	public void displayNotes() {
		for (Note note : notes) {
			System.out.println(note);
		}
	}

	public void sortNotesByContent() {
		Collections.sort(notes);
	}

	public void sortNotesByDate() {
		Comparator<Note> noteComparator = Comparator.comparing(Note::getCreationDate);
		Collections.sort(notes, noteComparator);
	}

	public void sortNotesByContentComparator(Comparator<Note> comparator) {
		Collections.sort(notes, comparator);
	}

	public void sortNotesByDateComparator(Comparator<Note> comparator) {
		Collections.sort(notes, comparator);
	}

	public void sortNotesByContentLength() {
		Comparator<Note> noteComparator = Comparator.comparingInt(note -> note.getContent().length());
		Collections.sort(notes, noteComparator);
	}

	public void sortNotesByContentLengthDescending() {
		Comparator<Note> noteComparator = Comparator.comparingInt(note -> note.getContent().length());
		Collections.sort(notes, noteComparator.reversed());
	}
}
