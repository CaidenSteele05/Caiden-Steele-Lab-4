
public class Playlist {
	private Song[] songs;
	private int numSongs;
	private static final int MIN_CAPACITY = 3;
	
	public Playlist() {
		songs = new Song[MIN_CAPACITY];
	}
	
	public Playlist(int capacity) {
		int cap = capacity > MIN_CAPACITY ? capacity : MIN_CAPACITY;
		songs = new Song[cap];
	}
	
	public int getCapacity() {
		return songs.length;
	}
	
	public int getNumSongs() {
		return numSongs;
	}
	
	public Song getSong(int i) {
		return i >= 0 && i < songs.length ? songs[i] : null;
	}
	
	public Song[] getSongs() {
		Song[] songs = new Song[numSongs];
		for(int i = 0; i < numSongs; i++) {
			songs[i] = this.songs[i];
		}
		return songs;
	}
	
	public boolean addSong(Song song) {
		return addSong(numSongs, song);
	}
	
	public boolean addSong(int index, Song song) {
		boolean valid = numSongs != songs.length && index >= 0 && index <= numSongs && song != null;
		if(valid) {
			for(int i = songs.length-1; i > index; i--) {
				songs[i] = songs[i-1];
			}
			songs[index] = song;
			numSongs++;
		}
		return valid;
	}
	
	public int addSongs(Playlist playlist) {
		int count = 0;
		if(playlist == null) {
			return count;
		}
		int length = playlist.getNumSongs();
		for(int i = 0; i < length; i++) {
			count += this.addSong(playlist.getSong(i)) ? 1 : 0;
		}
		return count;
	}
	
	public Song removeSong() {
		for(int i = songs.length-1; i >= 0; i--) {
			if(songs[i] != null) {
				Song song = songs[i];
				songs[i] = null;
				numSongs--;
				return song;
			}
		}
		return null;
	}
	
	public Song removeSong(int index) {
		boolean valid = index >= 0 && index < numSongs;
		if(valid && songs[index] != null) {
			Song song = songs[index];
			songs[index] = null;
			for(int i = index; i < songs.length - 1; i++) {
				songs[i] = songs[i + 1];
			}
			numSongs--;
			return song;
		}
		return null;
	}
}
