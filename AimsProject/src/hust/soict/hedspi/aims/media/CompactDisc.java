package hust.soict.hedspi.aims.media;

import javax.swing.*;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost, String director, String artist, ArrayList<Track> tracks) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String category, String artist, float cost) {
        super(nbMedia++, title, category, cost, 0, null);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) System.out.println("Track is already in the list");
        else {
            tracks.add(track);
            System.out.println("Track added");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed");
        } else System.out.println("Track is not in the list");
    }

    public int getLength() {
        int length = 0;
        for (Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    @Override
    public void play() {
        StringBuilder messageBuilder = new StringBuilder();

        if (getLength() == 0) messageBuilder.append("CD cannot be played!");
        else {
            messageBuilder.append("Playing CompactDisc: ").append(this.getTitle()).append("\n");
            messageBuilder.append("CD length: ").append(getLength()).append(" sec\n");
            messageBuilder.append("Artist: ").append(this.getArtist()).append("\n");
            messageBuilder.append("Tracks:\n");

            for (Track track : tracks) {
                messageBuilder.append(" - ").append(track.getTitle()).append(": ").append(track.getLength()).append(" sec\n");
            }
        }

        String message = messageBuilder.toString();
        JOptionPane.showMessageDialog(null, message, "Playing CD", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String toString() {
        return "CompactDisc: " +
                "id = " + getId() +
                " - title = '" + getTitle() + '\'' +
                " - category = '" + getCategory() + '\'' +
                " - cost = " + getCost() +
                " - length = " + getLength() +
                " - director = '" + getDirector() + '\'' +
                " - artist = '" + artist + '\'' +
                " - tracks = " + tracks;
    }
}
