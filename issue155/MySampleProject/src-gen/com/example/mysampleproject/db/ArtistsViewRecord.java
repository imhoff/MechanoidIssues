/*
 * Generated by Robotoworks Mechanoid
 */
package com.example.mysampleproject.db;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.mysampleproject.db.SampleDBContract.ArtistsView;
import com.example.mysampleproject.db.SampleDBContract.ArtistsView.Builder;
import com.robotoworks.mechanoid.util.Closeables;
import com.robotoworks.mechanoid.db.ActiveRecord;
import com.robotoworks.mechanoid.db.ActiveRecordFactory;
import com.robotoworks.mechanoid.Mechanoid;
import com.robotoworks.mechanoid.db.AbstractValuesBuilder;

public class ArtistsViewRecord extends ActiveRecord implements Parcelable {

	private static ActiveRecordFactory<ArtistsViewRecord> sFactory = new ActiveRecordFactory<ArtistsViewRecord>() {
		@Override
		public ArtistsViewRecord create(Cursor c) {
			return fromCursor(c);
		}
		
		@Override
		public String[] getProjection() {
			return PROJECTION;
		}
	};
	
	public static ActiveRecordFactory<ArtistsViewRecord> getFactory() {
		return sFactory;
	}

    public static final Parcelable.Creator<ArtistsViewRecord> CREATOR 
    	= new Parcelable.Creator<ArtistsViewRecord>() {
        public ArtistsViewRecord createFromParcel(Parcel in) {
            return new ArtistsViewRecord(in);
        }

        public ArtistsViewRecord[] newArray(int size) {
            return new ArtistsViewRecord[size];
        }
    };
    
    public static String[] PROJECTION = {
    	ArtistsView._ID,
    	ArtistsView.NAME
    };
    
    public interface Indices {
    	int _ID = 0;
    	int NAME = 1;
    }
    
    private String mName;
    private boolean mNameDirty;
    
    @Override
    protected String[] _getProjection() {
    	return PROJECTION;
    }
    
    public void setName(String name) {
    	mName = name;
    	mNameDirty = true;
    }
    
    public String getName() {
    	return mName;
    }
    
    public ArtistsViewRecord() {
    	super(ArtistsView.CONTENT_URI);
	}
	
	private ArtistsViewRecord(Parcel in) {
    	super(ArtistsView.CONTENT_URI);
    	
		setId(in.readLong());
		
		mName = in.readString();
		
		boolean[] dirtyFlags = new boolean[2];
		in.readBooleanArray(dirtyFlags);
		mNameDirty = dirtyFlags[0];
	}
	
	@Override
	public int describeContents() {
	    return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(getId());
		dest.writeString(mName);
		dest.writeBooleanArray(new boolean[] {
			mNameDirty
		});
	}
	
	@Override
	protected AbstractValuesBuilder createBuilder() {
		Builder builder = ArtistsView.newBuilder();

		if(mNameDirty) {
			builder.setName(mName);
		}
		
		return builder;
	}
	
    @Override
	public void makeDirty(boolean dirty){
		mNameDirty = dirty;
	}

	@Override
	protected void setPropertiesFromCursor(Cursor c) {
		setId(c.getLong(Indices._ID));
		setName(c.getString(Indices.NAME));
	}
	
	public static ArtistsViewRecord fromCursor(Cursor c) {
	    ArtistsViewRecord item = new ArtistsViewRecord();
	    
		item.setPropertiesFromCursor(c);
		
		item.makeDirty(false);
		
	    return item;
	}
	
	public static ArtistsViewRecord get(long id) {
	    Cursor c = null;
	    
	    ContentResolver resolver = Mechanoid.getContentResolver();
	    
	    try {
	        c = resolver.query(ArtistsView.CONTENT_URI.buildUpon()
			.appendPath(String.valueOf(id)).build(), PROJECTION, null, null, null);
	        
	        if(!c.moveToFirst()) {
	            return null;
	        }
	        
	        return fromCursor(c);
	    } finally {
	        Closeables.closeSilently(c);
	    }
	}
}
