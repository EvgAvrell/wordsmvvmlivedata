package com.example.wordsmvvmlivedata.domain;

import androidx.lifecycle.LiveData;

import com.example.wordsmvvmlivedata.data.room.Word;

import java.util.List;

public interface WordRepository {

    LiveData<List<Word>> getAllWords();

    void insert(Word word);

    void deleteAll();
}
