package com.android.abhi.abhidemo.retrofit.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class  ItemModel {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("tag")
    @Expose
    public String tag;
    @SerializedName("color")
    @Expose
    public String color;
    @SerializedName("criteria")
    @Expose
    public ArrayList<Criterium> criteria = null;

    public class Criterium {

        @SerializedName("type")
        @Expose
        public String type;
        @SerializedName("text")
        @Expose
        public String text;
        @SerializedName("variable")
        @Expose
        public Variable variable;

        public class Variable {

            @SerializedName("$17")
            @Expose
            public $17 $17;
            @SerializedName("$1")
            @Expose
            public $1 $1;
            @SerializedName("$2")
            @Expose
            public $2 $2;
            @SerializedName("$3")
            @Expose
            public $3 $3;
            @SerializedName("$4")
            @Expose
            public $4 $4;

            public class $1 {

                @SerializedName("type")
                @Expose
                public String type;
                @SerializedName("study_type")
                @Expose
                public String studyType;
                @SerializedName("parameter_name")
                @Expose
                public String parameterName;
                @SerializedName("min_value")
                @Expose
                public Integer minValue;
                @SerializedName("max_value")
                @Expose
                public Integer maxValue;
                @SerializedName("default_value")
                @Expose
                public Integer defaultValue;
                @SerializedName("values")
                @Expose
                public ArrayList<Integer> values = null;

            }

            public class $17 {

                @SerializedName("type")
                @Expose
                public String type;
                @SerializedName("values")
                @Expose
                public ArrayList<Integer> values = null;

            }

            public class $3 {

                @SerializedName("type")
                @Expose
                public String type;
                @SerializedName("values")
                @Expose
                public ArrayList<Float> values = null;


            }

            public class $4 {

                @SerializedName("type")
                @Expose
                public String type;
                @SerializedName("study_type")
                @Expose
                public String studyType;
                @SerializedName("parameter_name")
                @Expose
                public String parameterName;
                @SerializedName("min_value")
                @Expose
                public Integer minValue;
                @SerializedName("max_value")
                @Expose
                public Integer maxValue;
                @SerializedName("default_value")
                @Expose
                public Integer defaultValue;

            }

            public class $2 {

                @SerializedName("type")
                @Expose
                public String type;
                @SerializedName("values")
                @Expose
                public ArrayList<Integer> values = null;

            }

        }
    }
}
