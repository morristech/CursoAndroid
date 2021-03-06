package com.franmontiel.todolist.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Francisco J. Montiel on 28/11/16.
 */

@DatabaseTable(tableName = "Task")
public class Task implements Parcelable {
    @DatabaseField(generatedId = true, columnName = "_id")
    private int id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String description;
    @DatabaseField
    private boolean important;

    public Task(){
        // Required for ORMLITE
    }

    public Task(String name) {
        this.name = name;
        this.description = "";
    }

    public Task(String name, String description, boolean important) {
        this.name = name;
        this.description = description;
        this.important = important;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    // Parcelable
    protected Task(Parcel in) {
        name = in.readString();
        description = in.readString();
        important = in.readInt() == 1;
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeInt(important ? 1 : 0);
    }
}
