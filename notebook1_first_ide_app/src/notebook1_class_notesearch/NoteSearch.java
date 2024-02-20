package notebook1_class_notesearch;

import notebook1_class_note.Note;
import notebook1_class_notebook.Notebook;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class NoteSearch {
	public static void main(String[] args) {

		Notebook notebook = new Notebook();

		notebook.addNote("Заметка 1");
		notebook.addNoteWithDate("Заметка 2", new Date());
		notebook.addNote("Важное событие");

		List<Note> searchByContentResult = notebook.searchNotesByContent("Заметка");
		System.out.println("Результат поиска по содержимому:");
		searchByContentResult.forEach(System.out::println);

		List<Note> searchByDateResult = notebook.searchNotesByDate(new Date());
		System.out.println("\nРезультат поиска по дате создания:");
		searchByDateResult.forEach(System.out::println);

		System.out.println("\nВсе записи в блокноте:");
		notebook.displayNotes();

		notebook.sortNotesByContent();
		System.out.println("\nЗаметки после сортировки по содержимому:");
		notebook.displayNotes();

		notebook.sortNotesByDate();
		System.out.println("\nЗаметки после сортировки по дате создания:");
		notebook.displayNotes();

		notebook.sortNotesByContentComparator(Comparator.comparing(Note::getContent));
		System.out.println("\nЗаметки после сортировки по содержимому с использованием Comparator:");
		notebook.displayNotes();

		notebook.sortNotesByDateComparator(Comparator.comparing(Note::getCreationDate).reversed());
		System.out
				.println("\nЗаметки после сортировки по дате создания в обратном порядке с использованием Comparator:");
		notebook.displayNotes();

		notebook.sortNotesByContentLength();
		System.out.println("\nЗаметки после сортировки по длине содержимого (по возрастанию):");
		notebook.displayNotes();

		notebook.sortNotesByContentLengthDescending();
		System.out.println("\nЗаметки после сортировки по длине содержимого (по убыванию):");
		notebook.displayNotes();
	}
}
