/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.PetContract.PetEntry;

import com.example.android.pets.data.PetContract.*;
/**
 * Database helper for Pets app. Manages database creation and version management.
 */
public class PetDbHelper  extends SQLiteOpenHelper{
    public static final int DATA_VERSION=1;

    public static final String DATA_BASE="shelter.db";


    public PetDbHelper(Context context) {
        super(context,DATA_BASE,null,DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_QUERIES="CREATE TABLE"+PetEntry.TABLE_NAME + " ( "
                + PetEntry.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PetEntry.COL_PET_NAME   + " TEXT NOT NULL, "
                + PetEntry.COL_PET_BREED  + " TEXT, "
                + PetEntry.COL_PET_WEIGHT + " INTEGER NOT NULL, "
                + PetEntry.COL_PET_GENDER + " INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_QUERIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_ENTERIES="DROP TABLE IF EXIST"+PetEntry.TABLE_NAME;
        db.execSQL(SQL_DELETE_ENTERIES);
        onCreate(db);

    }
}