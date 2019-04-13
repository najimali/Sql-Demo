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

import android.net.Uri;
import android.provider.BaseColumns;

import java.net.URI;

/**
 * API Contract for the Pets app.
 */
public final class PetContract {
    private PetContract() {}
    public static final String CONTENT_AUTHORITY="com.example.android.pets";
    public static final String PET_PATHS=PetEntry.TABLE_NAME;
    public static final Uri BASE_CONTENT_URI= Uri.parse("content://"+CONTENT_AUTHORITY);


    public static final class PetEntry implements BaseColumns{

        public static final Uri CONTENT_URI=Uri.withAppendedPath(BASE_CONTENT_URI,PET_PATHS);


        public static final String TABLE_NAME="pets";
        public static final String COL_ID=BaseColumns._ID;
        public static final String COL_PET_NAME="name";
        public static final String COL_PET_BREED="breed";
        public static final String COL_PET_WEIGHT="weight";
        public static final String COL_PET_GENDER="gender";

        public static final int GENDER_UNKNOWN=0;
        public static final int GENDER_MALE=1;
        public static final int GENDER_FEMALE=2;

        private boolean isValidGender(int gender)
        {
            if(gender==PetEntry.GENDER_UNKNOWN||gender==PetEntry.GENDER_MALE||gender==PetEntry.GENDER_FEMALE)
            {
                return true;

            }
            return false;
        }






    }



}

