package problem2;

import java.util.ArrayList;
import java.util.Objects;

public class Band extends Creator {
    protected String bandName;
    protected ArrayList<RecordingArtist> bandMember;

    public Band(String bandName, ArrayList<RecordingArtist> bandMember) {
        //super("", "");
        super("", "");
        this.bandName = bandName;
        this.bandMember = bandMember;
    }

    public Band(String bandName) {
        super("","");
        this.bandName = bandName;
        this.bandMember = new ArrayList<RecordingArtist>();
    }

    public String getBandName() {
        return bandName;
    }

    public ArrayList<RecordingArtist> getBandMember() {
        return bandMember;
    }

    public Band addBandMember(String bandName, RecordingArtist recordingArtist){
        if(bandName.equals(this.bandName)){
            this.bandMember.add(recordingArtist);
            return this;
        }
        ArrayList<RecordingArtist> newList = new ArrayList<RecordingArtist>();
        newList.add(recordingArtist);

        Band newBand = new Band(bandName);
        newBand.bandName = bandName;
        newBand.bandMember = newList;
        return newBand;
    }
}
