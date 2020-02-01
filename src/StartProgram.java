//runs menu and gets user input


import java.util.List;
import java.util.Scanner;

import controller.ListSongHelper;
import model.ListSong;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListSongHelper lih = new ListSongHelper();

		private static void addASong() {
			System.out.println("Let's add a new Song to the List!");
			System.out.print("Enter a Song Title: ");
			String Title = in.nextLine();
			System.out.print("Enter the Artist: ");
			String Artist = in.nextLine();
			ListSong toAdd = new ListSong(Artist, Title);
			lih.insertSong(toAdd);

		}

		//reworked to use the new method searchASong to assist with selecting a song
		private static void deleteASong() {
			System.out.println("Let's delete a Song from the List!");
			ListSong selected = searchASong();
			
			if(selected == null) {return;}
			else {
			lih.deleteSong(selected);
			System.out.println(selected.toString()+" was deleted.");
			}
		}

		private static ListSong searchASong() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Artist");
			System.out.println("2 : Search by Title");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListSong> foundSongs;
			if (searchBy == 1) {
				System.out.print("Enter the Artist name: ");
				String ArtistName = in.nextLine();
				foundSongs	=	lih.searchForSongByArtist(ArtistName);

			} else {
				System.out.print("Enter the Song Title: ");
				String title = in.nextLine();
				foundSongs	=	lih.searchForSongByTitle(title);
			}

			if (!foundSongs.isEmpty()) {
				System.out.println("Found Results.");
				for (ListSong l : foundSongs) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to select: ");
				int idToEdit = in.nextInt();

				ListSong selected = lih.searchForSongById(idToEdit);
				System.out.println("Found " + selected.getTitle() + " by " + selected.getArtist());
				return selected;

			} else {
				System.out.println("---- No results found");
				return null;
			}
		}
		private static void editASong() {

				ListSong toEdit = searchASong();
				System.out.println("1 : Update Artist");
				System.out.println("2 : Update Title");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Artist: ");
					String newArtist = in.nextLine();
					toEdit.setArtist(newArtist);
				} else if (update == 2) {
					System.out.print("New Song Title: ");
					String newTitle = in.nextLine();
					toEdit.setTitle(newTitle);
				}

				lih.updateSong(toEdit);

			
		}

		public static void main(String[] args) {
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select a Song:");
				System.out.println("*  1 -- Add a Song");
				System.out.println("*  2 -- Edit a Song");
				System.out.println("*  3 -- Delete a Song");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the song management program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addASong();
				} else if (selection == 2) {
					editASong();
				} else if (selection == 3) {
					deleteASong();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}
			}
		}

		private static void viewTheList() {
			System.out.println("-----------");
			System.out.println("Song List:");
			List<ListSong>	allSongs	=	lih.showAllSongs();
			for(ListSong singleSong :	allSongs){
			System.out.println(singleSong.toString());
			}			
			System.out.println("-----------");
		}

	}